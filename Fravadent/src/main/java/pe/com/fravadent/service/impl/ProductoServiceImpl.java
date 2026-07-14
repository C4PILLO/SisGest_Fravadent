package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.fravadent.dto.ProductoDTO;
import pe.com.fravadent.entity.ProductoEntity;
import pe.com.fravadent.repository.ProductoRepository;
import pe.com.fravadent.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
    private final ModelMapper modelMapper;
    private final ProductoRepository repositorio;

    public ProductoServiceImpl(ProductoRepository repositorio, ModelMapper modelMapper) {
        this.repositorio = repositorio;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductoDTO> findAll() {
        return repositorio.findAll().stream().map(e -> modelMapper.map(e, ProductoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductoDTO> findAllCustom() {
        return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, ProductoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ProductoDTO findById(Long id) {
        return modelMapper.map(repositorio.findById(id).get(), ProductoDTO.class);
    }

    @Override
    public ProductoDTO add(ProductoDTO obj) {
        obj.setEstado("A");
        ProductoEntity entity = modelMapper.map(obj, ProductoEntity.class);
        return modelMapper.map(repositorio.save(entity), ProductoDTO.class);
    }

    @Override
    public ProductoDTO update(ProductoDTO obj, Long id) {
        ProductoEntity entity = repositorio.findById(id).get();
        modelMapper.map(obj, entity);
        return modelMapper.map(repositorio.save(entity), ProductoDTO.class);
    }

    @Override
    public ProductoDTO delete(Long id) {
        ProductoEntity entity = repositorio.findById(id).get();
        entity.setEstado("I");
        return modelMapper.map(repositorio.save(entity), ProductoDTO.class);
    }

    @Override
    public ProductoDTO enable(Long id) {
        ProductoEntity entity = repositorio.findById(id).get();
        entity.setEstado("A");
        return modelMapper.map(repositorio.save(entity), ProductoDTO.class);
    }
}
