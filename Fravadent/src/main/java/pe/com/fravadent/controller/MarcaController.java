package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.MarcaDTO;
import pe.com.fravadent.service.MarcaService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/marca")
public class MarcaController extends GenericoController<MarcaDTO> {
	private final MarcaService servicio;

	public MarcaController(MarcaService servicio) {
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<MarcaDTO> getServicio() {
		return servicio;
	}

	@Override
	protected String getRuta() {
		return "marca";
	}

	@Override
	protected String getVistaListar() {
		return "marca/listar";
	}

	@Override
	protected String getVistaRegistrar() {
		return "marca/registrar";
	}

	@Override
	protected String getVistaActualizar() {
		return "marca/actualizar";
	}

	@Override
	protected String getVistaHabilitar() {
		return "marca/habilitar";
	}

	@Override
	protected String getNombreLista() {
		return "marcas";
	}

	@Override
	protected String getNombreObjeto() {
		return "marca";
	}

	@Override
	protected MarcaDTO crearObjeto() {
		return new MarcaDTO();
	}
}
