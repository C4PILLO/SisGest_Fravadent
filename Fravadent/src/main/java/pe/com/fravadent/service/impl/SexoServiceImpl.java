package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import pe.com.fravadent.dto.SexoDTO;
import pe.com.fravadent.entity.SexoEntity;
import pe.com.fravadent.repository.SexoRepository;
import pe.com.fravadent.service.SexoService;

@Service
public class SexoServiceImpl implements SexoService {
	private final ModelMapper modelMapper;
	private final SexoRepository repositorio;

	public SexoServiceImpl(SexoRepository repositorio, ModelMapper modelMapper) {
		this.repositorio = repositorio;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<SexoDTO> findAll() {
		return repositorio.findAll().stream().map(e -> modelMapper.map(e, SexoDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<SexoDTO> findAllCustom() {
		return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, SexoDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public SexoDTO findById(Long id) {
		return modelMapper.map(repositorio.findById(id).get(), SexoDTO.class);
	}

	@Override
	public SexoDTO add(SexoDTO obj) {
		obj.setEstado("A");
		SexoEntity entity = modelMapper.map(obj, SexoEntity.class);
		return modelMapper.map(repositorio.save(entity), SexoDTO.class);
	}

	@Override
	public SexoDTO update(SexoDTO obj, Long id) {
		SexoEntity entity = repositorio.findById(id).get();
		modelMapper.map(obj, entity);
		return modelMapper.map(repositorio.save(entity), SexoDTO.class);
	}

	@Override
	public SexoDTO delete(Long id) {
		SexoEntity entity = repositorio.findById(id).get();
		entity.setEstado("I");
		return modelMapper.map(repositorio.save(entity), SexoDTO.class);
	}

	@Override
	public SexoDTO enable(Long id) {
		SexoEntity entity = repositorio.findById(id).get();
		entity.setEstado("A");
		return modelMapper.map(repositorio.save(entity), SexoDTO.class);
	}
}
