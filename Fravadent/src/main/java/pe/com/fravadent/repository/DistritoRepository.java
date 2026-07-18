package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.DistritoEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface DistritoRepository extends GenericoRepository<DistritoEntity, Long> {
	@Query("select e from DistritoEntity e where e.estado='A'")
	List<DistritoEntity> findAllCustom();
}
