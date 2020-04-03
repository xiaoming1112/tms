package tyut.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="tms_teacher")
@ApiModel
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value="id")
	private Integer id;
	
	@ApiModelProperty(value="登录id")
	@ManyToOne
	@JoinColumn(name="login_id")
	private Login login;
	@ApiModelProperty(value="school_id")
	@ManyToOne
	@JoinColumn(name="school_id")
	private School school;
	@ApiModelProperty(value="base_id")
	@ManyToOne
	@JoinColumn(name="base_id")
	private Base base;
	
	@ApiModelProperty(value="姓名")
	private String name;
	@ApiModelProperty(value="性别")
	private String gender;
	@ApiModelProperty(value="电话")
	private String phone;
	@ApiModelProperty(value="简介")
	private String content;
	@ApiModelProperty(value="状态")
	private String status;
	public Teacher() {
	}
	public Teacher(String name, String gender, String phone, String content, String status) {
		super();
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.content = content;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public Base getBase() {
		return base;
	}
	public void setBase(Base base) {
		this.base = base;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getstatus() {
		return status;
	}
	public void setstatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", gender=" + gender + ", phone=" + phone + ", content=" + content
				+ ", status=" + status + "]";
	}
	
	
	
}
