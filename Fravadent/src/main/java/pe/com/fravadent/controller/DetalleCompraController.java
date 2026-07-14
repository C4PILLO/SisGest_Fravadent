package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.DetalleCompraDTO;
import pe.com.fravadent.service.DetalleCompraService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/detalle_compra")
public class DetalleCompraController extends GenericoController<DetalleCompraDTO> {
    private final DetalleCompraService servicio;

    public DetalleCompraController(DetalleCompraService servicio) {
        this.servicio = servicio;
    }

    @Override
    protected GenericoService<DetalleCompraDTO> getServicio() {
        return servicio;
    }

    @Override
    protected String getRuta() {
        return "detalle_compra";
    }

    @Override
    protected String getVistaListar() {
        return "detalle_compra/listar";
    }

    @Override
    protected String getVistaRegistrar() {
        return "detalle_compra/registrar";
    }

    @Override
    protected String getVistaActualizar() {
        return "detalle_compra/actualizar";
    }

    @Override
    protected String getVistaHabilitar() {
        return "detalle_compra/habilitar";
    }

    @Override
    protected String getNombreLista() {
        return "detallecompras";
    }

    @Override
    protected String getNombreObjeto() {
        return "detallecompra";
    }

    @Override
    protected DetalleCompraDTO crearObjeto() {
        return new DetalleCompraDTO();
    }
}
