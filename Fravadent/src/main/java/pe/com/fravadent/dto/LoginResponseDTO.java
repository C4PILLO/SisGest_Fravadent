package pe.com.fravadent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginResponseDTO {
	private String token;
	private String tipo;
	private Long codigo;
	private String usuario;
	private String nombrecompleto;
	private String rol;
}
