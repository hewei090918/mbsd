package com.mybatis.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			//通过配置文件初始化sqlSessionFactory
			reader = Resources.getResourceAsReader("Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public void getUserByID(int userID) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			User user = userOperation.selectUserByID(userID);
			if (user != null) {
				System.out.println("用户ID：" + user.getId());
				System.out.println("用户名：" + user.getUserName());
				System.out.println("用户地址：" + user.getUserAddress());
				System.out.println("****************************");
			}

		} finally {
			session.close();
		}
	}

	public void getUserList(String userName) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			List<User> users = userOperation.selectUsersByName(userName);
			for (User user : users) {
				System.out.println("用户ID：" + user.getId());
				System.out.println("用户名：" + user.getUserName());
				System.out.println("用户地址：" + user.getUserAddress());
				System.out.println("****************************");
			}

		} finally {
			session.close();
		}
	}

	/**
	 * 增加后要commit
	 */
	public void addUser() {
		User user = new User();
		user.setUserAddress("place");
		user.setUserName("test_add");
		user.setUserAge(30);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			userOperation.addUser(user);
			session.commit();
			System.out.println("新增用户ID：" + user.getId());
		} finally {
			session.close();
		}
	}

	/**
	 * 修改后要commit
	 */
	public void updateUser() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			User user = userOperation.selectUserByID(1);
			if (user != null) {
				user.setUserAddress("Tokyo");
				userOperation.updateUser(user);
				session.commit();
				System.out.println("更新用户信息成功");
			}
			
		} finally {
			session.close();
		}
	}

	/**
	 * 删除后要commit.
	 * 
	 * @param id
	 */
	public void deleteUser(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			userOperation.deleteUser(id);
			session.commit();
			System.out.println("删除用户成功");
		} finally {
			session.close();
		}
	}

	public void getUserArticles(int userid) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IArticleOperation articleOperation = session.getMapper(IArticleOperation.class);
			List<Article> articles = articleOperation.getUserArticles(userid);
			for (Article article : articles) {
				System.out.println(article.getTitle());
				System.out.println(article.getContent());
				System.out.println("用户名：" + article.getUser().getUserName());
				System.out.println("用户地址：" + article.getUser().getUserAddress());
				System.out.println("****************************");
			}
		} finally {
			session.close();
		}
	}

	public void getBlogArticles(int blogid) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IBlogOperation blogOperation = session
					.getMapper(IBlogOperation.class);
			Blog blog = blogOperation.getBlogByID(blogid);
			System.out.println("博客专栏>" + blog.getTitle() + ":");
			List<Article> articles = blog.getArticles();
			for (Article article : articles) {
				System.out.println(article.getTitle());
				System.out.println(article.getContent());
				System.out.println("用户名：" + article.getUser().getUserName());
				System.out.println("用户地址：" + article.getUser().getUserAddress());
				System.out.println("****************************");
			}
		} finally {
			session.close();
		}
	}

	public static void main(String[] args) {
		try {
			Test test = new Test();
			test.getUserByID(2);
			//test.getUserList("test");
			//test.addUser();
			//test.updateUser();
			//test.deleteUser(6);

			//test.getUserArticles(2);

			//test.getBlogArticles(4);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
