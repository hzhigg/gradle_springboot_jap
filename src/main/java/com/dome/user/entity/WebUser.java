package com.dome.user.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.dome.base.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 用户信息表
 * 原则：ID，用户名，邮箱号，手机号，微信ID都不可重复
 * @author maybe
 */
@NoArgsConstructor
@AllArgsConstructor
/*
 * @Entity说明这是一个实体bean，使用orm默认规则（类名=表名；属性名=字段名）关联DB；
 * 如果想改变这种规则：1，可以配置@Entity的name来对应DB中的表名；@Entity(name="USER")
 * 				  2，使用@Table来改变class和DB表名的映射规则；@Column来改变属性名和字段名的映射规则
*/
@Data
@Entity(name="WEBUSER")
public class WebUser extends BaseEntity{
 

	/**
	 * 
	 */
	private static final long serialVersionUID = -6611213740441882886L;

	@JSONField(ordinal=1) 
	@Column(length=32,name="nickName",columnDefinition="varchar(32) default '' comment '昵称'")
	private String nickName; //昵称

	@JSONField(ordinal=1)
	@Column(length=32,name="userName",nullable=false,columnDefinition="varchar(32) unique default ''  comment '用户名'")
	protected String userName; //用户名
	
	@JSONField(ordinal=2)
	@Column(length=32,name="password",nullable=false,columnDefinition="varchar(32) default '000000' comment '密码'")
	protected String password; //密码
	
	@JSONField(ordinal=3)
	@Column(length=64,name="email",nullable=false,columnDefinition="varchar(64) unique default '' comment '邮箱'")
	protected String email; //邮箱号
	
	@JSONField(ordinal=3) 
	@OneToMany(mappedBy="webUser",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Address> addresses;
	
	public WebUser(String username) {
		this.userName = username;
	}
	
	@Override
	public String toString() {
		return JSONObject.toJSONString(this,true);
	}
}

