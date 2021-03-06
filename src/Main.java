import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class Main {
	
public static void main(String[] args) {
		
		List<Produto> listaProdutos = new ArrayList<Produto>();
//		listaProdutos.add(new Produto("Geladeira Dako",0.751, 999.90));
//		listaProdutos.add(new Produto("Geladeira Brastemp",0.635, 849.00));
//		listaProdutos.add(new Produto("Geladeira Consul",0.870, 1199.89));
//		listaProdutos.add(new Produto("TV 55",0.400, 4346.99));
//		listaProdutos.add(new Produto("TV 50",0.290, 399.90));
//		listaProdutos.add(new Produto("TV 42",0.200, 2999.00));
//		listaProdutos.add(new Produto("Notebook Dell",0.00350, 2499.90));
//		listaProdutos.add(new Produto("Notebook Lenovo",0.498, 1999.90));
//		listaProdutos.add(new Produto("Notebook Asus",0.527, 3999.00));
//		listaProdutos.add(new Produto("Microondas Electrolux",0.0424, 308.66));
//		listaProdutos.add(new Produto("Microondas LG",0.0544, 429.90));
//		listaProdutos.add(new Produto("Microondas Panasonic",0.0319, 299.29));
//		listaProdutos.add(new Produto("Iphone 6",0.000089, 2911.12));
//		listaProdutos.add(new Produto("Ventilador Panasonic",0.496, 199.90));
		
		
		
		
		List espacos = new ArrayList<>();
		List valores = new ArrayList<>();
		List nomes = new ArrayList<>();
		
		for (Produto produto : listaProdutos) {
			espacos.add(produto.getEspaco());
			valores.add(produto.getValor());
			nomes.add(produto.getNome());	
		}
		
		Double limite = 3.0;
//		Individuo individuo = new Individuo(espacos, valores, limite);
//		System.out.println("Espa�os: " + individuo.getEspacos());
//		System.out.println("Valores: " + individuo.getValores());
//		System.out.println("Cromossomo: " + individuo.getCromossomo());		
//		
//		System.out.println("\n Componentes da Carga");
//		
//		for (int i = 0; i < listaProdutos.size(); i++) {
//			if (individuo.getCromossomo().get(i) ==  "1" ) {
//				System.out.println(i+1 + " Nome: " + listaProdutos.get(i).getNome() +
//				" RS: " + listaProdutos.get(i).getValor());
//			}
//			
//		}
		int tamanhoPopulacao = 20;
		AlgoritmoGenetico ag = new AlgoritmoGenetico(tamanhoPopulacao);
		ag.inicizlizaPopulacao(espacos, valores, limite);
		for(Individuo individuo : ag.getPopulacao()){
			individuo.avaliacao();
		}
		ag.ordenaPopulacao();
		ag.melhorIndividuo(ag.getPopulacao().get(0));
		
//		for (int i = 0; i < ag.getTamanhoPopulacao(); i++) {
//			System.out.println("\n***** Indiviudo " + i + " *******\n Espa�os = "+
//					ag.getPopulacao().get(i).getEspacos() +
//					"\nValores = " + ag.getPopulacao().get(i).getValores()+
//					"\nCromossomo = " + ag.getPopulacao().get(i).getCromossomo()+
//					"\nNota = " + ag.getPopulacao().get(i).getNotaAvaliacao());
//			
//		}
//		
		System.out.println("\nMelhor solu��o para o problema: " +
				ag.getMelhorSolucao().getCromossomo() +
				" Nota: " +ag.getMelhorSolucao().getNotaAvaliacao() );
		Double soma = ag.somaAvaliacoes();
		System.out.println("Soma das Avalia��es: " + soma);
		for (int i = 0; i < ag.getPopulacao().size() / 2; i++) {
			int pai1 = ag.selecionaPai(soma);
			int pai2 = ag.selecionaPai(soma);
		}
	}	

}
