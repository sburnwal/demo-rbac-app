package demo.rbacapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Hibernate provides the JPA implementation
 * @author sburnwal
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NetworkDevice extends BaseEntity {
	private static final long serialVersionUID = 1234567891L;

	@Column(name = "make")	//like Cisco, Juniper
	private String make;
	
	@Column(name = "model")	//like Cat6k, Nexus9k
	private String model;

	@Column(name = "version")
	private String version;
	
	public NetworkDevice() {
		//default constructor
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
