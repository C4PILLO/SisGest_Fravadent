package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.DespachoDTO;
import pe.com.fravadent.service.DespachoService;
import pe.com.fravadent.service.DistritoService;
import pe.com.fravadent.service.EstadoDespachoService;
import pe.com.fravadent.service.TipoDespachoService;
import pe.com.fravadent.service.UsuarioService;
import pe.com.fravadent.service.VentaService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/despacho")
public class DespachoController extends GenericoController<DespachoDTO> {
    private final DespachoService servicio;
    private final VentaService ventaService;
    private final UsuarioService usuarioService;
    private final TipoDespachoService tipoDespachoService;
    private final EstadoDespachoService estadoDespachoService;
    private final DistritoService distritoService;

    public DespachoController(DespachoService servicio,
                              VentaService ventaService,
                              UsuarioService usuarioService,
                              TipoDespachoService tipoDespachoService,
                              EstadoDespachoService estadoDespachoService,
                              DistritoService distritoService) {
        this.servicio = servicio;
        this.ventaService = ventaService;
        this.usuarioService = usuarioService;
        this.tipoDespachoService = tipoDespachoService;
        this.estadoDespachoService = estadoDespachoService;
        this.distritoService = distritoService;
    }

    @Override
    protected void cargarCombos(Model model) {
        model.addAttribute("ventas", ventaService.findAllCustom());
        model.addAttribute("usuarios", usuarioService.findAllCustom());
        model.addAttribute("tipodespachos", tipoDespachoService.findAllCustom());
        model.addAttribute("estadodespachos", estadoDespachoService.findAllCustom());
        model.addAttribute("distritos", distritoService.findAllCustom());
    }

    @Override
    protected GenericoService<DespachoDTO> getServicio() {
        return servicio;
    }

    @Override
    protected String getRuta() {
        return "despacho";
    }

    @Override
    protected String getVistaListar() {
        return "despacho/listar";
    }

    @Override
    protected String getVistaRegistrar() {
        return "despacho/registrar";
    }

    @Override
    protected String getVistaActualizar() {
        return "despacho/actualizar";
    }

    @Override
    protected String getVistaHabilitar() {
        return "despacho/habilitar";
    }

    @Override
    protected String getNombreLista() {
        return "despachos";
    }

    @Override
    protected String getNombreObjeto() {
        return "despacho";
    }

    @Override
    protected DespachoDTO crearObjeto() {
        return new DespachoDTO();
    }
}
