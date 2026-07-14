package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.fravadent.dto.DespachoDTO;
import pe.com.fravadent.entity.DespachoEntity;
import pe.com.fravadent.repository.DespachoRepository;
import pe.com.fravadent.service.DespachoService;

@Service
public class DespachoServiceImpl implements DespachoService {
    private final ModelMapper modelMapper;
    private final DespachoRepository repositorio;

    public DespachoServiceImpl(DespachoRepository repositorio, ModelMapper modelMapper) {
        this.repositorio = repositorio;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DespachoDTO> findAll() {
        return repositorio.findAll().stream().map(e -> modelMapper.map(e, DespachoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<DespachoDTO> findAllCustom() {
        return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, DespachoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public DespachoDTO findById(Long id) {
        return modelMapper.map(repositorio.findById(id).get(), DespachoDTO.class);
    }

    @Override
    public DespachoDTO add(DespachoDTO obj) {
        obj.setEstado("A");
        DespachoEntity entity = modelMapper.map(obj, DespachoEntity.class);
        return modelMapper.map(repositorio.save(entity), DespachoDTO.class);
    }

    @Override
    public DespachoDTO update(DespachoDTO obj, Long id) {
        DespachoEntity entity = repositorio.findById(id).get();
        modelMapper.map(obj, entity);
        return modelMapper.map(repositorio.save(entity), DespachoDTO.class);
    }

    @Override
    public DespachoDTO delete(Long id) {
        DespachoEntity entity = repositorio.findById(id).get();
        entity.setEstado("I");
        return modelMapper.map(repositorio.save(entity), DespachoDTO.class);
    }

    @Override
    public DespachoDTO enable(Long id) {
        DespachoEntity entity = repositorio.findById(id).get();
        entity.setEstado("A");
        return modelMapper.map(repositorio.save(entity), DespachoDTO.class);
    }
}
