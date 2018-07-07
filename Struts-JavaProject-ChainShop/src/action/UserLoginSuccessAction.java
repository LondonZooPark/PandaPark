package action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import dao.ShopDAO;
import dao.UserDAO;
import model.Goods;
import model.Shop;
import model.User;

public class UserLoginSuccessAction {
private ArrayList<Shop> shops;
	
	public ArrayList<Shop> getShops() {
	return shops;
}


public void setShops(ArrayList<Shop> shops) {
	this.shops = shops;
}


	public String execute() {
		UserDAO userDAO = new UserDAO();
		User user = new User();
		Connection con = null;
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		String username = (String) session.get("user_username");
		try {
			if((con=(Connection) session.get("con"))==null)
			{
				con = userDAO.ConSQL(con);
				session.put("con", con);
			}
			user = userDAO.getUserinfo(con, username);
			this.shops = userDAO.getShopByLocation(con, user);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return "success";
	}
}
