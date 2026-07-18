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
@Entity(name = "DespachoEntity")
@Table(name = "despacho")
public class DespachoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_despacho")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;



    @ManyToOne
    @JoinColumn(name = "id_venta")
    private VentaEntity venta;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "id_tipo_despacho")
    private TipoDespachoEntity tipoDespacho;

    @ManyToOne
    @JoinColumn(name = "id_estado_despacho")
    private EstadoDespachoEntity estadoDespacho;

    @Column(name = "direccion_entrega")
    private String direccionEntrega;

    @ManyToOne
    @JoinColumn(name = "id_distrito")
    private DistritoEntity distrito;

    @Column(name = "fecha_programada")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fechaProgramada;

    @Column(name = "fecha_entrega_real")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fechaEntregaReal;

    @Column(name = "observaciones")
    private String observaciones;
}
