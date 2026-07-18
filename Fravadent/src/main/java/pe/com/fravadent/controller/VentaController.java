package pe.com.fravadent.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.VentaDTO;
import pe.com.fravadent.dto.wrapper.VentaWrapperDTO;
import pe.com.fravadent.service.ClienteService;
import pe.com.fravadent.service.EstadoVentaService;
import pe.com.fravadent.service.MetodoPagoService;
import pe.com.fravadent.service.ProductoService;
import pe.com.fravadent.service.TipoComprobanteService;
import pe.com.fravadent.service.VentaService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/venta")
public class VentaController extends GenericoController<VentaDTO> {
    private final VentaService servicio;
    private final ClienteService clienteService;
    private final TipoComprobanteService tipoComprobanteService;
    private final MetodoPagoService metodoPagoService;
    private final EstadoVentaService estadoVentaService;
    private final ProductoService productoService;
    public VentaController(VentaService servicio,
                           ClienteService clienteService,
                           TipoComprobanteService tipoComprobanteService,
                           MetodoPagoService metodoPagoService,
                           EstadoVentaService estadoVentaService,
                           ProductoService productoService) {
        this.servicio = servicio;
        this.clienteService = clienteService;
        this.tipoComprobanteService = tipoComprobanteService;
        this.metodoPagoService = metodoPagoService;
        this.estadoVentaService = estadoVentaService;
        this.productoService = productoService;
    }

    @Override
    protected void cargarCombos(Model model) {
        model.addAttribute("clientes", clienteService.findAllCustom());
        model.addAttribute("tipocomprobantes", tipoComprobanteService.findAllCustom());
        model.addAttribute("metodopagos", metodoPagoService.findAllCustom());
        model.addAttribute("estadoventas", estadoVentaService.findAllCustom());
        model.addAttribute("productos", productoService.findAllCustom());
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
