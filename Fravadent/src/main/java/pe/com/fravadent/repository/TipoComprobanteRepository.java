package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.TipoComprobanteEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface TipoComprobanteRepository extends GenericoRepository<TipoComprobanteEntity, Long> {
    @Query("select e from TipoComprobanteEntity e where e.estado='A'")
    List<TipoComprobanteEntity> findAllCustom();
}
