package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.RolDTO;
import pe.com.fravadent.service.RolService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/rol")
public class RolController extends GenericoController<RolDTO> {
    private final RolService servicio;

    public RolController(RolService servicio) {
        this.servicio = servicio;
    }

    @Override
    protected GenericoService<RolDTO> getServicio() {
        return servicio;
    }

    @Override
    protected String getRuta() {
        return "rol";
    }

    @Override
    protected String getVistaListar() {
        return "rol/listar";
    }

    @Override
    protected String getVistaRegistrar() {
        return "rol/registrar";
    }

    @Override
    protected String getVistaActualizar() {
        return "rol/actualizar";
    }

    @Override
    protected String getVistaHabilitar() {
        return "rol/habilitar";
    }

    @Override
    protected String getNombreLista() {
        return "rols";
    }

    @Override
    protected String getNombreObjeto() {
        return "rol";
    }

    @Override
    protected RolDTO crearObjeto() {
        return new RolDTO();
    }
}
