package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.UnidadMedidaDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.UnidadMedidaService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/unidad_medida")
public class UnidadMedidaRestController extends GenericoRestController<UnidadMedidaDTO> {

	private final UnidadMedidaService servicio;

	public UnidadMedidaRestController(UnidadMedidaService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<UnidadMedidaDTO> getServicio() {
		return servicio;
	}
}
