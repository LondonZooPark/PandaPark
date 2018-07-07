package model;

public class Goods {
	private int goods_id;
	private String goods_name;
	private String goods_info;
	private int goods_num;
	private double goods_price;
	private String goods_type;
	private double goods_discount;
	private double goods_totalPrice;
	private double goods_totalPriceAfterDiscount;
	private String goods_seller;
	public double getGoods_totalPriceAfterDiscount() {
		return goods_totalPriceAfterDiscount;
	}
	public void setGoods_totalPriceAfterDiscount(double goods_totalPriceAfterDiscount) {
		this.goods_totalPriceAfterDiscount = goods_totalPriceAfterDiscount;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}
	public double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}
	public String getGoods_info() {
		return goods_info;
	}
	public void setGoods_info(String goods_info) {
		this.goods_info = goods_info;
	}
	public String getGoods_type() {
		return goods_type;
	}
	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}
	public double getGoods_totalPrice() {
		return goods_totalPrice;
	}
	public void setGoods_totalPrice(double goods_totalPrice) {
		this.goods_totalPrice = goods_totalPrice;
	}
	public double getGoods_discount() {
		return goods_discount;
	}
	public void setGoods_discount(double goods_discount) {
		this.goods_discount = goods_discount;
	}
	public String getGoods_seller() {
		return goods_seller;
	}
	public void setGoods_seller(String goods_seller) {
		this.goods_seller = goods_seller;
	}

	
}
