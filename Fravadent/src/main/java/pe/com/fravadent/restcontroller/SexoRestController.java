package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.SexoDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.SexoService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/sexo")
public class SexoRestController extends GenericoRestController<SexoDTO> {

	private final SexoService servicio;

	public SexoRestController(SexoService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<SexoDTO> getServicio() {
		return servicio;
	}
}
