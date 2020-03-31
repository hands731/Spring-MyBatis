package son.jun.Test.service;
import java.util.List;



import javax.inject.Inject;



import org.springframework.stereotype.Service;



import son.jun.Test.DAO.BoardDAO;
import son.jun.Test.bean.BoardBean;


@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;

	@Override
	public List<BoardBean> getBoardList() throws Exception {
		// TODO Auto-generated method stub
		return dao.getBoardList();
	}

	@Override
	public int writeBoard(BoardBean bean) {
		// TODO Auto-generated method stub
		return dao.writeBoard(bean);
	}

	@Override
	public BoardBean getDetailDocument(int id) {
		// TODO Auto-generated method stub
		return dao.getDetailDocument(id);
	}

	@Override
	public void viewUpdate(int id) {
		// TODO Auto-generated method stub
		dao.viewUpdate(id);
	}

	

	@Override
	public int likeUpdate(BoardBean bean) {
		dao.likeUpdate(bean);
		int result = dao.getLike(bean.getId());
		return result;
		
	}

	@Override
	public void deleteDocument(int id) {

		dao.deleteDocument(id);
		
	}

	@Override
	public void updateDocument(BoardBean bean) {
		dao.updateDocument(bean);
		
	}

	

}