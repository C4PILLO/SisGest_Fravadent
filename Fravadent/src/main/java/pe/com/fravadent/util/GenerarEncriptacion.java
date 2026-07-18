package pe.com.fravadent.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class GenerarEncriptacion {

	private static final PasswordEncoder passwordEnconder = new BCryptPasswordEncoder();

	public static String encriptar(String texto) {
		return passwordEnconder.encode(texto);
	}

	public static boolean validar(String texto, String textoencriptado) {
		return passwordEnconder.matches(texto, textoencriptado);
	}

	public static void main(String[] args) {
		// Cambia el texto aqui para generar un hash BCrypt valido y copiarlo a tu base
		// de datos
		String clave = "admin123";
		String claveEncriptada = GenerarEncriptacion.encriptar(clave);

		System.out.println("Clave original: " + clave);
		System.out.println("Clave encriptada: " + claveEncriptada);

		boolean coincide = GenerarEncriptacion.validar(clave, claveEncriptada);
		System.out.println("Coinciden: " + coincide);
	}
}
