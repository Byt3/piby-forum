package com.pharmawizard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pharmawizard.domain.Comment;
import com.pharmawizard.domain.Topic;
import com.pharmawizard.domain.UserProfile;
import com.pharmawizard.repository.CommentRepository;
import com.pharmawizard.repository.TopicRepository;
import com.pharmawizard.repository.UserProfileRepository;

@Controller
@RequestMapping(value = "/")
public class IndexController {

	private final TopicRepository topicRepository;
	private final UserProfileRepository userProfileRepository;
	private final CommentRepository commentRepository;

	@Autowired
	public IndexController(TopicRepository topicRepository, UserProfileRepository userProfileRepository, CommentRepository commentRepository) {
		this.topicRepository = topicRepository;
		this.userProfileRepository = userProfileRepository;
		this.commentRepository = commentRepository;
	}

	@RequestMapping(value = "/")
	public String index(Model model, Pageable pageable) {
		final Page<Topic> topic = topicRepository.findAll(pageable);
		final Page<UserProfile> user = userProfileRepository.findAll(pageable);
		final Page<Comment> comment = commentRepository.findAll(pageable);
		model.addAttribute("topic", topic);
		model.addAttribute("user", user);
		model.addAttribute("comment", comment);
		return "index";
	}

}
