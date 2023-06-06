package com.cssl.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	//为了保证后期SqlSession在各个层级是同一个，确保事务可控
	//1.定义本地线程池
	static ThreadLocal<SqlSession> local=new ThreadLocal<SqlSession>();

	//2.确保会话工厂为单列模式
	static SqlSessionFactory factory=null;
	
	//3.采用静态代码块的方式
	static {
		try {
			//指定读取配置文件
			String configFile="mybatis-config.xml";
			//使用工具类Resources读取上述指定文件
			InputStream in=Resources.getResourceAsStream(configFile);
			//创建工厂构造器对象
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			//使用构造器创建工厂对象
			factory = builder.build(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//4.获取sqlsession的方法
	public static SqlSession createSqlSession() {
		SqlSession sqlSession = local.get();
		if(sqlSession==null) {
			sqlSession=factory.openSession();
			local.set(sqlSession);
		}
		return sqlSession;
	}
	//5.关闭资源的方法
	public static void closeSqlSession() {
		SqlSession sqlSession = local.get();
		if(sqlSession!=null) {
			sqlSession.close();
			local.set(null);
		}
	}
}
