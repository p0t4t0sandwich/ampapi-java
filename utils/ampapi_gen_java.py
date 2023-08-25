#!/bin/python3
from __future__ import annotations

import sys

import requests
import json

type_dict = {
    "InstanceDatastore": "Object",
    "ActionResult": "ActionResult",
    "Int32": "Integer",
    "IEnumerable<InstanceDatastore>": "Result<List<Object>>",
    "RunningTask": "Object",
    "Task<RunningTask>": "Task<Object>",
    "IEnumerable<JObject>": "Result<List<Map<String, String>>>",
    "Guid": "UUID",
    "Result<RunningTask>": "Object",
    "IEnumerable<DeploymentTemplate>": "Result<List<Object>>",
    "String": "String",
    "DeploymentTemplate": "Object",
    "Boolean": "Boolean",
    "List<String>": "List",
    "PostCreateActions": "Object",
    "Dictionary<String, String>": "Map",
    "RemoteTargetInfo": "Object",
    "IEnumerable<ApplicationSpec>": "Result<List<Object>>",
    "Void": "Void",
    "IEnumerable<EndpointInfo>": "Result<List<Object>>",
    "IEnumerable<IADSInstance>": "Result<List<ADSInstance>>",
    "JObject": "Map",
    "PortProtocol": "String",
    "Result<ActionResult>": "Object",
    "ActionResult<String>": "Object",
    "IADSInstance": "Result<ADSInstance>",
    "Uri": "String",
    "IEnumerable<PortUsage>": "Result<List<Object>>",
    "Dictionary<String, Int32>": "Map",
    "LocalAMPInstance": "Object",
    "ContainerMemoryPolicy": "Object",
    "Single": "Object",
    "Result<JObject>": "Object",
    "Int64": "Integer",
    "FileChunkData": "Object",
    "IEnumerable<BackupManifest>": "Result<List<Object>>",
    "Nullable<DateTime>": "Object",
    "IEnumerable<IAuditLogEntry>": "Result<List<Object>>",
    "Dictionary<String, IEnumerable<JObject>>": "Map<String, List<Map<String, String>>>",
    "IDictionary<String, String>": "Map<String, String>",
    "List<JObject>": "List<Map<String, String>>",
    "String[]": "List<String>",
    "Nullable<Boolean>": "Boolean",
    "ScheduleInfo": "Object",
    "Int32[]": "List<Integer>",
    "TimeIntervalTrigger": "Object",
    "IEnumerable<WebSessionSummary>": "Result<List<Object>>",
    "IList<IPermissionsTreeNode>": "List",
    "WebauthnLoginInfo": "Object",
    "IEnumerable<WebauthnCredentialSummary>": "Result<List<Object>>",
    "IEnumerable<RunningTask>": "Result<List<Object>>",
    "ModuleInfo": "Object",
    "Dictionary<String, Dictionary<String, MethodInfoSummary>>": "Map<String, Map<String, Object>>",
    "Object": "Object",
    "Result<String>": "Object",
    "UpdateInfo": "Object",
    "IEnumerable<ListeningPortSummary>": "Result<List<Object>>",
    "Task<JObject>": "Task<Map<String, String>>",
    "Task<ActionResult<TwoFactorSetupInfo>>": "Task<Object>",
    "Task<IEnumerable<String>>": "Task<List<String>>",
    "Task<UserInfo>": "Task<UserInfo>",
    "Task<IEnumerable<UserInfoSummary>>": "Task<List<Object>>",
    "Task<IEnumerable<UserInfo>>": "Task<List<UserInfo>>",
    "Task<String>": "Task<String>",
    "Task<AuthRoleSummary>": "Task<Object>",
    "Task<IEnumerable<AuthRoleSummary>>": "Task<List<Object>>",
    "Task<IDictionary<Guid, String>>": "Task<Map<UUID, String>>",
    "Task<ActionResult>": "Task<ActionResult>",
    "Task<ActionResult<Guid>>": "Task<ActionResult<UUID>>",

    # Custom types
    "GetStatusResult": "GetStatusResult",
    "LoginResult": "LoginResult",
    "Result<Instance>": "Result<Instance>",
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
            .replace("%METHOD_PARAMETER_TYPE%", type_dict[type_name])\
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
    spec = ""
    if len(sys.argv) >= 2 and sys.argv[1] == "-l":
        print("Using local spec...")
        # Load local file

        with open("LocalSpec.json", "r") as f:
            spec = json.load(f)
            f.close()
    else:
        print("Using remote spec...")

        # Load remote file
        res = requests.get("https://raw.githubusercontent.com/p0t4t0sandwich/ampapi-spec/main/APISpec.json")
        spec = json.loads(res.content)

    generate_spec(spec)
