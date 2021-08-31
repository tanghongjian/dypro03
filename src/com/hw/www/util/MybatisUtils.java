package com.hw.www.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	
	static InputStream inputStream = null;
	//获取回话工厂
	static SqlSessionFactory sqlSessionFactory = null;
	
	static {
		try {
			inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//编写一个用于返回sqlSession的方法
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession(true);
	}

}
