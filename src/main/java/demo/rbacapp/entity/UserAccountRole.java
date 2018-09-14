package demo.rbacapp.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This is the many-to-many relationship table of UserAccount and Role. Normally, such an 
 * entity definition is not needed and just by defining the @ManyToMany relation on the 
 * entity (e.g. Role) would have been sufficient and the relationship table would have been 
 * created automatically. But since we need extra columns like 'update_timestamp', 'updated_by' 
 * etc, we need this extra entity explicitly.
 *  
 * @author sburnwal
 */
@Entity (name = "UserAccountRole")
@Table(name = "USERACCOUNT_ROLES")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserAccountRole extends BaseEntity {
	//composite primary key
	@EmbeddedId		
	private UserAccountRolePk userAccountRolePk;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@MapsId("userId")
	private UserAccount userAccount;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@MapsId("roleId")
	private Role role;
	
	//additional fields if any (updateTimeStamp inherited from BaseEntity)
	private boolean immutable;
	
	private UserAccountRole() {
		
	}
	
	public UserAccountRole(UserAccount ua, Role r) {
		this.userAccount = ua;
		this.role = r;
		this.userAccountRolePk = new UserAccountRolePk(ua.getId(), r.getId());
	}
	
	public UserAccountRolePk getUserAccountRolePk() {
		return userAccountRolePk;
	}

	public void setUserAccountRolePk(UserAccountRolePk pk) {
		this.userAccountRolePk = pk;
	}

	@Transient 
	public UserAccount getUserAccount() {
		return userAccount;
	}
	
	public void setUserAccount(UserAccount u) {
		this.userAccount = u;
	}
	
	@Transient 
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role r) {
		this.role = r;
	}
	
	public boolean isImmutable() {
		return immutable;
	}

	public void setImmutable(boolean immutable) {
		this.immutable = immutable;
	}
}