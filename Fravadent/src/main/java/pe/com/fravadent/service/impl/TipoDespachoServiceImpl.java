package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.fravadent.dto.TipoDespachoDTO;
import pe.com.fravadent.entity.TipoDespachoEntity;
import pe.com.fravadent.repository.TipoDespachoRepository;
import pe.com.fravadent.service.TipoDespachoService;

@Service
public class TipoDespachoServiceImpl implements TipoDespachoService {
    private final ModelMapper modelMapper;
    private final TipoDespachoRepository repositorio;

    public TipoDespachoServiceImpl(TipoDespachoRepository repositorio, ModelMapper modelMapper) {
        this.repositorio = repositorio;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TipoDespachoDTO> findAll() {
        return repositorio.findAll().stream().map(e -> modelMapper.map(e, TipoDespachoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<TipoDespachoDTO> findAllCustom() {
        return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, TipoDespachoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TipoDespachoDTO findById(Long id) {
        return modelMapper.map(repositorio.findById(id).get(), TipoDespachoDTO.class);
    }

    @Override
    public TipoDespachoDTO add(TipoDespachoDTO obj) {
        obj.setEstado("A");
        TipoDespachoEntity entity = modelMapper.map(obj, TipoDespachoEntity.class);
        return modelMapper.map(repositorio.save(entity), TipoDespachoDTO.class);
    }

    @Override
    public TipoDespachoDTO update(TipoDespachoDTO obj, Long id) {
        TipoDespachoEntity entity = repositorio.findById(id).get();
        modelMapper.map(obj, entity);
        return modelMapper.map(repositorio.save(entity), TipoDespachoDTO.class);
    }

    @Override
    public TipoDespachoDTO delete(Long id) {
        TipoDespachoEntity entity = repositorio.findById(id).get();
        entity.setEstado("I");
        return modelMapper.map(repositorio.save(entity), TipoDespachoDTO.class);
    }

    @Override
    public TipoDespachoDTO enable(Long id) {
        TipoDespachoEntity entity = repositorio.findById(id).get();
        entity.setEstado("A");
        return modelMapper.map(repositorio.save(entity), TipoDespachoDTO.class);
    }
}
