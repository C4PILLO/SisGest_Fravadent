package pe.com.fravadent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.fravadent.entity.UsuarioEntity;
import pe.com.fravadent.repository.generic.GenericoRepository;

public interface UsuarioRepository extends GenericoRepository<UsuarioEntity, Long> {
    @Query("select e from UsuarioEntity e where e.estado='A'")
    List<UsuarioEntity> findAllCustom();
    
    UsuarioEntity findByUsername(String username);
}
