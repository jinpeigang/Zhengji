package com.jpg.hebei.dao;

import java.util.List;

import com.jpg.hebei.model.Information;
import com.jpg.hebei.model.PageBean;

public interface PageDao {

	/**
	 * 分页查询
	 * @param hql  查询条件
	 * @param offset  开始记录
	 * @param length  一次查询几条记录
	 * @return 查询的记录集合
	 */
	@SuppressWarnings("unchecked")
	public List<Information> queryForPage(final String hql,final int offset,final int length);
	/*public PageBean queryForPage(int pageSize,int currentPage);*/
	
	/**
	 * 查询所有的记录数
	 * @param hql 查询条件
	 * @return 总记录数
	 */
	/*public int getAllRowCount(String hql); */
	public PageBean queryForPage(int pageSize,int currentPage,String hql);
	public List<Information> findAllInformation(String hql);
}
