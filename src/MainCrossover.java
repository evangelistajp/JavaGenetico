import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jfree.ui.RefineryUtilities;

import model.Produto;


public class MainCrossover {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		List<Produto> listaProdutos = new ArrayList<Produto>();
				
		
//		listaProdutos.add(new Produto("Geladeira Dako",0.751, 999.90,1));
//		listaProdutos.add(new Produto("Geladeira Brastemp",0.635, 849.00,2));
//		listaProdutos.add(new Produto("Geladeira Consul",0.870, 1199.89,6));
//		listaProdutos.add(new Produto("TV 55",0.400, 4346.99,2));
//		listaProdutos.add(new Produto("TV 50",0.290, 3999.90,3));
//		listaProdutos.add(new Produto("TV 42",0.200, 2999.00,4));
//		listaProdutos.add(new Produto("Notebook Dell",0.00350, 2499.90,1));
//		listaProdutos.add(new Produto("Notebook Lenovo",0.498, 1999.90,2));
//		listaProdutos.add(new Produto("Notebook Asus",0.527, 3999.00,1));
//		listaProdutos.add(new Produto("Microondas Electrolux",0.0424, 308.66,2));
//		listaProdutos.add(new Produto("Microondas LG",0.0544, 429.90,5));
//		listaProdutos.add(new Produto("Microondas Panasonic",0.0319, 299.29,3));
//		listaProdutos.add(new Produto("Iphone 6",0.000089, 2911.12,5));
//		listaProdutos.add(new Produto("Ventilador Panasonic",0.496, 199.90,10));
		
		
		List espacos = new ArrayList<>();
		List valores = new ArrayList<>();
		List nomes = new ArrayList<>();
		
		for (Produto produto : listaProdutos) {
			espacos.add(produto.getEspaco());
			valores.add(produto.getValor());
			nomes.add(produto.getNome());	
		}
		
		Double limite = 3.0;
		
//		Individuo individuo1 = new Individuo(espacos, valores, limite);
//
//		System.out.println("\nindividuo 1 " + individuo1.getCromossomo());
//		individuo1.avaliacao();
//		System.out.println("Nota: " + individuo1.getNotaAvaliacao());
//		System.out.println("Espaço usado: " + individuo1.getEspacoUsado());
//		
//		Individuo individuo2  = new Individuo(espacos, valores, limite);
//		System.out.println("\nindividuo 2 " + individuo2.getCromossomo());
//		individuo2.avaliacao();
//		System.out.println("Nota: " + individuo2.getNotaAvaliacao());
//		System.out.println("Espaço usado: " + individuo2.getEspacoUsado());
//		
//		individuo1.Crossover(individuo2);
		
		int tamanhoPopulacao = 20;
		Double taxaMutacao = 0.01;
		int numeroGeracoes = 100;
		AlgoritmoGenetico ag = new AlgoritmoGenetico(tamanhoPopulacao);		
		List resultado = ag.resolver(taxaMutacao, numeroGeracoes, espacos, valores, limite);
		for(int i = 0; i < listaProdutos.size(); i ++ ){
			if (resultado.get(i).equals("1")) {
				System.out.println("Nome: " + listaProdutos.get(i).getNome());
			}
		}
		
		Grafico g = new Grafico("Algoritmo Genetico", "Evolução das Soluções", ag.getMelhoresCromossomos());
		g.pack();
		RefineryUtilities.centerFrameOnScreen(g);
		g.setVisible(true);
		
				
//		ag.inicizlizaPopulacao(espacos, valores, limite);
//		for(Individuo individuo : ag.getPopulacao()){
//			individuo.avaliacao();
//		}
//		ag.ordenaPopulacao();
//		ag.melhorIndividuo(ag.getPopulacao().get(0));
//		Double soma = ag.somaAvaliacoes();
//		System.out.println("Soma das Avaliações: " + soma);
//		System.out.println("\nMelhor solução para o problema: " +
//				ag.getMelhorSolucao().getCromossomo() +
//				" Nota: " +ag.getMelhorSolucao().getNotaAvaliacao() );
//		Double probabilidadeMutacao = 0.01;
//		List<Individuo> novaPopulacao = new ArrayList<>();
//		for (int i = 0; i < ag.getPopulacao().size() / 2; i++) {
//			int pai1 = ag.selecionaPai(soma);
//			int pai2 = ag.selecionaPai(soma);
//			
//			List<Individuo> filhos = ag.getPopulacao().get(pai1).Crossover(ag.getPopulacao().get(pai2));
//			novaPopulacao.add(filhos.get(0).mutacao(probabilidadeMutacao));
//			novaPopulacao.add(filhos.get(1).mutacao(probabilidadeMutacao));
//		}
//				
//		ag.setPopulacao(novaPopulacao);
//		for (Individuo individuo : ag.getPopulacao()) {
//			individuo.avaliacao();
//		}
//		ag.ordenaPopulacao();
//		ag.melhorIndividuo(ag.getPopulacao().get(0));
//		soma = ag.somaAvaliacoes();
//		System.out.println("Soma das Avaliações: " + soma);
//		System.out.println("\nMelhor solução para o problema: " +
//				ag.getMelhorSolucao().getCromossomo() +
//				" Nota: " +ag.getMelhorSolucao().getNotaAvaliacao() );
		
		
		
	}
	
	
}
