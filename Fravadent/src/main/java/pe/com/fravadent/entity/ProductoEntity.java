package pe.com.fravadent.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "ProductoEntity")
@Table(name = "producto")
public class ProductoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_producto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "estado", length = 1, nullable = false)
	private String estado;

	@Column(name = "codigo_sku")
	private String codigoSku;

	@Column(name = "nombre_descripcion")
	private String nombreDescripcion;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private CategoriaEntity categoria;

	@ManyToOne
	@JoinColumn(name = "id_marca")
	private MarcaEntity marca;

	@ManyToOne
	@JoinColumn(name = "id_unidad_medida")
	private UnidadMedidaEntity unidadMedida;

	@Column(name = "precio_compra")
	private BigDecimal precioCompra;

	@Column(name = "precio_venta")
	private BigDecimal precioVenta;

	@Column(name = "stock_actual")
	private Integer stockActual;

	@Column(name = "stock_minimo")
	private Integer stockMinimo;
}
