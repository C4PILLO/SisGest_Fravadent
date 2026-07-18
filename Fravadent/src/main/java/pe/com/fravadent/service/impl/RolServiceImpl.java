package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import pe.com.fravadent.dto.RolDTO;
import pe.com.fravadent.entity.RolEntity;
import pe.com.fravadent.repository.RolRepository;
import pe.com.fravadent.service.RolService;

@Service
public class RolServiceImpl implements RolService {
	private final ModelMapper modelMapper;
	private final RolRepository repositorio;

	public RolServiceImpl(RolRepository repositorio, ModelMapper modelMapper) {
		this.repositorio = repositorio;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<RolDTO> findAll() {
		return repositorio.findAll().stream().map(e -> modelMapper.map(e, RolDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<RolDTO> findAllCustom() {
		return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, RolDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public RolDTO findById(Long id) {
		return modelMapper.map(repositorio.findById(id).get(), RolDTO.class);
	}

	@Override
	public RolDTO add(RolDTO obj) {
		obj.setEstado("A");
		RolEntity entity = modelMapper.map(obj, RolEntity.class);
		return modelMapper.map(repositorio.save(entity), RolDTO.class);
	}

	@Override
	public RolDTO update(RolDTO obj, Long id) {
		RolEntity entity = repositorio.findById(id).get();
		modelMapper.map(obj, entity);
		return modelMapper.map(repositorio.save(entity), RolDTO.class);
	}

	@Override
	public RolDTO delete(Long id) {
		RolEntity entity = repositorio.findById(id).get();
		entity.setEstado("I");
		return modelMapper.map(repositorio.save(entity), RolDTO.class);
	}

	@Override
	public RolDTO enable(Long id) {
		RolEntity entity = repositorio.findById(id).get();
		entity.setEstado("A");
		return modelMapper.map(repositorio.save(entity), RolDTO.class);
	}
}
