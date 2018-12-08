package com.dome.user.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.dome.user.entity.User;
/**
 * JpaSpecificationExecutor 模糊查询继承接口
 * @author hzhigg
 * 2018年12月6日
 */
@Repository
public interface UserMapper extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User> {

}