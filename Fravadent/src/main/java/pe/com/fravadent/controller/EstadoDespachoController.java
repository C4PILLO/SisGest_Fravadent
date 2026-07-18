package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.EstadoDespachoDTO;
import pe.com.fravadent.service.EstadoDespachoService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/estado_despacho")
public class EstadoDespachoController extends GenericoController<EstadoDespachoDTO> {
	private final EstadoDespachoService servicio;

	public EstadoDespachoController(EstadoDespachoService servicio) {
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<EstadoDespachoDTO> getServicio() {
		return servicio;
	}

	@Override
	protected String getRuta() {
		return "estado_despacho";
	}

	@Override
	protected String getVistaListar() {
		return "estado_despacho/listar";
	}

	@Override
	protected String getVistaRegistrar() {
		return "estado_despacho/registrar";
	}

	@Override
	protected String getVistaActualizar() {
		return "estado_despacho/actualizar";
	}

	@Override
	protected String getVistaHabilitar() {
		return "estado_despacho/habilitar";
	}

	@Override
	protected String getNombreLista() {
		return "estadodespachos";
	}

	@Override
	protected String getNombreObjeto() {
		return "estadodespacho";
	}

	@Override
	protected EstadoDespachoDTO crearObjeto() {
		return new EstadoDespachoDTO();
	}
}
