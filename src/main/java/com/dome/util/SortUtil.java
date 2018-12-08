package com.dome.util;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

/**
 * 排序工具类
 * @author hzhigg
 * 2018年12月6日
 */
public class SortUtil {
	
	/**
	 * 默认排序字段
	 */
	public static final String DEFAULT_FIELD="id";
	public static final String DESC="DESC";
	public static final String ASC="ASC";
	
	public static Sort baseSort(){
		return baseSort(Direction.DESC.name(),DEFAULT_FIELD);
	}

	/**
	 * 
	 * @param orderBy 排序方式
	 * @param orderField 排序字段
	 * @return
	 */
	public static Sort baseSort(String orderBy,String orderField){
		Sort sort=new Sort(Direction.fromString(orderBy), orderField);
		return sort;
		
	}
}
