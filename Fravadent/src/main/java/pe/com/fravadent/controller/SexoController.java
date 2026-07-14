package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.SexoDTO;
import pe.com.fravadent.service.SexoService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/sexo")
public class SexoController extends GenericoController<SexoDTO> {
    private final SexoService servicio;

    public SexoController(SexoService servicio) {
        this.servicio = servicio;
    }

    @Override
    protected GenericoService<SexoDTO> getServicio() {
        return servicio;
    }

    @Override
    protected String getRuta() {
        return "sexo";
    }

    @Override
    protected String getVistaListar() {
        return "sexo/listar";
    }

    @Override
    protected String getVistaRegistrar() {
        return "sexo/registrar";
    }

    @Override
    protected String getVistaActualizar() {
        return "sexo/actualizar";
    }

    @Override
    protected String getVistaHabilitar() {
        return "sexo/habilitar";
    }

    @Override
    protected String getNombreLista() {
        return "sexos";
    }

    @Override
    protected String getNombreObjeto() {
        return "sexo";
    }

    @Override
    protected SexoDTO crearObjeto() {
        return new SexoDTO();
    }
}
