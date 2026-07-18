package pe.com.fravadent.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BaseEntity {
	@Column(name = "nombre", length = 80, nullable = false)
	private String nombre;

	@Column(name = "estado", length = 1, nullable = false)
	private String estado;
}
