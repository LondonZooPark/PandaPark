package action;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Map;
import java.util.Random;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.DAO;
import dao.ShopDAO;
import dao.UserDAO;

public class User_LoginAction extends ActionSupport{
	private String user_username;
	private String user_password;
	private String error_message;
	
	public String getError_message() {
		return error_message;
	}
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	public String getUser_username() {
		return user_username;
	}
	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String execute() {
		this.error_message = null;
		DAO userDao = new UserDAO();
		Connection con = null;
		ActionContext actionContext = ActionContext.getContext();
		try {
			con = userDao.ConSQL(con);
			Map session = actionContext.getSession();
			session.put("con", con);
			if(userDao.isRegisted(this.user_username, this.user_password,con)==true) {
				session.put("user_username", this.user_username);
				session.put("user_password", this.user_password);
				return "success";
			}else {
				this.error_message = "账号或密码错误";
				return "login_error";
			}
			
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return "login_error";
	}
}
