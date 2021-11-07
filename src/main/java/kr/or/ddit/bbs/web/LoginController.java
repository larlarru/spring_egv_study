package kr.or.ddit.bbs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping(value = {"/login.do"})
	public String selectLoginFront() throws Exception {
		
		return "login";
	}
	
}
