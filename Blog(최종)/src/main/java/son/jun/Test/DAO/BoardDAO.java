package son.jun.Test.DAO;
import java.util.List;

import son.jun.Test.bean.BoardBean;



public interface BoardDAO {


	public List<BoardBean> getBoardList() throws Exception;

	public int writeBoard(BoardBean bean);

	public BoardBean getDetailDocument(int id);

	public void viewUpdate(int id);

	public void likeUpdate(BoardBean bean);

	int getLike(int id);

	public void deleteDocument(int id);

	public void updateDocument(BoardBean bean);

}

