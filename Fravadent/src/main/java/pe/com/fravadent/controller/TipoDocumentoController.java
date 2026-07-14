package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.fravadent.controller.generic.GenericoController;
import pe.com.fravadent.dto.TipoDocumentoDTO;
import pe.com.fravadent.service.TipoDocumentoService;
import pe.com.fravadent.service.generic.GenericoService;

@Controller
@RequestMapping("/tipo_documento")
public class TipoDocumentoController extends GenericoController<TipoDocumentoDTO> {
    private final TipoDocumentoService servicio;

    public TipoDocumentoController(TipoDocumentoService servicio) {
        this.servicio = servicio;
    }

    @Override
    protected GenericoService<TipoDocumentoDTO> getServicio() {
        return servicio;
    }

    @Override
    protected String getRuta() {
        return "tipo_documento";
    }

    @Override
    protected String getVistaListar() {
        return "tipo_documento/listar";
    }

    @Override
    protected String getVistaRegistrar() {
        return "tipo_documento/registrar";
    }

    @Override
    protected String getVistaActualizar() {
        return "tipo_documento/actualizar";
    }

    @Override
    protected String getVistaHabilitar() {
        return "tipo_documento/habilitar";
    }

    @Override
    protected String getNombreLista() {
        return "tipodocumentos";
    }

    @Override
    protected String getNombreObjeto() {
        return "tipodocumento";
    }

    @Override
    protected TipoDocumentoDTO crearObjeto() {
        return new TipoDocumentoDTO();
    }
}
