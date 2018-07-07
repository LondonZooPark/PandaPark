package action;

import java.sql.Connection;

import com.opensymphony.xwork2.ActionContext;

import dao.ShopDAO;
import dao.UserDAO;

public class UserRcvGoodsAction {
	private String order_id;

	
	
	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String execute() {
		UserDAO userDAO = new UserDAO();
		String user_username = (String) ActionContext.getContext().getSession().get("user_username");
		Connection con = (Connection) ActionContext.getContext().getSession().get("con");
		return userDAO.rcvGoods(con, user_username, order_id)?"success":"error";
	}
}
