package pe.com.fravadent.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.ProductoDTO;
import pe.com.fravadent.restcontroller.generic.GenericoRestController;
import pe.com.fravadent.service.ProductoService;
import pe.com.fravadent.service.generic.GenericoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoRestController extends GenericoRestController<ProductoDTO> {

	private final ProductoService servicio;

	public ProductoRestController(ProductoService servicio) {
		super();
		this.servicio = servicio;
	}

	@Override
	protected GenericoService<ProductoDTO> getServicio() {
		return servicio;
	}
}
