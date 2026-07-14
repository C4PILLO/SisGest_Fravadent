package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.UnidadMedidaDTO;
import pe.com.fravadent.service.UnidadMedidaService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/unidad_medida")
public class UnidadMedidaController extends GenericoController<UnidadMedidaDTO> {
    private final UnidadMedidaService servicio;

    public UnidadMedidaController(UnidadMedidaService servicio) {
        this.servicio = servicio;
    }

    @Override
    protected GenericoService<UnidadMedidaDTO> getServicio() {
        return servicio;
    }

    @Override
    protected String getRuta() {
        return "unidad_medida";
    }

    @Override
    protected String getVistaListar() {
        return "unidad_medida/listar";
    }

    @Override
    protected String getVistaRegistrar() {
        return "unidad_medida/registrar";
    }

    @Override
    protected String getVistaActualizar() {
        return "unidad_medida/actualizar";
    }

    @Override
    protected String getVistaHabilitar() {
        return "unidad_medida/habilitar";
    }

    @Override
    protected String getNombreLista() {
        return "unidadmedidas";
    }

    @Override
    protected String getNombreObjeto() {
        return "unidadmedida";
    }

    @Override
    protected UnidadMedidaDTO crearObjeto() {
        return new UnidadMedidaDTO();
    }
}
