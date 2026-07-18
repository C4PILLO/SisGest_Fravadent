package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.DistritoDTO;
import pe.com.fravadent.service.DistritoService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/distrito")
public class DistritoController extends GenericoController<DistritoDTO> {
	private final DistritoService servicio;

	public DistritoController(DistritoService servicio) {
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<DistritoDTO> getServicio() {
		return servicio;
	}

	@Override
	protected String getRuta() {
		return "distrito";
	}

	@Override
	protected String getVistaListar() {
		return "distrito/listar";
	}

	@Override
	protected String getVistaRegistrar() {
		return "distrito/registrar";
	}

	@Override
	protected String getVistaActualizar() {
		return "distrito/actualizar";
	}

	@Override
	protected String getVistaHabilitar() {
		return "distrito/habilitar";
	}

	@Override
	protected String getNombreLista() {
		return "distritos";
	}

	@Override
	protected String getNombreObjeto() {
		return "distrito";
	}

	@Override
	protected DistritoDTO crearObjeto() {
		return new DistritoDTO();
	}
}
