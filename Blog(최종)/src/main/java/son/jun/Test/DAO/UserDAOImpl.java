package son.jun.Test.DAO;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import son.jun.Test.bean.MembersBean;

@Repository
public class UserDAOImpl implements UserDAO {
	private static final String namespace="son.jun.Test.mappers.userMapper";
	
	@Inject
	public SqlSession sqlSession;

	public MembersBean getUserOne(String common, String col) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		if(col.equals("userId")) {
			map.put("userId",common);
		}else if(col.equals("nickname")) {
			map.put("nickname",common);
		}
		return sqlSession.selectOne(namespace+".getUserOne",map);
	}

	@Override
	public int userJoin(MembersBean members) {

		return sqlSession.insert("userJoin",members);
	}

}
