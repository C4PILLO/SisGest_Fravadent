package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.ClienteDTO;
import pe.com.fravadent.service.ClienteService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/cliente")
public class ClienteController extends GenericoController<ClienteDTO> {
    private final ClienteService servicio;

    public ClienteController(ClienteService servicio) {
        this.servicio = servicio;
    }

    @Override
    protected GenericoService<ClienteDTO> getServicio() {
        return servicio;
    }

    @Override
    protected String getRuta() {
        return "cliente";
    }

    @Override
    protected String getVistaListar() {
        return "cliente/listar";
    }

    @Override
    protected String getVistaRegistrar() {
        return "cliente/registrar";
    }

    @Override
    protected String getVistaActualizar() {
        return "cliente/actualizar";
    }

    @Override
    protected String getVistaHabilitar() {
        return "cliente/habilitar";
    }

    @Override
    protected String getNombreLista() {
        return "clientes";
    }

    @Override
    protected String getNombreObjeto() {
        return "cliente";
    }

    @Override
    protected ClienteDTO crearObjeto() {
        return new ClienteDTO();
    }
}
