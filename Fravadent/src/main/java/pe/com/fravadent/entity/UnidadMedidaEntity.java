package pe.com.fravadent.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pe.com.fravadent.entity.base.BaseEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "UnidadMedidaEntity")
@Table(name = "unidad_medida")
public class UnidadMedidaEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_unidad_medida")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;


    @Column(name = "abreviatura")
    private String abreviatura;
}
