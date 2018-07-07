package model;

import java.util.ArrayList;

public class Order {
	private String order_id;
	private String order_name;
	private int order_goods_stock;
	private double order_goods_singleprice;
	private String order_seller_id;
	private String order_buyer_id;
	private double order_totalprce;
	private ArrayList<Goods> goods;
	private Goods order_singlegoods;
	private String order_info;
	
	
	public Goods getOrder_singlegoods() {
		return order_singlegoods;
	}
	public void setOrder_singlegoods(Goods order_singlegoods) {
		this.order_singlegoods = order_singlegoods;
	}
	public ArrayList<Goods> getGoods() {
		return goods;
	}
	public void setGoods(ArrayList<Goods> goods) {
		this.goods = goods;
	}
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public int getOrder_goods_stock() {
		return order_goods_stock;
	}
	public void setOrder_goods_stock(int order_goods_stock) {
		this.order_goods_stock = order_goods_stock;
	}
	public double getOrder_goods_singleprice() {
		return order_goods_singleprice;
	}
	public void setOrder_goods_singleprice(double order_goods_singleprice) {
		this.order_goods_singleprice = order_goods_singleprice;
	}
	public String getOrder_seller_id() {
		return order_seller_id;
	}
	public void setOrder_seller_id(String order_seller_id) {
		this.order_seller_id = order_seller_id;
	}
	public String getOrder_buyer_id() {
		return order_buyer_id;
	}
	public void setOrder_buyer_id(String order_buyer_id) {
		this.order_buyer_id = order_buyer_id;
	}
	public double getOrder_totalprce() {
		return order_totalprce;
	}
	public void setOrder_totalprce(double order_totalprce) {
		this.order_totalprce = order_totalprce;
	}
	public String getOrder_info() {
		return order_info;
	}
	public void setOrder_info(String order_info) {
		this.order_info = order_info;
	}
	
	
	
}
