package pe.com.fravadent.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.VentaDTO;
import pe.com.fravadent.dto.wrapper.VentaWrapperDTO;
import pe.com.fravadent.service.VentaService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/venta")
public class VentaController extends GenericoController<VentaDTO> {
    private final VentaService servicio;

    public VentaController(VentaService servicio) {
        this.servicio = servicio;
    }

    @Override
    protected GenericoService<VentaDTO> getServicio() {
        return servicio;
    }

    @Override
    protected String getRuta() {
        return "venta";
    }

    @Override
    protected String getVistaListar() {
        return "venta/listar";
    }

    @Override
    protected String getVistaRegistrar() {
        return "venta/registrar";
    }

    @Override
    protected String getVistaActualizar() {
        return "venta/actualizar";
    }

    @Override
    protected String getVistaHabilitar() {
        return "venta/habilitar";
    }

    @Override
    protected String getNombreLista() {
        return "ventas";
    }

    @Override
    protected String getNombreObjeto() {
        return "venta";
    }

    @Override
    protected VentaDTO crearObjeto() {
        return new VentaDTO();
    }

    @PostMapping("/transaccional")
    @ResponseBody
    public ResponseEntity<?> registrarTransaccional(@RequestBody VentaWrapperDTO wrapper) {
        try {
            return ResponseEntity.ok(servicio.registrarTransaccional(wrapper));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
