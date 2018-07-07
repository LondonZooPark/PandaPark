package action;

import java.sql.Connection;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.ShopDAO;
import model.Goods;

public class SellerManageGoodsAction extends ActionSupport{
	private int goods_id;
	private Goods singlegoods;
	
	public Goods getSinglegoods() {
		return singlegoods;
	}

	public void setSinglegoods(Goods singlegoods) {
		this.singlegoods = singlegoods;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	
	public String execute() {
		//Goods goods = new Goods();
		ShopDAO shopDAO = new ShopDAO();
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		String username = (String) session.get("seller_username");
		Connection con = null;
		try {
			if((con=(Connection) session.get("con"))==null)
			{
				con = shopDAO.ConSQL(con);
				session.put("con", con);
			}
			this.singlegoods = shopDAO.getSingleGoods(con, username,this.goods_id);
			//System.out.println("AAAAAAAAA    "+singlegoods.getGoods_id());
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return "success";
	}
}
