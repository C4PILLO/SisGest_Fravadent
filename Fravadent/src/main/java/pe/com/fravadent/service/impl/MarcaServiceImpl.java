package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.fravadent.dto.MarcaDTO;
import pe.com.fravadent.entity.MarcaEntity;
import pe.com.fravadent.repository.MarcaRepository;
import pe.com.fravadent.service.MarcaService;

@Service
public class MarcaServiceImpl implements MarcaService {
    private final ModelMapper modelMapper;
    private final MarcaRepository repositorio;

    public MarcaServiceImpl(MarcaRepository repositorio, ModelMapper modelMapper) {
        this.repositorio = repositorio;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MarcaDTO> findAll() {
        return repositorio.findAll().stream().map(e -> modelMapper.map(e, MarcaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<MarcaDTO> findAllCustom() {
        return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, MarcaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public MarcaDTO findById(Long id) {
        return modelMapper.map(repositorio.findById(id).get(), MarcaDTO.class);
    }

    @Override
    public MarcaDTO add(MarcaDTO obj) {
        obj.setEstado("A");
        MarcaEntity entity = modelMapper.map(obj, MarcaEntity.class);
        return modelMapper.map(repositorio.save(entity), MarcaDTO.class);
    }

    @Override
    public MarcaDTO update(MarcaDTO obj, Long id) {
        MarcaEntity entity = repositorio.findById(id).get();
        modelMapper.map(obj, entity);
        return modelMapper.map(repositorio.save(entity), MarcaDTO.class);
    }

    @Override
    public MarcaDTO delete(Long id) {
        MarcaEntity entity = repositorio.findById(id).get();
        entity.setEstado("I");
        return modelMapper.map(repositorio.save(entity), MarcaDTO.class);
    }

    @Override
    public MarcaDTO enable(Long id) {
        MarcaEntity entity = repositorio.findById(id).get();
        entity.setEstado("A");
        return modelMapper.map(repositorio.save(entity), MarcaDTO.class);
    }
}
