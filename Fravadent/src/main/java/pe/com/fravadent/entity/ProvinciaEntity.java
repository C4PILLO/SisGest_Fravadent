package pe.com.fravadent.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Entity(name = "ProvinciaEntity")
@Table(name = "provincia")
public class ProvinciaEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_provincia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;


    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private DepartamentoEntity departamento;
}
