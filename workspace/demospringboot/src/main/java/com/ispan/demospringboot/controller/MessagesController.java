package com.ispan.demospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ispan.demospringboot.model.Messages;
import com.ispan.demospringboot.service.MessageService;

@Controller
public class MessagesController {

		@Autowired
		private MessageService mService;
		
		@GetMapping("/messages/add")
		public String addMsg(Model model) {
			
			Messages m1 = new Messages();
			
			model.addAttribute("messages", m1);
			
			//新增後清除資料
			Messages lastestMsg = mService.findLastest();
			model.addAttribute("lastestMsg", lastestMsg);
			
			return "messages/addMessagePage"; 
		}
		
		@PostMapping("/messages/post")    //接addMessagesPage的modelAttribute="messages",Model model是為新增後 清除頁面資料
		public String postMsg(@ModelAttribute(name="messages") Messages msg, Model model) {
			
			mService.insert(msg);
			
	        Messages m1 = new Messages();
			
			model.addAttribute("messages", m1);
			
			Messages lastestMsg = mService.findLastest();
			
			model.addAttribute("lastestMsg", lastestMsg);
			
			return "messages/addMessagePage"; 
		}
		
		
}