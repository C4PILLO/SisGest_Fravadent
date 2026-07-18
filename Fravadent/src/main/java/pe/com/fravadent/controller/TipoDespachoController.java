package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.TipoDespachoDTO;
import pe.com.fravadent.service.TipoDespachoService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/tipo_despacho")
public class TipoDespachoController extends GenericoController<TipoDespachoDTO> {
	private final TipoDespachoService servicio;

	public TipoDespachoController(TipoDespachoService servicio) {
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<TipoDespachoDTO> getServicio() {
		return servicio;
	}

	@Override
	protected String getRuta() {
		return "tipo_despacho";
	}

	@Override
	protected String getVistaListar() {
		return "tipo_despacho/listar";
	}

	@Override
	protected String getVistaRegistrar() {
		return "tipo_despacho/registrar";
	}

	@Override
	protected String getVistaActualizar() {
		return "tipo_despacho/actualizar";
	}

	@Override
	protected String getVistaHabilitar() {
		return "tipo_despacho/habilitar";
	}

	@Override
	protected String getNombreLista() {
		return "tipodespachos";
	}

	@Override
	protected String getNombreObjeto() {
		return "tipodespacho";
	}

	@Override
	protected TipoDespachoDTO crearObjeto() {
		return new TipoDespachoDTO();
	}
}
