package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.UnidadMedidaEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface UnidadMedidaRepository extends GenericoRepository<UnidadMedidaEntity, Long> {
    @Query("select e from UnidadMedidaEntity e where e.estado='A'")
    List<UnidadMedidaEntity> findAllCustom();
}
