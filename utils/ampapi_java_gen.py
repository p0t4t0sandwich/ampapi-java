#!/bin/python3
from __future__ import annotations

import requests
import json

import os

type_dict = {
    "InstanceDatastore": "",
    "ActionResult": "",
    "Int32": "Integer",
    "IEnumerable<InstanceDatastore>": "List<?>",
    "RunningTask": "",
    "IEnumerable<JObject>": "List<Map<?, ?>>",
    "Guid": "String",
    "Task<RunningTask>": "",
    "IEnumerable<DeploymentTemplate>": "List<?>",
    "String": "String",
    "DeploymentTemplate": "",
    "Boolean": "boolean",
    "List<String>": "List<String>",
    "PostCreateActions": "",
    "Dictionary<String, String>": "Map<String, String>",
    "RemoteTargetInfo": "",
    "IEnumerable<ApplicationSpec>": "List<?>",
    "Void": "void",
    "IEnumerable<EndpointInfo>": "List<?>",
    "IEnumerable<IADSInstance>": "List<?>",
    "JObject": "Map<?, ?>",
    "PortProtocol": "String",
    "Task<ActionResult>": "",
    "ActionResult<String>": "",
    "IADSInstance": "bool",
    "Uri": "String",
    "IEnumerable<PortUsage>": "List<?>",
    "Dictionary<String, Int32>": "Map<String, Integer>",
    "LocalAMPInstance": "",
    "ContainerMemoryPolicy": "",
    "Single": "",
    "Task<JObject>": "",
    "Int64": "Integer",
    "FileChunkData": "",
    "IEnumerable<BackupManifest>": "List<Map<?, ?>>",
    "Nullable<DateTime>": "",
    "IEnumerable<IAuditLogEntry>": "Map<?, ?>",
    "Dictionary<String, IEnumerable<JObject>>": "dict[str, list[dict]]",
    "IDictionary<String, String>": "Map<String, String>",
    "List<JObject>": "List<Map<?, ?>>",
    "String[]": "List<String>",
    "Task<IEnumerable<AuthRoleSummary>>": "",
    "Task<IDictionary<Guid, String>>": "",
    "Task<AuthRoleSummary>": "",
    "Task<ActionResult<Guid>>": "",
    "Nullable<Boolean>": "boolean",
    "Task<IEnumerable<String>>": "",
    "ScheduleInfo": "",
    "Int32[]": "List<Integer>",
    "TimeIntervalTrigger": "",
    "IEnumerable<WebSessionSummary>": "List<?>",
    "Task<IEnumerable<UserInfoSummary>>": "",
    "Task<UserInfo>": "",
    "Task<IEnumerable<UserInfo>>": "",
    "IList<IPermissionsTreeNode>": "List<?>",
    "WebauthnLoginInfo": "",
    "IEnumerable<WebauthnCredentialSummary>": "List<?>",
    "Task<ActionResult<TwoFactorSetupInfo>>": "",
    "IEnumerable<RunningTask>": "", "ModuleInfo": "",
    "Dictionary<String, Dictionary<String, MethodInfoSummary>>": "Map<String, Map<String, Object>>",
    "Object": "",
    "Task<String>": "",
    "UpdateInfo": "",
    "IEnumerable<ListeningPortSummary>": "List<?>",
}

def generate_java(spec):
    f = open("auto_java_gen.java","w+")
    for module in spec.keys():
        methods = spec[module]
        for method in methods.keys():
            methodParams = spec[module][method]["Parameters"]
            data = {methodParams[i]["Name"]:methodParams[i]["Name"] for i in range(len(methodParams))}

            ##################### Add docs
            description = ""
            if "Description" in spec[module][method].keys():
                description = "\n     * " + spec[module][method]["Description"]

            javadoc = f"    /**{description}\n     * Name TypeName Description Optional"

            ########## Parameters
            for i in range(len(methodParams)):
                name = methodParams[i]["Name"]
                type_name = methodParams[i]["TypeName"]

                # Print out the type if it hasn't been added to the type_dict
                if not type_name in type_dict.keys(): print(type_name)
                description = methodParams[i]["Description"]
                optional = methodParams[i]["Optional"]
                if optional == "true": type_name + ", optional"
                javadoc += f"\n     * @param {name} {type_dict[type_name]} AMPType: {type_name} {description}"

            ##########

            ########## Return type
            return_type = spec[module][method]["ReturnTypeName"]

            # Print out the type if it hasn't been added to the type_dict
            if not return_type in type_dict.keys(): print(return_type)
            javadoc += f"\n     * @return {type_dict[return_type]} AMPType: {return_type}"
            ##########

            javadoc += "\n     */"
            #####################

            data_string = ""
            for i in range(len(methodParams)):
                data_string += 'args.put("' + methodParams[i]["Name"] + '", ' + methodParams[i]["Name"] + ");\n        "

            params = ""
            if len(data.keys()) != 0:
                for i in range(len(methodParams)):
                    param_type = "Object "
                    if not type_dict[methodParams[i]["TypeName"]] == "":
                        param_type = f"{type_dict[methodParams[i]['TypeName']]} "
                    params += param_type + methodParams[i]["Name"] + ", "
                params = params[:-2]

            template = f"""{javadoc}
    public Map<?, ?> {module}_{method}({params}) {"{"}
        HashMap<String, Object> args = new HashMap<>();
        {data_string}return this.APICall("{module}/{method}", args);
    {"}"}\n\n"""
            f.write(template)
    f.close()

if __name__ == "__main__":
    res = requests.get("https://raw.githubusercontent.com/p0t4t0sandwich/ampapi-spec/main/APISpec.json")
    res_json = json.loads(res.content)

    generate_java(res_json)
