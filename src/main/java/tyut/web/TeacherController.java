package tyut.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/teacher")
@Api(description = "Teacher相关接口")
public class TeacherController {

}
