import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class Grafico extends ApplicationFrame{
	
	private List<Individuo> melhoresCromossos = new ArrayList<Individuo>();
	
	public Grafico(String tituloJanela, String tituloGrafico, List melhores) {
		super(tituloJanela);
		this.melhoresCromossos = melhores;
		JFreeChart graficoLinha = ChartFactory.createLineChart(tituloGrafico, "Geração",
				"Valor", carregarDados(), 
				PlotOrientation.VERTICAL,
				true, true, false);
		ChartPanel janelaGrafico =  new ChartPanel(graficoLinha);
		janelaGrafico.setPreferredSize(new java.awt.Dimension(800,600));
		setContentPane(janelaGrafico);
		
		
	}
	
	private DefaultCategoryDataset carregarDados(){ 
		DefaultCategoryDataset dados = new DefaultCategoryDataset();
		
		for (int i = 0; i < melhoresCromossos.size() ; i++) {
			dados.addValue(melhoresCromossos.get(i).getNotaAvaliacao(), "Melhor Solução"
					, "" + i);
		}
		
		return dados;
		
	}

	

}
