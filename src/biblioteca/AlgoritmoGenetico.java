package biblioteca;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.IntegerGene;

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
		return soma;
	}
	
	public void visualizaGeracao(IChromosome cromossomo, int geracao){
		List lista = new ArrayList<>();
		Gene[] genes = cromossomo.getGenes();
		for (int i = 0; i < cromossomo.size(); i++) {
			lista.add(genes[i].getAllele().toString() + " ");
		}
		
		System.out.println("G: " + geracao + 
				" Valor: " + cromossomo.getFitnessValue() +
				" Espaços: " + somaEspacos(cromossomo)+
				" Cromossomo: " + lista);
	}
	
	public IChromosome criarCromossomo() throws InvalidConfigurationException{
		Gene[] genes = new Gene [listaProdutos.size()];
		for (int i = 0; i < genes.length; i++) {
			genes[i] = new IntegerGene(configuracao, 0,1);
			genes[i].setAllele(i);
		}
		IChromosome modelo = new Chromosome(configuracao, genes);
		return modelo;
	}
	
	public FitnessFunction criarFuncaoFitness(){
		return new Avalicao(this);
	}
}
