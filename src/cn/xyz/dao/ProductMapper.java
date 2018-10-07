package cn.xyz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.servlet.ModelAndView;

import cn.xyz.domain.Category;
import cn.xyz.domain.Product;

public interface ProductMapper {
	public Product queryProduct(String id);
	
	  public List<Category> queryCategorys(String cids);//查找类别
      public List<Product> queryProducts();//查询所有产品
	  

	public int insertProduct(Product product);
	public int insertPc(@Param("pid")String pid,@Param("cid")String cid);

	public int deleteProduct(String id);
	public int deletePc(@Param("pid")String pid);

	public int updateProduct(Product product);
}
