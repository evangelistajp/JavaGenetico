package biblioteca;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.DefaultFitnessEvaluator;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.Population;
import org.jgap.event.EventManager;
import org.jgap.impl.BestChromosomesSelector;
import org.jgap.impl.CrossoverOperator;
import org.jgap.impl.IntegerGene;
import org.jgap.impl.StockRandomGenerator;
import org.jgap.impl.SwappingMutationOperator;

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
	
	public Configuration criarConfiguracao() throws InvalidConfigurationException{
		Configuration configuracao = new Configuration();
	
		configuracao.removeNaturalSelectors(true);
		configuracao.addNaturalSelector(new BestChromosomesSelector(configuracao, 0.4), true);
		configuracao.setRandomGenerator(new StockRandomGenerator());
		configuracao.addGeneticOperator(new CrossoverOperator(configuracao));
		configuracao.addGeneticOperator(new SwappingMutationOperator(configuracao, taxaMutacao));
		configuracao.setKeepPopulationSizeConstant(true);
		configuracao.setEventManager(new EventManager());
		configuracao.setFitnessEvaluator(new DefaultFitnessEvaluator());
		
		return configuracao;
	}
	
	public void procurarMelhorSolucao() throws InvalidConfigurationException{
		this.configuracao = criarConfiguracao();
		FitnessFunction funcaoFitness = criarFuncaoFitness();
		configuracao.setFitnessFunction(funcaoFitness);
		IChromosome modeloCromossomo = criarCromossomo();
		configuracao.setSampleChromosome(modeloCromossomo);
		configuracao.setPopulationSize(tamanhoPopulacao);
		IChromosome[] cromossomos = new IChromosome[tamanhoPopulacao];
		
		for (int i = 0; i < this.tamanhoPopulacao; i++) {
			cromossomos[i] = criarCromossomo();
		}
		Genotype populacao = new Genotype(configuracao, new Population(configuracao, cromossomos));
		for (int j = 0; j < this.numeroGeracoes; j++) {
			visualizaGeracao(populacao.getFittestChromosome(), j);
			this.melhoresCromossomos.add(populacao.getFittestChromosome());
			populacao.evolve();
		}
	}

	public List<IChromosome> getMelhoresCromossomos() {
		return melhoresCromossomos;
	}

	public void setMelhoresCromossomos(List<IChromosome> melhoresCromossomos) {
		this.melhoresCromossomos = melhoresCromossomos;
	}

	public IChromosome getMelhor() {
		return melhor;
	}

	public void setMelhor(IChromosome melhor) {
		this.melhor = melhor;
	}
	
	public void MelhorSolucaoDeTodas(){
		
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	
}
