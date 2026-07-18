package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.MetodoPagoDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.MetodoPagoService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/metodo_pago")
public class MetodoPagoRestController extends GenericoRestController<MetodoPagoDTO> {

	private final MetodoPagoService servicio;

	public MetodoPagoRestController(MetodoPagoService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<MetodoPagoDTO> getServicio() {
		return servicio;
	}
}
