package viko.eif.lt.simanaviciusd.PI24SN.task2.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import viko.eif.lt.simanaviciusd.PI24SN.task2.model.Siunta;

import java.util.List;

/**
 * Sąsaja siuntos skaitymo operacijoms.
 */
@WebService
public interface SiuntosReadService {

    /**
     * Grąžina visų siuntų sąrašą.
     *
     * @return siuntų sąrašas
     */
    @WebMethod
    List<Siunta> gautiVisasSiuntas();

    /**
     * Grąžina siuntą pagal ID.
     *
     * @param id siuntos identifikatorius
     * @return siunta arba null jei nerasta
     */
    @WebMethod
    Siunta gautiSiuntaPagalId(@WebParam(name = "id") int id);
}