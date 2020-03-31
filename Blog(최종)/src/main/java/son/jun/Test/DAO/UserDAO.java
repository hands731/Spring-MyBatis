package son.jun.Test.DAO;

import son.jun.Test.bean.MembersBean;

public interface UserDAO {

	MembersBean getUserOne(String common, String col);
	
	int userJoin(MembersBean members);
}
