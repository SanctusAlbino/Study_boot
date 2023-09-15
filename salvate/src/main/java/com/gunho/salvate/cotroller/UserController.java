package com.gunho.salvate.cotroller;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gunho.salvate.entity.gunho.User;
import com.gunho.salvate.repository.gunho.UserRepository;


@Controller @RequestMapping("/user")
public class UserController {
	@Autowired private UserRepository repository;
	@PersistenceContext EntityManager entityManager;
	
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
	@RequestMapping("/list/insert")
	public String insert(Model model, HttpSession session) {
		model.addAttribute("user", new User());
		return "user/insert";
	}
	
	@RequestMapping("/salvate/user/list")
	public String saveUser(@RequestParam(value = "user_id")String user_id,
			@RequestParam(value = "user_pw")String user_pw,
			@RequestParam(value = "firstname")String firstname,
			@RequestParam(value = "lastname")String lastname,
			@RequestParam(value = "create_ymd")String create_ymd,
			@RequestParam(value = "update_ymd")String update_ymd
	) {
	    // 사용자 입력값을 User 엔티티로 받아와 데이터베이스에 저장
		User user = User.builder()
		        .user_id(user_id)
		        .user_pw(user_pw)
		        .firstname(firstname)
		        .lastname(lastname)
		        .create_ymd(create_ymd)
		        .update_ymd(update_ymd)
		        .build();

	    repository.save(user);

	    // 저장 결과를 보여주는 화면으로 리디렉션
	    return "user/user";
	}
	
}
