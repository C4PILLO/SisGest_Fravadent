package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.VentaEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface VentaRepository extends GenericoRepository<VentaEntity, Long> {
    @Query("select e from VentaEntity e")
    List<VentaEntity> findAllCustom();
}
