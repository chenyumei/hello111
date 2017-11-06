import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import cn.com.dao.MyBatisUtil;
import cn.com.pojo.User;


public class Test1 {
    private Logger logger=Logger.getLogger(Test1.class);
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		SqlSession sqlSession=null;
		List<User> userList=new ArrayList<User>();
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			userList=sqlSession.selectList("cn.com.dao.UserMapper.getUserList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		for(User user :userList){
			logger.debug("testGetUserList userCode "+user.getUserCode()+" and userName"+user.getUserName());
		}
	}

}
