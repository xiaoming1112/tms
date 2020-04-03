package tyut.bean;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="tms_base")
@ApiModel
public class Base {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value="基地id")
	private Integer id;
	@ApiModelProperty(value="基地名称")
	private String name;
	@ApiModelProperty(value="基地地址")
	private String address;
	@ApiModelProperty(value="基地电话")
	private String phone;
	@ApiModelProperty(value="基地简介")
	private String content;
	@ApiModelProperty(value="基地网站")
	private String web;


	public Base() {
	}

	public Base(String name, String address, String phone, String content, String web) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.content = content;
		this.web = web;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}


	@Override
	public String toString() {
		return "Base [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", content="
				+ content + ", web=" + web + "]";
	}
	
	
	
}
