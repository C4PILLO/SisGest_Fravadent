package pe.com.fravadent.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import pe.com.fravadent.dto.ClienteDTO;
import pe.com.fravadent.entity.ClienteEntity;
import pe.com.fravadent.repository.ClienteRepository;
import pe.com.fravadent.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	private final ModelMapper modelMapper;
	private final ClienteRepository repositorio;

	public ClienteServiceImpl(ClienteRepository repositorio, ModelMapper modelMapper) {
		this.repositorio = repositorio;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<ClienteDTO> findAll() {
		return repositorio.findAll().stream().map(e -> modelMapper.map(e, ClienteDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ClienteDTO> findAllCustom() {
		return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, ClienteDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ClienteDTO findById(Long id) {
		return modelMapper.map(repositorio.findById(id).get(), ClienteDTO.class);
	}

	@Override
	public ClienteDTO add(ClienteDTO obj) {
		obj.setEstado("A");
		obj.setFechaRegistro(LocalDate.now());
		ClienteEntity entity = modelMapper.map(obj, ClienteEntity.class);
		return modelMapper.map(repositorio.save(entity), ClienteDTO.class);
	}

	@Override
	public ClienteDTO update(ClienteDTO obj, Long id) {
		ClienteEntity entity = repositorio.findById(id).get();
		entity.setDistrito(null);
		entity.setTipoDocumento(null);
		modelMapper.map(obj, entity);
		return modelMapper.map(repositorio.save(entity), ClienteDTO.class);
	}

	@Override
	public ClienteDTO delete(Long id) {
		ClienteEntity entity = repositorio.findById(id).get();
		entity.setEstado("I");
		return modelMapper.map(repositorio.save(entity), ClienteDTO.class);
	}

	@Override
	public ClienteDTO enable(Long id) {
		ClienteEntity entity = repositorio.findById(id).get();
		entity.setEstado("A");
		return modelMapper.map(repositorio.save(entity), ClienteDTO.class);
	}
}
