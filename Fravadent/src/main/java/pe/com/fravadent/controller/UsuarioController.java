package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.UsuarioDTO;
import pe.com.fravadent.service.UsuarioService;
import pe.com.fravadent.service.TipoDocumentoService;
import pe.com.fravadent.service.SexoService;
import pe.com.fravadent.service.DistritoService;
import pe.com.fravadent.service.RolService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController extends GenericoController<UsuarioDTO> {
    private final UsuarioService servicio;
    private final TipoDocumentoService tipoDocumentoService;
    private final SexoService sexoService;
    private final DistritoService distritoService;
    private final RolService rolService;

    public UsuarioController(UsuarioService servicio, 
                             TipoDocumentoService tipoDocumentoService, 
                             SexoService sexoService, 
                             DistritoService distritoService, 
                             RolService rolService) {
        this.servicio = servicio;
        this.tipoDocumentoService = tipoDocumentoService;
        this.sexoService = sexoService;
        this.distritoService = distritoService;
        this.rolService = rolService;
    }

    @Override
    protected void cargarCombos(Model modelo) {
        modelo.addAttribute("tipodocumentos", tipoDocumentoService.findAllCustom());
        modelo.addAttribute("sexos", sexoService.findAllCustom());
        modelo.addAttribute("distritos", distritoService.findAllCustom());
        modelo.addAttribute("roles", rolService.findAllCustom());
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
