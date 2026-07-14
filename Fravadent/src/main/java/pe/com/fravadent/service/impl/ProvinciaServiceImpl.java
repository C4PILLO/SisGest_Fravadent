package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.fravadent.dto.ProvinciaDTO;
import pe.com.fravadent.entity.ProvinciaEntity;
import pe.com.fravadent.repository.ProvinciaRepository;
import pe.com.fravadent.service.ProvinciaService;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {
    private final ModelMapper modelMapper;
    private final ProvinciaRepository repositorio;

    public ProvinciaServiceImpl(ProvinciaRepository repositorio, ModelMapper modelMapper) {
        this.repositorio = repositorio;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProvinciaDTO> findAll() {
        return repositorio.findAll().stream().map(e -> modelMapper.map(e, ProvinciaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProvinciaDTO> findAllCustom() {
        return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, ProvinciaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ProvinciaDTO findById(Long id) {
        return modelMapper.map(repositorio.findById(id).get(), ProvinciaDTO.class);
    }

    @Override
    public ProvinciaDTO add(ProvinciaDTO obj) {
        obj.setEstado("A");
        ProvinciaEntity entity = modelMapper.map(obj, ProvinciaEntity.class);
        return modelMapper.map(repositorio.save(entity), ProvinciaDTO.class);
    }

    @Override
    public ProvinciaDTO update(ProvinciaDTO obj, Long id) {
        ProvinciaEntity entity = repositorio.findById(id).get();
        modelMapper.map(obj, entity);
        return modelMapper.map(repositorio.save(entity), ProvinciaDTO.class);
    }

    @Override
    public ProvinciaDTO delete(Long id) {
        ProvinciaEntity entity = repositorio.findById(id).get();
        entity.setEstado("I");
        return modelMapper.map(repositorio.save(entity), ProvinciaDTO.class);
    }

    @Override
    public ProvinciaDTO enable(Long id) {
        ProvinciaEntity entity = repositorio.findById(id).get();
        entity.setEstado("A");
        return modelMapper.map(repositorio.save(entity), ProvinciaDTO.class);
    }
}
