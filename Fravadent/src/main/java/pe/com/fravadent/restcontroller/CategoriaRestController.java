package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.CategoriaDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.CategoriaService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaRestController extends GenericoRestController<CategoriaDTO> {
	private final CategoriaService servicio;

	public CategoriaRestController(CategoriaService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<CategoriaDTO> getServicio() {
		return servicio;
	}
}
