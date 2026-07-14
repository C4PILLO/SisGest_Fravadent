package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.CompraEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface CompraRepository extends GenericoRepository<CompraEntity, Long> {
    @Query("select e from CompraEntity e where e.estado='A'")
    List<CompraEntity> findAllCustom();
}
