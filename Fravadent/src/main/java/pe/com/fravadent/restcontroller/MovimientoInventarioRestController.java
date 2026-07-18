package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.MovimientoInventarioDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.MovimientoInventarioService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/movimiento_inventario")
public class MovimientoInventarioRestController extends GenericoRestController<MovimientoInventarioDTO> {

	private final MovimientoInventarioService servicio;

	public MovimientoInventarioRestController(MovimientoInventarioService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<MovimientoInventarioDTO> getServicio() {
		return servicio;
	}
}
