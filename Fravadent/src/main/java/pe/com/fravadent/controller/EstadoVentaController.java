package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.EstadoVentaDTO;
import pe.com.fravadent.service.EstadoVentaService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/estado_venta")
public class EstadoVentaController extends GenericoController<EstadoVentaDTO> {
	private final EstadoVentaService servicio;

	public EstadoVentaController(EstadoVentaService servicio) {
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<EstadoVentaDTO> getServicio() {
		return servicio;
	}

	@Override
	protected String getRuta() {
		return "estado_venta";
	}

	@Override
	protected String getVistaListar() {
		return "estado_venta/listar";
	}

	@Override
	protected String getVistaRegistrar() {
		return "estado_venta/registrar";
	}

	@Override
	protected String getVistaActualizar() {
		return "estado_venta/actualizar";
	}

	@Override
	protected String getVistaHabilitar() {
		return "estado_venta/habilitar";
	}

	@Override
	protected String getNombreLista() {
		return "estadoventas";
	}

	@Override
	protected String getNombreObjeto() {
		return "estadoventa";
	}

	@Override
	protected EstadoVentaDTO crearObjeto() {
		return new EstadoVentaDTO();
	}
}
