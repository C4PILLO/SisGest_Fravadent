package pe.com.fravadent.dto;

import java.time.LocalDate;

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
public class UsuarioDTO extends BaseDTO {
	private String estado;

	private String username;

	private String password_hash;

	private RolDTO rol;

	private TipoDocumentoDTO tipoDocumento;

	private String numeroDocumento;

	private String nombres;

	private String apellidoPaterno;

	private String apellidoMaterno;

	private SexoDTO sexo;

	private String telefono;

	private String email;

	private String direccion;

	private DistritoDTO distrito;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaRegistro;
}
