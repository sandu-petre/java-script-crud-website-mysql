 package daw.project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daw.project.model.ConnectionManager;
import daw.project.model.beans.ProductBean;

public class ProductDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	
	public static List<ProductBean> findAll(){
		List<ProductBean> products= new ArrayList<ProductBean>();
		// preparing some objects for connection
		Statement stmt = null;
		String searchQuery = "select * from product;";
		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			ProductBean product;
			while(rs.next()) {
				//construct new product bean from 
				product = new ProductBean(); 
				product.setIdProduct(rs.getInt("id_product"));
				product.setProductName(rs.getString("product_name"));
				product.setProductDescription(rs.getString("product_description"));
				product.setProductPrice(rs.getFloat("product_price"));
				product.setProductQuantity(rs.getInt("product_quantity"));
				
				//add to list
				products.add(product);
				
			}
			
		}
		catch (Exception ex) {
			System.out.println("Error retriving data from database products! " + ex);
		}
		// some exception handling
		finally {
			if (rs != null) {
			try {
			rs.close();
			} catch (Exception e) {
			}
			rs = null;
			}
			if (stmt != null) {
			try {
			stmt.close();
			} catch (Exception e) {
			}
			stmt = null;
			}
			if (currentCon != null) {
			try {
			currentCon.close();
			} catch (Exception e) {
			}
			currentCon = null;
			}
			

		}
		
		return products;
		
		
	
	}

	public static int create(ProductBean newProduct) {
		int created=0;
		PreparedStatement stmt = null;
		String searchQuery = "INSERT INTO `daw`.`product`(`product_name`,`product_description`,`product_price`,`product_quantity`)"
				+ "VALUES(?,?,?,?);";
		
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.prepareStatement(searchQuery); 
			stmt.setString(1, newProduct.getProductName());
			stmt.setString(2, newProduct.getProductDescription());
			stmt.setFloat(3, newProduct.getProductPrice());
			stmt.setInt(4, newProduct.getProductQuantity());
			
			created= stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					}
					stmt = null;
			}
			if (currentCon != null) {
				try {
				currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		
		
		return created;
	}

	public static int delete(String productId) {
		int deleted=0;
		PreparedStatement stmt = null;
		String searchQuery = "DELETE from `daw`.`product` WHERE `id_product`=?;";
		
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.prepareStatement(searchQuery); 
			stmt.setInt(1, Integer.parseInt(productId,10));
			
			deleted= stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					}
					stmt = null;
			}
			if (currentCon != null) {
				try {
				currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		
		
		return deleted;
	}

	public static ProductBean findById(String productId) {
		ProductBean result = null;
		
		// preparing some objects for connection
		PreparedStatement stmt = null;
		String searchQuery = "select * FROM `daw`.`product` where `product`.`id_product`=?;";
		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.prepareStatement(searchQuery);
			stmt.setInt(1, Integer.parseInt(productId,10));
			rs = stmt.executeQuery();
						
			
			if(rs.next()) {
				//construct new product bean from 
				result = new ProductBean(); 
				result.setIdProduct(rs.getInt("id_product"));
				result.setProductName(rs.getString("product_name"));
				result.setProductDescription(rs.getString("product_description"));
				result.setProductPrice(rs.getFloat("product_price"));
				result.setProductQuantity(rs.getInt("product_quantity"));	
								
			}
			
		}
		catch (Exception ex) {
			System.out.println("Error getting product by id from database ! " + ex);
		}
		// some exception handling
		finally {
			if (rs != null) {
			try {
			rs.close();
			} catch (Exception e) {
			}
			rs = null;
			}
			if (stmt != null) {
			try {
			stmt.close();
			} catch (Exception e) {
			}
			stmt = null;
			}
			if (currentCon != null) {
			try {
			currentCon.close();
			} catch (Exception e) {
			}
			currentCon = null;
			}		
		}		
		
		return result;
	}

	public static int save(ProductBean productToEdit) {
		int edited=0;
		PreparedStatement stmt = null;
		String searchQuery = "UPDATE `daw`.`product`\r\n"
				+ "SET\r\n"				
				+ "`product_name` = ?,\r\n"
				+ "`product_description` = ?,\r\n"
				+ "`product_price` = ?,\r\n"
				+ "`product_quantity` = ?\r\n"
				+ "WHERE `id_product` = ?;";
		
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.prepareStatement(searchQuery); 
			stmt.setString(1, productToEdit.getProductName());
			stmt.setString(2,productToEdit.getProductDescription());
			stmt.setFloat(3,productToEdit.getProductPrice());
			stmt.setInt(4,productToEdit.getProductQuantity());
			stmt.setInt(5,productToEdit.getIdProduct());
			
			
			edited= stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					}
					stmt = null;
			}
			if (currentCon != null) {
				try {
				currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		
		
		return edited;
	}

}

