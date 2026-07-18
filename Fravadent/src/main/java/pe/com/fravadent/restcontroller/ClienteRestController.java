package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.ClienteDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.ClienteService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteRestController extends GenericoRestController<ClienteDTO> {

	private final ClienteService servicio;

	public ClienteRestController(ClienteService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<ClienteDTO> getServicio() {
		return servicio;
	}
}
