package demo.rbacapp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Primary aim of this class is to hold meta information about entities like
 * the priviledge for an entity etc. Care should be taken to make sure that 
 * name of entity follows a specific pattern (so that RBAC can be enforced 
 * on them with a generic code).
 * 
 * @author sburnwal
 *
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AttributeOverride(name = "id", column = @Column(name="entity_id"))
public class EntityMetaInfo extends BaseEntity {
	private static final long serialVersionUID = 1234567896L;

	@Column(name = "entity_name", unique = true)	
	private String entityName;
	
	@OneToOne @JoinColumn(name = "priv_name", referencedColumnName = "priv_name")	
	private Priviledge priviledge;
	
	@Column(name = "immutable")
	private boolean immutable ;		//cannot be changed by users or rest api

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String name) {
		this.entityName = name;
	}

	public Priviledge getPriviledge() {
		return priviledge;
	}

	public void setPriviledge(Priviledge priviledge) {
		this.priviledge = priviledge;
	}

	public boolean isImmutable() {
		return immutable;
	}

	public void setImmutable(boolean immutable) {
		this.immutable = immutable;
	}
}
