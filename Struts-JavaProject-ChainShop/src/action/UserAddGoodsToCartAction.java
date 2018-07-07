package action;

import java.sql.Connection;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.ShopDAO;
import dao.UserDAO;
import model.Goods;

public class UserAddGoodsToCartAction extends ActionSupport{
	private String goods_id;
	private String goods_num;
	private String goods_price;
	private String goods_name;
	private String goods_discount;
	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_num() {
		return goods_num;
	}

	public void setGoods_num(String goods_num) {
		this.goods_num = goods_num;
	}

	public String getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(String goods_price) {
		this.goods_price = goods_price;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	
	public String getGoods_discount() {
		return goods_discount;
	}

	public void setGoods_discount(String goods_discount) {
		this.goods_discount = goods_discount;
	}

	public String execute() { 
		Connection con = (Connection) ActionContext.getContext().getSession().get("con");
		Goods goods =new Goods();
		String username = (String) ActionContext.getContext().getSession().get("user_username");
		String seller = (String) ActionContext.getContext().getSession().get("seller_username");
		System.out.println(this.goods_id);
		System.out.println(this.goods_name);
		System.out.println(this.goods_num);
		System.out.println(this.goods_price);
		System.out.println(this.goods_discount);
		System.out.println("Âô¼Ò"+seller);
		goods.setGoods_id(Integer.parseInt(this.goods_id));
		goods.setGoods_name(this.goods_name);
		goods.setGoods_num(Integer.parseInt(this.goods_num));
		goods.setGoods_price(Double.parseDouble(this.goods_price));
		goods.setGoods_discount(Double.parseDouble(this.goods_discount));
		ShopDAO shopDAO = new ShopDAO();
		UserDAO userDAO = new UserDAO();
		userDAO.addGoodsToShoppingCart(con, goods, username,seller);
		return "success";
	}
}
