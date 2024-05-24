package com.example.utils;

public class EmailUntils {

    public static String getEmailMessage(String name, String host, String token) {
        return "Hello" + name + ",\n\n Your  new account has been created. Please click on link below to verity your account.  "
                + getVerificationUrl(host,token) + "\n\nThe support Team";

    }

    public static String getResetPasswordMessage(String name, String host, String token) {
        return "Hello" + name + ",\n\n Your  new account has been created. Please click on link below to verity your account.  "
                + getResetPasswordUrl(host,token) + "\n\nThe support Team";

    }
    public  static  String getVerificationUrl(String host, String token) {
        return host + "/verify/account?token="+token;
    }
    public  static  String getResetPasswordUrl(String host, String token) {
        return host + "/verify/password?token="+token;
    }
}
