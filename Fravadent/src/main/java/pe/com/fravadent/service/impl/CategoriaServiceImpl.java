package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import pe.com.fravadent.dto.CategoriaDTO;
import pe.com.fravadent.entity.CategoriaEntity;
import pe.com.fravadent.repository.CategoriaRepository;
import pe.com.fravadent.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	private final ModelMapper modelMapper;
	private final CategoriaRepository repositorio;

	public CategoriaServiceImpl(CategoriaRepository repositorio, ModelMapper modelMapper) {
		this.repositorio = repositorio;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<CategoriaDTO> findAll() {
		return repositorio.findAll().stream().map(e -> modelMapper.map(e, CategoriaDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<CategoriaDTO> findAllCustom() {
		return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, CategoriaDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public CategoriaDTO findById(Long id) {
		return modelMapper.map(repositorio.findById(id).get(), CategoriaDTO.class);
	}

	@Override
	public CategoriaDTO add(CategoriaDTO obj) {
		obj.setEstado("A");
		CategoriaEntity entity = modelMapper.map(obj, CategoriaEntity.class);
		return modelMapper.map(repositorio.save(entity), CategoriaDTO.class);
	}

	@Override
	public CategoriaDTO update(CategoriaDTO obj, Long id) {
		CategoriaEntity entity = repositorio.findById(id).get();
		modelMapper.map(obj, entity);
		return modelMapper.map(repositorio.save(entity), CategoriaDTO.class);
	}

	@Override
	public CategoriaDTO delete(Long id) {
		CategoriaEntity entity = repositorio.findById(id).get();
		entity.setEstado("I");
		return modelMapper.map(repositorio.save(entity), CategoriaDTO.class);
	}

	@Override
	public CategoriaDTO enable(Long id) {
		CategoriaEntity entity = repositorio.findById(id).get();
		entity.setEstado("A");
		return modelMapper.map(repositorio.save(entity), CategoriaDTO.class);
	}
}
