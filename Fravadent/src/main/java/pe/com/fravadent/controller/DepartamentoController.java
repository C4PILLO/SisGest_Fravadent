package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.DepartamentoDTO;
import pe.com.fravadent.service.DepartamentoService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/departamento")
public class DepartamentoController extends GenericoController<DepartamentoDTO> {
	private final DepartamentoService servicio;

	public DepartamentoController(DepartamentoService servicio) {
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<DepartamentoDTO> getServicio() {
		return servicio;
	}

	@Override
	protected String getRuta() {
		return "departamento";
	}

	@Override
	protected String getVistaListar() {
		return "departamento/listar";
	}

	@Override
	protected String getVistaRegistrar() {
		return "departamento/registrar";
	}

	@Override
	protected String getVistaActualizar() {
		return "departamento/actualizar";
	}

	@Override
	protected String getVistaHabilitar() {
		return "departamento/habilitar";
	}

	@Override
	protected String getNombreLista() {
		return "departamentos";
	}

	@Override
	protected String getNombreObjeto() {
		return "departamento";
	}

	@Override
	protected DepartamentoDTO crearObjeto() {
		return new DepartamentoDTO();
	}
}
