package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.MarcaEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface MarcaRepository extends GenericoRepository<MarcaEntity, Long> {
	@Query("select e from MarcaEntity e where e.estado='A'")
	List<MarcaEntity> findAllCustom();
}
