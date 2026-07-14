package pe.com.fravadent.dto.wrapper;

import java.util.List;
import lombok.Data;
import pe.com.fravadent.dto.VentaDTO;
import pe.com.fravadent.dto.DetalleVentaDTO;

@Data
public class VentaWrapperDTO {
    private VentaDTO venta;
    private List<DetalleVentaDTO> detalles;
}
