package com.gunho.salvate.cotroller;

import java.util.Optional;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gunho.salvate.entity.gunho.User;
import com.gunho.salvate.repository.gunho.UserRepository;


@Controller @RequestMapping("/user")
public class UserController {
	@Autowired private UserRepository repository;
	
	@RequestMapping("/info/{user_id}")
	public String info(Model model, @PathVariable String user_id) {
		Optional<User> optional = repository.findById(user_id);
		User vo = optional.isPresent() ? optional.get() : null;
		model.addAttribute("vo", vo);
		return "user/info";
	}
	
	@RequestMapping("/info")
	public String info(String user_id, Model model ) {
		User vo = repository.findById(user_id).orElse(null);
		model.addAttribute("vo", vo);
		return "user/info";
	}
	@RequestMapping("/list")
	public String list(Model model, HttpSession session) {
		model.addAttribute("list", repository.findAll());
		return "user/user";
	}
	
}
