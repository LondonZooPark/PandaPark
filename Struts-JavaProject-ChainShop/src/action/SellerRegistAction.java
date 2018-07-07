package action;

import java.sql.Connection;

import com.opensymphony.xwork2.ActionSupport;

import dao.DAO;
import dao.ShopDAO;
import model.Shop;

public class SellerRegistAction extends ActionSupport{
	Shop shop;
	
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String execute() {
		
		ShopDAO sellerDao = new ShopDAO();
		Connection con = null;
		try {
			con = sellerDao.ConSQL(con);
			if(sellerDao.regist(con, shop)) {
			
				return "success";
			}else {
				return "error";
			}
		} catch (InstantiationException | IllegalAccessException e) {
			return "error";
		}
		
		
	}
}
