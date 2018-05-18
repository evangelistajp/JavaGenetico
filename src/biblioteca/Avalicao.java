package biblioteca;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class Avalicao extends FitnessFunction{
	
	private final AlgoritmoGenetico algoritmoGenetico;

	public Avalicao(AlgoritmoGenetico algoritmoGenetico) {
		this.algoritmoGenetico = algoritmoGenetico;
	}

	@Override
	protected double evaluate(IChromosome cromossomo) {
		Double nota = 0.0;
		Double somaEspacos = 0.0;
		for (int i = 0; i < cromossomo.size(); i++) {
			if (cromossomo.getGene(i).getAllele().toString().equals("1")) {
				nota += this.algoritmoGenetico.listaProdutos.get(i).getValor();
				somaEspacos += this.algoritmoGenetico.listaProdutos.get(i).getEspaco();
			}
		}
		if (somaEspacos > this.algoritmoGenetico.limite) {
			nota = 1.0;
		}
		return nota;
	}
	
}
