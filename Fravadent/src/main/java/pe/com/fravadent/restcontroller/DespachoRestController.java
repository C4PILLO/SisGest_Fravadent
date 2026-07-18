package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.DespachoDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.DespachoService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/despacho")
public class DespachoRestController extends GenericoRestController<DespachoDTO> {

	private final DespachoService servicio;

	public DespachoRestController(DespachoService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<DespachoDTO> getServicio() {
		return servicio;
	}
}
