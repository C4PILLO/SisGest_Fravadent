package pe.com.fravadent.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "UsuarioEntity")
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "estado", length = 1, nullable = false)
	private String estado;

	@Column(name = "username", length = 50, nullable = false, unique = true)
	private String username;

	@Column(name = "password_hash", length = 255, nullable = false)
	private String password_hash;

	@ManyToOne
	@JoinColumn(name = "id_rol", nullable = false)
	private RolEntity rol;

	@ManyToOne
	@JoinColumn(name = "id_tipo_documento")
	private TipoDocumentoEntity tipoDocumento;

	@Column(name = "numero_documento")
	private String numeroDocumento;

	@Column(name = "nombres")
	private String nombres;

	@Column(name = "apellido_paterno")
	private String apellidoPaterno;

	@Column(name = "apellido_materno")
	private String apellidoMaterno;

	@ManyToOne
	@JoinColumn(name = "id_sexo")
	private SexoEntity sexo;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "email")
	private String email;

	@Column(name = "direccion")
	private String direccion;

	@ManyToOne
	@JoinColumn(name = "id_distrito")
	private DistritoEntity distrito;

	@Column(name = "fecha_registro")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaRegistro;
}
