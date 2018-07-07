package action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.ShopDAO;
import model.Goods;

public class UserIntoShopAction extends ActionSupport{
	private String seller_username;
	private ArrayList<Goods> goods ;
	private String imagePath;
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public ArrayList<Goods> getGoods() {
		return goods;
	}

	public void setGoods(ArrayList<Goods> goods) {
		this.goods = goods;
	}

	public String getSeller_username() {
		return seller_username;
	}



	public void setSeller_username(String seller_username) {
		this.seller_username = seller_username;
	}

	

	public String execute() {
		ShopDAO shopDAO = new ShopDAO();
		Connection con = (Connection) ActionContext.getContext().getSession().get("con");
		
		System.out.println("NIU BI DE HEN A  "+this.seller_username);
		if(this.seller_username==null) {
			this.seller_username = (String) ActionContext.getContext().getSession().get("seller_username");
			System.out.println(this.seller_username);

		}
		try {
			String realpath = ServletActionContext.getServletContext().getRealPath("/WebContent/image/"+
					this.seller_username+"_shop/");
			//realpath = realpath.replaceAll(".metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\", "");
			String projectPath = getClass().getResource("/").getFile().toString();
			projectPath = realpath.replace(".metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\", "");
			this.imagePath = projectPath;
			System.out.println(this.imagePath);
			goods = shopDAO.getAllGoods(con, this.seller_username);
			ActionContext.getContext().getSession().put("goods", goods);
			ActionContext.getContext().getSession().put("seller_username", this.seller_username);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return "success";
	}
}
