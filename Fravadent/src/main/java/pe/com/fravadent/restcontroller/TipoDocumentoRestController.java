package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.TipoDocumentoDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.TipoDocumentoService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/tipo_documento")
public class TipoDocumentoRestController extends GenericoRestController<TipoDocumentoDTO> {

	private final TipoDocumentoService servicio;

	public TipoDocumentoRestController(TipoDocumentoService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<TipoDocumentoDTO> getServicio() {
		return servicio;
	}
}
