package pe.com.fravadent.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.CompraDTO;
import pe.com.fravadent.dto.wrapper.CompraWrapperDTO;
import pe.com.fravadent.service.CompraService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/compra")
public class CompraController extends GenericoController<CompraDTO> {
    private final CompraService servicio;

    public CompraController(CompraService servicio) {
        this.servicio = servicio;
    }

    @Override
    protected GenericoService<CompraDTO> getServicio() {
        return servicio;
    }

    @Override
    protected String getRuta() {
        return "compra";
    }

    @Override
    protected String getVistaListar() {
        return "compra/listar";
    }

    @Override
    protected String getVistaRegistrar() {
        return "compra/registrar";
    }

    @Override
    protected String getVistaActualizar() {
        return "compra/actualizar";
    }

    @Override
    protected String getVistaHabilitar() {
        return "compra/habilitar";
    }

    @Override
    protected String getNombreLista() {
        return "compras";
    }

    @Override
    protected String getNombreObjeto() {
        return "compra";
    }

    @Override
    protected CompraDTO crearObjeto() {
        return new CompraDTO();
    }

    @PostMapping("/transaccional")
    @ResponseBody
    public ResponseEntity<?> registrarTransaccional(@RequestBody CompraWrapperDTO wrapper) {
        try {
            return ResponseEntity.ok(servicio.registrarTransaccional(wrapper));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
