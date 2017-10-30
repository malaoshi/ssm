package com.jsoft.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

/*
 * @Repository，spring框架的注解，告诉spring该类是dao层的类
 * id的名字是daoSupport
 */
@Repository("daoSupport")
public class DaoSupport  {
	//Resource作用，将id是sqlSessionTemplate的对象注入进成员变量sqlSessionTemplate
	/*
	 * 将ApplicationContext.xml配置文件中，id是sqlSessionTemplateABC的对象，注入到该成员变量中
	 */
	@Resource(name = "sqlSessionTemplateABC")
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 保存对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public int save(String str, Object obj) throws Exception {
		return sqlSessionTemplate.insert(str, obj);
	}
	
	
	/**
	 * 修改对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public int update(String str, Object obj) throws Exception {
		return sqlSessionTemplate.update(str, obj);
	}

	
	/**
	 * 删除对象 
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public int delete(String str, Object obj) throws Exception {
		return sqlSessionTemplate.delete(str, obj);
	}
	 
	/**
	 * 查找对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object findOne(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectOne(str, obj);
	}

	/**
	 * 查找对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List findList(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectList(str, obj);
	}
	
}


