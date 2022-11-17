package ca.sperrer.p0t4t0sandwich.ampapi;

public class Main {
    public static void main(String[] args) {
        AMPAPI API = new AMPAPI("http://172.16.1.172:8080/");

        System.out.println(API.init(true));

        System.out.println(API.API.get("Core").get("GetAPISpec").accept(new Object[] {}));

        //API.API.get("Core").get("Login").accept(arguments);

//        Map res = API.APICall("Core", "GetAPISpec", arguments);
//
//        System.out.println(
//                ((Map<?, ?>) ((Map<?, ?>) res
//                        .get("result"))
//                        .get("Core"))
//                        .get("Login")
//        );
    }
}
