package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;

import com.hxtt.sql.el;
import com.sun.crypto.provider.RSACipher;

import jdk.nashorn.internal.objects.annotations.Where;
import model.Address;
import model.BigOrder;
import model.Goods;
import model.Order;
import model.Shop;
import model.User;
import sun.security.action.GetBooleanAction;

public class UserDAO implements DAO{

	
	@Override
	public boolean isRegisted(String inputAccount,String inputPassword) {
		
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

	@Override
	public boolean isRegisted(String inputAccount, String inputPassword, Connection con) {
		try {
			if(con!=null) {
				String Sqlsetence = "select * from user_infotable where user_username = '"+inputAccount+"' and user_password = '"+inputPassword+"' ";
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
	
	public boolean registUser(Connection con,User user) {
    	String SQLsetence = "INSERT INTO user_infotable(user_username,user_password,user_nickname,user_realname,user_realidnum,"
    			+ "user_city,user_county,user_street,user_building,user_phonenum) VALUES";
		String InsertSQLsetence = SQLsetence+"("+
				"'"+user.getUsername()+"',"+
				"'"+user.getPassword()+"',"+
				"'"+user.getNickname()+"',"+
				"'"+user.getRealname()+"',"+
				"'"+user.getIdnum()+"',"+
				"'"+user.getAddress().getCity()+"',"+
				"'"+user.getAddress().getCounty()+"',"+
				"'"+user.getAddress().getStreet()+"',"+
				"'"+user.getAddress().getBuilding()+"',"+
				"'"+user.getPhone_number()+"')";
		System.out.println(InsertSQLsetence);
		/*
	[goods_no] [int] NULL,
	[goods_name] [varchar](50) NULL,
	[goods_price] [float] NULL,
	[goods_stock] [int] NULL
		 */
		/*
	[order_id] [int] NULL,
	[user_id] [int] NULL,
	[seller_id] [int] NULL,
	[goods_id] [int] NULL,
	[goods_price] [float] NULL,
	[goods_stock] [int] NULL
		 * */
		String SelCreateTable = "CREATE TABLE " +user.getUsername()+"_shopping_cart ("
				+"[goods_no] [int] NULL,"
				+"[goods_name] [varchar](50) NULL,"
				+"[goods_price] [float] NULL,"
				+"[goods_stock] [int] NULL,"
				+"[goods_discount] [float] NULL,"
				+"[goods_seller] [varchar](50) NULL)";
		System.out.println(SelCreateTable);
		//String SqlinsertToTable = "Insert into seller_infotable(seller_username,seller_password,_seller_nickname,seller_realname,seller_realidnum,seller_location)"
			//	+"values("+seller.getUsername()+seller.getPassword()+seller.getNickname()+seller.getRealname()+seller.getIdnum()+seller.getLoaction()+")";
		//System.out.println(InsertSQLsetence);
		try {
            Statement stmt = con.createStatement();// 创建SQL命令对象
            //stmt.executeUpdate(InsertSQLsetence);
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
	public User getUserinfo(Connection con,String username) {
		User user = new User();
		user.setAddress(new Address());
    	String SQLsetence = "select * from user_infotable where user_username = '"+username+"'";
    	System.out.println(SQLsetence);
    	try {
            Statement stmt = con.createStatement();// 创建SQL命令对象
            //stmt.executeUpdate(InsertSQLsetence);
            ResultSet rs = stmt.executeQuery(SQLsetence);
            while(rs.next()) {
            	
            	user.setUsername(rs.getString("user_username"));
        		user.setPassword(rs.getString("user_password"));
        		user.setNickname(rs.getString("user_nickname"));
        		user.setRealname(rs.getString("user_realname"));
        		user.setIdnum(rs.getString("user_realidnum"));
        		user.getAddress().setCity(rs.getString("user_city"));
        		user.getAddress().setCounty(rs.getString("user_county"));
        		user.getAddress().setStreet(rs.getString("user_street"));
        		user.getAddress().setBuilding(rs.getString("user_building"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库表连接错误");
            //return false;
        }
		return null;
		
	}
	public Shop setShopFromDb(ResultSet rs) {
		Shop shop = new Shop();
		shop.setSeller(new User());
		try {
			shop.getSeller().setUsername(rs.getString("seller_username"));
			shop.getSeller().setPassword(rs.getString("seller_password"));
			shop.getSeller().setNickname(rs.getString("seller_nickname"));
			shop.getSeller().setRealname(rs.getString("seller_realname"));
			shop.getSeller().setIdnum(rs.getString("seller_realidnum"));
			shop.getSeller().setLoaction(rs.getString("seller_location"));
			shop.getSeller().getAddress().setCity(rs.getString("seller_city"));
			shop.getSeller().getAddress().setCounty(rs.getString("seller_county"));
			shop.getSeller().getAddress().setStreet(rs.getString("seller_street"));
			shop.getSeller().getAddress().setBuilding(rs.getString("seller_building"));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return shop;
	}
	public ArrayList<Shop> getShopByLocation(Connection con,User user){
		ArrayList<Shop> shops = new ArrayList<Shop>();
		//ArrayList<Shop> shops = new ArrayList<>();
		/*
		 * *  
		select * from seller_infotable where seller_city = 'A' and seller_county = 'B' EXCEPT
			(select * from seller_infotable where seller_city = 'A' and seller_county = 'B' and seller_street = 'C')
		 * */
		String getByCity = "select * from seller_infotable where seller_city = '"+user.getAddress().getCity()+"'";
		String getByCounty = getByCity+" and seller_county = '"+user.getAddress().getCounty()+"'";
		String getByStreet = getByCounty+" and seller_street = '"+user.getAddress().getStreet()+"'";
		String getByCountyNoStreet = getByCounty + "EXCEPT ("+getByStreet+")";
		String getByCityNoStreet = getByCity + "EXCEPT ("+getByCounty+")";
    	Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(getByStreet);
	    	while(rs.next()) {
	    		Shop shop = new Shop();
	    		shop.setSeller(new User());
	    		shop.getSeller().setAddress(new Address());
	    		shop.getSeller().setUsername(rs.getString("seller_username"));
	    		shop.getSeller().setPassword(rs.getString("seller_password"));
	    		shop.getSeller().setNickname(rs.getString("seller_nickname"));
	    		shop.getSeller().getAddress().setCity(rs.getString("seller_city"));
	    		shop.getSeller().getAddress().setCounty(rs.getString("seller_county"));
	    		shop.getSeller().getAddress().setStreet(rs.getString("seller_street"));
	    		shop.getSeller().getAddress().setBuilding(rs.getString("seller_building"));
	    		shops.add(shop);
	    	}
	    	rs = null;
	    	rs = stmt.executeQuery(getByCountyNoStreet);
	    	while(rs.next()) {
	    		Shop shop = new Shop();
	    		shop.setSeller(new User());
	    		shop.getSeller().setAddress(new Address());
	    		shop.getSeller().setUsername(rs.getString("seller_username"));
	    		shop.getSeller().setPassword(rs.getString("seller_password"));
	    		shop.getSeller().setNickname(rs.getString("seller_nickname"));
	    		shop.getSeller().getAddress().setCity(rs.getString("seller_city"));
	    		shop.getSeller().getAddress().setCounty(rs.getString("seller_county"));
	    		shop.getSeller().getAddress().setStreet(rs.getString("seller_street"));
	    		shop.getSeller().getAddress().setBuilding(rs.getString("seller_building"));
				shops.add(shop);
				
	    	}
	    	rs = null;
	    	rs = stmt.executeQuery(getByCityNoStreet);
	    	while(rs.next()) {
	    		Shop shop = new Shop();
	    		shop.setSeller(new User());
	    		shop.getSeller().setAddress(new Address());
	    		shop.getSeller().setUsername(rs.getString("seller_username"));
	    		shop.getSeller().setPassword(rs.getString("seller_password"));
	    		shop.getSeller().setNickname(rs.getString("seller_nickname"));
	    		shop.getSeller().getAddress().setCity(rs.getString("seller_city"));
	    		shop.getSeller().getAddress().setCounty(rs.getString("seller_county"));
	    		shop.getSeller().getAddress().setStreet(rs.getString("seller_street"));
	    		shop.getSeller().getAddress().setBuilding(rs.getString("seller_building"));
	    		Iterator iter = shops.iterator();
				shops.add(shop);
	    	}
	    	return shops;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    	
		return shops;
	}
	
	public ArrayList<Shop> getAllShops(Connection con){
		ArrayList<Shop> shops = new ArrayList<Shop>();
		return shops;
	}
	
	public boolean addGoodsToShoppingCart(Connection con,Goods goods,String username,String seller_username) {
		String SQLsetence = "INSERT INTO "+username+"_shopping_cart(goods_no,goods_name,goods_price,goods_stock,goods_discount,goods_seller) VALUES";
		String InsertSQLsetence = SQLsetence+"("+
				"'"+goods.getGoods_id()+"',"+
				"'"+goods.getGoods_name()+"',"+
				"'"+goods.getGoods_price()+"',"+
				"'"+goods.getGoods_num()+"',"+
				"'"+goods.getGoods_discount()+"',"+
				"'"+seller_username+"')";
		
		System.out.println(InsertSQLsetence);
		//System.out.println(InsertSQLsetence);
		try {
            Statement stmt = con.createStatement();// 创建SQL命令对象
            //stmt.executeUpdate(InsertSQLsetence);
            if(checkShoppingCartRepeat(con, goods, username)==false) {
            	stmt.executeUpdate(InsertSQLsetence);
            	return true;
            }else {
            	String UpdateIfRepeat = "Update "+username+"_shopping_cart set goods_stock = '"+(getGoodsNumIfRepeat(con, goods, username)+goods.getGoods_num())
    					+"' where goods_no ='" +goods.getGoods_id()+"'";
            	stmt.executeUpdate(UpdateIfRepeat);
				return true;
			}
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库表连接错误");
            return false;
        }
	}
	public int getGoodsNumIfRepeat(Connection con,Goods goods,String username) {
		String SQLsetence = "select * from "+username+"_shopping_cart where goods_no = '"+goods.getGoods_id()+"'";
		int goods_num = 0;
		try {
            Statement stmt = con.createStatement();// 创建SQL命令对象
            //stmt.executeUpdate(InsertSQLsetence);
            ResultSet rs = stmt.executeQuery(SQLsetence);
            if(rs.next()) {
            goods_num = rs.getInt("goods_stock");
            }
		}catch (Exception e) {
			// TODO: handle exception
		}
		return goods_num;
	}
	public boolean checkShoppingCartRepeat(Connection con,Goods goods,String username) {
		String SQLsetence = "select * from "+username+"_shopping_cart where goods_no = '"+goods.getGoods_id()+"'";
		try {
            Statement stmt = con.createStatement();// 创建SQL命令对象
            //stmt.executeUpdate(InsertSQLsetence);
            ResultSet rs = stmt.executeQuery(SQLsetence);
            if(rs.next()) {
            return true;
            }else {
            	return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库表连接错误");
            return false;
        }
		//return true;
	}
	public ArrayList<Goods> getGoodsFromShoppingCart(Connection con,String username){
		ArrayList<Goods> goods = new ArrayList<Goods>();
		String SQLsetence = "select * from "+username+"_shopping_cart ";
		try {
            Statement stmt = con.createStatement();// 创建SQL命令对象
            //stmt.executeUpdate(InsertSQLsetence);
            ResultSet rs = stmt.executeQuery(SQLsetence);
            while(rs.next()) {
            	Goods singlegoods = new Goods();
            	singlegoods.setGoods_id(rs.getInt("goods_no"));
            	singlegoods.setGoods_name(rs.getString("goods_name"));
            	singlegoods.setGoods_num(rs.getInt("goods_stock"));
            	singlegoods.setGoods_price(rs.getDouble("goods_price"));
            	singlegoods.setGoods_totalPrice(rs.getDouble("goods_price")*rs.getInt("goods_stock"));
            	singlegoods.setGoods_seller(rs.getString("goods_seller"));
            	singlegoods.setGoods_totalPriceAfterDiscount(singlegoods.getGoods_totalPrice()-(singlegoods.getGoods_totalPrice()*rs.getDouble("goods_discount")/100));
            	goods.add(singlegoods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库表连接错误");
        }
		return goods;
	}
	
	public boolean checkOutShoppingCart(Connection con,String username,ArrayList<Goods> goods,String seller_username,String order_id) {
		
		String CleanShoppingCartSQLsetence = "truncate table "+username+"_shopping_cart";
		String UpdateOrder = "Update ordertable set order_state = 1 where order_id = '"+order_id+"'";
		try {
            Statement stmt = con.createStatement();// 创建SQL命令对象
            ResultSet rs = stmt.executeQuery("select * from "+username+"_shopping_cart");
            while (rs.next()) {
				Goods singlegoods = new Goods();
				singlegoods.setGoods_id(rs.getInt("goods_no"));
				singlegoods.setGoods_num(rs.getInt("goods_stock"));
				String UpdateGoodsStock = "Update "+seller_username+"_shop set goods_stock -= "+rs.getInt("goods_stock")+" where goods_no = '"+rs.getInt("goods_no")+"'";
				Statement stmt2 = con.createStatement();
				stmt2.executeUpdate(UpdateGoodsStock);
			}
            Statement stmt3 = con.createStatement();
            stmt3.executeUpdate(CleanShoppingCartSQLsetence);
            stmt3.executeUpdate(UpdateOrder);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库表连接错误");
            return false;
        }
		
		return true;
	}
	
	public Order userCreatOrder(Connection con,String username,Order order) {
		
		String SQLcreatOrder =  "INSERT INTO ordertable (order_id,user_id,seller_id,goods_id,goods_price,goods_stock,order_totalprice) VALUES";
		
		ShopDAO shopDAO = new ShopDAO();
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改   
		 int year = c.get(Calendar.YEAR);
		 int month = c.get(Calendar.MONTH);  
		 int date = c.get(Calendar.DATE);  
		 int hour = c.get(Calendar.HOUR_OF_DAY);   
		 int minute = c.get(Calendar.MINUTE);   
		 int second = c.get(Calendar.SECOND);   
		 String order_id_day_root_type_string = Integer.toString(year)+Integer.toString(month+1)+Integer.toString(date)+
					Integer.toString(hour)+Integer.toString(minute)+Integer.toString(second);
		 Random random = new Random();
		 int order_root = random.nextInt(9999);
		 int order_id = 0;
		 order.setOrder_id(order_id_day_root_type_string+Integer.valueOf(order_root));
		 System.out.println("生成的订单号为"+order.getOrder_id());
		 String order_info = "";
		 order.setOrder_name(shopDAO.getShopFromDB("seller_infotable", order.getGoods().get(0).getGoods_seller(), con).getSeller().getNickname()+"店购买商品");
		 for(int i=0;i<order.getGoods().size();i++) {
			 String InsertSQLsetence = SQLcreatOrder+"("+
						"'"+order.getOrder_id()+"',"+
						"'"+username+"',"+
						"'"+order.getGoods().get(i).getGoods_seller()+"',"+
						"'"+order.getGoods().get(i).getGoods_id()+"',"+
						"'"+order.getGoods().get(i).getGoods_price()+"',"+
						"'"+order.getGoods().get(i).getGoods_num()+"',"+
						"'"+order.getGoods().get(i).getGoods_totalPriceAfterDiscount()+"')";
			 System.out.println(InsertSQLsetence);
			 order_info += order.getGoods().get(i).getGoods_name()+"*"+order.getGoods().get(i).getGoods_num()+",";
			 //order.setOrder_info(order_info);
			 try {
				Statement stmt = con.createStatement();
				stmt.executeUpdate(InsertSQLsetence);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		 order.setOrder_info(order_info);
		return order;
	}
	
	public boolean orderIdRepeat(Connection con,int order_id) {
		String getOid = "select order_id from ordertable where order_id = '"+order_id+"'";
		try {
			Statement stat = con.createStatement();
			ResultSet rSet = stat.executeQuery(getOid);
			if(rSet.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			return true;
		}
		
	}
	
	public int userCreatOrder(Connection con,String username,ArrayList<Goods> goods) {
		
		String SQLcreatOrder =  "INSERT INTO ordertable (order_id,user_id,seller_id,goods_id,goods_price,goods_stock,order_state) VALUES";
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改   
		 int year = c.get(Calendar.YEAR);
		 int month = c.get(Calendar.MONTH);  
		 int date = c.get(Calendar.DATE);  
		 int order_id_day_root = year*1000000+(month+1)*100000+date*10000;
		 Random random = new Random();
		 int order_root = random.nextInt(9999);
		 int order_id = 0;
		 order_id = order_id_day_root+order_root;
		 for(int i=0;i<goods.size();i++) {
		 String InsertSQLsetence = SQLcreatOrder+"("+
					"'"+order_id+"',"+
					"'"+username+"',"+
					"'"+goods.get(i).getGoods_seller()+"',"+
					"'"+goods.get(i).getGoods_id()+"',"+
					"'"+goods.get(i).getGoods_price()+"',"+
					"'"+goods.get(i).getGoods_num()+"',"+
					"'0')";
		 System.out.println(InsertSQLsetence);
		 try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(InsertSQLsetence);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		}
		return order_id;
	}
	
	public ArrayList<Order> getsingleOrder(Connection con,String user_username){
		ArrayList<Order>orders = new ArrayList<Order>();
		ArrayList<BigOrder>bigOrders = new ArrayList<BigOrder>();
		ResultSet rs;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("select * from ordertable where user_id = '"+user_username+"'");
			while(rs.next()) {
				Order singleorder = new Order();
				Goods goods = new Goods();
				singleorder.setGoods(new ArrayList<Goods>());
				singleorder.setOrder_id(rs.getString("order_id"));
				goods.setGoods_id(rs.getInt("goods_id"));
				singleorder.setOrder_singlegoods(goods);
				singleorder.setOrder_goods_singleprice(rs.getDouble("goods_price"));
				singleorder.setOrder_seller_id(rs.getString("seller_id"));
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
	
	public boolean rcvGoods(Connection con,String user_username,String order_id) {
		String updatSql = "update ordertable set order_state = 3 where user_id = '"+user_username+"' and order_id = '"+order_id+"'";  
		System.out.println(updatSql);
		try {
			Statement stmt = con.createStatement();
			stmt.executeLargeUpdate(updatSql);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
