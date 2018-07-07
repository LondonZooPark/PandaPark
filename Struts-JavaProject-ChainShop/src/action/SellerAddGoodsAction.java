package action;

import java.sql.Connection;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.ShopDAO;
import model.Goods;

public class SellerAddGoodsAction extends ActionSupport{
	private String goods_name;
	private String goods_info;
	private String goods_num;
	private String goods_price;
	private String goods_type;
	private String goods_discount;
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_info() {
		return goods_info;
	}
	public void setGoods_info(String goods_info) {
		this.goods_info = goods_info;
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
	public String getGoods_type() {
		return goods_type;
	}
	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}
	
	public String getGoods_discount() {
		return goods_discount;
	}
	public void setGoods_discount(String goods_discount) {
		this.goods_discount = goods_discount;
	}
	public String execute() {
		String username = (String) ActionContext.getContext().getSession().get("seller_username");
		Connection con = (Connection) ActionContext.getContext().getSession().get("con");
		Goods goods = new Goods();
		goods.setGoods_name(this.goods_name);
		goods.setGoods_info(this.goods_info);
		goods.setGoods_num(Integer.parseInt(this.goods_num));
		goods.setGoods_price(Double.parseDouble(this.goods_price));
		goods.setGoods_type(this.goods_type);
		goods.setGoods_discount(Double.parseDouble(this.goods_discount));
		ShopDAO shopDAO = new ShopDAO();
		shopDAO.addNewGoos(con, goods, username);
		return "success";
	}
}
