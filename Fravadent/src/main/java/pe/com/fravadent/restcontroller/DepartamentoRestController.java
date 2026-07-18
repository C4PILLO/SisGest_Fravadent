package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.DepartamentoDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.DepartamentoService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/departamento")
public class DepartamentoRestController extends GenericoRestController<DepartamentoDTO> {

	private final DepartamentoService servicio;

	public DepartamentoRestController(DepartamentoService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<DepartamentoDTO> getServicio() {
		return servicio;
	}
}
