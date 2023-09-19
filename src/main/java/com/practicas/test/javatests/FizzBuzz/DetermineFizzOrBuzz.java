package com.practicas.test.javatests.FizzBuzz;

public class DetermineFizzOrBuzz {

    public static String determine(int num){

        String aux= "";

        if (num%3==0) {
            aux += "Fizz";
        }
        if (num%5==0) {
            aux+= "Buzz";
        }
        return aux.isEmpty()? ""+num:aux;
    }
}
