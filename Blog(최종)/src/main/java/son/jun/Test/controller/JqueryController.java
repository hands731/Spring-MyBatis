package son.jun.Test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import son.jun.Test.bean.BoardBean;
import son.jun.Test.bean.MembersBean;
import son.jun.Test.service.BoardService;
import son.jun.Test.service.UserService;

@Controller
@RequestMapping("jquery/*")
public class JqueryController {
	
	@Autowired
	BoardService board_svc;
	
	@Autowired
	UserService user_svc;
	
	@RequestMapping(value = "jquery/writeBoard", method = RequestMethod.POST)
	@ResponseBody     //json응답해주는 애노테이션
	public int writeBoard(BoardBean bean) {
		
		int result = 0;
		result = board_svc.writeBoard(bean);
		System.out.println(bean);
		return result;
	}
	
	@RequestMapping(value="jquery/login", method=RequestMethod.POST)
	@ResponseBody
	public int login(MembersBean members,HttpSession session) {
		int result = 0; 
		String col = null;
	
		col = "userId";
		MembersBean userIdCheck = user_svc.getUserOne(members.getUserId(),col);
		if(userIdCheck == null) {
			result = 2;
		}else {
		
		if(members.getUserId().equals(userIdCheck.getUserId())) {
			//ID OK
			if(members.getPassword().equals(userIdCheck.getPassword())) {
				//PW OK 
				session.setAttribute("loginUser", userIdCheck);

				result = 3;
			}else {
				result = 2;
			}
			
		}else {
			//ID not OK
			result = 2;
		}
		}
		
		return result;
	}
	

	@RequestMapping(value="jquery/signUp",method = RequestMethod.POST)
	@ResponseBody
	public int signUp(MembersBean members) {
		int result = 0; 
		String col = null;
		
		col = "userId";
		MembersBean userIdCheck = user_svc.getUserOne(members.getUserId(),col);
		if(userIdCheck != null) {
		result = 2; 
		}
		
		col = "nickname";
		MembersBean userNicknameCheck = user_svc.getUserOne(members.getNickname(),col);
		if(userNicknameCheck != null) { result = 3; }	
		
		if(result < 2) {
		result = user_svc.userJoin(members);	
		}
		
		return result;
	}
	
	@RequestMapping(value = "jquery/like",method = RequestMethod.POST)
	@ResponseBody
	public int like(BoardBean bean) {
		System.out.println("controller");
		int result=board_svc.likeUpdate(bean);
		return result;
		
	}
	
	@RequestMapping(value = "jquery/updateDocument", method = RequestMethod.POST)
	@ResponseBody     //json응답해주는 애노테이션
	public void updateDocument(BoardBean bean) {
		System.out.println("controller");		
		board_svc.updateDocument(bean);
		return;
	}
	
	
	
	
}
