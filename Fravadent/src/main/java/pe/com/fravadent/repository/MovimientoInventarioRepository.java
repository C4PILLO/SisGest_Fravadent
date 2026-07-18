package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.MovimientoInventarioEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface MovimientoInventarioRepository extends GenericoRepository<MovimientoInventarioEntity, Long> {
    @Query("select e from MovimientoInventarioEntity e order by e.fechaHora desc")
    List<MovimientoInventarioEntity> findAllCustom();
}
