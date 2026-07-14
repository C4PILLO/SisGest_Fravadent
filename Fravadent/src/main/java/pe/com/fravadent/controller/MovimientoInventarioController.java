package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.MovimientoInventarioDTO;
import pe.com.fravadent.service.MovimientoInventarioService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/movimiento_inventario")
public class MovimientoInventarioController extends GenericoController<MovimientoInventarioDTO> {
    private final MovimientoInventarioService servicio;

    public MovimientoInventarioController(MovimientoInventarioService servicio) {
        this.servicio = servicio;
    }

    @Override
    protected GenericoService<MovimientoInventarioDTO> getServicio() {
        return servicio;
    }

    @Override
    protected String getRuta() {
        return "movimiento_inventario";
    }

    @Override
    protected String getVistaListar() {
        return "movimiento_inventario/listar";
    }

    @Override
    protected String getVistaRegistrar() {
        return "movimiento_inventario/registrar";
    }

    @Override
    protected String getVistaActualizar() {
        return "movimiento_inventario/actualizar";
    }

    @Override
    protected String getVistaHabilitar() {
        return "movimiento_inventario/habilitar";
    }

    @Override
    protected String getNombreLista() {
        return "movimientoinventarios";
    }

    @Override
    protected String getNombreObjeto() {
        return "movimientoinventario";
    }

    @Override
    protected MovimientoInventarioDTO crearObjeto() {
        return new MovimientoInventarioDTO();
    }
}
