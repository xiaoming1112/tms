package tyut.web.test;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import tyut.bean.Login;

import tyut.service.ILoginService;
import tyut.untils.Message;
import tyut.untils.MessageUtil;

@RestController
@RequestMapping("/login")
@Api(description = "登录相关接口")
public class LoginController {
	@Autowired
	private ILoginService loginService;

	@PutMapping("/saveOrUpdate")
	@ApiOperation(value = "/保存或者更新一个用户")
	public Message<String> saveOrUpdate(Login login) {
		Message<String> message = null;
		try {
			loginService.saveOrUpdate(login);
			message = MessageUtil.success("保存成功");
		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}

		return message;
	}

	@GetMapping("/findById")
	@ApiOperation(value = "/根据id查用户")
	@ApiImplicitParam(name = "id", value = "用户id", paramType = "query", dataType = "int", required = true)
	public Message<Login> findById(Integer id) {
		Message<Login> message = null;
		try {
			Login login = loginService.findById(id);
			message = MessageUtil.success(login);

		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}

	@GetMapping("/findAll")
	@ApiOperation(value = "/查询所有用户")
	public Message<List<Login>> findAll() {
		List<Login> login = loginService.findAll();
		return MessageUtil.success(login);
	}

	@GetMapping("/findAllByName")
	@ApiOperation(value = "/由用户名模糊查询用户")
	@ApiImplicitParam(name = "name", value = "用户名", paramType = "query", dataType = "String", required = true)
	public Message<List<Login>> findAllByName(String name) {
		List<Login> login = loginService.findByUsername(name);

		for (Login l : login) {
			System.out.println(l);
		}

		return MessageUtil.success(login);
	}

	@GetMapping("/findAllByStatus")
	@ApiOperation(value = "/由状态模糊查询用户")
	@ApiImplicitParam(name = "status", value = "状态", paramType = "query", dataType = "String", required = true)
	public Message<List<Login>> findAllByStatus(String status) {
		List<Login> login = loginService.findByStatus(status);

		for (Login l : login) {
			System.out.println(l);
		}

		return MessageUtil.success(login);
	}

	@GetMapping("/tologin")
	@ApiOperation(value = "/用户登录")
	public Message<String> tologin(String username, String password, HttpSession session) {
		Message<String> message = null;
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		try {
			Login login_db = loginService.isRealUser(login);
			session.setAttribute("user", login_db);
			message = MessageUtil.success("登录成功");
		} catch (Exception e) {
			session.setAttribute("msg", e.getMessage());
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}

	@GetMapping("/logout")
	@ApiOperation(value = "/用户退出登录")
	public Message<String> logout(HttpSession session) {
		Message<String> message = null;
		session.removeAttribute("user");
		message = MessageUtil.success("退出登录");
		return message;
	}
}
