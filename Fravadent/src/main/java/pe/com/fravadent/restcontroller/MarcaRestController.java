package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.MarcaDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.MarcaService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/marca")
public class MarcaRestController extends GenericoRestController<MarcaDTO> {

	private final MarcaService servicio;

	public MarcaRestController(MarcaService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<MarcaDTO> getServicio() {
		return servicio;
	}
}
