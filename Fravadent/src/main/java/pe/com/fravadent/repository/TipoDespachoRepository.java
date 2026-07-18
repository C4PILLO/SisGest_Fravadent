package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.TipoDespachoEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface TipoDespachoRepository extends GenericoRepository<TipoDespachoEntity, Long> {
	@Query("select e from TipoDespachoEntity e where e.estado='A'")
	List<TipoDespachoEntity> findAllCustom();
}
