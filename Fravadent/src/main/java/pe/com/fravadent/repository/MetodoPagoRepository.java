package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.MetodoPagoEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface MetodoPagoRepository extends GenericoRepository<MetodoPagoEntity, Long> {
	@Query("select e from MetodoPagoEntity e where e.estado='A'")
	List<MetodoPagoEntity> findAllCustom();
}
