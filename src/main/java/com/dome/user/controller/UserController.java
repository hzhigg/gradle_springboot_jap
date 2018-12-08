package com.dome.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.dome.user.entity.User;
import com.dome.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="用户服务",tags={"用户服务"})
@RestController
@RequestMapping("/user")
public class UserController {
	private Logger logger=LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	
	@ApiOperation("根据id获取用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="id",dataType="Integer"),
		@ApiImplicitParam(name="name",value="姓名",dataType="String")
	})
	@GetMapping("/get")
	public String get(@RequestParam Integer id,@RequestParam(required=false)String name){
		User user=userService.get(id);
		return JSON.toJSONString(user);
	}
	
	@ApiOperation("获取所有用户")
	@GetMapping("/findAll")
	public String findAll(){
		List<User> user=userService.findAll();
		return JSON.toJSONString(user);
	}
	
	@ApiOperation("分页查询")
	@ApiImplicitParams({
		@ApiImplicitParam(name="page",value="当前页",defaultValue="1",required=false,dataType="Integer"),
		@ApiImplicitParam(name="size",value="总页数",defaultValue="1",required=false,dataType="Integer")
	})
	@GetMapping("/pageQuery")
	public String pageQuery(@RequestParam(required=false,defaultValue="1") Integer page,@RequestParam(required=false,defaultValue="1") Integer size){
		if(page<=0){
			return "参数错误";
		}
		Page<User> result=userService.pageUser(page-1, size);
		return JSON.toJSONString(result);
	}
	
	@ApiOperation("分页带参数查询")
	@ApiImplicitParams({
		@ApiImplicitParam(name="page",value="当前页",defaultValue="1",required=false,dataType="Integer"),
		@ApiImplicitParam(name="size",value="总页数",defaultValue="1",required=false,dataType="Integer"),
		@ApiImplicitParam(name="userName",value="姓名",defaultValue="",required=false,dataType="String")
	})
	@GetMapping("/pageQueryParam")
	public String pageQueryParam(@RequestParam(required=false,defaultValue="1") Integer page,@RequestParam(required=false,defaultValue="1") Integer size,String userName){
		if(page<=0){
			return "参数错误";
		}
		User user=new User();
		user.setUserName(userName);
		Page<User> result=userService.pageUserParam(page-1, size, user);
		return  JSON.toJSONString(result);
	}
	
}
