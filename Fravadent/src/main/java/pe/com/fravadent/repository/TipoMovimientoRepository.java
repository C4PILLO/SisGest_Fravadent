package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.TipoMovimientoEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface TipoMovimientoRepository extends GenericoRepository<TipoMovimientoEntity, Long> {
	@Query("select e from TipoMovimientoEntity e where e.estado='A'")
	List<TipoMovimientoEntity> findAllCustom();
}
