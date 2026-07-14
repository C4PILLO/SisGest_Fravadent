package pe.com.fravadent.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.com.fravadent.dto.ClienteDTO;
import pe.com.fravadent.dto.CompraDTO;
import pe.com.fravadent.dto.DespachoDTO;
import pe.com.fravadent.dto.ProductoDTO;
import pe.com.fravadent.dto.ProveedorDTO;
import pe.com.fravadent.dto.UsuarioDTO;
import pe.com.fravadent.dto.VentaDTO;
import pe.com.fravadent.entity.ClienteEntity;
import pe.com.fravadent.entity.CompraEntity;
import pe.com.fravadent.entity.DespachoEntity;
import pe.com.fravadent.entity.ProductoEntity;
import pe.com.fravadent.entity.ProveedorEntity;
import pe.com.fravadent.entity.UsuarioEntity;
import pe.com.fravadent.entity.VentaEntity;

@Configuration
public class ModelMapping {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD)
                .setAmbiguityIgnored(true);

        modelMapper.emptyTypeMap(ProductoDTO.class, ProductoEntity.class)
                .addMappings(mapper -> {
                    mapper.skip(ProductoEntity::setCategoria);
                    mapper.skip(ProductoEntity::setMarca);
                }).implicitMappings();

        modelMapper.emptyTypeMap(ClienteDTO.class, ClienteEntity.class)
                .addMappings(mapper -> {
                    mapper.skip(ClienteEntity::setDistrito);
                    mapper.skip(ClienteEntity::setTipoDocumento);
                }).implicitMappings();

        modelMapper.emptyTypeMap(UsuarioDTO.class, UsuarioEntity.class)
                .addMappings(mapper -> {
                    mapper.skip(UsuarioEntity::setDistrito);
                    mapper.skip(UsuarioEntity::setTipoDocumento);
                    mapper.skip(UsuarioEntity::setRol);
                }).implicitMappings();

        modelMapper.emptyTypeMap(ProveedorDTO.class, ProveedorEntity.class)
                .addMappings(mapper -> {
                    mapper.skip(ProveedorEntity::setDistrito);
                }).implicitMappings();

        modelMapper.emptyTypeMap(VentaDTO.class, VentaEntity.class)
                .addMappings(mapper -> {
                    mapper.skip(VentaEntity::setCliente);
                    mapper.skip(VentaEntity::setUsuario);
                    mapper.skip(VentaEntity::setTipoComprobante);
                    mapper.skip(VentaEntity::setMetodoPago);
                    mapper.skip(VentaEntity::setEstadoVenta);
                }).implicitMappings();

        modelMapper.emptyTypeMap(CompraDTO.class, CompraEntity.class)
                .addMappings(mapper -> {
                    mapper.skip(CompraEntity::setProveedor);
                    mapper.skip(CompraEntity::setUsuario);
                }).implicitMappings();

        modelMapper.emptyTypeMap(DespachoDTO.class, DespachoEntity.class)
                .addMappings(mapper -> {
                    mapper.skip(DespachoEntity::setVenta);
                    mapper.skip(DespachoEntity::setEstadoDespacho);
                }).implicitMappings();

        return modelMapper;
    }
}
