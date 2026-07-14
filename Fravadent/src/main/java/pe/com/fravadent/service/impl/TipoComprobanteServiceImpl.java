package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.fravadent.dto.TipoComprobanteDTO;
import pe.com.fravadent.entity.TipoComprobanteEntity;
import pe.com.fravadent.repository.TipoComprobanteRepository;
import pe.com.fravadent.service.TipoComprobanteService;

@Service
public class TipoComprobanteServiceImpl implements TipoComprobanteService {
    private final ModelMapper modelMapper;
    private final TipoComprobanteRepository repositorio;

    public TipoComprobanteServiceImpl(TipoComprobanteRepository repositorio, ModelMapper modelMapper) {
        this.repositorio = repositorio;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TipoComprobanteDTO> findAll() {
        return repositorio.findAll().stream().map(e -> modelMapper.map(e, TipoComprobanteDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<TipoComprobanteDTO> findAllCustom() {
        return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, TipoComprobanteDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TipoComprobanteDTO findById(Long id) {
        return modelMapper.map(repositorio.findById(id).get(), TipoComprobanteDTO.class);
    }

    @Override
    public TipoComprobanteDTO add(TipoComprobanteDTO obj) {
        obj.setEstado("A");
        TipoComprobanteEntity entity = modelMapper.map(obj, TipoComprobanteEntity.class);
        return modelMapper.map(repositorio.save(entity), TipoComprobanteDTO.class);
    }

    @Override
    public TipoComprobanteDTO update(TipoComprobanteDTO obj, Long id) {
        TipoComprobanteEntity entity = repositorio.findById(id).get();
        modelMapper.map(obj, entity);
        return modelMapper.map(repositorio.save(entity), TipoComprobanteDTO.class);
    }

    @Override
    public TipoComprobanteDTO delete(Long id) {
        TipoComprobanteEntity entity = repositorio.findById(id).get();
        entity.setEstado("I");
        return modelMapper.map(repositorio.save(entity), TipoComprobanteDTO.class);
    }

    @Override
    public TipoComprobanteDTO enable(Long id) {
        TipoComprobanteEntity entity = repositorio.findById(id).get();
        entity.setEstado("A");
        return modelMapper.map(repositorio.save(entity), TipoComprobanteDTO.class);
    }
}
