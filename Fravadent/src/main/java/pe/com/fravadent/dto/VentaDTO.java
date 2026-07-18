package pe.com.fravadent.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

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
public class VentaDTO extends BaseDTO {
    private String nroComprobante;

    private TipoComprobanteDTO tipoComprobante;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fechaHora;

    private ClienteDTO cliente;

    private UsuarioDTO usuario;

    private MetodoPagoDTO metodoPago;

    private EstadoVentaDTO estadoVenta;

    private BigDecimal montoTotal;
}
