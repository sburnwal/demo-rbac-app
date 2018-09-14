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
 * Has unidirectional ManyToMany relationship with Role
 * 
 * @author sburnwal
 */
@Entity(name = "UserAccount") @Table(name = "USER_ACCOUNT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserAccount extends BaseEntity {
	private static final long serialVersionUID = 1234567890L;
	
	@Column(name = "username", unique = true)	//username has to be unique
	private String username;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "age")
	private int age;

	@Column(name = "gender")
	private String gender;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL)
	private Set<UserAccountRole> userAccountRoles = new HashSet<>();

	public Set<UserAccountRole> getUserAccountRoles() {
		return userAccountRoles;
	}
	
	public void addRole(Role r) {
		UserAccountRole ur = new UserAccountRole(this, r);
		userAccountRoles.add(ur);
		r.getUserAccountRoles().add(ur);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
