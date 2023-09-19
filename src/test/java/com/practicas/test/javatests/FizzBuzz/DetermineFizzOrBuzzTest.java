package com.practicas.test.javatests.FizzBuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/*
* Si el número es divisible por 3, retorna “Fizz”
* Si el número es divisible por 5, retorna “Buzz”
* Si el número es divisible por 3 y por 5, retorna “FizzBuzz”
* En otro caso, retorna el mismo número
*/

class DetermineFizzOrBuzzTest {

    @Test
    void fizz_when_num_is_divisible_by_3() {
        int num = 9;
        assertThat(DetermineFizzOrBuzz.determine(num), is("Fizz"));

    }

    @Test
    void buzz_when_num_is_divisible_by_5() {
        int num = 5;
        assertThat(DetermineFizzOrBuzz.determine(num), is("Buzz"));

    }

    @Test
    void fizzBuzz_when_num_is_divisible_by_3_and_5() {
        int num = 30;
        assertThat(DetermineFizzOrBuzz.determine(num), is("FizzBuzz"));

    }

    @Test
    void num_value_when_num_is_not_divisible_by_3_and_5() {
        int num = 37;
        assertThat(DetermineFizzOrBuzz.determine(num), is("37"));

    }
}