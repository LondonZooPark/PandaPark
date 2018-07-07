package action;

import java.sql.Connection;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.ShopDAO;
import dao.UserDAO;
import model.Shop;
import model.User;

public class UserRegistAction extends ActionSupport{
	User user;
	
	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public String execute() {
		
		UserDAO  userDAO = new UserDAO();
		Connection con = null;
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		try {
			con = userDAO.ConSQL(con);
			if(userDAO.registUser(con, user)) {
				session.put("con", con);
				session.put("user_username", this.user.getUsername());
				session.put("user_password", this.user.getPassword());
				return "success";
			}else {
				return "error";
			}
		} catch (InstantiationException | IllegalAccessException e) {
			return "error";
		}
		
		
	}
}
