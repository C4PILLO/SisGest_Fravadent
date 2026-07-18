package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.DetalleCompraEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface DetalleCompraRepository extends GenericoRepository<DetalleCompraEntity, Long> {
    @Query("select e from DetalleCompraEntity e")
    List<DetalleCompraEntity> findAllCustom();
}
