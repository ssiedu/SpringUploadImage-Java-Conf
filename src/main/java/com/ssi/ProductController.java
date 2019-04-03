package com.ssi;

import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class ProductController {

@Autowired
ProductDAO dao;

@RequestMapping("showall")
public ModelAndView showAllProducts() {
	List<Product> products=dao.getAllProducts();
	ModelAndView mv=new ModelAndView("showallproducts");
	mv.addObject("products",products);	
	return mv;
}
@RequestMapping("imageDisplay")
public void sendImage(@RequestParam("pcode") int pcode, HttpServletResponse response) {
	
	Product product=dao.getProductById(pcode);
	Blob blob=product.getPicture();
	byte b[]=null;
	try {
	b=blob.getBytes(1, (int)blob.length());
	response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	ServletOutputStream out=response.getOutputStream();
	out.write(b);
	out.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
}

@RequestMapping("searchproduct")
public ModelAndView searchProduct(@RequestParam("pcode") int code) {
	Product product=dao.getProductById(code);
	ModelAndView mv=new ModelAndView("details");
	mv.addObject("product",product);
	return mv;
}

@RequestMapping("search")
public String showProductSearchForm() {
	return "search";
}
@RequestMapping("saveproduct")	
public String saveProduct(@ModelAttribute("product") Product product, @RequestParam("file") MultipartFile file) {
	byte b[]=null;
	try {
	b=file.getBytes();
	}catch(Exception e) {
		e.printStackTrace();
	}
	Blob blob=BlobProxy.generateProxy(b);
	product.setPicture(blob);
	dao.saveProduct(product);
	return "success";
}
@RequestMapping("productentry")
public String showProductEntryForm() {
	return "pentry";
}

}
