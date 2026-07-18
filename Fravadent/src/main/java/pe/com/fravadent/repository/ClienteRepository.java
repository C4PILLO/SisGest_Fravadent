package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.ClienteEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface ClienteRepository extends GenericoRepository<ClienteEntity, Long> {
	@Query("select e from ClienteEntity e where e.estado='A'")
	List<ClienteEntity> findAllCustom();
}
