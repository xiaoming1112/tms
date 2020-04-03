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
@Table(name="school_base")
@ApiModel
public class School_Base {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value="id")
	private Integer id;
	@ApiModelProperty(value="状态")
	private String status;
	@ManyToOne
	@JoinColumn(name="school_id")
	private School school;
	@ManyToOne
	@JoinColumn(name="base_id")
	private Base base;
	public School_Base() {

	}
	public School_Base(String status) {
		super();
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	@Override
	public String toString() {
		return "Schoolbase [id=" + id + ", status=" + status + "]";
	}
	
	

	
	
}
