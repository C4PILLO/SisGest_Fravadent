package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.ProvinciaDTO;
import pe.com.fravadent.service.ProvinciaService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/provincia")
public class ProvinciaController extends GenericoController<ProvinciaDTO> {
    private final ProvinciaService servicio;

    public ProvinciaController(ProvinciaService servicio) {
        this.servicio = servicio;
    }

    @Override
    protected GenericoService<ProvinciaDTO> getServicio() {
        return servicio;
    }

    @Override
    protected String getRuta() {
        return "provincia";
    }

    @Override
    protected String getVistaListar() {
        return "provincia/listar";
    }

    @Override
    protected String getVistaRegistrar() {
        return "provincia/registrar";
    }

    @Override
    protected String getVistaActualizar() {
        return "provincia/actualizar";
    }

    @Override
    protected String getVistaHabilitar() {
        return "provincia/habilitar";
    }

    @Override
    protected String getNombreLista() {
        return "provincias";
    }

    @Override
    protected String getNombreObjeto() {
        return "provincia";
    }

    @Override
    protected ProvinciaDTO crearObjeto() {
        return new ProvinciaDTO();
    }
}
