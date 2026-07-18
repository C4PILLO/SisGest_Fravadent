package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.ProvinciaEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface ProvinciaRepository extends GenericoRepository<ProvinciaEntity, Long> {
	@Query("select e from ProvinciaEntity e where e.estado='A'")
	List<ProvinciaEntity> findAllCustom();
}
