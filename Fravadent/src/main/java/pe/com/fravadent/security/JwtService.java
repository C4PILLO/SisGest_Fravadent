package pe.com.fravadent.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	@Value("${jwt.secret}")
	private String jwtSecret;

	@Value("${jwt.expiration}")
	private long jwtExpiration;

	public String generarToken(UsuarioUserDetails usuario) {
		Map<String, Object> claims = new HashMap<>();

		claims.put("codigo", usuario.getUsuario().getCodigo());
		claims.put("nombreCompleto", usuario.getNombreCompleto());

		String rol = usuario.getAuthorities().iterator().next().getAuthority();
		claims.put("rol", rol);

		return crearToken(claims, usuario.getUsername());
	}

	private String crearToken(Map<String, Object> claims, String username) {
		Date fechaActual = new Date();
		Date fechaExpiracion = new Date(fechaActual.getTime() + jwtExpiration);

		return Jwts.builder().claims(claims).subject(username).issuedAt(fechaActual).expiration(fechaExpiracion)
				.signWith(obtenerClave()).compact();
	}

	public String obtenerUsuario(String token) {
		return obtenerClaim(token, Claims::getSubject);
	}

	public Date obtenerFechaExpiracion(String token) {
		return obtenerClaim(token, Claims::getExpiration);
	}

	public <T> T obtenerClaim(String token, Function<Claims, T> claimsResolver) {
		Claims claims = obtenerTodosLosClaims(token);
		return claimsResolver.apply(claims);
	}

	public boolean validarToken(String token, UserDetails userDetails) {
		String username = obtenerUsuario(token);
		return username.equals(userDetails.getUsername()) && !tokenExpirado(token);
	}

	private boolean tokenExpirado(String token) {
		return obtenerFechaExpiracion(token).before(new Date());
	}

	private Claims obtenerTodosLosClaims(String token) {
		return Jwts.parser().verifyWith(obtenerClave()).build().parseSignedClaims(token).getPayload();
	}

	private SecretKey obtenerClave() {
		byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
