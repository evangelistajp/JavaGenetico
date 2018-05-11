import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlgoritmoGenetico {
	
	private int tamanhoPopulacao;
	private List<Individuo> populacao = new ArrayList<Individuo>();
	private int geracao;
	private Individuo melhorSolucao;
	
	
	public AlgoritmoGenetico(int tamanhoPopulacao) {
		this.tamanhoPopulacao = tamanhoPopulacao;
	}
	
	public void inicizlizaPopulacao(List espacos, List valores, Double limiteEspacos){
		for (int i = 0; i < this.tamanhoPopulacao; i++) {
			this.populacao.add(new Individuo(espacos, valores, limiteEspacos));
			
		}
		this.melhorSolucao = this.populacao.get(0);
	}
	
	public void ordenaPopulacao(){
		Collections.sort(this.populacao);
	}

	public void melhorIndividuo(Individuo individuo){
		if(individuo.getNotaAvaliacao() > this.melhorSolucao.getNotaAvaliacao()){
			this.melhorSolucao = individuo;
		}
	}
	
	public Double somaAvaliacoes(){
		Double soma = 0.0;
		for(Individuo individuo:  this.populacao){
			soma += individuo.getNotaAvaliacao();
		}
		return soma;
	}
	
	public int selecionaPai(Double somaAvalicao){
		int pai = -1;
		Double valorSorteado = Math.random() * somaAvalicao;
		Double soma = 0.0;
		int i = 0;
		while (i <this.populacao.size() && soma < valorSorteado){
			soma += this.populacao.get(i).getNotaAvaliacao();
			pai +=1;
			i += 1;
		}
		return pai;
	}
	
	public void visualizaGeracao(){
		Individuo melhor = this.populacao.get(0);
		System.out.println("G: " + this.populacao.get(0).getGeracao() +
				" Valor: " + melhor.getNotaAvaliacao() +
				" Espa�o: " + melhor.getEspacoUsado() +
				" Cromossomo: " + melhor.getCromossomo());
	}
	
	public int getTamanhoPopulacao() {
		return tamanhoPopulacao;
	}

	public void setTamanhoPopulacao(int tamanhoPopulacao) {
		this.tamanhoPopulacao = tamanhoPopulacao;
	}

	public List<Individuo> getPopulacao() {
		return populacao;
	}

	public void setPopulacao(List<Individuo> populacao) {
		this.populacao = populacao;
	}

	public int getGeracao() {
		return geracao;
	}

	public void setGeracao(int geracao) {
		this.geracao = geracao;
	}

	public Individuo getMelhorSolucao() {
		return melhorSolucao;
	}

	public void setMelhorSolucao(Individuo melhorSolucao) {
		this.melhorSolucao = melhorSolucao;
	}
	
	
	
}
