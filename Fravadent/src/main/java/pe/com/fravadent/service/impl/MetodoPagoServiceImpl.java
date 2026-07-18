package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import pe.com.fravadent.dto.MetodoPagoDTO;
import pe.com.fravadent.entity.MetodoPagoEntity;
import pe.com.fravadent.repository.MetodoPagoRepository;
import pe.com.fravadent.service.MetodoPagoService;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {
	private final ModelMapper modelMapper;
	private final MetodoPagoRepository repositorio;

	public MetodoPagoServiceImpl(MetodoPagoRepository repositorio, ModelMapper modelMapper) {
		this.repositorio = repositorio;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<MetodoPagoDTO> findAll() {
		return repositorio.findAll().stream().map(e -> modelMapper.map(e, MetodoPagoDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<MetodoPagoDTO> findAllCustom() {
		return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, MetodoPagoDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public MetodoPagoDTO findById(Long id) {
		return modelMapper.map(repositorio.findById(id).get(), MetodoPagoDTO.class);
	}

	@Override
	public MetodoPagoDTO add(MetodoPagoDTO obj) {
		obj.setEstado("A");
		MetodoPagoEntity entity = modelMapper.map(obj, MetodoPagoEntity.class);
		return modelMapper.map(repositorio.save(entity), MetodoPagoDTO.class);
	}

	@Override
	public MetodoPagoDTO update(MetodoPagoDTO obj, Long id) {
		MetodoPagoEntity entity = repositorio.findById(id).get();
		modelMapper.map(obj, entity);
		return modelMapper.map(repositorio.save(entity), MetodoPagoDTO.class);
	}

	@Override
	public MetodoPagoDTO delete(Long id) {
		MetodoPagoEntity entity = repositorio.findById(id).get();
		entity.setEstado("I");
		return modelMapper.map(repositorio.save(entity), MetodoPagoDTO.class);
	}

	@Override
	public MetodoPagoDTO enable(Long id) {
		MetodoPagoEntity entity = repositorio.findById(id).get();
		entity.setEstado("A");
		return modelMapper.map(repositorio.save(entity), MetodoPagoDTO.class);
	}
}
