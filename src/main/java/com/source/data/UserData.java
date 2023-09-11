package com.source.data;

import java.util.HashMap;
import java.util.Map;

public class UserData {

    public static Map<String, String> loginUserCredentails = new HashMap<String, String>();

    public static Map<String, String> getLoginUserCredentails(String userType) {
        String password = "secret_sauce";
        switch (userType) {
            case "standard":
                loginUserCredentails.put("username", "standard_user");
                loginUserCredentails.put("password", password);
                break;

            case "lockedOut":
                loginUserCredentails.put("username", "locked_out_user");
                loginUserCredentails.put("password", password);
                break;

            default: //problem_user
                loginUserCredentails.put("username", "problem_user");
                loginUserCredentails.put("password", password);
                break;
        }
        return loginUserCredentails;
    }

}
