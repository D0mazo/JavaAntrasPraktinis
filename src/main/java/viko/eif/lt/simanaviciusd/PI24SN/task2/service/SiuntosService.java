package viko.eif.lt.simanaviciusd.PI24SN.task2.service;

import jakarta.jws.WebService;

/**
 * Pagrindinė JAX-WS Web serviso sąsaja.
 * Sujungia {@link SiuntosReadService} ir {@link SiuntosWriteService}.
 */
@WebService
public interface SiuntosService extends SiuntosReadService, SiuntosWriteService {
}