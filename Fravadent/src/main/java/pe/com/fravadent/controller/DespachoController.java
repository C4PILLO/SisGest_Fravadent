package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.DespachoDTO;
import pe.com.fravadent.service.DespachoService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/despacho")
public class DespachoController extends GenericoController<DespachoDTO> {
    private final DespachoService servicio;

    public DespachoController(DespachoService servicio) {
        this.servicio = servicio;
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
