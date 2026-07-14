package pe.com.fravadent.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

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
@Entity(name = "VentaEntity")
@Table(name = "venta")
public class VentaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_venta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name="estado", length = 1, nullable = false)
    private String estado;

    @Column(name = "nro_comprobante")
    private String nroComprobante;

    @ManyToOne
    @JoinColumn(name = "id_tipo_comprobante")
    private TipoComprobanteEntity tipoComprobante;

    @Column(name = "fecha_hora")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pago")
    private MetodoPagoEntity metodoPago;

    @ManyToOne
    @JoinColumn(name = "id_estado_venta")
    private EstadoVentaEntity estadoVenta;

    @Column(name = "monto_total")
    private BigDecimal montoTotal;
}
