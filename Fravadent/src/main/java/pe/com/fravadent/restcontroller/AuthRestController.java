package pe.com.fravadent.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fravadent.dto.LoginRequestDTO;
import pe.com.fravadent.dto.LoginResponseDTO;
import pe.com.fravadent.security.JwtService;
import pe.com.fravadent.security.UsuarioUserDetails;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;

	public AuthRestController(AuthenticationManager authenticationManager, JwtService jwtService) {
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
		if (request.getUsuario() == null || request.getUsuario().isBlank() || request.getClave() == null
				|| request.getClave().isBlank()) {
			return ResponseEntity.badRequest().body("El usuario y la contraseña son obligatorios");
		}

		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getClave()));

			UsuarioUserDetails usuario = (UsuarioUserDetails) authentication.getPrincipal();
			String token = jwtService.generarToken(usuario);
			String rol = usuario.getAuthorities().iterator().next().getAuthority();

			LoginResponseDTO respuesta = new LoginResponseDTO(token, "Bearer", usuario.getUsuario().getCodigo(),
					usuario.getUsername(), usuario.getNombreCompleto(), rol);

			return ResponseEntity.ok(respuesta);
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos");
		}
	}
}
