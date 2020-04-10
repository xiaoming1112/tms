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

import tyut.bean.School;
import tyut.service.ISchoolService;
import tyut.untils.Message;
import tyut.untils.MessageUtil;

@RestController
@RequestMapping("/school")
@Api(description = "学校相关接口")
public class ISchoolController {
	@Autowired
	private ISchoolService schoolService;

	@PutMapping("/saveOrUpdate")
	@ApiOperation(value = "/保存或者更新一个学校")
	public Message<String> saveOrUpdate(School school) {
		Message<String> message = null;
		try {
			schoolService.saveOrUpdate(school);
			message = MessageUtil.success("保存成功");
		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}

		return message;
	}

	@GetMapping("/findById")
	@ApiOperation(value = "/根据id查学校")
	@ApiImplicitParam(name = "id", value = "学校id", paramType = "query", dataType = "int", required = true)
	public Message<School> findById(Integer id) {
		Message<School> message = null;
		try {
			School school = schoolService.findById(id);
			message = MessageUtil.success(school);

		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}

	@GetMapping("/findAll")
	@ApiOperation(value = "/查询所有学校")
	public Message<List<School>> findAll() {
		List<School> bases = schoolService.findAll();
		return MessageUtil.success(bases);
	}

	@GetMapping("/findAllByName")
	@ApiOperation(value = "/模糊查询学校")
	@ApiImplicitParam(name = "name", value = "学校名字", paramType = "query", dataType = "String", required = true)
	public Message<List<School>> findAllByName(String name) {
		List<School> school = schoolService.findByName(name);
		return MessageUtil.success(school);
	}

	@GetMapping("/deleteById")
	@ApiOperation(value = "/根据id删除一个学校")
	@ApiImplicitParam(name = "id", value = "学校id", paramType = "query", dataType = "int", required = true)
	public Message<String> deleteById(Integer id) {
		Message<String> message = null;
		try {
			schoolService.deleteById(id);
			message = MessageUtil.success("删除成功");

		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
}
