package son.jun.Test.service;
import java.util.List;

import son.jun.Test.bean.BoardBean;



public interface BoardService {

	public List<BoardBean> getBoardList() throws Exception;

	public int writeBoard(BoardBean bean);

	public BoardBean getDetailDocument(int id);

	public void viewUpdate(int id);

	public int likeUpdate(BoardBean bean);

	public void deleteDocument(int id);

	public void updateDocument(BoardBean bean);

}
