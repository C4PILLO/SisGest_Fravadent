package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.MovimientoInventarioDTO;
import pe.com.fravadent.service.MovimientoInventarioService;
import pe.com.fravadent.service.ProductoService;
import pe.com.fravadent.service.TipoMovimientoService;
import pe.com.fravadent.service.UsuarioService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/movimiento_inventario")
public class MovimientoInventarioController extends GenericoController<MovimientoInventarioDTO> {
	private final MovimientoInventarioService servicio;
	private final ProductoService productoService;
	private final TipoMovimientoService tipoMovimientoService;
	private final UsuarioService usuarioService;

	public MovimientoInventarioController(MovimientoInventarioService servicio, ProductoService productoService,
			TipoMovimientoService tipoMovimientoService, UsuarioService usuarioService) {
		this.servicio = servicio;
		this.productoService = productoService;
		this.tipoMovimientoService = tipoMovimientoService;
		this.usuarioService = usuarioService;
	}

	@Override
	protected void cargarCombos(Model modelo) {
		modelo.addAttribute("productos", productoService.findAllCustom());
		modelo.addAttribute("tipomovimientos", tipoMovimientoService.findAllCustom());
		modelo.addAttribute("usuarios", usuarioService.findAllCustom());
	}

	@Override
	protected GenericoService<MovimientoInventarioDTO> getServicio() {
		return servicio;
	}

	@Override
	protected String getRuta() {
		return "movimiento_inventario";
	}

	@Override
	protected String getVistaListar() {
		return "movimiento_inventario/listar";
	}

	@Override
	protected String getVistaRegistrar() {
		return "movimiento_inventario/registrar";
	}

	@Override
	protected String getVistaActualizar() {
		return "movimiento_inventario/actualizar";
	}

	@Override
	protected String getVistaHabilitar() {
		return "movimiento_inventario/habilitar";
	}

	@Override
	protected String getNombreLista() {
		return "movimientoinventarios";
	}

	@Override
	protected String getNombreObjeto() {
		return "movimientoinventario";
	}

	@Override
	protected MovimientoInventarioDTO crearObjeto() {
		return new MovimientoInventarioDTO();
	}
}
