package demo.rbacapp.dto;

import demo.rbacapp.entity.User;

public class UserDTO extends BaseDTO {
	private String username;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;

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

	public static UserDTO toDto(User user) {
		UserDTO dto = null;
		if(user != null) {
			dto = new UserDTO();
			dto.setId(user.getId());
			dto.setUsername(user.getUsername());
			dto.setFirstName(user.getFirstName());
			dto.setLastName(user.getLastName());
			dto.setGender(user.getGender());
			dto.setAge(user.getAge());
		}
		return dto;
	}
}
