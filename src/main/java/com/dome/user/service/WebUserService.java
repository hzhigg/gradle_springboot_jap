package com.dome.user.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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

import com.dome.user.entity.WebUser;
import com.dome.user.mapper.WebUserMapper;
import com.dome.util.SortUtil;

@Service("webUserService")
public class WebUserService {

	@Autowired
	private WebUserMapper webUserMapper;
	
	@Autowired
	private EntityManager entityManager;
	
	
	/**
	 * @Query 注解原生sql查询
	 * @param userName
	 * @return
	 */
	public List<WebUser> findByKeyNameLimit(String userName){
		return webUserMapper.findByKeyNameLimit(userName);
	}
	
	/**
	 * 原生sql
	 * @param userName
	 * @return
	 */
	public List<WebUser> nativeQuery(String userName){
		String sql = "select * from webuser where user_name=:userName";
		Query query = entityManager.createNativeQuery(sql, WebUser.class);
		query.setParameter("userName", userName);
		//query 有executeUpdate、getFirstResult等方法，可以根据sql调用
		List<WebUser> result = query.getResultList();
		return result;

	}

	public WebUser get(Long id) {
		return webUserMapper.findById(id).get();
	}
	
	public List<WebUser> findAll(){
		return webUserMapper.findAll(SortUtil.baseSort());
	}
	
	public WebUser save(WebUser user){
		WebUser u=webUserMapper.save(user);
		return u;
	}
	/**
	 * 简单分页查询
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<WebUser> pageUser(int page,int size){
		Pageable pageable = new PageRequest(page, size,SortUtil.baseSort());
		return webUserMapper.findAll(pageable);
	}
	
	/**
	 * 分页带参数查询
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<WebUser> pageUserParam(int page,int size,WebUser user){
		Pageable pageable = new PageRequest(page, size,SortUtil.baseSort());
		
		Page<WebUser> result = webUserMapper.findAll(new Specification<WebUser>() {

			@Override
			public Predicate toPredicate(Root<WebUser> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
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