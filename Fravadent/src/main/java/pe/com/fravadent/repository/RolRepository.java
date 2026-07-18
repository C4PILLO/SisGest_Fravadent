package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.RolEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface RolRepository extends GenericoRepository<RolEntity, Long> {
	@Query("select e from RolEntity e where e.estado='A'")
	List<RolEntity> findAllCustom();
}
