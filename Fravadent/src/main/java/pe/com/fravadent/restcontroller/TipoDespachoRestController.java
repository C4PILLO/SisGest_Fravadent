package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.TipoDespachoDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.TipoDespachoService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/tipo_despacho")
public class TipoDespachoRestController extends GenericoRestController<TipoDespachoDTO> {

	private final TipoDespachoService servicio;

	public TipoDespachoRestController(TipoDespachoService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<TipoDespachoDTO> getServicio() {
		return servicio;
	}
}
