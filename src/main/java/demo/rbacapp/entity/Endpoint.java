package demo.rbacapp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Entity with JPA annotations. Hibernate provides the JPA implementation.
 * It overrides the 'id' attribute from the mappedsuperclass BaseEntity.
 * @author sburnwal
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AttributeOverride(name = "id", column = @Column(name="endpoint_id"))
public class Endpoint extends BaseEntity {
	private static final long serialVersionUID = 1234567892L;

	@Column(name = "make")
	private String make;
	
	@Column(name = "product_name")
	private String productName;

	@Column(name = "os")
	private String os;
	
	@Column(name = "version")
	private String version;
	
	public Endpoint() {
		//default constructor
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
