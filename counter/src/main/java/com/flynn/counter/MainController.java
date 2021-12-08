package com.flynn.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
		}else {
			Integer count = (Integer) session.getAttribute("count");
			session.setAttribute("count", count+1);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String getCounter() {
		return "counter.jsp";
	}
}
