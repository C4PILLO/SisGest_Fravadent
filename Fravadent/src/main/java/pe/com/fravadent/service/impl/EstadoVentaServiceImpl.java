package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.fravadent.dto.EstadoVentaDTO;
import pe.com.fravadent.entity.EstadoVentaEntity;
import pe.com.fravadent.repository.EstadoVentaRepository;
import pe.com.fravadent.service.EstadoVentaService;

@Service
public class EstadoVentaServiceImpl implements EstadoVentaService {
    private final ModelMapper modelMapper;
    private final EstadoVentaRepository repositorio;

    public EstadoVentaServiceImpl(EstadoVentaRepository repositorio, ModelMapper modelMapper) {
        this.repositorio = repositorio;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EstadoVentaDTO> findAll() {
        return repositorio.findAll().stream().map(e -> modelMapper.map(e, EstadoVentaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<EstadoVentaDTO> findAllCustom() {
        return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, EstadoVentaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public EstadoVentaDTO findById(Long id) {
        return modelMapper.map(repositorio.findById(id).get(), EstadoVentaDTO.class);
    }

    @Override
    public EstadoVentaDTO add(EstadoVentaDTO obj) {
        obj.setEstado("A");
        EstadoVentaEntity entity = modelMapper.map(obj, EstadoVentaEntity.class);
        return modelMapper.map(repositorio.save(entity), EstadoVentaDTO.class);
    }

    @Override
    public EstadoVentaDTO update(EstadoVentaDTO obj, Long id) {
        EstadoVentaEntity entity = repositorio.findById(id).get();
        modelMapper.map(obj, entity);
        return modelMapper.map(repositorio.save(entity), EstadoVentaDTO.class);
    }

    @Override
    public EstadoVentaDTO delete(Long id) {
        EstadoVentaEntity entity = repositorio.findById(id).get();
        entity.setEstado("I");
        return modelMapper.map(repositorio.save(entity), EstadoVentaDTO.class);
    }

    @Override
    public EstadoVentaDTO enable(Long id) {
        EstadoVentaEntity entity = repositorio.findById(id).get();
        entity.setEstado("A");
        return modelMapper.map(repositorio.save(entity), EstadoVentaDTO.class);
    }
}
