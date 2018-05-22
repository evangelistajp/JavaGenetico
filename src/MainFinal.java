import org.jfree.ui.RefineryUtilities;
import org.jgap.InvalidConfigurationException;

import biblioteca.AlgoritmoGenetico;

public class MainFinal {
	
	public static void main(String args[]) throws InvalidConfigurationException {
		AlgoritmoGenetico ag = new AlgoritmoGenetico();
		ag.carregar();
		ag.procurarMelhorSolucao();
		
		int geracao = 0;
		for (int i = 0; i < ag.getMelhoresCromossomos().size(); i++) {
			if (ag.getMelhor() == null) {
				ag.setMelhor(ag.getMelhoresCromossomos().get(i));
			}else if(ag.getMelhor().getFitnessValue() < ag.getMelhoresCromossomos().get(i).getFitnessValue()){
				ag.setMelhor(ag.getMelhoresCromossomos().get(i));
				geracao = i;
			}
		}
		System.out.println("\n Melhor Solução");
		ag.visualizaGeracao(ag.getMelhor(), geracao);
		
		for (int i = 0; i < ag.getListaProdutos().size(); i++) {
			if (ag.getMelhor().getGene(i).getAllele().toString().equals("1")) {
				System.out.println("Nome: " +ag.getListaProdutos().get(i).getNome());
			}
		}
		
		Grafico g = new Grafico("Algoritmo Genético", "Evolução das Soluções", ag.getMelhoresCromossomos());
		g.pack();
		RefineryUtilities.centerFrameOnScreen(g);
		g.setVisible(true);
		
	}
	
	
	

}
