package son.jun.Test.DAO;

import java.util.HashMap;
import java.util.List;



import javax.inject.Inject;



import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;

import son.jun.Test.bean.BoardBean;



@Repository
public class BoardDAOImpl implements BoardDAO {

	private static final String namespace="son.jun.Test.mappers.testMapper";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public List<BoardBean> getBoardList() throws Exception{
		return sqlSession.selectList(namespace+".getBoardList");

	}

	@Override
	public int writeBoard(BoardBean bean) {
		return sqlSession.insert(namespace+".writeBoard",bean);
	}

	@Override
	public BoardBean getDetailDocument(int id) {
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("id",id);
		return sqlSession.selectOne(namespace+".getDetailDocument", map);
	}

	@Override
	public void viewUpdate(int id) {

		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("id",id);
		sqlSession.update(namespace+".viewUpdate",map);
		
	}

	@Override
	public void likeUpdate(BoardBean bean) {
		
		HashMap<String,Object> map = new HashMap<String, Object>();
		int id = bean.getId();
		map.put("id",id);
		sqlSession.update(namespace+".likeUpdate",map);
		
		
	}
	
	@Override
	public int getLike(int id){
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("id",id);
		return sqlSession.selectOne(namespace+".getLike",map);
	}

	@Override
	public void deleteDocument(int id) {
		
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("id",id);
		sqlSession.delete(namespace+".deleteDocument", map);
		
	}

	@Override
	public void updateDocument(BoardBean bean) {
		System.out.println("dao");
		sqlSession.update(namespace+".updateDocument",bean);
		
	}


}