package com.dome.base.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
 
@MappedSuperclass //表明这是父类，可以将属性映射到子类中使用JPA生成表
@Data
public abstract class BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -18135716827288538L;


	@JSONField(ordinal=1) 
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",columnDefinition="BIGINT(30) comment '无意义自增主键'")
	protected Integer id; //无意义自增主键
 
	@JSONField(ordinal=2,format="yyyy-MM-dd HH:mm:ss") 
	@Column(name="createTime",columnDefinition="DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间'")
	protected Date createTime; //创建时间
	
	@JSONField(ordinal=3,format="yyyy-MM-dd HH:mm:ss") 
	@Column(name="updateTime",columnDefinition="DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间'")
	protected Date updateTime; //销毁时间
	
	@JSONField(ordinal=4) 
	@Version @Column(name="version",nullable=false,columnDefinition="int(20) NOT NULL 0 comment '版本号'")
	protected Integer version;
	
	@JSONField(ordinal=5) 
	@Column(length=1,name="createUser",nullable=false,columnDefinition="BIGINT(10) NOT NULL DEFAULT 0 comment '创建用户'")
	protected Integer createUser; //创建用户
	
	@JSONField(ordinal=5) 
	@Column(length=1,name="updateUser",nullable=false,columnDefinition="BIGINT(10) NOT NULL DEFAULT 0 comment '更新用户'")
	protected Integer updateUser; //是否启用 
	
	@JSONField(ordinal=5) 
	@Column(length=1,name="isValid",nullable=false,columnDefinition="int(1) NOT NULL DEFAULT 0 comment '是否启用，1:启用     0:不启用'")
	protected Integer isValid; //是否启用 
 
}
