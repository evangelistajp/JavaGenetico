package biblioteca;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.jgap.Configuration;
import org.jgap.IChromosome;

import dao.PersistenceUtil;
import dao.ProdutoDAO;
import model.Produto;



public class AlgoritmoGenetico {
	
	Configuration configuracao;
	int numeroGeracoes = 100;
	Double limite = 3.0;
	int tamanhoPopulacao = 20;
	int taxaMutacao = 100;
	
	List<IChromosome> melhoresCromossomos = new ArrayList<>();
	List<Produto> listaProdutos = new ArrayList<>();
	IChromosome melhor;
	
	public void carregar(){
		
		EntityManager em = PersistenceUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		produtoDAO.beginTransaction();
		for(Produto lpr : produtoDAO.findAll()){
			listaProdutos.add(lpr);
		}
		produtoDAO.commit();
		
	}
	
	public Double somaEspacos(IChromosome cromossomo){
		Double soma = 0.0;
		for (int i = 0; i < cromossomo.size(); i++) {
			if (cromossomo.getGene(i).getAllele().toString().equals("1")) {
				soma+= this.listaProdutos.get(i).getEspaco();
			}
		}
		return null;
	}

}
