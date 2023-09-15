package com.practicas.test.javatests.util;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringUtilTest {

    /// Lo correcto es crear una función de test para cada prueba por separado

    // En el nombre de la función se describe el caso de uso.
    @Test
    public void repeat_string_once(){
        assertEquals("hola",StringUtil.repeat("hola",1) );


    }

    @Test
    public void repeat_string_multiple_times(){
        assertEquals("holaholahola",StringUtil.repeat("hola",3) );

    }

    @Test
    public void repeat_string_zero_times(){
        assertEquals("",StringUtil.repeat("hola",0) );

    }
    // ¿ Qué pasa si ocurre un comportamiento no esperado ?
    // En teoria se esperaria una excepción
    @Test()
    public void repeat_string_negative_times(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            StringUtil.repeat("hola", -1);
        });

        String expected = "negative times not allowed";
        /// Luego si volvemos a usar el 'assertEquals'
        assertEquals(expected,exception.getMessage());

    }


    @Test
    public void pruebaStringUtil(){
        // Resultado esperado ,  Resultado obtenido por el metodo o lógica implementada
        assertEquals("holaholahola",StringUtil.repeat("hola",3) );
        assertEquals("hola",StringUtil.repeat("hola",1) );
    }




}
