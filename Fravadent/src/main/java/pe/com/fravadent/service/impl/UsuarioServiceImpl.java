package pe.com.fravadent.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.fravadent.dto.UsuarioDTO;
import pe.com.fravadent.entity.UsuarioEntity;
import pe.com.fravadent.repository.UsuarioRepository;
import pe.com.fravadent.service.UsuarioService;
import pe.com.fravadent.util.GenerarEncriptacion;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final ModelMapper modelMapper;
    private final UsuarioRepository repositorio;

    public UsuarioServiceImpl(UsuarioRepository repositorio, ModelMapper modelMapper) {
        this.repositorio = repositorio;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UsuarioDTO> findAll() {
        return repositorio.findAll().stream().map(e -> modelMapper.map(e, UsuarioDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<UsuarioDTO> findAllCustom() {
        return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, UsuarioDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO findById(Long id) {
        return modelMapper.map(repositorio.findById(id).get(), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO add(UsuarioDTO obj) {
        obj.setEstado("A");
        obj.setFechaRegistro(LocalDate.now());
        if (obj.getPassword_hash() != null && !obj.getPassword_hash().isEmpty()) {
            obj.setPassword_hash(GenerarEncriptacion.encriptar(obj.getPassword_hash()));
        }
        UsuarioEntity entity = modelMapper.map(obj, UsuarioEntity.class);
        return modelMapper.map(repositorio.save(entity), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO update(UsuarioDTO obj, Long id) {
        UsuarioEntity entity = repositorio.findById(id).get();
        entity.setDistrito(null);
        entity.setTipoDocumento(null);
        entity.setRol(null);
        
        String oldPassword = entity.getPassword_hash();
        
        modelMapper.map(obj, entity);
        
        if (obj.getPassword_hash() != null && !obj.getPassword_hash().isEmpty()) {
            entity.setPassword_hash(GenerarEncriptacion.encriptar(obj.getPassword_hash()));
        } else {
            entity.setPassword_hash(oldPassword);
        }
        
        return modelMapper.map(repositorio.save(entity), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO delete(Long id) {
        UsuarioEntity entity = repositorio.findById(id).get();
        entity.setEstado("I");
        return modelMapper.map(repositorio.save(entity), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO enable(Long id) {
        UsuarioEntity entity = repositorio.findById(id).get();
        entity.setEstado("A");
        return modelMapper.map(repositorio.save(entity), UsuarioDTO.class);
    }
}
