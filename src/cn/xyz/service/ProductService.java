package cn.xyz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xyz.c.ProductC;
import cn.xyz.dao.ProductMapper;
import cn.xyz.domain.Category;
import cn.xyz.domain.Product;

@Service
public class ProductService {
	   @Autowired
	   private ProductMapper productdao;
       public List<Product> queryProducts(){
    	   List<Product> products = productdao.queryProducts();
    	   return products;   
       }
       public List<Category> queryCategorys(String cids){
    	   return   productdao.queryCategorys(cids);   	    
       }
       public int insertProduct(Product product) {
    	   return  productdao.insertProduct(product);
       }
       public int insertPc(String pid,String cid) {
    	   return   productdao.insertPc(pid, cid);
       }
       public int deleteProduct(String id) {
    	  return  productdao.deleteProduct(id);
       }
       public int deletePc(String pid) {
    	    return productdao.deletePc(pid);
       }
       public Product getupdate(String id) {
    	   return productdao.queryProduct(id);
       }
       public int updateProduct(Product product) {
    	   return productdao.updateProduct(product);
       }
//       public static void main(String[] args) {
//    	   ProductService p = new ProductService();
//    	   List<Product> p2 = p.queryProducts();
//    	   System.out.println(p2);
//	}
  
}
