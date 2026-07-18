package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import pe.com.fravadent.dto.DetalleCompraDTO;
import pe.com.fravadent.entity.DetalleCompraEntity;
import pe.com.fravadent.repository.DetalleCompraRepository;
import pe.com.fravadent.service.DetalleCompraService;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService {
	private final ModelMapper modelMapper;
	private final DetalleCompraRepository repositorio;

	public DetalleCompraServiceImpl(DetalleCompraRepository repositorio, ModelMapper modelMapper) {
		this.repositorio = repositorio;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<DetalleCompraDTO> findAll() {
		return repositorio.findAll().stream().map(e -> modelMapper.map(e, DetalleCompraDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<DetalleCompraDTO> findAllCustom() {
		return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, DetalleCompraDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public DetalleCompraDTO findById(Long id) {
		return modelMapper.map(repositorio.findById(id).get(), DetalleCompraDTO.class);
	}

	@Override
	public DetalleCompraDTO add(DetalleCompraDTO obj) {
		DetalleCompraEntity entity = modelMapper.map(obj, DetalleCompraEntity.class);
		return modelMapper.map(repositorio.save(entity), DetalleCompraDTO.class);
	}

	@Override
	public DetalleCompraDTO update(DetalleCompraDTO obj, Long id) {
		DetalleCompraEntity entity = repositorio.findById(id).get();
		modelMapper.map(obj, entity);
		return modelMapper.map(repositorio.save(entity), DetalleCompraDTO.class);
	}

	@Override
	public DetalleCompraDTO delete(Long id) {
		DetalleCompraEntity entity = repositorio.findById(id).get();
		repositorio.delete(entity);
		return modelMapper.map(entity, DetalleCompraDTO.class);
	}

	@Override
	public DetalleCompraDTO enable(Long id) {
		return modelMapper.map(repositorio.findById(id).get(), DetalleCompraDTO.class);
	}
}
