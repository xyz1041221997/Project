package cn.xyz.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.xyz.domain.Category;
import cn.xyz.domain.Product;

import cn.xyz.service.ProductService;

@Controller
public class ProductC {
	@Autowired
	private ProductService productservice;
	/*
	 * 
	 * ��ѯ���в�Ʒ����Ϣ
	 */
    @RequestMapping("/queryProduct.do")
	public String queryProducts(Model model) {
//	   ModelAndView mv = new ModelAndView();
	   List<Product> products = productservice.queryProducts();
	
	   for(Product p:products) {
		   List<Category> categorys = productservice.queryCategorys(p.getId());
		         p.setCategorys(categorys);
	   }
	   model.addAttribute("products", products);
//	   mv.addObject("products",products);
	 
		return "/product-list";
	}
    /***
     * ���Ӳ�Ʒ
     * @param product
     * @return
     */
    @RequestMapping("/insertProduct.do")
    public  ModelAndView insertProduct(Product product) {
    	 ModelAndView mv = new ModelAndView();
    	 int i = productservice.insertProduct(product);
    	 String pid = product.getId();
    	 String[] cids = product.getCids().split(",");
    	 for(String cid:cids) {
    		 int j = productservice.insertPc(pid, cid);
    	 }
    	 if(i<0) {
    		 mv.addObject("message", "���ӮaƷ��Ϣ���e!");
    		 mv.setViewName("/msg");
    	 }
    	mv.setViewName("redirect:/queryProduct.do");
		return mv;
    }
    /**
     * ɾ����Ʒ��Ϣ
     * @param id
     * @return
     */
    @RequestMapping("/deleteProduct.do")
    public ModelAndView deleteProduct(String id) {
    	ModelAndView mv = new ModelAndView();
//    	String pid = id;
    	int j = productservice.deletePc(id);
    	int i = productservice.deleteProduct(id);
    	if(i<0) {
    		 mv.addObject("message", "���ӮaƷ��Ϣ���e!");
    		 mv.setViewName("/msg");
    	}
    	mv.setViewName("redirect:/queryProduct.do");
    	return mv;
    }
    /**
     * �޸Ĳ�Ʒ��Ϣ����
     * @param id
     * @return
     */
    @RequestMapping("/getupdate.do")
    public ModelAndView getupdate(String id){
    	 ModelAndView mv = new ModelAndView();
    	 Product product = productservice.getupdate(id);
    	 List<Category> categorys = productservice.queryCategorys(product.getId());
    	 product.setCategorys(categorys); 
    	 mv.addObject("product",product);
    	 mv.setViewName("/getupdate");
		return mv;
    }
    /*
     * ִ���޸�
     */
    @RequestMapping("/updateProduct.do")
    public ModelAndView updateProduct(Product product) {
   	          ModelAndView mv = new ModelAndView();
   	          int i = productservice.updateProduct(product);
   	         // System.out.println(product);
   	          String pid = product.getId();
   	          String[] cids = product.getCids().split(",");
   	     //     System.out.println(pid+" "+product.getCids());
   	            productservice.deletePc(pid);
   	            for(String cid:cids) {
   	            	productservice.insertPc(pid, cid);
   	            }
   	          if(i>0) {
   	        	  mv.setViewName("redirect:/queryProduct.do");
   	          }else {
   	        	  mv.addObject("message","�޸���Ϣ���e!!");
   	        	  mv.setViewName("/msg");
   	          }
   	          return mv;
    }
}
