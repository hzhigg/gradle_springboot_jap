package com.dome.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="user_t")
@Entity
public class User {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    private String password;

    private Integer age;

    private String nike;
   
    private String userNake;
    
}