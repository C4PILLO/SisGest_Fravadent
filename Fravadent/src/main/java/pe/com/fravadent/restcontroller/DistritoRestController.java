package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.DistritoDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.DistritoService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/distrito")
public class DistritoRestController extends GenericoRestController<DistritoDTO> {

	private final DistritoService servicio;

	public DistritoRestController(DistritoService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<DistritoDTO> getServicio() {
		return servicio;
	}
}
