package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.fravadent.dto.MovimientoInventarioDTO;
import pe.com.fravadent.entity.MovimientoInventarioEntity;
import pe.com.fravadent.repository.MovimientoInventarioRepository;
import pe.com.fravadent.service.MovimientoInventarioService;

@Service
public class MovimientoInventarioServiceImpl implements MovimientoInventarioService {
    private final ModelMapper modelMapper;
    private final MovimientoInventarioRepository repositorio;

    public MovimientoInventarioServiceImpl(MovimientoInventarioRepository repositorio, ModelMapper modelMapper) {
        this.repositorio = repositorio;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MovimientoInventarioDTO> findAll() {
        return repositorio.findAll().stream().map(e -> modelMapper.map(e, MovimientoInventarioDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<MovimientoInventarioDTO> findAllCustom() {
        return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, MovimientoInventarioDTO.class)).collect(Collectors.toList());
    }

    @Override
    public MovimientoInventarioDTO findById(Long id) {
        return modelMapper.map(repositorio.findById(id).get(), MovimientoInventarioDTO.class);
    }

    @Override
    public MovimientoInventarioDTO add(MovimientoInventarioDTO obj) {
        obj.setEstado("A");
        MovimientoInventarioEntity entity = modelMapper.map(obj, MovimientoInventarioEntity.class);
        return modelMapper.map(repositorio.save(entity), MovimientoInventarioDTO.class);
    }

    @Override
    public MovimientoInventarioDTO update(MovimientoInventarioDTO obj, Long id) {
        MovimientoInventarioEntity entity = repositorio.findById(id).get();
        modelMapper.map(obj, entity);
        return modelMapper.map(repositorio.save(entity), MovimientoInventarioDTO.class);
    }

    @Override
    public MovimientoInventarioDTO delete(Long id) {
        MovimientoInventarioEntity entity = repositorio.findById(id).get();
        entity.setEstado("I");
        return modelMapper.map(repositorio.save(entity), MovimientoInventarioDTO.class);
    }

    @Override
    public MovimientoInventarioDTO enable(Long id) {
        MovimientoInventarioEntity entity = repositorio.findById(id).get();
        entity.setEstado("A");
        return modelMapper.map(repositorio.save(entity), MovimientoInventarioDTO.class);
    }
}
