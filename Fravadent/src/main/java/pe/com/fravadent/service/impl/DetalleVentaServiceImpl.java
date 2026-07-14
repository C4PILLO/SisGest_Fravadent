package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.fravadent.dto.DetalleVentaDTO;
import pe.com.fravadent.entity.DetalleVentaEntity;
import pe.com.fravadent.repository.DetalleVentaRepository;
import pe.com.fravadent.service.DetalleVentaService;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {
    private final ModelMapper modelMapper;
    private final DetalleVentaRepository repositorio;

    public DetalleVentaServiceImpl(DetalleVentaRepository repositorio, ModelMapper modelMapper) {
        this.repositorio = repositorio;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DetalleVentaDTO> findAll() {
        return repositorio.findAll().stream().map(e -> modelMapper.map(e, DetalleVentaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<DetalleVentaDTO> findAllCustom() {
        return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, DetalleVentaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public DetalleVentaDTO findById(Long id) {
        return modelMapper.map(repositorio.findById(id).get(), DetalleVentaDTO.class);
    }

    @Override
    public DetalleVentaDTO add(DetalleVentaDTO obj) {
        obj.setEstado("A");
        DetalleVentaEntity entity = modelMapper.map(obj, DetalleVentaEntity.class);
        return modelMapper.map(repositorio.save(entity), DetalleVentaDTO.class);
    }

    @Override
    public DetalleVentaDTO update(DetalleVentaDTO obj, Long id) {
        DetalleVentaEntity entity = repositorio.findById(id).get();
        modelMapper.map(obj, entity);
        return modelMapper.map(repositorio.save(entity), DetalleVentaDTO.class);
    }

    @Override
    public DetalleVentaDTO delete(Long id) {
        DetalleVentaEntity entity = repositorio.findById(id).get();
        entity.setEstado("I");
        return modelMapper.map(repositorio.save(entity), DetalleVentaDTO.class);
    }

    @Override
    public DetalleVentaDTO enable(Long id) {
        DetalleVentaEntity entity = repositorio.findById(id).get();
        entity.setEstado("A");
        return modelMapper.map(repositorio.save(entity), DetalleVentaDTO.class);
    }
}
