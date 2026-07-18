package pe.com.fravadent.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.CompraDTO;
import pe.com.fravadent.dto.wrapper.CompraWrapperDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.CompraService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/compra")
public class CompraRestController extends GenericoRestController<CompraDTO> {

	private final CompraService servicio;

	public CompraRestController(CompraService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<CompraDTO> getServicio() {
		return servicio;
	}

	@PostMapping("/transaccional")
	public ResponseEntity<?> registrarTransaccional(@RequestBody CompraWrapperDTO wrapper) {
		try {
			return ResponseEntity.ok(servicio.registrarTransaccional(wrapper));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
}
