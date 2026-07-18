package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import pe.com.fravadent.dto.DepartamentoDTO;
import pe.com.fravadent.entity.DepartamentoEntity;
import pe.com.fravadent.repository.DepartamentoRepository;
import pe.com.fravadent.service.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	private final ModelMapper modelMapper;
	private final DepartamentoRepository repositorio;

	public DepartamentoServiceImpl(DepartamentoRepository repositorio, ModelMapper modelMapper) {
		this.repositorio = repositorio;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<DepartamentoDTO> findAll() {
		return repositorio.findAll().stream().map(e -> modelMapper.map(e, DepartamentoDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<DepartamentoDTO> findAllCustom() {
		return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, DepartamentoDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public DepartamentoDTO findById(Long id) {
		return modelMapper.map(repositorio.findById(id).get(), DepartamentoDTO.class);
	}

	@Override
	public DepartamentoDTO add(DepartamentoDTO obj) {
		obj.setEstado("A");
		DepartamentoEntity entity = modelMapper.map(obj, DepartamentoEntity.class);
		return modelMapper.map(repositorio.save(entity), DepartamentoDTO.class);
	}

	@Override
	public DepartamentoDTO update(DepartamentoDTO obj, Long id) {
		DepartamentoEntity entity = repositorio.findById(id).get();
		modelMapper.map(obj, entity);
		return modelMapper.map(repositorio.save(entity), DepartamentoDTO.class);
	}

	@Override
	public DepartamentoDTO delete(Long id) {
		DepartamentoEntity entity = repositorio.findById(id).get();
		entity.setEstado("I");
		return modelMapper.map(repositorio.save(entity), DepartamentoDTO.class);
	}

	@Override
	public DepartamentoDTO enable(Long id) {
		DepartamentoEntity entity = repositorio.findById(id).get();
		entity.setEstado("A");
		return modelMapper.map(repositorio.save(entity), DepartamentoDTO.class);
	}
}
