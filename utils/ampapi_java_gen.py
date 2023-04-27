from ampapi.ampapi import AMPAPI

username = ""
password = ""

def generate_java(spec):
    f = open("auto_java_gen.txt","w+")
    for module in spec.keys():
        methods = spec[module]
        for method in methods.keys():
            methodParams = spec[module][method]["Parameters"]
            data = {methodParams[i]["Name"]:methodParams[i]["Name"] for i in range(len(methodParams))}

            javadoc = ""
            for i in range(len(methodParams)):
                name = methodParams[i]["Name"]
                type_name = methodParams[i]["TypeName"]
                description = methodParams[i]["Description"]
                optional = methodParams[i]["Optional"]

                javadoc += f"     * @param {name} {type_name} {description} {optional}\n"
            return_type = spec[module][method]["ReturnTypeName"]
            is_complex_type = spec[module][method]["IsComplexType"]
            javadoc += f"     *  ReturnTypeName IsComplexType\n     * @return {return_type} {is_complex_type}\n"

            data_string = ""
            for i in range(len(methodParams)):
                data_string += 'args.put("' + methodParams[i]["Name"] + '", ' + methodParams[i]["Name"] + ");\n        "

            keys = str(["Object " + i for i in data.keys()]).replace("[","").replace("]","").replace("'","")

            template = f"""    /** Name TypeName Description Optional
{javadoc}     */
    public Map<?, ?> {module}_{method}({keys}) {"{"}
        HashMap<String, Object> args = new HashMap<>();
        {data_string}return this.APICall("/{module}/{method}", args);
    {"}"}\n\n"""
            f.write(template)
    f.close()


def start() -> None:
    API = AMPAPI("http://localhost:8080")

    # try:
    APIInitOK = API.init()

    if not APIInitOK:
        print("API Init failed")
        return

    loginResult = API.Core.Login(username, password, "", False)

    if "success" in loginResult.keys() and loginResult["success"]:
        print("Login successful")
        API.sessionId = loginResult["sessionID"]

        APIInitOK = API.init()
        if not APIInitOK:
            print("API Stage 2 Init failed")
            return

        # Grab the APISpec
        spec = API.Core.GetAPISpec()["result"]
        generate_java(spec)

    else:
        print("Login failed")
        print(loginResult)

    # except Exception as err:
    #     print(err)

start()
