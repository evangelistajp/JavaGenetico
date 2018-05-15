import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import dao.PersistenceUtil;
import dao.ProdutoDAO;
import model.Produto;

public class MainBD {
	
	public static void main(String[] args) {
		
		EntityManager em = PersistenceUtil.getCurrentEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		if (produtoDAO.findAll().size() == 0) {
			List<Produto> pr = new ArrayList<>();

			pr.add(new Produto("Geladeira Dako",0.751, 999.90,1));
			pr.add(new Produto("Geladeira Brastemp",0.635, 849.00,2));
			pr.add(new Produto("Geladeira Consul",0.870, 1199.89,6));
			pr.add(new Produto("TV 55",0.400, 4346.99,2));
			pr.add(new Produto("TV 50",0.290, 3999.90,3));
			pr.add(new Produto("TV 42",0.200, 2999.00,4));
			pr.add(new Produto("Notebook Dell",0.00350, 2499.90,1));
			pr.add(new Produto("Notebook Lenovo",0.498, 1999.90,2));
			pr.add(new Produto("Notebook Asus",0.527, 3999.00,1));
			pr.add(new Produto("Microondas Electrolux",0.0424, 308.66,2));
			pr.add(new Produto("Microondas LG",0.0544, 429.90,5));
			pr.add(new Produto("Microondas Panasonic",0.0319, 299.29,3));
			pr.add(new Produto("Iphone 6",0.000089, 2911.12,5));
			pr.add(new Produto("Ventilador Panasonic",0.496, 199.90,10));
			
			produtoDAO.beginTransaction();
			for(Produto lpr : produtoDAO.findAll()){
				produtoDAO.insert(lpr);
			}
			produtoDAO.commit();
		}

	}

}
