package action;

import java.sql.Connection;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDAO;
import model.Goods;

public class UserCheckOutAction extends ActionSupport{
	private ArrayList<Goods> goods;

	public ArrayList<Goods> getGoods() {
		return goods;
	}

	public void setGoods(ArrayList<Goods> goods) {
		this.goods = goods;
	}
	
	public String execute() {
		UserDAO userDAO = new UserDAO();
		Connection con = (Connection) ActionContext.getContext().getSession().get("con");
		String username = (String) ActionContext.getContext().getSession().get("user_username");
		String order_id = (String) ActionContext.getContext().getSession().get("order_id");
		this.goods = userDAO.getGoodsFromShoppingCart(con, username);
		userDAO.checkOutShoppingCart(con, username, goods, goods.get(0).getGoods_seller(),order_id);
		return "success";
	}
}
