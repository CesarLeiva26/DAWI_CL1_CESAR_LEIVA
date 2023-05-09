package pe.edu.cibertec.DAWI_CL1_CESAR_LEIVA.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 
import lombok.Data;
import pe.edu.cibertec.DAWI_CL1_CESAR_LEIVA.model.bd.Especialidad;

@Data
@Table(name = "Especialidad")
@Entity
 
public class Especialidad {
	
	@Id
	private String idesp;
	@Column (name = "nomesp")
	private String nomesp;
	@Column (name = "costo")
	private Double costo;
}
