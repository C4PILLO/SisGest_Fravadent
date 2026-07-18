package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.TipoMovimientoDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.TipoMovimientoService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/tipo_movimiento")
public class TipoMovimientoRestController extends GenericoRestController<TipoMovimientoDTO> {

	private final TipoMovimientoService servicio;

	public TipoMovimientoRestController(TipoMovimientoService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<TipoMovimientoDTO> getServicio() {
		return servicio;
	}
}
