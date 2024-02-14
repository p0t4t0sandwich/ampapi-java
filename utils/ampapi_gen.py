#!/bin/python3
from __future__ import annotations

import requests
import json

import sys

type_dict = {
    # Generic types
    "ActionResult": "ActionResult",
    "ActionResult<Guid>": "ActionResult<UUID>",
    "ActionResult<LicenceInfo>": "ActionResult<LicenceInfo>",
    "ActionResult<String>": "ActionResult<String>",
    "ActionResult<TwoFactorSetupInfo>": "ActionResult<Object>",
    "RunningTask": "RunningTask",
    "IEnumerable<RunningTask>": "List<RunningTask>",

    # Primitive types
    "Boolean": "Boolean",
    "Guid": "UUID",
    "Int32": "Integer",
    "Int32[]": "List<Integer>",
    "Int64": "Integer",
    "JObject": "Map<String, Object>",
    "Object": "Object",
    "String": "String",
    "String[]": "List<String>",
    "Uri": "URL",
    "Void": "Void",

    # Nested types
    "Dictionary<String, Dictionary<String, MethodInfoSummary>>": "Map<String, Map<String, Object>>",
    "Dictionary<String, Int32>": "Map<String, Integer>",
    "Dictionary<String, SettingSpec>": "Map<String, SettingSpec>",
    "Dictionary<String, String>": "Map<String, String>",
    "IDictionary<Guid, String>": "Map<UUID, String>",
    "IDictionary<String, String>": "Map<String, String>",
    "IEnumerable<ApplicationSpec>": "List<Object>",
    "IEnumerable<AuthRoleSummary>": "List<Object>",
    "IEnumerable<BackupManifest>": "List<Object>",
    "IEnumerable<DeploymentTemplate>": "List<Object>",
    "IEnumerable<EndpointInfo>": "List<EndpointInfo>",
    "IEnumerable<FileDirectory>": "List<FileDirectory>",
    "IEnumerable<IADSInstance>": "List<IADSInstance>",
    "IEnumerable<IAuditLogEntry>": "List<Object>",
    "IEnumerable<InstanceDatastore>": "List<InstanceDatastore>",
    "IEnumerable<InstanceStatus>": "List<InstanceStatus>",
    "IEnumerable<JObject>": "List<Map<String, Object>>",
    "IEnumerable<ListeningPortSummary>": "List<Object>",
    "IEnumerable<PortUsage>": "List<Object>",
    "IEnumerable<ProvisionSettingInfo>": "List<Object>",
    "IEnumerable<String>": "List<String>",
    "IEnumerable<UserInfo>": "List<UserInfo>",
    "IEnumerable<UserInfoSummary>": "List<Object>",
    "IEnumerable<WebauthnCredentialSummary>": "List<Object>",
    "IEnumerable<WebSessionSummary>": "List<Object>",
    "IList<IPermissionsTreeNode>": "List<Object>",
    "List<JObject>": "List<Map<String, Object>>",
    "List<String>": "List<String>",
    "Nullable<Boolean>": "Boolean", # Optional?
    "Nullable<DateTime>": "Object", # Optional?

    # Object types
    "AuthRoleSummary": "Object",
    "ContainerMemoryPolicy": "Object",
    "DeploymentTemplate": "Object",
    "FileChunkData": "Object",
    "IADSInstance": "IADSInstance",
    "Instance": "Instance",
    "InstanceDatastore": "InstanceDatastore",
    "LocalAMPInstance": "Object",
    "LoginResult": "LoginResult",
    "ModuleInfo": "ModuleInfo",
    "PortProtocol": "Object",
    "PostCreateActions": "Object",
    "RemoteTargetInfo": "RemoteTargetInfo",
    "ScheduleInfo": "Object",
    "SimpleUser": "Object",
    "Single": "Object",
    "Status": "Status",
    "TimeIntervalTrigger": "Object",
    "UpdateInfo": "UpdateInfo",
    "Updates": "Updates",
    "UserInfo": "UserInfo",
    "WebauthnLoginInfo": "Object",
}

custom_types = {
    # API.ADSModule.GetInstance
#     "ADSModule.GetInstance": "Result<Instance>",
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
        if module == "CommonCorePlugin": continue
        generate_apimodule(module, spec[module])

def load_custom_types(spec: dict):
    for type_index in custom_types.keys():
        type_module = type_index.split(".")[0]
        type_method = type_index.split(".")[1]

        # Update the return type
        spec[type_module][type_method]["ReturnTypeName"] = custom_types[type_index]

if __name__ == "__main__":
    branch = "main"
    if len(sys.argv) > 1:
        branch = sys.argv[1]

    # Load remote file
    res = requests.get(f"https://raw.githubusercontent.com/p0t4t0sandwich/ampapi-spec/{branch}/OldAPISpec.json")
    spec = json.loads(res.content)

    # Load custom types
    load_custom_types(spec)

    generate_spec(spec)
