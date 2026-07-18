package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import pe.com.fravadent.dto.EstadoDespachoDTO;
import pe.com.fravadent.entity.EstadoDespachoEntity;
import pe.com.fravadent.repository.EstadoDespachoRepository;
import pe.com.fravadent.service.EstadoDespachoService;

@Service
public class EstadoDespachoServiceImpl implements EstadoDespachoService {
	private final ModelMapper modelMapper;
	private final EstadoDespachoRepository repositorio;

	public EstadoDespachoServiceImpl(EstadoDespachoRepository repositorio, ModelMapper modelMapper) {
		this.repositorio = repositorio;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<EstadoDespachoDTO> findAll() {
		return repositorio.findAll().stream().map(e -> modelMapper.map(e, EstadoDespachoDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<EstadoDespachoDTO> findAllCustom() {
		return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, EstadoDespachoDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public EstadoDespachoDTO findById(Long id) {
		return modelMapper.map(repositorio.findById(id).get(), EstadoDespachoDTO.class);
	}

	@Override
	public EstadoDespachoDTO add(EstadoDespachoDTO obj) {
		obj.setEstado("A");
		EstadoDespachoEntity entity = modelMapper.map(obj, EstadoDespachoEntity.class);
		return modelMapper.map(repositorio.save(entity), EstadoDespachoDTO.class);
	}

	@Override
	public EstadoDespachoDTO update(EstadoDespachoDTO obj, Long id) {
		EstadoDespachoEntity entity = repositorio.findById(id).get();
		modelMapper.map(obj, entity);
		return modelMapper.map(repositorio.save(entity), EstadoDespachoDTO.class);
	}

	@Override
	public EstadoDespachoDTO delete(Long id) {
		EstadoDespachoEntity entity = repositorio.findById(id).get();
		entity.setEstado("I");
		return modelMapper.map(repositorio.save(entity), EstadoDespachoDTO.class);
	}

	@Override
	public EstadoDespachoDTO enable(Long id) {
		EstadoDespachoEntity entity = repositorio.findById(id).get();
		entity.setEstado("A");
		return modelMapper.map(repositorio.save(entity), EstadoDespachoDTO.class);
	}
}
