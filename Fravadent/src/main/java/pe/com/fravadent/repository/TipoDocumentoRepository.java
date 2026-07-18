package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.TipoDocumentoEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface TipoDocumentoRepository extends GenericoRepository<TipoDocumentoEntity, Long> {
	@Query("select e from TipoDocumentoEntity e where e.estado='A'")
	List<TipoDocumentoEntity> findAllCustom();
}
