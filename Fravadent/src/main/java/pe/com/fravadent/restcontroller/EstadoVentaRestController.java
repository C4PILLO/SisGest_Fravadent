package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.EstadoVentaDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.EstadoVentaService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/estado_venta")
public class EstadoVentaRestController extends GenericoRestController<EstadoVentaDTO> {

	private final EstadoVentaService servicio;

	public EstadoVentaRestController(EstadoVentaService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<EstadoVentaDTO> getServicio() {
		return servicio;
	}
}
