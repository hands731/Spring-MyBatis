package son.jun.Test.service;

import son.jun.Test.bean.MembersBean;

public interface UserService {
	MembersBean getUserOne(String common, String col);
	
	int userJoin(MembersBean members);
}
