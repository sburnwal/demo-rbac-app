package demo.rbacapp.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * This is the class for RolePriviledge primary key, needed
 * for many-to-many mapping for the Role and Priviledge models.
 * 
 * To have ManyToMany relationship, define two @ManyToOne relationships. We are 
 * going for for this approach instead of @ManyToMany annotation because we want 
 * to have extra column in the join table (like update_timestamp etc).
 * 
 * @author sburnwal
 */
/* @Embeddable means instances of this class are part of the entities who own it */ 
@Embeddable 
public class RolePriviledgePk implements Serializable {
	
    @ManyToOne(cascade = CascadeType.ALL) 
	private Role role;
	
	@ManyToOne(cascade = CascadeType.ALL) 
	private Priviledge priviledge;
	
    public Role getRole() {
        return role;
    }
 
    public void setRole(Role role) {
        this.role = role;
    }
 
    public Priviledge getPriviledge() {
        return priviledge;
    }
 
    public void setPriviledge(Priviledge priv) {
        this.priviledge = priv;
    }
    
    public boolean equals(Object o) {
    	if(o == null || o.getClass() != this.getClass()) {
    		return false;
    	}
    	
    	RolePriviledgePk pk = (RolePriviledgePk) o;
    	if(this.getRole().equals(pk.getRole()) && this.getPriviledge().equals(pk.getPriviledge())) {
    		return true;
    	}
    	
    	return false;
    }
    
    public int hashCode() {
    	return new Long(this.getRole().getId() + this.getPriviledge().getId()).hashCode();
    }
}
