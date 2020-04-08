package tyut.web.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import tyut.bean.Base;
import tyut.bean.Login;
import tyut.bean.School;
import tyut.bean.Teacher;
import tyut.service.ITeacherService;

import tyut.untils.Message;
import tyut.untils.MessageUtil;

@RestController
@RequestMapping("/teacher")
@Api(description = "Teacher相关接口")
public class TeacherController {
	@Autowired
	private ITeacherService teacherService;

	@PutMapping("/saveOrUpdate")
	@ApiOperation(value = "/保存或者更新一个老师")
	public Message<String> saveOrUpdate(Teacher teacher) {
		Message<String> message = null;
		try {
			teacherService.saveOrUpdate(teacher);
			message = MessageUtil.success("保存成功");
		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}

		return message;
	}

	@GetMapping("/findById")
	@ApiOperation(value = "/根据id查老师")
	@ApiImplicitParam(name = "id", value = "id", paramType = "query", dataType = "int", required = true)
	public Message<Teacher> findById(Integer id) {
		Message<Teacher> message = null;
		try {
			Teacher teacher = teacherService.findById(id);
			message = MessageUtil.success(teacher);

		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}

	@GetMapping("/findAll")
	@ApiOperation(value = "/查询所有老师")
	public Message<List<Teacher>> findAll() {
		List<Teacher> list = teacherService.findAll();
		return MessageUtil.success(list);
	}

	@GetMapping("/deleteById")
	@ApiOperation(value = "/根据id删除老师")
	@ApiImplicitParam(name = "id", value = "id", paramType = "query", dataType = "int", required = true)
	public Message<String> deleteById(Integer id) {
		Message<String> message = null;
		try {
			teacherService.deleteById(id);
			message = MessageUtil.success("删除成功");

		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}

	@GetMapping("/findByLogin")
	@ApiOperation(value = "/根据登录id查老师")
	@ApiImplicitParam(name = "login_id", value = "登录id", paramType = "query", dataType = "int", required = true)
	public Message<Teacher> findByLogin(Integer login_id) {
		Login login = new Login();
		login.setId(login_id);
		Message<Teacher> message = null;
		try {
			Teacher teacher = teacherService.findByLogin(login);
			message = MessageUtil.success(teacher);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;

	}

	@GetMapping("/findBySchool")
	@ApiOperation(value = "/根据学校id查老师")
	@ApiImplicitParam(name = "school_id", value = "学校id", paramType = "query", dataType = "int", required = true)
	public Message<List<Teacher>> findBySchool(Integer school_id) {
		School school = new School();
		school.setId(school_id);
		Message<List<Teacher>> message = null;
		try {
			List<Teacher> list = teacherService.findBySchool(school);
			message = MessageUtil.success(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}

	@GetMapping("/findByBase")
	@ApiOperation(value = "/根据基地查老师")
	@ApiImplicitParam(name = "base_id", value = "基地id", paramType = "query", dataType = "int", required = true)
	public Message<List<Teacher>> findByBase(Integer base_id) {
		Base base = new Base();
		base.setId(base_id);
		Message<List<Teacher>> message = null;
		try {
			List<Teacher> list = teacherService.findByBase(base);
			message = MessageUtil.success(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}

	@GetMapping("/findByStatus")
	@ApiOperation(value = "/根据状态查老师")
	@ApiImplicitParam(name = "status", value = "状态", paramType = "query", dataType = "string", required = true)
	public Message<List<Teacher>> findByStatus(String status) {
		Message<List<Teacher>> message = null;
		try {
			List<Teacher> list = teacherService.findByStatus(status);
			message = MessageUtil.success(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}

	@GetMapping("/findByName")
	@ApiOperation(value = "/根据Name查老师")
	@ApiImplicitParam(name = "name", value = "姓名", paramType = "query", dataType = "string", required = true)
	public Message<List<Teacher>> findByName(String name) {
		Message<List<Teacher>> message = null;
		try {
			List<Teacher> list = teacherService.findByName(name);
			message = MessageUtil.success(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}

}
