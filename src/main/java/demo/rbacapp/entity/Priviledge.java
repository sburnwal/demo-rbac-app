package demo.rbacapp.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * There is ManyToMany relationship between Role and Priviledge. Instead of using @ManyToMany
 * annotation, @OneToMany annotation is used on both the sides since we need extra columns 
 * on the join table.
 * 
 * @author sburnwal
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Priviledge extends BaseEntity{
	private static final long serialVersionUID = 1234567894L;

	@Column(name = "priv_name", unique = true)	
	private String name;
	
	@Column(name = "role_bit")	
	private long roleBit ;
	
	@Column(name = "description")	
	private String description;
	
	@Column(name = "immutable")
	private boolean immutable ;		//cannot be changed by users or rest api
	
	@OneToMany(mappedBy = "rolePriviledgePk.priviledge", cascade = CascadeType.ALL)
	private Set<RolePriviledge> rolePriviledges = new HashSet<>();
	
	public boolean isImmutable() {
		return immutable;
	}

	public void setImmutable(boolean immutable) {
		this.immutable = immutable;
	}
	
	public Set<RolePriviledge> getRolePriviledges() {
		return rolePriviledges;
	}
	
	public void setRolePriviledges(Set<RolePriviledge> s) {
		this.rolePriviledges = s;
	}
	
	public void addRolePriviledge(RolePriviledge rp) {
		this.rolePriviledges.add(rp);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getRoleBit() {
		return roleBit;
	}

	public void setRoleBit(long roleBit) {
		this.roleBit = roleBit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
