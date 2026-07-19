package pe.com.fravadent.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.fravadent.dto.MovimientoInventarioDTO;
import pe.com.fravadent.entity.MovimientoInventarioEntity;
import pe.com.fravadent.entity.ProductoEntity;
import pe.com.fravadent.entity.UsuarioEntity;
import pe.com.fravadent.repository.MovimientoInventarioRepository;
import pe.com.fravadent.repository.ProductoRepository;
import pe.com.fravadent.repository.UsuarioRepository;
import pe.com.fravadent.service.MovimientoInventarioService;

@Service
public class MovimientoInventarioServiceImpl implements MovimientoInventarioService {
	private final ModelMapper modelMapper;
	private final MovimientoInventarioRepository repositorio;
	private final ProductoRepository productoRepo;
	private final UsuarioRepository usuarioRepo;

	public MovimientoInventarioServiceImpl(MovimientoInventarioRepository repositorio, ModelMapper modelMapper,
			ProductoRepository productoRepo, UsuarioRepository usuarioRepo) {
		this.repositorio = repositorio;
		this.modelMapper = modelMapper;
		this.productoRepo = productoRepo;
		this.usuarioRepo = usuarioRepo;
	}

	@Override
	public List<MovimientoInventarioDTO> findAll() {
		return repositorio.findAll().stream().map(e -> modelMapper.map(e, MovimientoInventarioDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<MovimientoInventarioDTO> findAllCustom() {
		return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, MovimientoInventarioDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public MovimientoInventarioDTO findById(Long id) {
		return modelMapper.map(repositorio.findById(id).get(), MovimientoInventarioDTO.class);
	}

	@Transactional
	@Override
	public MovimientoInventarioDTO add(MovimientoInventarioDTO obj) {
		if (obj.getFechaHora() == null) {
			obj.setFechaHora(LocalDateTime.now());
		}

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UsuarioEntity usuarioLogueado = usuarioRepo.findByUsername(username);

		MovimientoInventarioEntity entity = modelMapper.map(obj, MovimientoInventarioEntity.class);
		if (usuarioLogueado != null) {
			entity.setUsuario(usuarioLogueado);
		}
		entity = repositorio.save(entity);

		if (entity.getProducto() != null && entity.getTipoMovimiento() != null && entity.getCantidad() != null) {
			ProductoEntity prod = productoRepo.findById(entity.getProducto().getCodigo()).orElse(null);
			if (prod != null) {
				if (entity.getTipoMovimiento().getCodigo() == 1L) {
					prod.setStockActual(prod.getStockActual() + entity.getCantidad());
				} else if (entity.getTipoMovimiento().getCodigo() == 2L) {
					prod.setStockActual(prod.getStockActual() - entity.getCantidad());
				}
				productoRepo.save(prod);
			}
		}

		return modelMapper.map(entity, MovimientoInventarioDTO.class);
	}

	@Override
	public MovimientoInventarioDTO update(MovimientoInventarioDTO obj, Long id) {
		MovimientoInventarioEntity entity = repositorio.findById(id).get();
		if (obj.getProducto() != null && obj.getProducto().getCodigo() != null) entity.setProducto(null);
		if (obj.getTipoMovimiento() != null && obj.getTipoMovimiento().getCodigo() != null) entity.setTipoMovimiento(null);
		if (obj.getUsuario() != null && obj.getUsuario().getCodigo() != null) entity.setUsuario(null);
		modelMapper.map(obj, entity);
		return modelMapper.map(repositorio.save(entity), MovimientoInventarioDTO.class);
	}

	@Transactional
	@Override
	public MovimientoInventarioDTO delete(Long id) {
		MovimientoInventarioEntity entity = repositorio.findById(id).get();

		if (entity.getProducto() != null && entity.getTipoMovimiento() != null && entity.getCantidad() != null) {
			ProductoEntity prod = productoRepo.findById(entity.getProducto().getCodigo()).orElse(null);
			if (prod != null) {
				if (entity.getTipoMovimiento().getCodigo() == 1L) {
					prod.setStockActual(prod.getStockActual() - entity.getCantidad());
				} else if (entity.getTipoMovimiento().getCodigo() == 2L) {
					prod.setStockActual(prod.getStockActual() + entity.getCantidad());
				}
				productoRepo.save(prod);
			}
		}

		repositorio.deleteById(id);
		return modelMapper.map(entity, MovimientoInventarioDTO.class);
	}

	@Override
	public MovimientoInventarioDTO enable(Long id) {
		return null;
	}
}
