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
@Table(name="tms_adminuser")
@ApiModel
public class Adminuser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value="id")
	private Integer id;
	@ApiModelProperty(value="登录id",hidden = true)
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
	private String  name;
	@ApiModelProperty(value="电话")
	private String phone;
	@ApiModelProperty(value="状态")
	private String status;
	@ApiModelProperty(value="权限：新建管理员")
	private Integer newadmin_role;
	@ApiModelProperty(value="权限：基地管理")
	private Integer base_role;
	@ApiModelProperty(value="权限：信息发布管理")
	private Integer message_role;
	@ApiModelProperty(value="权限：学生管理")
	private Integer student_role;
	@ApiModelProperty(value="权限：教学管理")
	private Integer teaching_role;
	@ApiModelProperty(value="权限：教师管理")
	private Integer steacher_role;
	@ApiModelProperty(value="权限：宿舍管理")
	private Integer studenthost_role;
	public Adminuser() {
		
	}
	public Adminuser(String name, String phone, String status, Integer newadmin_role, Integer base_role,
			Integer message_role, Integer student_role, Integer teaching_role, Integer steacher_role,
			Integer studenthost_role) {
		this.name = name;
		this.phone = phone;
		this.status = status;
		this.newadmin_role = newadmin_role;
		this.base_role = base_role;
		this.message_role = message_role;
		this.student_role = student_role;
		this.teaching_role = teaching_role;
		this.steacher_role = steacher_role;
		this.studenthost_role = studenthost_role;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getNewadmin_role() {
		return newadmin_role;
	}
	public void setNewadmin_role(Integer newadmin_role) {
		this.newadmin_role = newadmin_role;
	}
	public Integer getBase_role() {
		return base_role;
	}
	public void setBase_role(Integer base_role) {
		this.base_role = base_role;
	}
	public Integer getMessage_role() {
		return message_role;
	}
	public void setMessage_role(Integer message_role) {
		this.message_role = message_role;
	}
	public Integer getStudent_role() {
		return student_role;
	}
	public void setStudent_role(Integer student_role) {
		this.student_role = student_role;
	}
	public Integer getTeaching_role() {
		return teaching_role;
	}
	public void setTeaching_role(Integer teaching_role) {
		this.teaching_role = teaching_role;
	}
	public Integer getSteacher_role() {
		return steacher_role;
	}
	public void setSteacher_role(Integer steacher_role) {
		this.steacher_role = steacher_role;
	}
	public Integer getStudenthost_role() {
		return studenthost_role;
	}
	public void setStudenthost_role(Integer studenthost_role) {
		this.studenthost_role = studenthost_role;
	}
	@Override
	public String toString() {
		return "Adminuser [name=" + name + ", phone=" + phone + ", status=" + status + ", newadmin_role="
				+ newadmin_role + ", base_role=" + base_role + ", message_role=" + message_role + ", student_role="
				+ student_role + ", teaching_role=" + teaching_role + ", steacher_role=" + steacher_role
				+ ", studenthost_role=" + studenthost_role + "]";
	}
	
	
}
