package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.DepartamentoEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface DepartamentoRepository extends GenericoRepository<DepartamentoEntity, Long> {
    @Query("select e from DepartamentoEntity e where e.estado='A'")
    List<DepartamentoEntity> findAllCustom();
}
