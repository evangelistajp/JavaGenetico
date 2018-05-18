package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Produto;

import org.hibernate.HibernateException;
import org.jboss.logging.Logger;
import javax.persistence.Query;

public class ProdutoDAO extends GenericDAOJPAImpl<Produto, Long>{
	
private static Logger logger = Logger.getLogger(ProdutoDAO.class);
	
	public ProdutoDAO(EntityManager em){
		super(em);
	}
	
	public ProdutoDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}
	
	
	public List<Produto> findAll() throws DAOException{
		List<Produto> produtos = null;
		try {
			Query q = this.getEntityManager()
					.createQuery("from Produto f");
			produtos = (List<Produto>) q.getResultList();
		} catch (HibernateException e) {
			throw new DAOException("Erro ao tentar pegar Produtos", e);
		}
		return produtos;
	}


}
