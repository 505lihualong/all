package xx.all.upms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xx.all.upms.model.User;
import xx.common.web.utils.ResultUtil;
import xx.common.web.vo.Result;

@RestController
@RequestMapping("/testMybatis")
public class UserController {
	
	public Result add(User user) {
		return ResultUtil.success();
	}

}
