package com.practicas.test.javatests.player;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

/*
* Objetivo: Testear el método 'play' de Player
* Causa: El método play debe devolver true o false
* en función del número del dado
* Proceso: */
class PlayerTest {

    @Test
    void lose_when_dice_number_is_too_low() {

        //Dice dice = new Dice(6); -> Esto no se usa en test's

        Dice dice = Mockito.mock(Dice.class); // -> Se simula la clase con Mockito
        /* Para este ejemplo quiero simular cuando un dado me
        * devuelve especificamnete un 2
        */
        Mockito.when(dice.roll()).thenReturn(2); // -> Fuerzo el resultado

        // Ahora si uso un player con un 'dice' simulado a mi acomodo
        Player player = new Player(dice,5);
        assertFalse(player.play());
    }

    @Test
    void lose_when_dice_number_is_big() {

        Dice dice = Mockito.mock(Dice.class); // -> Se simula la clase con Mockito
        Mockito.when(dice.roll()).thenReturn(4); // -> Fuerzo el resultado
        Player player = new Player(dice,3);
        assertTrue(player.play());
    }
}