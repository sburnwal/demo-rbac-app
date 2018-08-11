package demo.rbacapp.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This is the many-to-many relationship table of Role and Priviledge. Normally, such an 
 * entity definition is not needed and just by defining the @ManyToMany relation on the 
 * entity (e.g. Role) would have been sufficient and the relationship table would have been 
 * created automatically. But since we need extra columns like 'update_timestamp', 'updated_by' 
 * etc, we need this extra entity explicitely.
 *  
 * @author sburnwal
 */
@Entity
@Table(name = "ROLE_PRIVILEDGE")
@AssociationOverrides(
	{ @AssociationOverride(name = "rolePriviledgePk.role",
        joinColumns = @JoinColumn(name = "ROLE_ID")),
    @AssociationOverride(name = "rolePriviledgePk.priviledge",
        joinColumns = @JoinColumn(name = "PRIVILEDGE_ID")) 
})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RolePriviledge extends BaseEntity {
	//composite primary key
	@EmbeddedId
	private RolePriviledgePk rolePriviledgePk = new RolePriviledgePk();

	//aditional fields if any (updateTimeStamp inherited from BaseEntity)
	private boolean immutable;
	
	public RolePriviledgePk getRolePriviledgePk() {
		return rolePriviledgePk;
	}

	public void setRolePriviledgePk(RolePriviledgePk rolePriviledgePk) {
		this.rolePriviledgePk = rolePriviledgePk;
	}

	@Transient 
	public Role getRole() {
		return getRolePriviledgePk().getRole();
	}
	
	public void setRole(Role role) {
		getRolePriviledgePk().setRole(role);
	}
	
	@Transient 
	public Priviledge getPriviledge() {
		return getRolePriviledgePk().getPriviledge();
	}
	
	public void setPriviledge(Priviledge p) {
		getRolePriviledgePk().setPriviledge(p);
	}

	public boolean isImmutable() {
		return immutable;
	}

	public void setImmutable(boolean immutable) {
		this.immutable = immutable;
	}
}
