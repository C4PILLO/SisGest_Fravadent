package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.TipoComprobanteDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.TipoComprobanteService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/tipo_comprobante")
public class TipoComprobanteRestController extends GenericoRestController<TipoComprobanteDTO> {

	private final TipoComprobanteService servicio;

	public TipoComprobanteRestController(TipoComprobanteService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<TipoComprobanteDTO> getServicio() {
		return servicio;
	}
}
