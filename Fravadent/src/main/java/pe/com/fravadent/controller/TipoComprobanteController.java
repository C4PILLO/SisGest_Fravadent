package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.TipoComprobanteDTO;
import pe.com.fravadent.service.TipoComprobanteService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/tipo_comprobante")
public class TipoComprobanteController extends GenericoController<TipoComprobanteDTO> {
	private final TipoComprobanteService servicio;

	public TipoComprobanteController(TipoComprobanteService servicio) {
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<TipoComprobanteDTO> getServicio() {
		return servicio;
	}

	@Override
	protected String getRuta() {
		return "tipo_comprobante";
	}

	@Override
	protected String getVistaListar() {
		return "tipo_comprobante/listar";
	}

	@Override
	protected String getVistaRegistrar() {
		return "tipo_comprobante/registrar";
	}

	@Override
	protected String getVistaActualizar() {
		return "tipo_comprobante/actualizar";
	}

	@Override
	protected String getVistaHabilitar() {
		return "tipo_comprobante/habilitar";
	}

	@Override
	protected String getNombreLista() {
		return "tipocomprobantes";
	}

	@Override
	protected String getNombreObjeto() {
		return "tipocomprobante";
	}

	@Override
	protected TipoComprobanteDTO crearObjeto() {
		return new TipoComprobanteDTO();
	}
}
