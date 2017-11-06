import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.com.dao.MyBatisUtil;
import cn.com.dao.UserMapper;
import cn.com.pojo.User;

public class TestUserList {
	private Logger logger = Logger.getLogger(Test1.class);

	@Test
	public void testUserLi() {
		SqlSession sqlSession = null;
		List<User> userList = new ArrayList<User>();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			userList = sqlSession.getMapper(UserMapper.class).getUserList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		for (User user : userList) {
			logger.debug("testGetUserList userCode " + user.getUserCode()
					+ " and userName" + user.getUserName());
		}
	}

}
