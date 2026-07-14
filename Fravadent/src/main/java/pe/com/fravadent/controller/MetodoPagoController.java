package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.MetodoPagoDTO;
import pe.com.fravadent.service.MetodoPagoService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/metodo_pago")
public class MetodoPagoController extends GenericoController<MetodoPagoDTO> {
    private final MetodoPagoService servicio;

    public MetodoPagoController(MetodoPagoService servicio) {
        this.servicio = servicio;
    }

    @Override
    protected GenericoService<MetodoPagoDTO> getServicio() {
        return servicio;
    }

    @Override
    protected String getRuta() {
        return "metodo_pago";
    }

    @Override
    protected String getVistaListar() {
        return "metodo_pago/listar";
    }

    @Override
    protected String getVistaRegistrar() {
        return "metodo_pago/registrar";
    }

    @Override
    protected String getVistaActualizar() {
        return "metodo_pago/actualizar";
    }

    @Override
    protected String getVistaHabilitar() {
        return "metodo_pago/habilitar";
    }

    @Override
    protected String getNombreLista() {
        return "metodopagos";
    }

    @Override
    protected String getNombreObjeto() {
        return "metodopago";
    }

    @Override
    protected MetodoPagoDTO crearObjeto() {
        return new MetodoPagoDTO();
    }
}
