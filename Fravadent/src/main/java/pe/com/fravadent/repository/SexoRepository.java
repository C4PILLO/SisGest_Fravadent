package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.SexoEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface SexoRepository extends GenericoRepository<SexoEntity, Long> {
    @Query("select e from SexoEntity e where e.estado='A'")
    List<SexoEntity> findAllCustom();
}
