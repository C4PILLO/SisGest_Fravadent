package pe.com.fravadent.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import pe.com.fravadent.dto.ProveedorDTO;
import pe.com.fravadent.entity.ProveedorEntity;
import pe.com.fravadent.repository.ProveedorRepository;
import pe.com.fravadent.service.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService {
	private final ModelMapper modelMapper;
	private final ProveedorRepository repositorio;

	public ProveedorServiceImpl(ProveedorRepository repositorio, ModelMapper modelMapper) {
		this.repositorio = repositorio;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<ProveedorDTO> findAll() {
		return repositorio.findAll().stream().map(e -> modelMapper.map(e, ProveedorDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ProveedorDTO> findAllCustom() {
		return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, ProveedorDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ProveedorDTO findById(Long id) {
		return modelMapper.map(repositorio.findById(id).get(), ProveedorDTO.class);
	}

	@Override
	public ProveedorDTO add(ProveedorDTO obj) {
		obj.setEstado("A");
		obj.setFechaRegistro(LocalDate.now());
		ProveedorEntity entity = modelMapper.map(obj, ProveedorEntity.class);
		return modelMapper.map(repositorio.save(entity), ProveedorDTO.class);
	}

	@Override
	public ProveedorDTO update(ProveedorDTO obj, Long id) {
		ProveedorEntity entity = repositorio.findById(id).get();
		entity.setDistrito(null);
		modelMapper.map(obj, entity);
		return modelMapper.map(repositorio.save(entity), ProveedorDTO.class);
	}

	@Override
	public ProveedorDTO delete(Long id) {
		ProveedorEntity entity = repositorio.findById(id).get();
		entity.setEstado("I");
		return modelMapper.map(repositorio.save(entity), ProveedorDTO.class);
	}

	@Override
	public ProveedorDTO enable(Long id) {
		ProveedorEntity entity = repositorio.findById(id).get();
		entity.setEstado("A");
		return modelMapper.map(repositorio.save(entity), ProveedorDTO.class);
	}
}
