package pe.com.fravadent.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.VentaDTO;
import pe.com.fravadent.dto.wrapper.VentaWrapperDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.VentaService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/venta")
public class VentaRestController extends GenericoRestController<VentaDTO> {

	private final VentaService servicio;

	public VentaRestController(VentaService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<VentaDTO> getServicio() {
		return servicio;
	}

	@PostMapping("/transaccional")
	public ResponseEntity<?> registrarTransaccional(@RequestBody VentaWrapperDTO wrapper) {
		try {
			return ResponseEntity.ok(servicio.registrarTransaccional(wrapper));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
}
