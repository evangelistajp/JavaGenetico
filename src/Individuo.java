import java.util.ArrayList;
import java.util.List;

public class Individuo implements Comparable<Individuo> {
	
	private List espacos = new ArrayList<>();
	private List valores= new ArrayList<>();
	private Double limiteEspaços;
	private Double notaAvaliacao;
	private Double espacoUsado;
	private int geracao = 0;
	private List cromossomo = new ArrayList<>();
	
	
	public Individuo(List espacos, List valores, Double limiteEspacos){
		this.espacos = espacos;
		this.valores = valores;
		this.limiteEspaços = limiteEspacos;
		this.notaAvaliacao = 0.0;
		this.espacoUsado = 0.0;
		this.geracao = 0;
		
		for (int i = 0; i < this.espacos.size(); i++) {
			if(java.lang.Math.random() < 0.5){
				this.cromossomo.add("0");
			}else{
				this.cromossomo.add("1");
			}
		}
		
	}
	
	public void avaliacao(){
		Double nota = 0.0;
		Double somaEspacos = 0.0;
		
		for (int i = 0; i < this.cromossomo.size(); i++) {
			if (this.cromossomo.get(i).equals("1")) {
				nota+= (Double) this.valores.get(i);
				somaEspacos += (Double) this.espacos.get(i);
			}
		}
		if (somaEspacos > this.limiteEspaços) {
			nota = 1.0;
		}
		
		this.notaAvaliacao = nota;
		this.espacoUsado = somaEspacos;
		
	}
	
	public List Crossover (Individuo outro){
		int corte = (int) Math.round(Math.random() * this.cromossomo.size());
//		System.out.println("\nCorte " + corte);
		List filho1 = new ArrayList<>();
		filho1.addAll(outro.getCromossomo().subList(0, corte));
		filho1.addAll(this.cromossomo.subList(corte, this.cromossomo.size()));
		
		List filho2 = new ArrayList<>();
		filho2.addAll(this.cromossomo.subList(0, corte));
		filho2.addAll(outro.getCromossomo().subList(corte, this.cromossomo.size()));
		
		List<Individuo> filhos = new ArrayList<>();
		filhos.add(new Individuo(this.espacos, this.valores, this.limiteEspaços));
		filhos.add(new Individuo(this.espacos, this.valores, this.limiteEspaços));
		
		filhos.get(0).setCromossomo(filho1);
		filhos.get(0).setGeracao(this.geracao + 1);
//		System.out.println("Filho 1 " + filhos.get(0).getCromossomo());
		filhos.get(1).setCromossomo(filho2);
		filhos.get(1).setGeracao(this.geracao + 1);
//		System.out.println("Filho 2 " + filhos.get(1).getCromossomo());
		
		return filhos;
	}
	
	public Individuo mutacao(Double taxaMutacao){
//		System.out.println("\nAntes da mutação:   " + this.cromossomo);
		for (int i = 0; i < this.cromossomo.size(); i++) {
			if (Math.random() < taxaMutacao) {
				if (this.cromossomo.get(i).equals("1")) {
					this.cromossomo.set(i, "0");
				}else{
					this.cromossomo.set(i, "1");
				}
			}
		}
//		System.out.println("Despois da Mutação: " + this.cromossomo + "\n");
		return this;
	}

	public List getEspacos() {
		return espacos;
	}


	public void setEspacos(List espacos) {
		this.espacos = espacos;
	}


	public List getValores() {
		return valores;
	}


	public void setValores(List valores) {
		this.valores = valores;
	}


	public Double getLimiteEspaços() {
		return limiteEspaços;
	}


	public void setLimiteEspaços(Double limiteEspaços) {
		this.limiteEspaços = limiteEspaços;
	}


	public Double getNotaAvaliacao() {
		return notaAvaliacao;
	}


	public void setNotaAvaliacao(Double notaAvaliacao) {
		this.notaAvaliacao = notaAvaliacao;
	}


	public int getGeracao() {
		return geracao;
	}


	public void setGeracao(int geracao) {
		this.geracao = geracao;
	}


	public List getCromossomo() {
		return cromossomo;
	}


	public void setCromossomo(List cromossomo) {
		this.cromossomo = cromossomo;
	}


	public Double getEspacoUsado() {
		return espacoUsado;
	}


	public void setEspacoUsado(Double espacoUsado) {
		this.espacoUsado = espacoUsado;
	}

	@Override
	public int compareTo(Individuo o) {
		if(this.notaAvaliacao > o.getNotaAvaliacao()){
			return -1;
		}
		if (this.notaAvaliacao < o.getNotaAvaliacao()) {
			return 1;
		}
		return 0;
	}
	
	
	
	

}
