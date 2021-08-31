package com.hw.www.service.imp;

import java.util.List;
import java.util.Map;

import com.hw.www.bean.Hz;
import com.hw.www.bean.Product;
import com.hw.www.bean.Sales;
import com.hw.www.mapper.ProductMapper;
import com.hw.www.service.ProductService;
import com.hw.www.util.MybatisUtils;

public class ProductServiceImp implements ProductService {
	// 列表
	@Override
	public List<Product> find(Map<Object, Object> map) {
		ProductMapper mapper = MybatisUtils.getSqlSession().getMapper(ProductMapper.class);
		return mapper.find(map);
	}

	// 查找产品线下拉框
	@Override
	public List getsel() {
		ProductMapper mapper = MybatisUtils.getSqlSession().getMapper(ProductMapper.class);
		return mapper.getsel();
	}

	// 添加
	@Override
	public int save(Map<Object, Object> map) {
		ProductMapper mapper = MybatisUtils.getSqlSession().getMapper(ProductMapper.class);
		return mapper.save(map);
	}

	// 正则校验
	@Override
	public Product getpname(Map<Object, Object> map) {
		ProductMapper mapper = MybatisUtils.getSqlSession().getMapper(ProductMapper.class);
		return mapper.getpname(map);
	}

	// 汇总
	@Override
	public List<Hz> gethz() {
		ProductMapper mapper = MybatisUtils.getSqlSession().getMapper(ProductMapper.class);
		return mapper.gethz();
	}

	// 删除
	@Override
	public int del(Map<Object, Object> map) {
		ProductMapper mapper = MybatisUtils.getSqlSession().getMapper(ProductMapper.class);
		return mapper.del(map);
	}

	// 回显表单数据
	@Override
	public Product getform(Map<Object, Object> map) {
		ProductMapper mapper = MybatisUtils.getSqlSession().getMapper(ProductMapper.class);
		return mapper.getform(map);
	}

	// 获取销售表数据
	@Override
	public List findAllSales(Map<Object, Object> map) {
		ProductMapper mapper = MybatisUtils.getSqlSession().getMapper(ProductMapper.class);
		return mapper.findAllSales(map);
	}

	// 获取销售表汇总数据
	@Override
	public List<Sales> fingHz(Map<Object, Object> map) {
		ProductMapper mapper = MybatisUtils.getSqlSession().getMapper(ProductMapper.class);
		return mapper.fingHz(map);
	}

	// 添加月销售量数据
	@Override
	public int saveSales(Map<Object, Object> map) {
		ProductMapper mapper = MybatisUtils.getSqlSession().getMapper(ProductMapper.class);
		return mapper.saveSales(map);
	}

}
