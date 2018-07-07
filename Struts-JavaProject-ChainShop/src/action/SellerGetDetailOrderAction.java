package action;

import java.sql.Connection;

import com.opensymphony.xwork2.ActionContext;

import dao.ShopDAO;
import model.Order;

public class SellerGetDetailOrderAction {
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
		String seller_username = (String) ActionContext.getContext().getSession().get("seller_username");
		Connection con = (Connection) ActionContext.getContext().getSession().get("con");
		this.order = shopDAO.getOrderByOrderID(con, order_id);
		return "success";
	}
}
