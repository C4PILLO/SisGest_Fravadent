package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.DetalleVentaDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.DetalleVentaService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/detalle_venta")
public class DetalleVentaRestController extends GenericoRestController<DetalleVentaDTO> {

	private final DetalleVentaService servicio;

	public DetalleVentaRestController(DetalleVentaService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<DetalleVentaDTO> getServicio() {
		return servicio;
	}
}
