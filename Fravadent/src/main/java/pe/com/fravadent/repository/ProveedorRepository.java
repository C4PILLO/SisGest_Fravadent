package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.ProveedorEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface ProveedorRepository extends GenericoRepository<ProveedorEntity, Long> {
	@Query("select e from ProveedorEntity e where e.estado='A'")
	List<ProveedorEntity> findAllCustom();
}
