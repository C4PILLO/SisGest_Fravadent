package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.ProveedorDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.ProveedorService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorRestController extends GenericoRestController<ProveedorDTO> {

	private final ProveedorService servicio;

	public ProveedorRestController(ProveedorService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<ProveedorDTO> getServicio() {
		return servicio;
	}
}
