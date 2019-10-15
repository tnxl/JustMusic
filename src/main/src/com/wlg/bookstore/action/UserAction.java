package com.wlg.bookstore.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wlg.bookstore.service.IUserService;
import com.wlg.bookstore.vo.User;

// ��½ ע�� �޸� ɾ�� ����
public class UserAction extends ActionSupport{
	private User user;
	protected IUserService userService;
	//ע��
	public String register(){
		userService.saveUser(user);
		return SUCCESS;
	}
	// ע��
	public String  logout(){
		Map session = ActionContext.getContext().getSession();
		session.remove("user");
		return SUCCESS;
	}
	//Ĭ�Ͼ��ǵ�½��  action ����ص�  �Զ�ִ��execute ������  main()
	public String execute() throws Exception {
		User u =userService.validateUser(user.getUsername(), user.getPassword());
		if(u!=null){
			// ע��   session ���û����浽һ��session ��  map  key value   ��a�� "123"
			Map session = ActionContext.getContext().getSession();
			session.put("user", u);
			return SUCCESS;
		}
		return ERROR;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	
	
}
