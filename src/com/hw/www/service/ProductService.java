package com.hw.www.service;

import java.util.List;
import java.util.Map;

import com.hw.www.bean.Hz;
import com.hw.www.bean.Product;
import com.hw.www.bean.Sales;

public interface ProductService {
	// 列表
	List<Product> find(Map<Object, Object> map);

	// 查找产品线下拉框
	List getsel();

	// 添加
	int save(Map<Object, Object> map);

	// 正则校验
	Product getpname(Map<Object, Object> map);

	// 汇总
	List<Hz> gethz();

	// 删除
	int del(Map<Object, Object> map);

	// 回显表单数据
	Product getform(Map<Object, Object> map);

	// 获取销售表数据
	List findAllSales(Map<Object, Object> map);

	// 获取销售表汇总数据
	List<Sales> fingHz(Map<Object, Object> map);

	// 添加月销售量数据
	int saveSales(Map<Object, Object> map);

}
