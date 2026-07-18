package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.DetalleVentaDTO;
import pe.com.fravadent.service.DetalleVentaService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/detalle_venta")
public class DetalleVentaController extends GenericoController<DetalleVentaDTO> {
	private final DetalleVentaService servicio;

	public DetalleVentaController(DetalleVentaService servicio) {
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<DetalleVentaDTO> getServicio() {
		return servicio;
	}

	@Override
	protected String getRuta() {
		return "detalle_venta";
	}

	@Override
	protected String getVistaListar() {
		return "detalle_venta/listar";
	}

	@Override
	protected String getVistaRegistrar() {
		return "detalle_venta/registrar";
	}

	@Override
	protected String getVistaActualizar() {
		return "detalle_venta/actualizar";
	}

	@Override
	protected String getVistaHabilitar() {
		return "detalle_venta/habilitar";
	}

	@Override
	protected String getNombreLista() {
		return "detalleventas";
	}

	@Override
	protected String getNombreObjeto() {
		return "detalleventa";
	}

	@Override
	protected DetalleVentaDTO crearObjeto() {
		return new DetalleVentaDTO();
	}
}
