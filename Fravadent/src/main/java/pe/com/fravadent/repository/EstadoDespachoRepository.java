package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.EstadoDespachoEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface EstadoDespachoRepository extends GenericoRepository<EstadoDespachoEntity, Long> {
    @Query("select e from EstadoDespachoEntity e where e.estado='A'")
    List<EstadoDespachoEntity> findAllCustom();
}
