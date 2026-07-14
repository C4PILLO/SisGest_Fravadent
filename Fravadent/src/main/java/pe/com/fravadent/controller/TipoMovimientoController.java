package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.TipoMovimientoDTO;
import pe.com.fravadent.service.TipoMovimientoService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/tipo_movimiento")
public class TipoMovimientoController extends GenericoController<TipoMovimientoDTO> {
    private final TipoMovimientoService servicio;

    public TipoMovimientoController(TipoMovimientoService servicio) {
        this.servicio = servicio;
    }

    @Override
    protected GenericoService<TipoMovimientoDTO> getServicio() {
        return servicio;
    }

    @Override
    protected String getRuta() {
        return "tipo_movimiento";
    }

    @Override
    protected String getVistaListar() {
        return "tipo_movimiento/listar";
    }

    @Override
    protected String getVistaRegistrar() {
        return "tipo_movimiento/registrar";
    }

    @Override
    protected String getVistaActualizar() {
        return "tipo_movimiento/actualizar";
    }

    @Override
    protected String getVistaHabilitar() {
        return "tipo_movimiento/habilitar";
    }

    @Override
    protected String getNombreLista() {
        return "tipomovimientos";
    }

    @Override
    protected String getNombreObjeto() {
        return "tipomovimiento";
    }

    @Override
    protected TipoMovimientoDTO crearObjeto() {
        return new TipoMovimientoDTO();
    }
}
