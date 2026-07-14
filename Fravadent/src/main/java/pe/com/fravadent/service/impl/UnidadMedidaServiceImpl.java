package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.fravadent.dto.UnidadMedidaDTO;
import pe.com.fravadent.entity.UnidadMedidaEntity;
import pe.com.fravadent.repository.UnidadMedidaRepository;
import pe.com.fravadent.service.UnidadMedidaService;

@Service
public class UnidadMedidaServiceImpl implements UnidadMedidaService {
    private final ModelMapper modelMapper;
    private final UnidadMedidaRepository repositorio;

    public UnidadMedidaServiceImpl(UnidadMedidaRepository repositorio, ModelMapper modelMapper) {
        this.repositorio = repositorio;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UnidadMedidaDTO> findAll() {
        return repositorio.findAll().stream().map(e -> modelMapper.map(e, UnidadMedidaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<UnidadMedidaDTO> findAllCustom() {
        return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, UnidadMedidaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UnidadMedidaDTO findById(Long id) {
        return modelMapper.map(repositorio.findById(id).get(), UnidadMedidaDTO.class);
    }

    @Override
    public UnidadMedidaDTO add(UnidadMedidaDTO obj) {
        obj.setEstado("A");
        UnidadMedidaEntity entity = modelMapper.map(obj, UnidadMedidaEntity.class);
        return modelMapper.map(repositorio.save(entity), UnidadMedidaDTO.class);
    }

    @Override
    public UnidadMedidaDTO update(UnidadMedidaDTO obj, Long id) {
        UnidadMedidaEntity entity = repositorio.findById(id).get();
        modelMapper.map(obj, entity);
        return modelMapper.map(repositorio.save(entity), UnidadMedidaDTO.class);
    }

    @Override
    public UnidadMedidaDTO delete(Long id) {
        UnidadMedidaEntity entity = repositorio.findById(id).get();
        entity.setEstado("I");
        return modelMapper.map(repositorio.save(entity), UnidadMedidaDTO.class);
    }

    @Override
    public UnidadMedidaDTO enable(Long id) {
        UnidadMedidaEntity entity = repositorio.findById(id).get();
        entity.setEstado("A");
        return modelMapper.map(repositorio.save(entity), UnidadMedidaDTO.class);
    }
}
