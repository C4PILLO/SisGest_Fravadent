package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.ProveedorDTO;
import pe.com.fravadent.service.ProveedorService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController extends GenericoController<ProveedorDTO> {
    private final ProveedorService servicio;

    public ProveedorController(ProveedorService servicio) {
        this.servicio = servicio;
    }

    @Override
    protected GenericoService<ProveedorDTO> getServicio() {
        return servicio;
    }

    @Override
    protected String getRuta() {
        return "proveedor";
    }

    @Override
    protected String getVistaListar() {
        return "proveedor/listar";
    }

    @Override
    protected String getVistaRegistrar() {
        return "proveedor/registrar";
    }

    @Override
    protected String getVistaActualizar() {
        return "proveedor/actualizar";
    }

    @Override
    protected String getVistaHabilitar() {
        return "proveedor/habilitar";
    }

    @Override
    protected String getNombreLista() {
        return "proveedors";
    }

    @Override
    protected String getNombreObjeto() {
        return "proveedor";
    }

    @Override
    protected ProveedorDTO crearObjeto() {
        return new ProveedorDTO();
    }
}
