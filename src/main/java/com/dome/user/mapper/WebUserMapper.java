package com.dome.user.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dome.user.entity.WebUser;
/**
 * JpaSpecificationExecutor 模糊查询继承接口
 * @author hzhigg
 * 2018年12月6日
 */
@Repository
public interface WebUserMapper extends JpaRepository<WebUser, Long>,JpaSpecificationExecutor<WebUser> {

	/**
	 * @Query 注解原生sql查询
	 * @param userName
	 * @return
	 */
	@Query(value="select * from webuser where user_name like CONCAT('%',:userName,'%')",nativeQuery=true)
	public List<WebUser> findByKeyNameLimit(@Param("userName") String userName);
}