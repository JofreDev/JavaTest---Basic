package com.practicas.test.javatests.PaymentGateway;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

/* Acá no importa el monto.
* Importa que cuando el status sea ERROR entonces se devuelva un 'false'
* y que cuanso el status sea un OK se devuelva un 'true'.
* Por ende se simula con mockito la clase PaymentGateway y lo que debe
* devolver
*
* Conslusión : Para testear la clase 'PaymentProcessor' se debe simular a 'PaymentGateway' y definir su respuesta
*              la cual es un 'PaymentResponse' */
class PaymentProcessorTest {

    /* Si hay objetos que se estan usando en varios test,
     *  se pueden usar como atributos directamente de la clase
     * */

    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;


    @BeforeEach // -> En cada test vuelven a estar limpios los objetos
    public void setup(){
        this.paymentGateway = Mockito.mock(PaymentGateway.class);
        this.paymentProcessor = new PaymentProcessor(paymentGateway);
    }


    @Test
    void payment_is_correct() {

        /// acá se está usando un interfaz para testear !!!!
        // El test prescinde de la definición real de los metodos

        //PaymentGateway paymentGateway= Mockito.mock(PaymentGateway.class); -> Pasa a ser atributo y a inicilizarse con setup

        /// Se simula la respuesta directa del paymentGateway. Es decir el paymentresponse
        // Para lo que entre se devuelve un OK

        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                                                // Llama al status que espera de manera estatica
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        // Recordemos que 'PaymentProcessor' usa a 'PaymentGateway' y en función de este devuelve true o flase
        //PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway); -> Pasa a ser atributo y a inicilizarse con setup

        boolean result = paymentProcessor.makePayment(1000);

        assertTrue(result);

    }

    @Test
    void payment_is_wrong() {

        /// acá se está usando un interfaz para testear !!!!
        // El test prescinde de la definición real de los metodos

        //PaymentGateway paymentGateway= Mockito.mock(PaymentGateway.class); -> Pasa a ser atributo y a inicilizarse con setup

        /// Se simula la respuesta directa del paymentGateway

        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                // Llama al status que espera de manera estatica
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        // Recordemos que 'PaymentProcessor' usa a 'PaymentGateway'
        //PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway); -> Pasa a ser atributo y a inicilizarse con setup

        boolean result = paymentProcessor.makePayment(1000);

        assertFalse(result);

    }
}