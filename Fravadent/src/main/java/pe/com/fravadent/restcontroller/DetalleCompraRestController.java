package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.DetalleCompraDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.DetalleCompraService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/detalle_compra")
public class DetalleCompraRestController extends GenericoRestController<DetalleCompraDTO> {

	private final DetalleCompraService servicio;

	public DetalleCompraRestController(DetalleCompraService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<DetalleCompraDTO> getServicio() {
		return servicio;
	}
}
