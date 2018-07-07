package action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.ShopDAO;
import model.BigOrder;
import model.Order;

public class SellerGetOrderAction extends ActionSupport{
	
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
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		String username = (String) session.get("seller_username");
		Connection con = (Connection) session.get("con");
		this.orders = shopDAO.getsingleOrder(con, username);
		this.bigOrder = shopDAO.getBigOrder(orders);
		//this.bigOrders = shopDAO.getBigOrder2(orders);
		return "success";
	}
}
