package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.EstadoVentaEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface EstadoVentaRepository extends GenericoRepository<EstadoVentaEntity, Long> {
	@Query("select e from EstadoVentaEntity e where e.estado='A'")
	List<EstadoVentaEntity> findAllCustom();
}
