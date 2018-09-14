package demo.rbacapp.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Overrides the 'id' attribute so that we can have different column name (role_id)
 * which would be useful in creating the ManyToMany relationship (DB will not allow 
 * two columns with the name 'id').  
 * 
 * There is ManyToMany relationship between Role and Priviledge. Instead of using @ManyToMany
 * annotation, @OneToMany annotation is used on both the sides since we need extra columns 
 * on the join table.
 * 
 * @author sburnwal
 */

@Entity(name = "Role") @Table(name = "role")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Role extends BaseEntity {
	private static final long serialVersionUID = 1234567893L;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "description")
	private String description;
	
	/* if true, then cannot be updated by users or rest api */
	@Column(name = "immutable")
	private boolean immutable;	
	
	@OneToMany(mappedBy = "rolePriviledgePk.role", cascade = CascadeType.ALL)
	private Set<RolePriviledge> rolePriviledges = new HashSet<>();

	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private Set<UserAccountRole> userAccountRoles = new HashSet<>();

	public Set<RolePriviledge> getRolePriviledges() {
		return rolePriviledges;
	}

	public void setRolePriviledges(Set<RolePriviledge> rolePriviledges) {
		this.rolePriviledges = rolePriviledges;
	}

	public void addRolePriviledges(RolePriviledge rolePriviledge) {
		this.rolePriviledges.add(rolePriviledge);
	}

	public Set<UserAccountRole> getUserAccountRoles() {
		return userAccountRoles;
	}

	public void setUserAccountRoles(Set<UserAccountRole> userAccountRoles) {
		this.userAccountRoles = userAccountRoles;
	}
	
	public void addUserAccountRole(UserAccountRole ur) {
		this.userAccountRoles.add(ur);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isImmutable() {
		return immutable;
	}

	public void setImmutable(boolean immutable) {
		this.immutable = immutable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}