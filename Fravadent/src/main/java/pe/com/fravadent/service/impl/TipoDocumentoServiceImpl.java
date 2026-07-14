package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.fravadent.dto.TipoDocumentoDTO;
import pe.com.fravadent.entity.TipoDocumentoEntity;
import pe.com.fravadent.repository.TipoDocumentoRepository;
import pe.com.fravadent.service.TipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {
    private final ModelMapper modelMapper;
    private final TipoDocumentoRepository repositorio;

    public TipoDocumentoServiceImpl(TipoDocumentoRepository repositorio, ModelMapper modelMapper) {
        this.repositorio = repositorio;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TipoDocumentoDTO> findAll() {
        return repositorio.findAll().stream().map(e -> modelMapper.map(e, TipoDocumentoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<TipoDocumentoDTO> findAllCustom() {
        return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, TipoDocumentoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TipoDocumentoDTO findById(Long id) {
        return modelMapper.map(repositorio.findById(id).get(), TipoDocumentoDTO.class);
    }

    @Override
    public TipoDocumentoDTO add(TipoDocumentoDTO obj) {
        obj.setEstado("A");
        TipoDocumentoEntity entity = modelMapper.map(obj, TipoDocumentoEntity.class);
        return modelMapper.map(repositorio.save(entity), TipoDocumentoDTO.class);
    }

    @Override
    public TipoDocumentoDTO update(TipoDocumentoDTO obj, Long id) {
        TipoDocumentoEntity entity = repositorio.findById(id).get();
        modelMapper.map(obj, entity);
        return modelMapper.map(repositorio.save(entity), TipoDocumentoDTO.class);
    }

    @Override
    public TipoDocumentoDTO delete(Long id) {
        TipoDocumentoEntity entity = repositorio.findById(id).get();
        entity.setEstado("I");
        return modelMapper.map(repositorio.save(entity), TipoDocumentoDTO.class);
    }

    @Override
    public TipoDocumentoDTO enable(Long id) {
        TipoDocumentoEntity entity = repositorio.findById(id).get();
        entity.setEstado("A");
        return modelMapper.map(repositorio.save(entity), TipoDocumentoDTO.class);
    }
}
