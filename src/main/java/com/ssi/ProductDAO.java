package com.ssi;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Product> getAllProducts(){
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		List<Product> products=criteria.list();
		session.close();
		return products;
	}
	public Product getProductById(int code) {
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class, code);
		session.close();
		return product;
	}
	public void saveProduct(Product product) {
		Session session=sessionFactory.openSession();
		session.save(product);
		session.beginTransaction().commit();
		session.close();
	}
}
