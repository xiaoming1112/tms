package tyut.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="tms_login")
public class Login {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value="登录id")
	private Integer id;
	@ApiModelProperty(value="用户账号")
	private String username;
	@ApiModelProperty(value="用户密码")
	private String password;
	@ApiModelProperty(value="用户状态")
	private String status;
	@ApiModelProperty(value="用户角色")
	private String role;
	public Login() {
		
	}
	public Login(String username, String password, String status, String role) {
		super();
		this.username = username;
		this.password = password;
		this.status = status;
		this.role = role;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", username=" + username + ", password=" + password + ", status=" + status
				+ ", role=" + role + "]";
	}
	
}
