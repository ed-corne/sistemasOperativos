
package org.proceso.chart;

import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;





public class Grafico {
    
    public void crearHistograma(int[] histograma,JPanel Panel,Color colorBarra) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
        String []serie = {"A","B","C","D","E","F","G","H","i","J"};
        for (int i = 0; i < histograma.length; i++){
            dataset.addValue(histograma[i], serie[i], "" + 1);
        
    }
        JFreeChart chart = ChartFactory.createBarChart("Histograma", null, null,
                                     dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot trama = (CategoryPlot) chart.getPlot();
        BarRenderer render = (BarRenderer) trama.getRenderer();
        render.setSeriesPaint(0, colorBarra);
        chart.setAntiAlias(true);
        chart.setBackgroundPaint(new Color(214,217,223));
        Panel.removeAll();
        Panel.repaint();
        Panel.setLayout(new java.awt.BorderLayout());
        Panel.add(new ChartPanel(chart));
        Panel.validate();
    }
        
        
    
}
