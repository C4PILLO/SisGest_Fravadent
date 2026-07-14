package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.ProductoDTO;
import pe.com.fravadent.service.ProductoService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/producto")
public class ProductoController extends GenericoController<ProductoDTO> {
    private final ProductoService servicio;

    public ProductoController(ProductoService servicio) {
        this.servicio = servicio;
    }

    @Override
    protected GenericoService<ProductoDTO> getServicio() {
        return servicio;
    }

    @Override
    protected String getRuta() {
        return "producto";
    }

    @Override
    protected String getVistaListar() {
        return "producto/listar";
    }

    @Override
    protected String getVistaRegistrar() {
        return "producto/registrar";
    }

    @Override
    protected String getVistaActualizar() {
        return "producto/actualizar";
    }

    @Override
    protected String getVistaHabilitar() {
        return "producto/habilitar";
    }

    @Override
    protected String getNombreLista() {
        return "productos";
    }

    @Override
    protected String getNombreObjeto() {
        return "producto";
    }

    @Override
    protected ProductoDTO crearObjeto() {
        return new ProductoDTO();
    }
}
