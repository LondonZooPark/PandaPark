package action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.ShopDAO;
import model.Goods;

public class GetGoodsByPageAction extends ActionSupport{
	private int pageNum;
	private String seller_username;
	private ArrayList<Goods> goods ;
	private int totalPage;
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public String getSeller_username() {
		return seller_username;
	}

	public void setSeller_username(String seller_username) {
		this.seller_username = seller_username;
	}

	public ArrayList<Goods> getGoods() {
		return goods;
	}

	public void setGoods(ArrayList<Goods> goods) {
		this.goods = goods;
	}

	public String execute() {
		ShopDAO shopDAO = new ShopDAO();
		Connection con = (Connection) ActionContext.getContext().getSession().get("con");
		System.out.println("NIU BI DE HEN A  "+this.seller_username);
		if(this.seller_username==null) {
			this.seller_username = (String) ActionContext.getContext().getSession().get("seller_username");
			System.out.println(this.seller_username);

		}
		this.totalPage = shopDAO.getGoodsTotalPage(con, seller_username);
		if(pageNum>totalPage) {
			this.pageNum = totalPage;
		}
		if(pageNum < 1) {
			this.pageNum = 1;
		}
		System.err.println("总页数"+this.totalPage);
		goods = shopDAO.getGoodsByPage(con,this.seller_username,this.pageNum);
		System.err.println("最后一个货号是"+goods.get(goods.size()-1).getGoods_id());
		ActionContext.getContext().getSession().put("goods", goods);
		ActionContext.getContext().getSession().put("seller_username", this.seller_username);
		return "success";
	}
	
}
