package com.dome.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.dome.base.controller.BaseController;
import com.dome.user.entity.WebUser;
import com.dome.user.service.WebUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="web用户服务",tags={"web用户服务"})
@RestController
@RequestMapping("/web/user")
public class WebUserController extends BaseController{
	

	@Autowired
	private WebUserService webUserService;
	
	
	@ApiOperation("根据id获取用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="id",dataType="Integer")
	})
	@GetMapping("/get")
	public String get(@RequestParam Long id){
		WebUser user=webUserService.get(id);;
		return JSON.toJSONString(user);
	}
	
	@ApiOperation("获取所有用户")
	@GetMapping("/findAll")
	public String findAll(){
		List<WebUser> user=webUserService.findAll();
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
		Page<WebUser> result=webUserService.pageUser(page-1, size);
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
		WebUser user=new WebUser();
		user.setUserName(userName);
		Page<WebUser> result=webUserService.pageUserParam(page-1, size, user);
		return JSON.toJSONString(result);
	}
	
	@ApiOperation("原生sql查询")
	@GetMapping("/nativeQuery")
	public String nativeQuery(@RequestParam String userName){
		List<WebUser> result=webUserService.nativeQuery(userName);
		return JSON.toJSONString(result);
	}
	
	/**
	 * @Query 注解原生sql查询
	 * @param userName
	 * @return
	 */
	@ApiOperation("注解原生sql查询")
	@GetMapping("/findByKeyNameLimit")
	public String findByKeyNameLimit(String userName){
		List<WebUser> result= webUserService.findByKeyNameLimit(userName);
		return JSON.toJSONString(result);
	}
	
}
