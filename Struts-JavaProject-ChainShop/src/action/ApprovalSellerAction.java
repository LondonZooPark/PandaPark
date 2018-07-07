package action;

import java.sql.Connection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;

import dao.ShopDAO;
import model.Shop;
import model.User;

public class ApprovalSellerAction {
	private String username;
	private User seller;
	private Shop shop;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public User getSeller() {
		return seller;
	}
	public void setSeller(User seller) {
		this.seller = seller;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public String execute() {
		ShopDAO shopDAO = new ShopDAO();
		Connection con = null;
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		System.out.println(username+"444444444444");
		try {
			if((con=(Connection) session.get("con"))==null)
			con = shopDAO.ConSQL(con);
			this.shop = shopDAO.getShopFromDB("seller_checktable", username, con);
			shopDAO.approvalShop(con, shop.getSeller());
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		return "success";
	}
}
