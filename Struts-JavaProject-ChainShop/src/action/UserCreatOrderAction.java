package action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDAO;
import freemarker.template.utility.Execute;
import model.Goods;
import model.Order;

public class UserCreatOrderAction extends ActionSupport{
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	public String execute() {
		UserDAO  userDAO = new UserDAO();
		this.order = new Order();
		ActionContext actionContext =ActionContext.getContext();
		Map session = actionContext.getSession();
		Connection con = (Connection) ActionContext.getContext().getSession().get("con");
		String username = (String) ActionContext.getContext().getSession().get("user_username");
		//System.out.println("测试获取"+userDAO.getGoodsFromShoppingCart(con, username).get(0).getGoods_name());
		//System.out.println("测试获取货物"+this.order.getGoods().get(0));
		ArrayList<Goods> goods = new ArrayList<Goods>();
		goods = userDAO.getGoodsFromShoppingCart(con, username);
		this.order.setGoods(goods);
		this.order = userDAO.userCreatOrder(con, username,order);
		double order_totalprce = 0;
		for(int i=0;i<goods.size();i++) {
			order_totalprce += goods.get(i).getGoods_totalPriceAfterDiscount();
		}
		order_totalprce = (double)Math.round(order_totalprce*100)/100 ;
		this.order.setOrder_totalprce(order_totalprce);
		session.put("order_id", order.getOrder_id());
		//this.order.setGoods(userDAO.getGoodsFromShoppingCart(con, username));
		//int order_id = userDAO.userCreatOrder(con, username, goods);
		//this.order.setOrder_id(order_id);
		//this.order.setOrder_name(order_name);
		return "success";
	}
}
