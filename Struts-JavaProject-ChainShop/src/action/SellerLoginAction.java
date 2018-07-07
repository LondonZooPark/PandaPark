package action;

import java.sql.Connection;
import java.util.Map;

import com.hxtt.sql.el;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.DAO;
import dao.ShopDAO;

public class SellerLoginAction extends ActionSupport{
	private String seller_username;
	private String seller_password;
	
	public String getSeller_username() {
		return seller_username;
	}

	public void setSeller_username(String seller_username) {
		this.seller_username = seller_username;
	}

	public String getSeller_password() {
		return seller_password;
	}

	public void setSeller_password(String seller_password) {
		this.seller_password = seller_password;
	}

	public String execute() {
		DAO sellerDao = new ShopDAO();
		Connection con = null;
		ActionContext actionContext = ActionContext.getContext();
		try {
			con = sellerDao.ConSQL(con);
			Map session = actionContext.getSession();
			session.put("con", con);
			if(sellerDao.isRegisted(this.seller_username, this.seller_password,con)==true) {
				session.put("seller_username", this.seller_username);
				session.put("seller.password", this.seller_password);
				return "success";
			}else {
				return "login_error";
			}
			
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return "success";
	}
}
