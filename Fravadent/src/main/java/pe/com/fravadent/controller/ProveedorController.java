package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.ProveedorDTO;
import pe.com.fravadent.service.ProveedorService;
import pe.com.fravadent.service.DistritoService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController extends GenericoController<ProveedorDTO> {
    private final ProveedorService servicio;
    private final DistritoService distritoService;

    public ProveedorController(ProveedorService servicio, DistritoService distritoService) {
        this.servicio = servicio;
        this.distritoService = distritoService;
    }

    @Override
    protected void cargarCombos(Model modelo) {
        modelo.addAttribute("distritos", distritoService.findAllCustom());
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
