package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.ProductoEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface ProductoRepository extends GenericoRepository<ProductoEntity, Long> {
    @Query("select e from ProductoEntity e where e.estado='A'")
    List<ProductoEntity> findAllCustom();
}
