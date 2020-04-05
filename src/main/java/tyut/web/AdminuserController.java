package tyut.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import tyut.bean.Adminuser;
import tyut.bean.Base;
import tyut.bean.Login;
import tyut.bean.School;

import tyut.service.IAdminuserService;

import tyut.untils.Message;
import tyut.untils.MessageUtil;

@RestController
@RequestMapping("/admin")
@Api(description = "管理员相关接口")
public class AdminuserController {
	@Autowired
	private IAdminuserService adminuserService;

	@PutMapping("/saveOrUpdate")
	@ApiOperation(value = "/保存或者更新一个管理员")
	public Message<String> saveOrUpdate(Adminuser adminuser) {
		Message<String> message = null;
		try {
			adminuserService.saveOrUpdate(adminuser);
			message = MessageUtil.success("保存成功");
		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}

		return message;
	}

	@GetMapping("/findById")
	@ApiOperation(value = "/根据id查管理员")
	@ApiImplicitParam(name = "id", value = "管理员id", paramType = "query", dataType = "int", required = true)
	public Message<Adminuser> findById(Integer id) {
		Message<Adminuser> message = null;
		try {
			Adminuser adminuser = adminuserService.findById(id);
			message = MessageUtil.success(adminuser);

		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}

	@GetMapping("/findAll")
	@ApiOperation(value = "/查询所有管理员")
	public Message<List<Adminuser>> findAll() {
		List<Adminuser> list = adminuserService.findAll();
		return MessageUtil.success(list);
	}

	@GetMapping("/deleteById")
	@ApiOperation(value = "/根据id删除管理员")
	@ApiImplicitParam(name = "id", value = "管理员id", paramType = "query", dataType = "int", required = true)
	public Message<String> deleteById(Integer id) {
		Message<String> message = null;
		try {
			adminuserService.deleteById(id);
			message = MessageUtil.success("删除成功");

		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}

	@GetMapping("/findByLogin")
	@ApiOperation(value = "/根据登录id查管理员")
	@ApiImplicitParam(name = "login_id", value = "登录id", paramType = "query", dataType = "int", required = true)
	public Message<Adminuser> findByLogin(Integer login_id) {
		Login login = new Login();
		login.setId(login_id);
		Message<Adminuser> message = null;
		try {
			Adminuser adminuser = adminuserService.findByLogin(login);
			message = MessageUtil.success(adminuser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;

	}

	@GetMapping("/findBySchool")
	@ApiOperation(value = "/根据学校id查管理员")
	@ApiImplicitParam(name = "school_id", value = "学校id", paramType = "query", dataType = "int", required = true)
	public Message<List<Adminuser>> findBySchool(Integer school_id) {
		School school = new School();
		school.setId(school_id);
		Message<List<Adminuser>> message = null;
		try {
			List<Adminuser> list = adminuserService.findBySchool(school);
			message = MessageUtil.success(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}

	@GetMapping("/findByBase")
	@ApiOperation(value = "/根据基地查管理员")
	@ApiImplicitParam(name = "base_id", value = "基地id", paramType = "query", dataType = "int", required = true)
	public Message<List<Adminuser>> findByBase(Integer base_id) {
		Base base = new Base();
		base.setId(base_id);
		Message<List<Adminuser>> message = null;
		try {
			List<Adminuser> list = adminuserService.findByBase(base);
			message = MessageUtil.success(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}

	@GetMapping("/findByStatus")
	@ApiOperation(value = "/根据状态查管理员")
	@ApiImplicitParam(name = "status", value = "状态", paramType = "query", dataType = "string", required = true)
	public Message<List<Adminuser>> findByStatus(String status) {
		Message<List<Adminuser>> message = null;
		try {
			List<Adminuser> list = adminuserService.findByStatus(status);
			message = MessageUtil.success(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
}
