package pe.com.fravadent.dto.wrapper;

import java.util.List;

import lombok.Data;
import pe.com.fravadent.dto.CompraDTO;
import pe.com.fravadent.dto.DetalleCompraDTO;

@Data
public class CompraWrapperDTO {
	private CompraDTO compra;
	private List<DetalleCompraDTO> detalles;
}
