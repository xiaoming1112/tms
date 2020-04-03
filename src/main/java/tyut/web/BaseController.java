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
import tyut.bean.Base;
import tyut.service.IBaseService;
import tyut.untils.Message;
import tyut.untils.MessageUtil;

@RestController
@RequestMapping("/base")
@Api(description = "基地相关接口")
public class BaseController {
	@Autowired
	private IBaseService baseService;
	
	@PutMapping("/saveOrUpdate")
	@ApiOperation(value="/保存或者更新一个基地")
	public Message<String> saveOrUpdate(Base base){
		Message<String> message = null;
		try {
			baseService.saveOrUpdate(base);
			message = MessageUtil.success("保存成功");
		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		
		return message;
	}
	
	@GetMapping("/findById")
	@ApiOperation(value="/根据id查基地")
	@ApiImplicitParam(name="id",value="基地id",paramType = "query",dataType = "int",required = true)
	public Message<Base> findById(Integer id){
		Message<Base > message =null;
		try {
			Base base=baseService.findById(id);
			message=MessageUtil.success(base);
			
		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
	@GetMapping("/findAll")
	@ApiOperation(value="/查询所有基地")
	public Message<List<Base> > findAll(){
		List<Base> bases =baseService.findAll();
		return MessageUtil.success(bases);
	}
	@GetMapping("/findAllByName")
	@ApiOperation(value="/模糊查询基地")
	@ApiImplicitParam(name="name",value="基地名字",paramType = "query",dataType = "String",required = true)
	public Message<List<Base> > findAllByName(String name){
		List<Base> bases =baseService.findByName(name);
		return MessageUtil.success(bases);
	}
	@GetMapping("/deleteById")
	@ApiOperation(value="/根据id删除一个基地")
	@ApiImplicitParam(name="id",value="基地id",paramType = "query",dataType = "int",required = true)
	public Message<String> deleteById(Integer id){
		Message<String > message =null;
		try {
			baseService.deleteById(id);
			message=MessageUtil.success("删除成功");
			
		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
}
