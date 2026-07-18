package pe.com.fravadent.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.fravadent.dto.CompraDTO;
import pe.com.fravadent.dto.DetalleCompraDTO;
import pe.com.fravadent.dto.wrapper.CompraWrapperDTO;
import pe.com.fravadent.entity.CompraEntity;
import pe.com.fravadent.entity.DetalleCompraEntity;
import pe.com.fravadent.entity.ProductoEntity;
import pe.com.fravadent.entity.MovimientoInventarioEntity;
import pe.com.fravadent.entity.TipoMovimientoEntity;
import pe.com.fravadent.entity.UsuarioEntity;
import pe.com.fravadent.repository.CompraRepository;
import pe.com.fravadent.repository.DetalleCompraRepository;
import pe.com.fravadent.repository.ProductoRepository;
import pe.com.fravadent.repository.UsuarioRepository;
import pe.com.fravadent.repository.MovimientoInventarioRepository;
import pe.com.fravadent.service.CompraService;

@Service
public class CompraServiceImpl implements CompraService {

    private final ModelMapper modelMapper;
    private final CompraRepository repositorio;
    private final DetalleCompraRepository detalleRepo;
    private final ProductoRepository productoRepo;
    private final MovimientoInventarioRepository movRepo;
    private final UsuarioRepository usuarioRepo;

    public CompraServiceImpl(CompraRepository repositorio, ModelMapper modelMapper, 
                             DetalleCompraRepository detalleRepo, 
                             ProductoRepository productoRepo, 
                             MovimientoInventarioRepository movRepo,
                             UsuarioRepository usuarioRepo) {
        this.repositorio = repositorio;
        this.modelMapper = modelMapper;
        this.detalleRepo = detalleRepo;
        this.productoRepo = productoRepo;
        this.movRepo = movRepo;
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public List<CompraDTO> findAll() {
        return repositorio.findAll().stream().map(e -> modelMapper.map(e, CompraDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<CompraDTO> findAllCustom() {
        return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, CompraDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CompraDTO findById(Long id) {
        return modelMapper.map(repositorio.findById(id).get(), CompraDTO.class);
    }

    @Override
    public CompraDTO add(CompraDTO obj) {
        obj.setEstado("A");
        CompraEntity entity = modelMapper.map(obj, CompraEntity.class);
        return modelMapper.map(repositorio.save(entity), CompraDTO.class);
    }

    @Override
    public CompraDTO update(CompraDTO obj, Long id) {
        CompraEntity entity = repositorio.findById(id).get();
        entity.setProveedor(null);
        entity.setUsuario(null);
        modelMapper.map(obj, entity);
        return modelMapper.map(repositorio.save(entity), CompraDTO.class);
    }

    @Override
    public CompraDTO delete(Long id) {
        CompraEntity entity = repositorio.findById(id).get();
        entity.setEstado("I");
        return modelMapper.map(repositorio.save(entity), CompraDTO.class);
    }

    @Override
    public CompraDTO enable(Long id) {
        CompraEntity entity = repositorio.findById(id).get();
        entity.setEstado("A");
        return modelMapper.map(repositorio.save(entity), CompraDTO.class);
    }

    @Transactional
    @Override
    public CompraDTO registrarTransaccional(CompraWrapperDTO wrapper) {
        CompraDTO compra = wrapper.getCompra();
        compra.setEstado("A");
        
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UsuarioEntity usuarioLogueado = usuarioRepo.findByUsername(username);
        
        CompraEntity cEntity = modelMapper.map(compra, CompraEntity.class);
        if (usuarioLogueado != null) {
            cEntity.setUsuario(usuarioLogueado);
        }
        
        cEntity = repositorio.save(cEntity);
        
        if (wrapper.getDetalles() != null) {
            for(DetalleCompraDTO det : wrapper.getDetalles()) {
                DetalleCompraEntity detEntity = modelMapper.map(det, DetalleCompraEntity.class);
                detEntity.setCompra(cEntity);
                detalleRepo.save(detEntity);
                
                ProductoEntity prod = productoRepo.findById(detEntity.getProducto().getCodigo()).orElseThrow();
                prod.setStockActual(prod.getStockActual() + detEntity.getCantidad());
                productoRepo.save(prod);
                
                MovimientoInventarioEntity mov = new MovimientoInventarioEntity();
                mov.setProducto(prod);
                TipoMovimientoEntity tm = new TipoMovimientoEntity();
                tm.setCodigo(1L);
                mov.setTipoMovimiento(tm);
                mov.setCantidad(detEntity.getCantidad());
                mov.setReferenciaTipo("COMPRA");
                mov.setReferenciaId(cEntity.getCodigo());
                mov.setUsuario(cEntity.getUsuario());
                mov.setFechaHora(LocalDateTime.now());
                movRepo.save(mov);
            }
        }
        return modelMapper.map(cEntity, CompraDTO.class);
    }
}
