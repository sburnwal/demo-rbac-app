package demo.rbacapp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * This is the class for UserAccountRole primary key, needed
 * for many-to-many mapping for the UserAccount and Role models.
 * 
 * To have ManyToMany relationship, define two @ManyToOne relationships. We are 
 * going for for this approach instead of @ManyToMany annotation because we want 
 * to have extra column in the join table (like update_timestamp etc).
 * 
 * @author sburnwal
 */
/* @Embeddable means instances of this class are part of the entities who own it */ 
@Embeddable 
public class UserAccountRolePk implements Serializable {
	@Column(name = "user_id") 
	private Long userId;
	
	@Column(name = "role_id")
	private Long roleId;
	
	public UserAccountRolePk() {
		
	}
	
	public UserAccountRolePk(Long userId, Long roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}
	
    public boolean equals(Object o) {
    	if(o == null || o.getClass() != this.getClass()) {
    		return false;
    	}
    	
    	UserAccountRolePk pk = (UserAccountRolePk) o;
    	if(this.userId.equals(pk.userId) && this.roleId.equals(pk.roleId)) {
    		return true;
    	}
    	
    	return false;
    }
    
    public int hashCode() {
    	return Objects.hash(userId, roleId);
    }
}