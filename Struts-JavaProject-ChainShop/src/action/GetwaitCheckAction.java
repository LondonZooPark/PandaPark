package action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import dao.ShopDAO;
import model.Shop;

public class GetwaitCheckAction {
	ArrayList<Shop> shops = new ArrayList<Shop>();
	
	public ArrayList<Shop> getShops() {
		return shops;
	}

	public void setShops(ArrayList<Shop> shops) {
		this.shops = shops;
	}

	public String execute() {
		ShopDAO shopDAO = new ShopDAO();
		Connection con = null;
		ActionContext actionContext = ActionContext.getContext();
		
		try {
			Map session = actionContext.getSession();
			if((con=(Connection) session.get("con"))==null) {
			System.out.println("hahahahahah");
			con = shopDAO.ConSQL(con);
			session.put("con", con);
			}
			this.shops = shopDAO.getwaitshops(con);
			System.out.println(shops.get(0).getSeller().getUsername());
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return "success";
	}
}
