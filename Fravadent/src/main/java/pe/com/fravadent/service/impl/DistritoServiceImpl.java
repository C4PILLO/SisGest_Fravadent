package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import pe.com.fravadent.dto.DistritoDTO;
import pe.com.fravadent.entity.DistritoEntity;
import pe.com.fravadent.repository.DistritoRepository;
import pe.com.fravadent.service.DistritoService;

@Service
public class DistritoServiceImpl implements DistritoService {
	private final ModelMapper modelMapper;
	private final DistritoRepository repositorio;

	public DistritoServiceImpl(DistritoRepository repositorio, ModelMapper modelMapper) {
		this.repositorio = repositorio;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<DistritoDTO> findAll() {
		return repositorio.findAll().stream().map(e -> modelMapper.map(e, DistritoDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<DistritoDTO> findAllCustom() {
		return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, DistritoDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public DistritoDTO findById(Long id) {
		return modelMapper.map(repositorio.findById(id).get(), DistritoDTO.class);
	}

	@Override
	public DistritoDTO add(DistritoDTO obj) {
		obj.setEstado("A");
		DistritoEntity entity = modelMapper.map(obj, DistritoEntity.class);
		return modelMapper.map(repositorio.save(entity), DistritoDTO.class);
	}

	@Override
	public DistritoDTO update(DistritoDTO obj, Long id) {
		DistritoEntity entity = repositorio.findById(id).get();
		modelMapper.map(obj, entity);
		return modelMapper.map(repositorio.save(entity), DistritoDTO.class);
	}

	@Override
	public DistritoDTO delete(Long id) {
		DistritoEntity entity = repositorio.findById(id).get();
		entity.setEstado("I");
		return modelMapper.map(repositorio.save(entity), DistritoDTO.class);
	}

	@Override
	public DistritoDTO enable(Long id) {
		DistritoEntity entity = repositorio.findById(id).get();
		entity.setEstado("A");
		return modelMapper.map(repositorio.save(entity), DistritoDTO.class);
	}
}
