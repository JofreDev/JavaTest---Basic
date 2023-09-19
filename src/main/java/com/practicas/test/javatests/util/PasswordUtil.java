package com.practicas.test.javatests.util;


/*
* Objetivo : determinar el nivel de seguridad
*            de un password
* */
public class PasswordUtil {

    public enum SecurityLevel {
        WEAK, MEDIUM, STRONG
    }


    public static SecurityLevel assessPassword(String pass){

        if (pass.length() < 8){
            return SecurityLevel.WEAK;
        }

        if (pass.matches("[a-zA-Z]+")){
            return SecurityLevel.WEAK;
        }

        if (pass.matches("[a-zA-Z0-9]+")){
            return SecurityLevel.MEDIUM;
        }


        return SecurityLevel.STRONG;
    }
}
