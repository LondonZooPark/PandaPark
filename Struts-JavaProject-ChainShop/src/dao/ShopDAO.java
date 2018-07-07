package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hxtt.b.bo;
import com.sun.org.apache.xpath.internal.operations.Or;

import model.Address;
import model.BigOrder;
import model.Goods;
import model.Order;
import model.Shop;
import model.User;

public class ShopDAO implements DAO{

	@Override
	public boolean isRegisted(String inputAccount, String inputPassword,Connection con)  {//
		try {
		if(con!=null) {
			String Sqlsetence = "select * from seller_infotable where seller_username = '"+inputAccount+"' and seller_password = '"+inputPassword+"' ";
			System.out.println(Sqlsetence);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(Sqlsetence);
			if(rs.next()) {
				return true;
			}
		}
		else {
			System.out.println("Link database failed");
			return false;
		}
		}catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public Connection ConSQL(Connection con) throws InstantiationException, IllegalAccessException {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL数据库引擎
        String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Chainshop";// 数据源
        
        try {
           Class.forName(JDriver).newInstance();
        } catch (ClassNotFoundException e) {
            // e.printStackTrace();
            System.out.println("加载数据库引擎失败");
            return con=null;
        }
        System.out.println("数据库驱动成功");
        //开始连接库
        try {
            String user = "sa";
            String password = "123";
            con = DriverManager.getConnection(connectDB, user, password);// 连接数据库对象
            System.out.println("连接数据库成功");
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接错误");
            return con=null;
        }
	}
	
	public boolean regist(Connection con,Shop shop) {
		String SQLsetence = "INSERT INTO seller_checktable(seller_username, seller_password, seller_nickname,seller_realname,seller_realidnum,"
				+ "seller_city,seller_county,seller_street,seller_building,seller_phonenum) VALUES";
		String InsertSQLsetence = SQLsetence+"("+
				"'"+shop.getSeller().getUsername()+"',"+
				"'"+shop.getSeller().getPassword()+"',"+
				"'"+shop.getSeller().getNickname()+"',"+
				"'"+shop.getSeller().getRealname()+"',"+
				"'"+shop.getSeller().getIdnum()+"',"+
				"'"+shop.getSeller().getAddress().getCity()+"',"+
				"'"+shop.getSeller().getAddress().getCounty()+"',"+
				"'"+shop.getSeller().getAddress().getStreet()+"',"+
				"'"+shop.getSeller().getAddress().getBuilding()+"',"+
				"'"+shop.getSeller().getPhone_number()+"')";
				
		System.out.println(InsertSQLsetence);
		try {
            Statement stmt = con.createStatement();// 创建SQL命令对象
            stmt.executeUpdate(InsertSQLsetence);
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库表连接错误");
            return false;
        }
        //return true;
	}
	public ArrayList<Goods> getAllGoods(Connection con,String username) throws SQLException{
		ArrayList<Goods> goods = new ArrayList<Goods>();
		Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery("select * from "+ username+"_shop ");
    	while(rs.next()) {
    		Goods singlegoods = new Goods();
    		//shop.setSeller(new User());
    		singlegoods.setGoods_id(rs.getInt("goods_no"));
    		singlegoods.setGoods_name(rs.getString("goods_name"));
    		singlegoods.setGoods_info(rs.getString("goods_info"));
    		singlegoods.setGoods_price(rs.getDouble("goods_price"));
    		singlegoods.setGoods_num(rs.getInt("goods_stock"));
    		singlegoods.setGoods_type(rs.getString("goods_type"));
    		singlegoods.setGoods_discount(rs.getDouble("goods_discount"));
    		goods.add(singlegoods);
    		//System.out.println(shops.get(shops.size()-1).getSeller().getUsername());
    	}
		return goods;
		
	}
    public ArrayList<Shop> getwaitshops(Connection con) throws SQLException {
    	ArrayList<Shop> shops = new ArrayList<>();
    	Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery("select * from seller_checktable where seller_adminstate = 0");
    	while(rs.next()) {
    		Shop shop = new Shop();
    		shop.setSeller(new User());
    		shop.getSeller().setAddress(new Address());
    		shop.getSeller().setUsername(rs.getString("seller_username"));
    		shop.getSeller().setPassword(rs.getString("seller_password"));
    		shop.getSeller().setNickname(rs.getString("seller_nickname"));
    		shop.getSeller().setRealname(rs.getString("seller_realname"));
    		shop.getSeller().setIdnum(rs.getString("seller_realidnum"));
    		shop.getSeller().getAddress().setCity(rs.getString("seller_city"));
    		shop.getSeller().getAddress().setCounty(rs.getString("seller_county"));
    		shop.getSeller().getAddress().setStreet(rs.getString("seller_street"));
    		shop.getSeller().getAddress().setBuilding(rs.getString("seller_building"));
    		shops.add(shop);
    		System.out.println(shops.get(shops.size()-1).getSeller().getUsername());
    	}
    	return shops;
    }
    public Shop getShopFromDB(String tableName,String username,Connection con) {
    	Shop shop = new Shop();
    	shop.setSeller(new User());
    	shop.getSeller().setAddress(new Address());
    	String SQLsetence = "select * from "+tableName+" where seller_username = '"+username+"'";
    	System.out.println(SQLsetence);
    	try {
            Statement stmt = con.createStatement();// 创建SQL命令对象
            //stmt.executeUpdate(InsertSQLsetence);
            ResultSet rs = stmt.executeQuery(SQLsetence);
            while(rs.next()) {
            	
            	shop.getSeller().setUsername(rs.getString("seller_username"));
        		shop.getSeller().setPassword(rs.getString("seller_password"));
        		shop.getSeller().setNickname(rs.getString("seller_nickname"));
        		shop.getSeller().setRealname(rs.getString("seller_realname"));
        		shop.getSeller().setIdnum(rs.getString("seller_realidnum"));
        		shop.getSeller().getAddress().setCity(rs.getString("seller_city"));
        		shop.getSeller().getAddress().setCounty(rs.getString("seller_county"));
        		shop.getSeller().getAddress().setStreet(rs.getString("seller_street"));
        		shop.getSeller().getAddress().setBuilding(rs.getString("seller_building"));
        		shop.getSeller().setPhone_number(rs.getString("seller_phonenum"));
            }
            return shop;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库表连接错误");
            //return false;
        }
		return null;
    	
    }
    public boolean approvalShop(Connection con,User seller) {
    	String SQLsetence = "INSERT INTO seller_infotable(seller_username,seller_password,seller_nickname,seller_realname,seller_realidnum,"
    			+ "seller_city,seller_county,seller_street,seller_building,seller_phonenum) VALUES";
		String InsertSQLsetence = SQLsetence+"("+
				"'"+seller.getUsername()+"',"+
				"'"+seller.getPassword()+"',"+
				"'"+seller.getNickname()+"',"+
				"'"+seller.getRealname()+"',"+
				"'"+seller.getIdnum()+"',"+
				"'"+seller.getAddress().getCity()+"',"+
				"'"+seller.getAddress().getCounty()+"',"+
				"'"+seller.getAddress().getStreet()+"',"+
				"'"+seller.getAddress().getBuilding()+"',"+
				"'"+seller.getPhone_number()+"')";
		/*
	[goods_no] [int] IDENTITY(1,1) NOT NULL,
	[goods_name] [varchar](50) NULL,
	[goods_info] [varchar](50) NULL,
	[goods_price] [float] NULL,
	[goods_stock] [int] NULL,
	[goods_type] [varchar](50) NULL
		 */
    	String Sqlsetence = "Update seller_checktable set seller_adminstate = 1 where seller_username = '" + seller.getUsername()+"'";
		String SelCreateTable = "CREATE TABLE " +seller.getUsername()+"_shop ("
				+"[goods_no] [int] IDENTITY(1,1) NOT NULL,"
				+"[goods_name] [varchar](50) NULL,"
				+"[goods_info] [varchar](50) NULL,"
				+"[goods_price] [float] NULL,"
				+"[goods_stock] [int] NULL,"
				+"[goods_type] [varchar](50) NULL,"
				+"[goods_discount] [float] NOT NULL)";
		//String SqlinsertToTable = "Insert into seller_infotable(seller_username,seller_password,_seller_nickname,seller_realname,seller_realidnum,seller_location)"
			//	+"values("+seller.getUsername()+seller.getPassword()+seller.getNickname()+seller.getRealname()+seller.getIdnum()+seller.getLoaction()+")";
		//System.out.println(InsertSQLsetence);
		try {
            Statement stmt = con.createStatement();// 创建SQL命令对象
            //stmt.executeUpdate(InsertSQLsetence);
            stmt.executeUpdate(Sqlsetence);
            stmt.executeUpdate(InsertSQLsetence);
            stmt.executeUpdate(SelCreateTable);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库表连接错误");
            return false;
        }
        //return true;
    	//return true;
    }

	@Override
	public boolean isRegisted(String inputAccount, String inputPassword) {
		// TODO 自动生成的方法存根
		return false;
	}

	public Goods getSingleGoods(Connection con, String username,int goods_id) throws SQLException {
		Goods singlegoods = new Goods();
		Statement stmt = con.createStatement();
    	ResultSet rs;
		rs = stmt.executeQuery("select * from "+ username+"_shop where goods_no = "+goods_id);
    	while(rs.next()) {
    		
    		//shop.setSeller(new User());
    		singlegoods.setGoods_id(rs.getInt("goods_no"));
    		singlegoods.setGoods_name(rs.getString("goods_name"));
    		singlegoods.setGoods_info(rs.getString("goods_info"));
    		singlegoods.setGoods_price(rs.getDouble("goods_price"));
    		singlegoods.setGoods_num(rs.getInt("goods_stock"));
    		singlegoods.setGoods_type(rs.getString("goods_type"));
    		singlegoods.setGoods_discount(rs.getDouble("goods_discount"));
    		singlegoods.setGoods_totalPriceAfterDiscount(rs.getDouble("goods_price")-(rs.getDouble("goods_price")*rs.getDouble("goods_discount")/100));
    		//System.out.println(shops.get(shops.size()-1).getSeller().getUsername());
    	}
		return singlegoods;
	}
	
	public boolean updateGoods(Connection con,Goods goods,String username) {
		String SQLsetence = "Update "+username+"_shop set "
				+" goods_name='"+goods.getGoods_name()+"',"	
				+" goods_info='"+goods.getGoods_info()+"',"
				+" goods_price='"+goods.getGoods_price()+"',"
				+" goods_stock='"+goods.getGoods_num()+"',"
				+" goods_type='"+goods.getGoods_type()+"',"
				+" goods_discount='"+goods.getGoods_discount()+"'"
				+" where goods_no = " +goods.getGoods_id();
		Statement stmt;
		System.out.println(SQLsetence);
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(SQLsetence);
			return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean addNewGoos(Connection con,Goods goods,String username) {
		String SQLsetence = "INSERT INTO "+username+"_shop(goods_name,goods_info,goods_price,goods_stock,goods_type,goods_discount) VALUES";
		String InsertSQLsetence = SQLsetence+"("+
				"'"+goods.getGoods_name()+"',"+
				"'"+goods.getGoods_info()+"',"+
				"'"+goods.getGoods_price()+"',"+
				"'"+goods.getGoods_num()+"',"+
				"'"+goods.getGoods_type()+"',"+
				"'0.0')";
		try {
            Statement stmt = con.createStatement();// 创建SQL命令对象
            //stmt.executeUpdate(InsertSQLsetence);
            //stmt.executeUpdate(Sqlsetence);
            stmt.executeUpdate(InsertSQLsetence);
            //stmt.executeUpdate(SelCreateTable);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库插入错误");
            return false;
        }
		
	}
	public int getGoodsTotalPage(Connection con,String seller_username) {
		int totalpage = 0;
		int totalgoods = 0;
		ResultSet rs;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("select count(goods_no)as GoodsCount from "+ seller_username+"_shop ");
			if(rs.next()) {
				totalgoods = rs.getInt(1);
	    	}
			if(totalgoods%10==0) {
				totalpage = totalgoods/10;
			}else {
				totalpage = totalgoods/10+1;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return totalpage;
	}
	public ArrayList<Goods> getGoodsByPage(Connection con,String seller_username,int pageNum){
		if(pageNum==0) {
			pageNum = 1;
		}
		String pageSql = "select top 10 * from "+seller_username+"_shop where goods_no not in "
						+ "(select top "+(pageNum-1)*10+" goods_no from "+seller_username+"_shop order by goods_no /*asc|desc*/) ";
		ArrayList<Goods> goods = new ArrayList<Goods>();
    	ResultSet rs;
		try {
			Statement stmt = con.createStatement();
			//rs = stmt.executeQuery("select top "+pageNum+" * from (select top "+pageNum*14+" * from "+ seller_username+"_shop )");
			rs = stmt.executeQuery(pageSql);
			while(rs.next()) {
	    		Goods singlegoods = new Goods();
	    		//shop.setSeller(new User());
	    		singlegoods.setGoods_id(rs.getInt("goods_no"));
	    		singlegoods.setGoods_name(rs.getString("goods_name"));
	    		singlegoods.setGoods_info(rs.getString("goods_info"));
	    		singlegoods.setGoods_price(rs.getDouble("goods_price"));
	    		singlegoods.setGoods_num(rs.getInt("goods_stock"));
	    		singlegoods.setGoods_type(rs.getString("goods_type"));
	    		singlegoods.setGoods_discount(rs.getDouble("goods_discount"));
	    		goods.add(singlegoods);
	    		//System.out.println(shops.get(shops.size()-1).getSeller().getUsername());
	    	}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    	
		return goods;
	}

	public int getGoodsTotalPageByKeywords(Connection con, String seller_username, String keywords) {
		int totalpage = 0;
		int totalgoods = 0;
		String totalSQl = "select count(goods_no)as GoodsCount from "+ seller_username+"_shop where "
				+ "goods_name like '%"+keywords+"%' or goods_info like '%"+keywords+"%' or goods_type like '%"+keywords+"%'";
		ResultSet rs;
		try {
			Statement stmt = con.createStatement();
			System.out.println(totalSQl);
			rs = stmt.executeQuery(totalSQl);
			
			if(rs.next()) {
				totalgoods = rs.getInt(1);
	    	}
			if(totalgoods%10==0) {
				totalpage = totalgoods/10;
			}else {
				totalpage = totalgoods/10+1;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return totalpage;
	}
	
	
	public ArrayList<Goods> getGoodsByPageKeywords2(Connection con, String seller_username, int pageNum, String keywords){
		if(pageNum==0) {
			pageNum = 1;
		}
		
		String getBygoods_name = "select top 10 * from "+seller_username+"_shop where goods_no not in "
				+"(select top "+(pageNum-1)*10+" goods_no from "+seller_username+"_shop order by goods_no /*asc|desc*/) "
				+"and goods_name like '%"+keywords+"%'";


		String getBygoods_info = "select top 10 * from "+seller_username+"_shop where goods_no not in "
						+"(select top "+(pageNum-1)*10+" goods_no from "+seller_username+"_shop order by goods_no /*asc|desc*/) "
						+"and goods_info like '%"+keywords+"%' Except("+getBygoods_name+")";

		String getBygoods_type ="select top 10 * from "+seller_username+"_shop where goods_no not in "
						+"(select top "+(pageNum-1)*10+" goods_no from "+seller_username+"_shop order by goods_no /*asc|desc*/) "
						+"and goods_type like '%"+keywords+"%' Except("+getBygoods_info+")";
		
		System.err.println(getBygoods_name);
		System.err.println(getBygoods_type);
		System.err.println(getBygoods_info);
		ArrayList<Goods> goods = new ArrayList<Goods>();
    	ResultSet rs;
    	Statement stmt;
		try {
			stmt = con.createStatement();
			 rs = stmt.executeQuery(getBygoods_name);
	    	while(rs.next()) {
	    		Goods singlegoods = new Goods();
	    		//shop.setSeller(new User());
	    		singlegoods.setGoods_id(rs.getInt("goods_no"));
	    		singlegoods.setGoods_name(rs.getString("goods_name"));
	    		singlegoods.setGoods_info(rs.getString("goods_info"));
	    		singlegoods.setGoods_price(rs.getDouble("goods_price"));
	    		singlegoods.setGoods_num(rs.getInt("goods_stock"));
	    		singlegoods.setGoods_type(rs.getString("goods_type"));
	    		singlegoods.setGoods_discount(rs.getDouble("goods_discount"));
	    		goods.add(singlegoods);
	    	}
	    	rs = null;
	    	rs = stmt.executeQuery(getBygoods_info);
	    	while(rs.next()) {
	    		Goods singlegoods = new Goods();
	    		//shop.setSeller(new User());
	    		singlegoods.setGoods_id(rs.getInt("goods_no"));
	    		singlegoods.setGoods_name(rs.getString("goods_name"));
	    		singlegoods.setGoods_info(rs.getString("goods_info"));
	    		singlegoods.setGoods_price(rs.getDouble("goods_price"));
	    		singlegoods.setGoods_num(rs.getInt("goods_stock"));
	    		singlegoods.setGoods_type(rs.getString("goods_type"));
	    		singlegoods.setGoods_discount(rs.getDouble("goods_discount"));
	    		goods.add(singlegoods);
				
	    	}
	    	rs = null;
	    	rs = stmt.executeQuery(getBygoods_type);
	    	while(rs.next()) {
	    		Goods singlegoods = new Goods();
	    		//shop.setSeller(new User());
	    		singlegoods.setGoods_id(rs.getInt("goods_no"));
	    		singlegoods.setGoods_name(rs.getString("goods_name"));
	    		singlegoods.setGoods_info(rs.getString("goods_info"));
	    		singlegoods.setGoods_price(rs.getDouble("goods_price"));
	    		singlegoods.setGoods_num(rs.getInt("goods_stock"));
	    		singlegoods.setGoods_type(rs.getString("goods_type"));
	    		singlegoods.setGoods_discount(rs.getDouble("goods_discount"));
	    		goods.add(singlegoods);
	    	}
	    	return goods;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return goods;
	}
	
	
	public ArrayList<Goods> getGoodsByPageKeywords(Connection con, String seller_username, int pageNum, String keywords) {
		if(pageNum==0) {
			pageNum = 1;
		}
		
		String getBygoods_name = "select top 10 * from "+seller_username+"_shop where goods_no not in "
							+"(select top "+(pageNum-1)*10+" goods_no from "+seller_username+"_shop order by goods_no /*asc|desc*/) "
							+"and goods_info like '%"+keywords+"%'";


		String getBygoods_info = "select top 10 * from "+seller_username+"_shop where goods_no not in "
							+"(select top "+(pageNum-1)*10+" goods_no from "+seller_username+"_shop order by goods_no /*asc|desc*/) "
							+"and goods_type like '%"+keywords+"%' Except("+getBygoods_name+")";
		
		String getBygoods_type ="select top 10 * from "+seller_username+"_shop where goods_no not in "
							+"(select top "+(pageNum-1)*10+" goods_no from "+seller_username+"_shop order by goods_no /*asc|desc*/) "
							+"and goods_type like '%"+keywords+"%' Except("+getBygoods_info+")";
		
		
		
		
		String pageSql = "select top 10 * from "+seller_username+"_shop where goods_no not in "
						+ "(select top "+(pageNum-1)*10+" goods_no from "+seller_username+"_shop order by goods_no /*asc|desc*/) "
						+"and goods_name like '%"+keywords+"%' or goods_info like '%"+keywords+"%' or goods_type like '%"+keywords+"%'";
		System.err.println(pageSql);
		ArrayList<Goods> goods = new ArrayList<Goods>();
    	ResultSet rs;
		try {
			Statement stmt = con.createStatement();
			//rs = stmt.executeQuery("select top "+pageNum+" * from (select top "+pageNum*14+" * from "+ seller_username+"_shop )");
			rs = stmt.executeQuery(pageSql);
			while(rs.next()) {
	    		Goods singlegoods = new Goods();
	    		//shop.setSeller(new User());
	    		singlegoods.setGoods_id(rs.getInt("goods_no"));
	    		singlegoods.setGoods_name(rs.getString("goods_name"));
	    		singlegoods.setGoods_info(rs.getString("goods_info"));
	    		singlegoods.setGoods_price(rs.getDouble("goods_price"));
	    		singlegoods.setGoods_num(rs.getInt("goods_stock"));
	    		singlegoods.setGoods_type(rs.getString("goods_type"));
	    		singlegoods.setGoods_discount(rs.getDouble("goods_discount"));
	    		goods.add(singlegoods);
	    		//System.out.println(shops.get(shops.size()-1).getSeller().getUsername());
	    	}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    	
		return goods;
	}
	
	public ArrayList<Order> getsingleOrder(Connection con,String seller_username){
		ArrayList<Order>orders = new ArrayList<Order>();
		ArrayList<BigOrder>bigOrders = new ArrayList<BigOrder>();
		ResultSet rs;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("select * from ordertable where seller_id = '"+seller_username+"'");
			while(rs.next()) {
				Order singleorder = new Order();
				Goods goods = new Goods();
				singleorder.setGoods(new ArrayList<Goods>());
				singleorder.setOrder_id(rs.getString("order_id"));
				goods.setGoods_id(rs.getInt("goods_id"));
				singleorder.setOrder_singlegoods(goods);
				singleorder.setOrder_goods_singleprice(rs.getDouble("goods_price"));
				singleorder.setOrder_buyer_id(rs.getString("user_id"));
				singleorder.setOrder_goods_stock(rs.getInt("goods_stock"));
				//
				if(1==rs.getInt("order_state")) {
				singleorder.setOrder_info("已付款");
				}
				if(0==rs.getInt("order_state")) {
					singleorder.setOrder_info("未付款");
					}
				if(2==rs.getInt("order_state")) {
					singleorder.setOrder_info("已发货");
					
				}
				if(3==rs.getInt("order_state")) {
					singleorder.setOrder_info("已签收");
					
				}
				//
				singleorder.setOrder_totalprce(rs.getDouble("order_totalprice"));
				orders.add(singleorder);
				
	    	}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("成功获取全部订单信息");
		return orders;
	}
	
	public ArrayList<Order> getBigOrder(ArrayList<Order> orders){
		ArrayList<Order>bigOrder = new ArrayList<Order>();
		double totalPrice = 0;
		String order_info;
		System.out.println("开始组合订单信息");
		for(int i=0;i<orders.size();i++) {
			Order singleorder = new Order();
			System.err.println("下一条信息是"+(i+1));
			if((i+1)<orders.size()&&orders.get(i).getOrder_id().equals(orders.get(i+1).getOrder_id())) {
				singleorder.setOrder_id(orders.get(i).getOrder_id());
				totalPrice += orders.get(i).getOrder_totalprce();
				System.out.println("正在整合的订单号是 "+orders.get(i).getOrder_id()+"  目前总金额是  "+totalPrice);
			}else {
				totalPrice += orders.get(i).getOrder_totalprce();
				totalPrice = (double)Math.round(totalPrice*100)/100 ;
				System.out.println("即将整合的订单号是 "+orders.get(i).getOrder_id()+"  总金额是  "+totalPrice);
				singleorder.setOrder_info(orders.get(i).getOrder_info());
				singleorder.setOrder_id(orders.get(i).getOrder_id());
				singleorder.setOrder_totalprce(totalPrice);
				totalPrice = 0;
				bigOrder.add(singleorder);
				System.out.println("成功组合一条订单"+i);
			}
		}
		System.out.println("成功组合订单信息");
		return bigOrder;
	}
	
	public ArrayList<BigOrder> getBigOrder2(ArrayList<Order> orders){
		ArrayList<BigOrder>bigOrders = new ArrayList<BigOrder>();
		double totalPrice = 0;
		System.out.println("开始组合订单信息");
		BigOrder bigOrder = new BigOrder();
		bigOrder.setSingleorders(new ArrayList<Order>());
		for(int i=0;i<orders.size();i++) {
			Order singleorder = new Order();
			System.err.println("下一条信息是"+(i+1));
			if((i+1)<orders.size()&&orders.get(i).getOrder_id()==orders.get(i+1).getOrder_id()) {
				singleorder.setOrder_id(orders.get(i).getOrder_id());
				totalPrice += orders.get(i).getOrder_totalprce();
				bigOrder.getSingleorders().add(singleorder);
			}else {
				singleorder.setOrder_totalprce(totalPrice);
				bigOrder.setTotalprice(totalPrice);
				totalPrice = 0;
				bigOrders.add(bigOrder);
				bigOrder.setSingleorders(null);
				System.out.println("成功组合一条订单"+i);
			}
		}
		System.out.println("成功组合订单信息");
		return bigOrders;
	}
		
	public boolean deliverGoods(Connection con,String seller_username,String order_id) {
		String updatSql = "update ordertable set order_state = 2 where seller_id = '"+seller_username+"' and order_id = '"+order_id+"'";  
		try {
			Statement stmt = con.createStatement();
			stmt.executeLargeUpdate(updatSql);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public Order getOrderByOrderID(Connection con,String order_id) {
		Order order = new Order();
		order.setGoods(new ArrayList<Goods>());
		String getById = "select * from ordertable where order_id = '"+order_id+"'";
		try {
			Statement stmt = con.createStatement();
			Statement stmt2 = con.createStatement();
			ResultSet rs = stmt.executeQuery(getById);
			double totalprice = 0;
			while (rs.next()) {
				order.setOrder_id(order_id);
				order.setOrder_seller_id(rs.getString("seller_id"));
				order.setOrder_buyer_id(rs.getString("user_id"));
				String getDetailGoodsinfo = "select * from "+order.getOrder_seller_id()+"_shop where goods_no = '"+rs.getInt("goods_id")+"'";
				Goods goods = new Goods();
				ResultSet rs2 = stmt2.executeQuery(getDetailGoodsinfo);
				goods = getSingleGoods(con, order.getOrder_seller_id(), rs.getInt("goods_id"));
				goods.setGoods_num(rs.getInt("goods_stock"));
				order.getGoods().add(goods);
				totalprice += rs.getDouble("order_totalprice");
			}
			totalprice = (double)Math.round(totalprice*100)/100 ;
			order.setOrder_totalprce(totalprice);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return order;
	}
	
}
