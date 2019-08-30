package com.digital.interceptor;
import java.util.Map;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.digital.entity.UserInfo;
import com.opensymphony.xwork2.Action;


public class AuthorizationInterceptor extends AbstractInterceptor {
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//取得session,获取用户会话信息
		Map session=invocation.getInvocationContext().getSession();
		UserInfo userInfo= (UserInfo)session.get("CURRENT_USER");
		if(session==null) {
			return "login";
		}else {
			if (userInfo==null) {
				//返回‘login’字符串，终止执行，返回登录页面
				return Action.LOGIN; //Action接口中的LOGIN常量
				} else {
				//用户登录， 放行，继续执行剩余的拦截器和Action
					return invocation.invoke();
				}
		}
	}
}