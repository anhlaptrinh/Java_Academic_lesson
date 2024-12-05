package crm.entity;

public class EmployeeEntity {
	
	private int id;
	private String email;
	private String password;
	private String fullname;
	private String avatar;
	private String roleId;
	
	
	public EmployeeEntity() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", email=" + email + ", password=" + password + ", fullname=" + fullname
				+ ", avatar=" + avatar + ", roleId=" + roleId + "]";
	}
	
}
