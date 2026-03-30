package viko.eif.lt.simanaviciusd.PI24SN.task2.client;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Vienetų testai {@link SiuntosClient} klasei.
 */
class SiuntosClientTest {

    /**
     * Tikrina ar SiuntosClient klasė egzistuoja ir gali būti sukurta.
     */
    @Test
    void siuntosClient_turėtų_egzistuoti() {
        assertDoesNotThrow(() -> SiuntosClient.class.getDeclaredConstructor());
    }

    /**
     * Tikrina ar main metodas egzistuoja.
     */
    @Test
    void main_turėtų_turėtiMainMetodą() throws Exception {
        assertNotNull(
                SiuntosClient.class.getMethod("main", String[].class)
        );
    }
}