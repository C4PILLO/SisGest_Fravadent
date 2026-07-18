package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.DespachoEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface DespachoRepository extends GenericoRepository<DespachoEntity, Long> {
    @Query("select e from DespachoEntity e")
    List<DespachoEntity> findAllCustom();
}
