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

import tyut.bean.School_Base;

import tyut.service.ISchool_BaseService;
import tyut.untils.Message;
import tyut.untils.MessageUtil;

@RestController
@RequestMapping("/school_base")
@Api(description = "学校-基地相关接口")
public class School_BaseController {
	@Autowired
	private ISchool_BaseService school_BaseService;

	@PutMapping("/saveOrUpdate")
	@ApiOperation(value = "/保存或者更新一个学校-基地")
	public Message<String> saveOrUpdate(School_Base school_Base) {
		Message<String> message = null;
		try {
			school_BaseService.saveOrUpdate(school_Base);
			message = MessageUtil.success("保存成功");
		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}

		return message;
	}

	@GetMapping("/findById")
	@ApiOperation(value = "/根据id查学校-基地")
	@ApiImplicitParam(name = "id", value = "学校-基地id", paramType = "query", dataType = "int", required = true)
	public Message<School_Base> findById(Integer id) {
		Message<School_Base> message = null;
		try {
			School_Base school_Base = school_BaseService.findById(id);
			message = MessageUtil.success(school_Base);

		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}

	@GetMapping("/findAll")
	@ApiOperation(value = "/查询所有学校-基地")
	public Message<List<School_Base>> findAll() {
		List<School_Base> school_Bases = school_BaseService.findAll();
		return MessageUtil.success(school_Bases);
	}

	@GetMapping("/deleteById")
	@ApiOperation(value = "/根据id删除一个学校-基地")
	@ApiImplicitParam(name = "id", value = "学校-基地id", paramType = "query", dataType = "int", required = true)
	public Message<String> deleteById(Integer id) {
		Message<String> message = null;
		try {
			school_BaseService.deleteById(id);
			message = MessageUtil.success("删除成功");

		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}

	@GetMapping("/findSchoolByBase")
	@ApiOperation(value = "/根据基地id查学校")
	@ApiImplicitParam(name = "base_id", value = "基地id", paramType = "query", dataType = "int", required = true)
	public Message<List<School_Base>> findSchoolByBase(Integer base_id) {

		List<School_Base> school = school_BaseService.findAllSchoolByBase(base_id);
		return MessageUtil.success(school);
	}

	@GetMapping("/findBaseBySchool")
	@ApiOperation(value = "/根据学校id查基地")
	@ApiImplicitParam(name = "school_id", value = "学校id", paramType = "query", dataType = "int", required = true)
	public Message<List<School_Base>> findBaseBySchool(Integer school_id) {
		List<School_Base> bases = school_BaseService.findAllBaseBySchool(school_id);
		return MessageUtil.success(bases);
	}
}
