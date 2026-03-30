package viko.eif.lt.simanaviciusd.PI24SN.task2.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import viko.eif.lt.simanaviciusd.PI24SN.task2.model.Siunta;

import java.util.List;

/**
 * JAX-WS Web serviso sąsaja siuntos operacijoms.
 */
@WebService
public interface SiuntosService {

    /**
     * Grąžina visų siuntų sąrašą.
     *
     * @return siuntų sąrašas
     */
    @WebMethod
    List<Siunta> gaуtiVisasSiuntas();

    /**
     * Grąžina siuntą pagal ID.
     *
     * @param id siuntos identifikatorius
     * @return siunta arba null jei nerasta
     */
    @WebMethod
    Siunta gautiSiuntaPagalId(@WebParam(name = "id") int id);

    /**
     * Prideda naują siuntą.
     *
     * @param siunta nauja siunta
     * @return pridėta siunta
     */
    @WebMethod
    Siunta pridеtiSiunta(@WebParam(name = "siunta") Siunta siunta);

    /**
     * Atnaujina esamos siuntos pristatymo statusą.
     *
     * @param id         siuntos identifikatorius
     * @param pristatyta naujas pristatymo statusas
     * @return atnaujinta siunta
     */
    @WebMethod
    Siunta atnaujintiStatusa(@WebParam(name = "id") int id,
                             @WebParam(name = "pristatyta") boolean pristatyta);

    /**
     * Ištrina siuntą pagal ID.
     *
     * @param id siuntos identifikatorius
     * @return true jei ištrinta sėkmingai
     */
    @WebMethod
    boolean istrintiSiunta(@WebParam(name = "id") int id);
}