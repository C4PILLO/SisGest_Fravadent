package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.CategoriaEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface CategoriaRepository extends GenericoRepository<CategoriaEntity, Long> {
	@Query("select e from CategoriaEntity e where e.estado='A'")
	List<CategoriaEntity> findAllCustom();
}
