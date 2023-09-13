package com.gunho.salvate.cotroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	@RequestMapping("/myinfo")
	public String hello(HttpServletRequest request, HttpServletResponse response) {
	request.setAttribute("name", "홍길동");
	return "member/myinfo";
	}
}
