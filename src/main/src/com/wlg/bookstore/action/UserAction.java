package com.wlg.bookstore.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wlg.bookstore.service.IUserService;
import com.wlg.bookstore.vo.User;

// 登陆 注册 修改 删除 查找
public class UserAction extends ActionSupport{
	private User user;
	protected IUserService userService;
	//注册
	public String register(){
		userService.saveUser(user);
		return SUCCESS;
	}
	// 注销
	public String  logout(){
		Map session = ActionContext.getContext().getSession();
		session.remove("user");
		return SUCCESS;
	}
	//默认就是登陆，  action 类的特点  自动执行execute 方法，  main()
	public String execute() throws Exception {
		User u =userService.validateUser(user.getUsername(), user.getPassword());
		if(u!=null){
			// 注销   session 把用户保存到一个session 内  map  key value   “a” "123"
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
