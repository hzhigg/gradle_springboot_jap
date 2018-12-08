package com.dome.user.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.dome.user.entity.User;
import com.dome.user.mapper.UserMapper;
import com.dome.util.SortUtil;

@Service("userService")
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public User get(Integer id) {
		return userMapper.getOne(id);
	}
	
	public List<User> findAll(){
		return userMapper.findAll(SortUtil.baseSort());
	}
	
	public User save(User user){
		User u=userMapper.save(user);
		return u;
	}
	/**
	 * 简单分页查询
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<User> pageUser(int page,int size){
		Pageable pageable = new PageRequest(page, size,SortUtil.baseSort());
		return userMapper.findAll(pageable);
	}
	
	/**
	 * 分页带参数查询
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<User> pageUserParam(int page,int size,User user){
		Pageable pageable = new PageRequest(page, size,SortUtil.baseSort());
		
		Page<User> result = userMapper.findAll(new Specification<User>() {

			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				Predicate predicate=criteriaBuilder.conjunction();
				if(!ObjectUtils.isEmpty(user)){
					if(StringUtils.isNoneBlank(user.getUserName())){
						predicate.getExpressions().add(criteriaBuilder.like(root.get("userName"), "%"+user.getUserName()+"%"));
					}
				}
				return predicate;
			}
		}, pageable);
		
		return result;
	}
}