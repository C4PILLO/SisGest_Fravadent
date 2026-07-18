package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.ProvinciaDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.ProvinciaService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/provincia")
public class ProvinciaRestController extends GenericoRestController<ProvinciaDTO> {

	private final ProvinciaService servicio;

	public ProvinciaRestController(ProvinciaService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<ProvinciaDTO> getServicio() {
		return servicio;
	}
}
