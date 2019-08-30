package com.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.digital.entity.UserInfo;
import com.digital.service.UserInfoService;

@RequestMapping("/userinfo")
@Controller
public class UserInfoHandler {

	// ʹ��@Autowiredע��ע��UserInfoServiceImplʵ��
	@Autowired
	UserInfoService userInfoService;

	@RequestMapping("/login")
	public String login(UserInfo ui) {
		List<UserInfo> uiList=userInfoService.login(ui);
		if (uiList.size() > 0) {
			// ��¼�ɹ���ת������index.jsp
			return "index";
		} else {
			// ��¼ʧ�ܣ��ض���login.jsp
			return "redirect:/login.jsp";
		}
	}

}
