#!/bin/python3
from __future__ import annotations

import requests
import json

type_dict = {
    "InstanceDatastore": "Object", # Undefined Type
    "ActionResult": "Object", # Undefined Type
    "Int32": "Integer",
    "IEnumerable<InstanceDatastore>": "List",
    "RunningTask": "Object", # Undefined Type
    "IEnumerable<JObject>": "List",
    "Guid": "String",
    "Task<RunningTask>": "Object", # Undefined Type
    "IEnumerable<DeploymentTemplate>": "List",
    "String": "String",
    "DeploymentTemplate": "Object", # Undefined Type
    "Boolean": "boolean",
    "List<String>": "List",
    "PostCreateActions": "Object", # Undefined Type
    "Dictionary<String, String>": "Map",
    "RemoteTargetInfo": "Object", # Undefined Type
    "IEnumerable<ApplicationSpec>": "List",
    "Void": "Void",
    "IEnumerable<EndpointInfo>": "List",
    "IEnumerable<IADSInstance>": "List",
    "JObject": "Map",
    "PortProtocol": "String",
    "Task<ActionResult>": "Object", # Undefined Type
    "ActionResult<String>": "Object", # Undefined Type
    "IADSInstance": "boolean",
    "Uri": "String",
    "IEnumerable<PortUsage>": "List",
    "Dictionary<String, Int32>": "Map",
    "LocalAMPInstance": "Object", # Undefined Type
    "ContainerMemoryPolicy": "Object", # Undefined Type
    "Single": "Object", # Undefined Type
    "Task<JObject>": "Object", # Undefined Type
    "Int64": "Integer",
    "FileChunkData": "Object", # Undefined Type
    "IEnumerable<BackupManifest>": "List",
    "Nullable<DateTime>": "Object", # Undefined Type
    "IEnumerable<IAuditLogEntry>": "Map",
    "Dictionary<String, IEnumerable<JObject>>": "Map",
    "IDictionary<String, String>": "Map",
    "List<JObject>": "List",
    "String[]": "List",
    "Task<IEnumerable<AuthRoleSummary>>": "Object", # Undefined Type
    "Task<IDictionary<Guid, String>>": "Object", # Undefined Type
    "Task<AuthRoleSummary>": "Object", # Undefined Type
    "Task<ActionResult<Guid>>": "Object", # Undefined Type
    "Nullable<Boolean>": "boolean",
    "Task<IEnumerable<String>>": "Object", # Undefined Type
    "ScheduleInfo": "Object", # Undefined Type
    "Int32[]": "List<Integer>",
    "TimeIntervalTrigger": "Object", # Undefined Type
    "IEnumerable<WebSessionSummary>": "List",
    "Task<IEnumerable<UserInfoSummary>>": "Object", # Undefined Type
    "Task<UserInfo>": "Object", # Undefined Type
    "Task<IEnumerable<UserInfo>>": "Object", # Undefined Type
    "IList<IPermissionsTreeNode>": "List",
    "WebauthnLoginInfo": "Object", # Undefined Type
    "IEnumerable<WebauthnCredentialSummary>": "List",
    "Task<ActionResult<TwoFactorSetupInfo>>": "Object", # Undefined Type
    "IEnumerable<RunningTask>": "Object", # Undefined Type
    "ModuleInfo": "Object", # Undefined Type
    "Dictionary<String, Dictionary<String, MethodInfoSummary>>": "Map",
    "Object": "Object",
    "Task<String>": "Object", # Undefined Type
    "UpdateInfo": "Object", # Undefined Type
    "IEnumerable<ListeningPortSummary>": "List",
}

def generate_apimodule_method(module: str, method: str, method_spec: dict):
    # Read the template file
    api_module_method_template = ""
    with open("templates/api_module_method.txt", "r") as tf:
        api_module_method_template = tf.read()
        tf.close()

    # Get the method description
    description = ""
    if "Description" in method_spec.keys():
        description = "\n     * " + method_spec["Description"]

    # Get the method parameters
    parameters_docs = ""
    methodParams = method_spec["Parameters"]
    if len(methodParams) > 0:
        parameters_docs += "\n"
    for i in range(len(methodParams)):
        api_module_method_parameter_doc_template = ""
        with open("templates/api_module_method_parameter_doc.txt", "r") as tf:
            api_module_method_parameter_doc_template = tf.read()
            tf.close()

        name = methodParams[i]["Name"]
        type_name = methodParams[i]["TypeName"]

        # Print out the type if it hasn't been added to the type_dict
        if not type_name in type_dict.keys(): print(type_name)

        description = methodParams[i]["Description"]
        optional = methodParams[i]["Optional"]
        if optional == "true": type_name += ", " + optional

        template = api_module_method_parameter_doc_template\
            .replace("%METHOD_PARAMETER_NAME%", name)\
            .replace("%METHOD_PARAMETER_DESCRIPTION%", description)\
            .replace("%METHOD_PARAMETER_OPTIONAL%", str(optional))

        parameters_docs += template
    parameters_docs = parameters_docs[:-1]

    # Get the method return type
    return_type = method_spec["ReturnTypeName"]

    # Print out the type if it hasn't been added to the type_dict
    if not return_type in type_dict.keys(): print(return_type)
    return_type = type_dict[return_type]

    # Get the method parameters
    parameters = ""
    for i in range(len(methodParams)):
        name = methodParams[i]["Name"]
        type_name = methodParams[i]["TypeName"]

        # Print out the type if it hasn't been added to the type_dict
        if not type_name in type_dict.keys(): print(type_name)
        parameters += f"{type_dict[type_name]} {name}, "

    parameters = parameters[:-2]

    # Get the parameters for the data map
    map_string = ""
    if len(methodParams) > 0:
        map_string += "\n"
    for i in range(len(methodParams)):
        api_module_method_parameter_map_template = ""
        with open("templates/api_module_method_parameter_map.txt", "r") as tf:
            api_module_method_parameter_map_template = tf.read()
            tf.close()

        name = methodParams[i]["Name"]
        map_string += api_module_method_parameter_map_template.replace("%METHOD_PARAMETER_NAME%", name)
    map_string = map_string[:-1]

    # Replace placeholders
    template = api_module_method_template\
        .replace("%METHOD_DESCRIPTION%", description)\
        .replace("%METHOD_PARAMETER_DOC%", parameters_docs)\
        .replace("%MODULE_NAME%", module)\
        .replace("%METHOD_NAME%", method)\
        .replace("%METHOD_PARAMETERS%", parameters)\
        .replace("%METHOD_RETURN_TYPE%", return_type)\
        .replace("%METHOD_PARAMETER_MAP%", map_string)

    # End result will return a string
    return template

def generate_apimodule(module: str, methods: dict):
    # Read the template file
    api_module_template = ""
    with open("templates/api_module.txt", "r") as tf:
        api_module_template = tf.read()
        tf.close()

    # Create a new file called f{module}.java
    f = open(f"../src/main/java/dev/neuralnexus/ampapi/apimodules/{module}.java","w+")
    f.write(api_module_template.replace("%MODULE_NAME%", module))

    for method in methods.keys():
        f.write(generate_apimodule_method(module, method, methods[method]))

    f.write("}\n")
    f.close()

def generate_spec(spec: dict):
    for module in spec.keys():
        generate_apimodule(module, spec[module])

if __name__ == "__main__":
    res = requests.get("https://raw.githubusercontent.com/p0t4t0sandwich/ampapi-spec/main/APISpec.json")
    res_json = json.loads(res.content)

    generate_spec(res_json)

