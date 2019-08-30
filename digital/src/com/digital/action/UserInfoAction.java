package com.digital.action;

import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import com.digital.entity.*;
import com.digital.service.UserInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoAction extends ActionSupport implements SessionAware{

	UserInfo ui;

	public UserInfo getUi() {
		return ui;
	}

	public void setUi(UserInfo ui) {
		this.ui = ui;
	}

	UserInfoService userInfoService;

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	Map<String,Object> session;
	private Object UserInfo;
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	 
	public String doLogin() throws Exception {
		List<UserInfo> uiList = userInfoService.login(ui);
		if (uiList.size() > 0) {
			session.put("CURRENT_USER", uiList.get(0));
			// ��¼�ɹ���ת������index.jsp
			return "index";
		} else {
			// ��¼ʧ�ܣ��ض���login.jsp
			return "login";
		}

	}
	public String logOut() {
		UserInfo userInfo= (UserInfo)session.get("CURRENT_USER");
		if(userInfo!=null) {
			session.remove("CURRENT_USER");
		}
		return "index";
		
	}

	

}
