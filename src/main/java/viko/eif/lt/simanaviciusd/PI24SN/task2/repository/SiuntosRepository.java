package viko.eif.lt.simanaviciusd.PI24SN.task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import viko.eif.lt.simanaviciusd.PI24SN.task2.model.Siunta;

/**
 * Repozitorija siuntų CRUD operacijoms su SQLite duomenų baze.
 */
@Repository
public interface SiuntosRepository extends JpaRepository<Siunta, Integer> {
}