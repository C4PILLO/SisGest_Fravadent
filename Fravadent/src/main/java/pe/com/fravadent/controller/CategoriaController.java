package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.CategoriaDTO;
import pe.com.fravadent.service.CategoriaService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/categoria_producto")
public class CategoriaController extends GenericoController<CategoriaDTO> {
    private final CategoriaService servicio;

    public CategoriaController(CategoriaService servicio) {
        this.servicio = servicio;
    }

    @Override
    protected GenericoService<CategoriaDTO> getServicio() {
        return servicio;
    }

    @Override
    protected String getRuta() {
        return "categoria_producto";
    }

    @Override
    protected String getVistaListar() {
        return "categoria_producto/listar";
    }

    @Override
    protected String getVistaRegistrar() {
        return "categoria_producto/registrar";
    }

    @Override
    protected String getVistaActualizar() {
        return "categoria_producto/actualizar";
    }

    @Override
    protected String getVistaHabilitar() {
        return "categoria_producto/habilitar";
    }

    @Override
    protected String getNombreLista() {
        return "categorias";
    }

    @Override
    protected String getNombreObjeto() {
        return "categoria";
    }

    @Override
    protected CategoriaDTO crearObjeto() {
        return new CategoriaDTO();
    }
}
