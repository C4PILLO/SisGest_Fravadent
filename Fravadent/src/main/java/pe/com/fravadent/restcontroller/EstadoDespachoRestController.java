package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.EstadoDespachoDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.EstadoDespachoService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/estado_despacho")
public class EstadoDespachoRestController extends GenericoRestController<EstadoDespachoDTO> {

	private final EstadoDespachoService servicio;

	public EstadoDespachoRestController(EstadoDespachoService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<EstadoDespachoDTO> getServicio() {
		return servicio;
	}
}
