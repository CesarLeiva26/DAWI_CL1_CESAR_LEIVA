package pe.edu.cibertec.DAWI_CL1_CESAR_LEIVA.model.bd;

import javax.persistence.Column;
 import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "especialidad")

public class Especialidad {
	
	@Column (name = "idEsp")
	private String idesp;
	@Column (name = "NomEsp")
	private String nomesp;
	@Column (name = "Costo")
	private Double costo;
}
