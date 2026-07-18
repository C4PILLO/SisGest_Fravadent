package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.UsuarioDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.UsuarioService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController extends GenericoRestController<UsuarioDTO> {

	private final UsuarioService servicio;

	public UsuarioRestController(UsuarioService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<UsuarioDTO> getServicio() {
		return servicio;
	}
}
