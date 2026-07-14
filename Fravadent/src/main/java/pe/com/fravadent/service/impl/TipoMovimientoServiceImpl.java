package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.fravadent.dto.TipoMovimientoDTO;
import pe.com.fravadent.entity.TipoMovimientoEntity;
import pe.com.fravadent.repository.TipoMovimientoRepository;
import pe.com.fravadent.service.TipoMovimientoService;

@Service
public class TipoMovimientoServiceImpl implements TipoMovimientoService {
    private final ModelMapper modelMapper;
    private final TipoMovimientoRepository repositorio;

    public TipoMovimientoServiceImpl(TipoMovimientoRepository repositorio, ModelMapper modelMapper) {
        this.repositorio = repositorio;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TipoMovimientoDTO> findAll() {
        return repositorio.findAll().stream().map(e -> modelMapper.map(e, TipoMovimientoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<TipoMovimientoDTO> findAllCustom() {
        return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, TipoMovimientoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TipoMovimientoDTO findById(Long id) {
        return modelMapper.map(repositorio.findById(id).get(), TipoMovimientoDTO.class);
    }

    @Override
    public TipoMovimientoDTO add(TipoMovimientoDTO obj) {
        obj.setEstado("A");
        TipoMovimientoEntity entity = modelMapper.map(obj, TipoMovimientoEntity.class);
        return modelMapper.map(repositorio.save(entity), TipoMovimientoDTO.class);
    }

    @Override
    public TipoMovimientoDTO update(TipoMovimientoDTO obj, Long id) {
        TipoMovimientoEntity entity = repositorio.findById(id).get();
        modelMapper.map(obj, entity);
        return modelMapper.map(repositorio.save(entity), TipoMovimientoDTO.class);
    }

    @Override
    public TipoMovimientoDTO delete(Long id) {
        TipoMovimientoEntity entity = repositorio.findById(id).get();
        entity.setEstado("I");
        return modelMapper.map(repositorio.save(entity), TipoMovimientoDTO.class);
    }

    @Override
    public TipoMovimientoDTO enable(Long id) {
        TipoMovimientoEntity entity = repositorio.findById(id).get();
        entity.setEstado("A");
        return modelMapper.map(repositorio.save(entity), TipoMovimientoDTO.class);
    }
}
