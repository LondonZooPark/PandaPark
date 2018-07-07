package action;

import java.sql.Connection;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.ShopDAO;
import model.Goods;

public class UserSelectByKeywordsAction extends ActionSupport{
	private String seller_username;
	private String keywords;
	private int pageNum;
	private ArrayList<Goods> goods ;
	private int totalPage;
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

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
		System.out.println("¹Ø¼ü×Ö6666:"+keywords);
		if(this.keywords==null) {
			this.keywords = (String) ActionContext.getContext().getSession().get("keywords");
			System.out.println("¹Ø¼ü×Ö"+keywords);
		}
		System.err.println("²âÊÔ°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡s");
		System.out.println("¹Ø¼ü×Ö7777:"+keywords);
		totalPage = shopDAO.getGoodsTotalPageByKeywords(con, seller_username,this.keywords);
		System.err.println("×ÜÒ³Êý"+this.totalPage);
		//goods = shopDAO.getGoodsByPageKeywords(con,this.seller_username,pageNum,this.keywords);
		goods = shopDAO.getGoodsByPageKeywords2(con,this.seller_username,pageNum,this.keywords);
		System.err.println("×îºóÒ»¸ö»õºÅÊÇ"+goods.get(goods.size()-1).getGoods_id());
		this.url = "get_goods_by_pageKeywords.action";
		ActionContext.getContext().getSession().put("goods", goods);
		ActionContext.getContext().getSession().put("seller_username", this.seller_username);
		ActionContext.getContext().getSession().put("keywords", this.keywords);
		return "success";
	}
	
}
