package pe.com.fravadent.service;

import pe.com.fravadent.dto.CompraDTO;
import pe.com.fravadent.dto.wrapper.CompraWrapperDTO;
import pe.com.fravadent.service.generic.GenericoService;

public interface CompraService extends GenericoService<CompraDTO> {
	CompraDTO registrarTransaccional(CompraWrapperDTO wrapper);
}
