package pe.com.fravadent.dto;

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
public class MovimientoInventarioDTO extends BaseDTO {
    private ProductoDTO producto;

    private TipoMovimientoDTO tipoMovimiento;

    private Integer cantidad;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fechaHora;

    private String referenciaTipo;

    private Long referenciaId;

    private UsuarioDTO usuario;

    private String observacion;
}
