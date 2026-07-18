package pe.com.fravadent.service;

import pe.com.fravadent.dto.VentaDTO;
import pe.com.fravadent.dto.wrapper.VentaWrapperDTO;
import pe.com.fravadent.service.generic.GenericoService;

public interface VentaService extends GenericoService<VentaDTO> {
	VentaDTO registrarTransaccional(VentaWrapperDTO wrapper);
}
