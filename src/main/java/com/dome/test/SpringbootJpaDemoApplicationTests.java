package com.dome.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dome.user.entity.WebUser;
import com.dome.user.mapper.WebUserMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJpaDemoApplicationTests {

	@Autowired
	private WebUserMapper webUserMapper;

	@Test
	public void contextLoads(){
		@SuppressWarnings("unused")
		List<WebUser> user=webUserMapper.findAll();
		System.out.println("11");
	}
}
