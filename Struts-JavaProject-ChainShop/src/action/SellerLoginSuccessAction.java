package action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.ShopDAO;
import model.Goods;

public class SellerLoginSuccessAction extends ActionSupport{
	private ArrayList<Goods> goods;
	private String seller_username;
	
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
		Connection con = null;
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		String username = (String) session.get("seller_username");
		this.setSeller_username(username) ;
		try {
			if((con=(Connection) session.get("con"))==null)
			{
				con = shopDAO.ConSQL(con);
				session.put("con", con);
			}
			this.goods = shopDAO.getAllGoods(con, username);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return "success";
	}
}
