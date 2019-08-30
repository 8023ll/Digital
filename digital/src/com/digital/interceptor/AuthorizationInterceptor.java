package com.digital.interceptor;
import java.util.Map;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.digital.entity.UserInfo;
import com.opensymphony.xwork2.Action;


public class AuthorizationInterceptor extends AbstractInterceptor {
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//ȡ��session,��ȡ�û��Ự��Ϣ
		Map session=invocation.getInvocationContext().getSession();
		UserInfo userInfo= (UserInfo)session.get("CURRENT_USER");
		if(session==null) {
			return "login";
		}else {
			if (userInfo==null) {
				//���ء�login���ַ�������ִֹ�У����ص�¼ҳ��
				return Action.LOGIN; //Action�ӿ��е�LOGIN����
				} else {
				//�û���¼�� ���У�����ִ��ʣ�����������Action
					return invocation.invoke();
				}
		}
	}
}