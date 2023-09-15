package com.practicas.test.javatests.util;

public class StringUtil {

    // Función que repite un string n veces
    public static String repeat(String str, int times) {

        if(times<0){
            throw new IllegalArgumentException("negative times not allowed");
        }

        return String.valueOf(str).repeat(Math.max(0, times));
    }

}
