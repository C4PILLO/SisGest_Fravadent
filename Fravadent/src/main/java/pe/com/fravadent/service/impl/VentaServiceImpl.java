package pe.com.fravadent.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.fravadent.dto.VentaDTO;
import pe.com.fravadent.dto.DetalleVentaDTO;
import pe.com.fravadent.dto.wrapper.VentaWrapperDTO;
import pe.com.fravadent.entity.VentaEntity;
import pe.com.fravadent.entity.DetalleVentaEntity;
import pe.com.fravadent.entity.ProductoEntity;
import pe.com.fravadent.entity.MovimientoInventarioEntity;
import pe.com.fravadent.entity.TipoMovimientoEntity;

import pe.com.fravadent.repository.VentaRepository;
import pe.com.fravadent.repository.DetalleVentaRepository;
import pe.com.fravadent.repository.ProductoRepository;
import pe.com.fravadent.repository.MovimientoInventarioRepository;
import pe.com.fravadent.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService {

    private final ModelMapper modelMapper;
    private final VentaRepository repositorio;
    private final DetalleVentaRepository detalleRepo;
    private final ProductoRepository productoRepo;
    private final MovimientoInventarioRepository movRepo;

    public VentaServiceImpl(VentaRepository repositorio, ModelMapper modelMapper, 
                            DetalleVentaRepository detalleRepo, 
                            ProductoRepository productoRepo, 
                            MovimientoInventarioRepository movRepo) {
        this.repositorio = repositorio;
        this.modelMapper = modelMapper;
        this.detalleRepo = detalleRepo;
        this.productoRepo = productoRepo;
        this.movRepo = movRepo;
    }

    @Override
    public List<VentaDTO> findAll() {
        return repositorio.findAll().stream().map(e -> modelMapper.map(e, VentaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<VentaDTO> findAllCustom() {
        return repositorio.findAllCustom().stream().map(e -> modelMapper.map(e, VentaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public VentaDTO findById(Long id) {
        return modelMapper.map(repositorio.findById(id).get(), VentaDTO.class);
    }

    @Override
    public VentaDTO add(VentaDTO obj) {
        obj.setEstado("A");
        VentaEntity entity = modelMapper.map(obj, VentaEntity.class);
        return modelMapper.map(repositorio.save(entity), VentaDTO.class);
    }

    @Override
    public VentaDTO update(VentaDTO obj, Long id) {
        VentaEntity entity = repositorio.findById(id).get();
        modelMapper.map(obj, entity);
        return modelMapper.map(repositorio.save(entity), VentaDTO.class);
    }

    @Override
    public VentaDTO delete(Long id) {
        VentaEntity entity = repositorio.findById(id).get();
        entity.setEstado("I");
        return modelMapper.map(repositorio.save(entity), VentaDTO.class);
    }

    @Override
    public VentaDTO enable(Long id) {
        VentaEntity entity = repositorio.findById(id).get();
        entity.setEstado("A");
        return modelMapper.map(repositorio.save(entity), VentaDTO.class);
    }

    @Transactional
    @Override
    public VentaDTO registrarTransaccional(VentaWrapperDTO wrapper) {
        VentaDTO venta = wrapper.getVenta();
        venta.setEstado("A");
        VentaEntity vEntity = repositorio.save(modelMapper.map(venta, VentaEntity.class));
        
        if (wrapper.getDetalles() != null) {
            for(DetalleVentaDTO det : wrapper.getDetalles()) {
                DetalleVentaEntity detEntity = modelMapper.map(det, DetalleVentaEntity.class);
                detEntity.setVenta(vEntity);
                detalleRepo.save(detEntity);
                
                ProductoEntity prod = productoRepo.findById(detEntity.getProducto().getCodigo()).orElseThrow();
                prod.setStockActual(prod.getStockActual() - detEntity.getCantidad());
                productoRepo.save(prod);
                
                MovimientoInventarioEntity mov = new MovimientoInventarioEntity();
                mov.setProducto(prod);
                TipoMovimientoEntity tm = new TipoMovimientoEntity();
                tm.setCodigo(2L);
                mov.setTipoMovimiento(tm);
                mov.setCantidad(detEntity.getCantidad());
                mov.setReferenciaTipo("VENTA");
                mov.setReferenciaId(vEntity.getCodigo());
                mov.setUsuario(vEntity.getUsuario());
                mov.setFechaHora(LocalDateTime.now());
                movRepo.save(mov);
            }
        }
        return modelMapper.map(vEntity, VentaDTO.class);
    }
}
