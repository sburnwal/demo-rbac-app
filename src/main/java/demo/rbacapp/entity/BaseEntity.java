package demo.rbacapp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

/**
 * Serves as the base model (entity) for all the entities.
 * It is annotated with @MappedSuperclass so that all the concrete
 * entities inherit the properties from this model and avoid 
 * code for these basic properties. This annotation is supported by
 * Hibernate framework.
 * 
 * It defines a common 'id' attribute that is the Primary key for all 
 * entities which is overridden using @AttributeOverride annotation.
 * We need to override because different column names are needed when
 * creating relationships between entities (for ex, look at Role entity) 
 * 
 * @author sburnwal
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE) 
	@Column(name = "id", nullable = false)
	private Long id;
	
	@UpdateTimestamp @Column(name = "update_timestamp", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTimestamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}

	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}
}
