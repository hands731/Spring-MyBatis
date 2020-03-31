package son.jun.Test.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import son.jun.Test.bean.BoardBean;
import son.jun.Test.service.BoardService;



@Controller

public class ViewController {

	@Autowired
	BoardService service;

	
	@RequestMapping(value="/board",method = RequestMethod.GET)
	public ModelAndView listBoard() throws Exception {

		List<BoardBean> list;		
		list = service.getBoardList();	
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		return mav;

	}
	
	@RequestMapping(value="/writeBoard",method = RequestMethod.GET)
	public ModelAndView writeBoard() {
		ModelAndView mav = new ModelAndView();
		return mav; 
		}
	
	@RequestMapping(value="/detailDocument", method = RequestMethod.GET)
	public ModelAndView detailDocument(int id) {
		service.viewUpdate(id);
		BoardBean bean = service.getDetailDocument(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("detail",bean);
		return mav;
	}
	
	@RequestMapping(value="/deleteDocument",method = RequestMethod.GET)
	public String deleteDocument(int id) {
		
		service.deleteDocument(id);
		return "redirect:board";
	}
	
	@RequestMapping(value="/updateBoard", method=RequestMethod.GET)
	public ModelAndView updateBoard(int id) {
		BoardBean bean = service.getDetailDocument(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("detail",bean);
		return mav;
	}
	

}