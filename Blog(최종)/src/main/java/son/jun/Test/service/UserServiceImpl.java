package son.jun.Test.service;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import son.jun.Test.DAO.UserDAO;
import son.jun.Test.bean.MembersBean;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	UserDAO userDAO;
	
	@Override
	public MembersBean getUserOne(String common, String col) {
		return userDAO.getUserOne(common,col);
	}

	@Override
	public int userJoin(MembersBean members) {
		// TODO Auto-generated method stub
		return userDAO.userJoin(members);
	}

}
