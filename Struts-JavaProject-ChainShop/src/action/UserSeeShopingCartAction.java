package action;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDAO;
import model.Goods;

public class UserSeeShopingCartAction extends ActionSupport{
	private ArrayList<Goods> goods;
	private double orderTotalPrice;
	public ArrayList<Goods> getGoods() {
		return goods;
	}

	public void setGoods(ArrayList<Goods> goods) {
		this.goods = goods;
	}
	
	public double getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public String execute() {
		UserDAO userDAO = new UserDAO();
		Connection con = (Connection) ActionContext.getContext().getSession().get("con");
		String username = (String) ActionContext.getContext().getSession().get("user_username");
		goods = userDAO.getGoodsFromShoppingCart(con, username);
		for(int i=0;i<goods.size();i++) {
			this.orderTotalPrice += goods.get(i).getGoods_totalPriceAfterDiscount();
		}
		
		this.orderTotalPrice = (double)Math.round(this.orderTotalPrice*100)/100 ;
		return "success";
	}
}
