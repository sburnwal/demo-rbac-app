package demo.rbacapp.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class RegisterUserRequest {
    @NotBlank @Size(min = 2, max = 40)
    private String firstName;

    @NotBlank @Size(min = 2, max = 40)
    private String lastName;

    @NotBlank @Size(min = 4, max = 15)
    private String username;

    @NotBlank @Size(min = 6, max = 20)
    private String password;

	@NotBlank  
    private String gender;

    @NotNull 
    private int age;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}