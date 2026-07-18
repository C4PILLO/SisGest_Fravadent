package pe.com.fravadent.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import pe.com.fravadent.entity.UsuarioEntity;

public class UsuarioUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private final UsuarioEntity usuario;
	private final String rolNombre;

	public UsuarioUserDetails(UsuarioEntity usuario, String rolNombre) {
		this.usuario = usuario;
		this.rolNombre = rolNombre;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + rolNombre));
	}

	@Override
	public String getPassword() {
		return usuario.getPassword_hash();
	}

	@Override
	public String getUsername() {
		return usuario.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return "A".equals(usuario.getEstado());
	}

	public String getNombreCompleto() {
		String paterno = usuario.getApellidoPaterno() != null ? usuario.getApellidoPaterno() : "";
		String materno = usuario.getApellidoMaterno() != null ? usuario.getApellidoMaterno() : "";
		return usuario.getNombres() + " " + paterno + " " + materno;
	}

	public UsuarioEntity getUsuario() {
		return this.usuario;
	}
}
