package com.pharmawizard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pharmawizard.domain.Topic;
import com.pharmawizard.repository.TopicRepository;

@Controller
@RequestMapping(value = "/topic")
public class TopicController {
	

	private final TopicRepository topicRepository;

	@Autowired
	public TopicController(TopicRepository topicRepository) {
		this.topicRepository = topicRepository;
	}
	
	
	@RequestMapping(value = "/")
	public String index(Model model, Pageable pageable) {
		final Page<Topic> topic = topicRepository.findAll(pageable);
		model.addAttribute("topic", topic);
		return "index.html";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Topic createTopic(Topic topic) {
		return topicRepository.save(topic);
	}

}
