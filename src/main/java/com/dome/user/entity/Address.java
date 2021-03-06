package com.dome.user.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.dome.base.entity.BaseEntity;

import lombok.Data;

@Data
@Entity(name="ADDRESS")
public class Address extends BaseEntity {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 3448718014776122189L;

	@JSONField(ordinal=1) 
	@Column(name="label",nullable=false,columnDefinition="varchar(16) comment '地址标签（家、公司）'")
	private String label;
 
	@JSONField(ordinal=2) 
	@Column(name="country",nullable=false,columnDefinition="varchar(16) comment '国家'")
	private String country;
	
	@JSONField(ordinal=3) 
	@Column(name="province",nullable=false,columnDefinition="varchar(32) comment '省份'")
	private String province;
	
	@JSONField(ordinal=4)
	@Column(name="city",nullable=false,columnDefinition="varchar(32) comment '城市'")
	private String city;
	
	@JSONField(ordinal=5) 
	@Column(name="address",nullable=false,columnDefinition="varchar(255) comment '具体地址'")
	private String address;
	
	@JSONField(ordinal=6)
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY,optional=true)
	@JoinColumn(name="webUser_id",nullable=true)
	private WebUser webUser;
	
	@Override
	public String toString() {
		return JSONObject.toJSONString(this,true);
	}
	
}
