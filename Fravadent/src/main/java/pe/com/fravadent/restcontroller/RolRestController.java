package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.RolDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.RolService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/rol")
public class RolRestController extends GenericoRestController<RolDTO> {

	private final RolService servicio;

	public RolRestController(RolService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<RolDTO> getServicio() {
		return servicio;
	}
}
