package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.ProductoDTO;
import pe.com.fravadent.service.CategoriaService;
import pe.com.fravadent.service.MarcaService;
import pe.com.fravadent.service.ProductoService;
import pe.com.fravadent.service.UnidadMedidaService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/producto")
public class ProductoController extends GenericoController<ProductoDTO> {
	private final ProductoService servicio;
	private final CategoriaService categoriaService;
	private final MarcaService marcaService;
	private final UnidadMedidaService unidadMedidaService;

	public ProductoController(ProductoService servicio, CategoriaService categoriaService, MarcaService marcaService,
			UnidadMedidaService unidadMedidaService) {
		this.servicio = servicio;
		this.categoriaService = categoriaService;
		this.marcaService = marcaService;
		this.unidadMedidaService = unidadMedidaService;
	}

	@Override
	protected void cargarCombos(Model modelo) {
		modelo.addAttribute("categorias", categoriaService.findAllCustom());
		modelo.addAttribute("marcas", marcaService.findAllCustom());
		modelo.addAttribute("unidadmedidas", unidadMedidaService.findAllCustom());
	}

	@Override
	protected GenericoService<ProductoDTO> getServicio() {
		return servicio;
	}

	@Override
	protected String getRuta() {
		return "producto";
	}

	@Override
	protected String getVistaListar() {
		return "producto/listar";
	}

	@Override
	protected String getVistaRegistrar() {
		return "producto/registrar";
	}

	@Override
	protected String getVistaActualizar() {
		return "producto/actualizar";
	}

	@Override
	protected String getVistaHabilitar() {
		return "producto/habilitar";
	}

	@Override
	protected String getNombreLista() {
		return "productos";
	}

	@Override
	protected String getNombreObjeto() {
		return "producto";
	}

	@Override
	protected ProductoDTO crearObjeto() {
		return new ProductoDTO();
	}
}
