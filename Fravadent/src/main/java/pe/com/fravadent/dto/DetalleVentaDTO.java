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
public class DetalleVentaDTO extends BaseDTO {
	private String estado;

	private VentaDTO venta;

	private ProductoDTO producto;

	private Integer cantidad;

	private BigDecimal precioUnitario;

	private BigDecimal subtotal;
}
