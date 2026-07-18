package pe.com.fravadent.entity;

import java.io.Serializable;
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
@Entity(name = "MovimientoInventarioEntity")
@Table(name = "movimiento_inventario")
public class MovimientoInventarioEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_movimiento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoEntity producto;

    @ManyToOne
    @JoinColumn(name = "id_tipo_movimiento")
    private TipoMovimientoEntity tipoMovimiento;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "fecha_hora")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fechaHora;

    @Column(name = "referencia_tipo")
    private String referenciaTipo;

    @Column(name = "referencia_id")
    private Long referenciaId;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @Column(name = "observacion")
    private String observacion;
}
