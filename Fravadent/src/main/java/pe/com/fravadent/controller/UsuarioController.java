package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.UsuarioDTO;
import pe.com.fravadent.service.UsuarioService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController extends GenericoController<UsuarioDTO> {
    private final UsuarioService servicio;

    public UsuarioController(UsuarioService servicio) {
        this.servicio = servicio;
    }

    @Override
    protected GenericoService<UsuarioDTO> getServicio() {
        return servicio;
    }

    @Override
    protected String getRuta() {
        return "usuario";
    }

    @Override
    protected String getVistaListar() {
        return "usuario/listar";
    }

    @Override
    protected String getVistaRegistrar() {
        return "usuario/registrar";
    }

    @Override
    protected String getVistaActualizar() {
        return "usuario/actualizar";
    }

    @Override
    protected String getVistaHabilitar() {
        return "usuario/habilitar";
    }

    @Override
    protected String getNombreLista() {
        return "usuarios";
    }

    @Override
    protected String getNombreObjeto() {
        return "usuario";
    }

    @Override
    protected UsuarioDTO crearObjeto() {
        return new UsuarioDTO();
    }
}
