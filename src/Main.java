import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Produto> listaProdutos = new ArrayList<Produto>();
		listaProdutos.add(new Produto("Geladeira Dako",0.751, 999.90));
		listaProdutos.add(new Produto("Geladeira Brastemp",0.635, 849.00));
		listaProdutos.add(new Produto("Geladeira Consul",0.870, 1199.89));
		listaProdutos.add(new Produto("TV 55",0.400, 4346.99));
		listaProdutos.add(new Produto("TV 50",0.290, 399.90));
		listaProdutos.add(new Produto("TV 42",0.200, 2999.00));
		listaProdutos.add(new Produto("Notebook Dell",0.00350, 2499.90));
		listaProdutos.add(new Produto("Notebook Lenovo",0.498, 1999.90));
		listaProdutos.add(new Produto("Notebook Asus",0.527, 3999.00));
		listaProdutos.add(new Produto("Microondas Electrolux",0.0424, 308.66));
		listaProdutos.add(new Produto("Microondas LG",0.0544, 429.90));
		listaProdutos.add(new Produto("Microondas Panasonic",0.0319, 299.29));
		listaProdutos.add(new Produto("Iphone 6",0.000089, 2911.12));
		listaProdutos.add(new Produto("Ventilador Panasonic",0.496, 199.90));
		
		
		List espacos = new ArrayList<>();
		List valores = new ArrayList<>();
		List nomes = new ArrayList<>();
		
		for (Produto produto : listaProdutos) {
			espacos.add(produto.getEspaco());
			valores.add(produto.getValor());
			nomes.add(produto.getNome());	
		}
		
		Double limite = 3.0;
		
		Individuo individuo = new Individuo(espacos, valores, limite);
//		System.out.println("Espaços: " + individuo.getEspacos());
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
		
		individuo.avaliacao();
		System.out.println("Nota: " + individuo.getNotaAvaliacao());
		System.out.println("Espaço usado: " + individuo.getEspacoUsado());
		

	}
	
	

}
