package action;

import java.sql.Connection;

import com.opensymphony.xwork2.ActionContext;

import dao.ShopDAO;
import dao.UserDAO;
import model.Order;

public class UserGetDetailOrderAction {
	private String order_id;

	private Order order;
	
	
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String execute() {
		ShopDAO shopDAO = new ShopDAO();
		UserDAO userDAO = new UserDAO();
		String user_username = (String) ActionContext.getContext().getSession().get("user_username");
		Connection con = (Connection) ActionContext.getContext().getSession().get("con");
		this.order = shopDAO.getOrderByOrderID(con, order_id);
		return "success";
	}
}
