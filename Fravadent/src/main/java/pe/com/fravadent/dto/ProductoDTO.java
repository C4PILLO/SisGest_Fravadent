package pe.com.fravadent.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.fravadent.dto.base.BaseDTO;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class ProductoDTO extends BaseDTO {
	private String estado;

	private String codigoSku;

	private String nombreDescripcion;

	private CategoriaDTO categoria;

	private MarcaDTO marca;

	private UnidadMedidaDTO unidadMedida;

	private BigDecimal precioCompra;

	private BigDecimal precioVenta;

	private Integer stockActual;

	private Integer stockMinimo;
}
