package pe.com.fravadent.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pe.com.fravadent.dto.DespachoDTO;
import pe.com.fravadent.entity.DespachoEntity;
import pe.com.fravadent.entity.EstadoVentaEntity;
import pe.com.fravadent.entity.UsuarioEntity;
import pe.com.fravadent.entity.VentaEntity;
import pe.com.fravadent.repository.DespachoRepository;
import pe.com.fravadent.repository.EstadoVentaRepository;
import pe.com.fravadent.repository.UsuarioRepository;
import pe.com.fravadent.repository.VentaRepository;
import pe.com.fravadent.service.DespachoService;

@Service
public class DespachoServiceImpl implements DespachoService {
	private final ModelMapper modelMapper;
	private final DespachoRepository repositorio;
	private final VentaRepository ventaRepo;
	private final EstadoVentaRepository estadoVentaRepo;
	private final UsuarioRepository usuarioRepo;

	public DespachoServiceImpl(DespachoRepository repositorio, ModelMapper modelMapper, VentaRepository ventaRepo,
			EstadoVentaRepository estadoVentaRepo, UsuarioRepository usuarioRepo) {
		this.repositorio = repositorio;
		this.modelMapper = modelMapper;
		this.ventaRepo = ventaRepo;
		this.estadoVentaRepo = estadoVentaRepo;
		this.usuarioRepo = usuarioRepo;
	}

	@Override
	public List<DespachoDTO> findAll() {
		return repositorio.findAll().stream().map(e -> modelMapper.map(e, DespachoDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<DespachoDTO> findAllCustom() {
		return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, DespachoDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public DespachoDTO findById(Long id) {
		return modelMapper.map(repositorio.findById(id).get(), DespachoDTO.class);
	}

	@Override
	public DespachoDTO add(DespachoDTO obj) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UsuarioEntity usuarioLogueado = usuarioRepo.findByUsername(username);
		DespachoEntity entity = modelMapper.map(obj, DespachoEntity.class);
		if (usuarioLogueado != null) {
			entity.setUsuario(usuarioLogueado);
		}
		return modelMapper.map(repositorio.save(entity), DespachoDTO.class);
	}

	@Override
	public DespachoDTO update(DespachoDTO obj, Long id) {
		DespachoEntity entity = repositorio.findById(id).get();
		entity.setVenta(null);
		entity.setUsuario(null);
		entity.setTipoDespacho(null);
		entity.setEstadoDespacho(null);
		entity.setDistrito(null);
		modelMapper.map(obj, entity);
		DespachoEntity savedDespacho = repositorio.save(entity);

		if (savedDespacho.getEstadoDespacho() != null && savedDespacho.getEstadoDespacho().getCodigo() != null) {

			if (savedDespacho.getEstadoDespacho().getCodigo() == 2L
					|| "Entregado".equalsIgnoreCase(savedDespacho.getEstadoDespacho().getNombre())) {

				if (savedDespacho.getVenta() != null) {
					VentaEntity venta = savedDespacho.getVenta();

					EstadoVentaEntity estadoVenta = estadoVentaRepo.findById(2L).orElse(null);
					if (estadoVenta != null) {
						venta.setEstadoVenta(estadoVenta);
						ventaRepo.save(venta);
					}
				}
			}
		}

		return modelMapper.map(savedDespacho, DespachoDTO.class);
	}

	@Override
	public DespachoDTO delete(Long id) {
		DespachoEntity entity = repositorio.findById(id).get();
		repositorio.delete(entity);
		return modelMapper.map(entity, DespachoDTO.class);
	}

	@Override
	public DespachoDTO enable(Long id) {
		return modelMapper.map(repositorio.findById(id).get(), DespachoDTO.class);
	}
}
