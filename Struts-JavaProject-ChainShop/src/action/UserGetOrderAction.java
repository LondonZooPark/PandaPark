package action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import dao.ShopDAO;
import dao.UserDAO;
import model.BigOrder;
import model.Order;

public class UserGetOrderAction {
	private ArrayList<Order>orders;
	private ArrayList<Order>bigOrder;
	private ArrayList<BigOrder>bigOrders;
	
	public ArrayList<BigOrder> getBigOrders() {
		return bigOrders;
	}



	public void setBigOrders(ArrayList<BigOrder> bigOrders) {
		this.bigOrders = bigOrders;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}



	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}



	public ArrayList<Order> getBigOrder() {
		return bigOrder;
	}



	public void setBigOrder(ArrayList<Order> bigOrder) {
		this.bigOrder = bigOrder;
	}



	public String execute() {
		
		ShopDAO shopDAO = new ShopDAO();
		UserDAO userDAO = new UserDAO();
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		String username = (String) session.get("user_username");
		Connection con = (Connection) session.get("con");
		this.orders = userDAO.getsingleOrder(con, username);
		this.bigOrder = userDAO.getBigOrder(orders);
		//this.bigOrders = shopDAO.getBigOrder2(orders);
		return "success";
	}
}
