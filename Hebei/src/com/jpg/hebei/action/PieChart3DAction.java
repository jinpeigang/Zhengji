package com.jpg.hebei.action;

import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import com.jpg.hebei.dao.PieCharDao;
import com.opensymphony.xwork2.ActionSupport;

public class PieChart3DAction extends ActionSupport {
  private String biaoyin;
  private PieCharDao pieCharDao; 
  private JFreeChart chart;
     public JFreeChart getChart() {
       chart = ChartFactory.createPieChart3D("���������", getDataset(), true,false, false);
       chart.setTitle(new TextTitle("���������", new Font("����", Font.ITALIC,22)));
       LegendTitle legend = chart.getLegend();
       legend.setItemFont(new Font("����", Font.ITALIC, 14));
       PiePlot3D plot = (PiePlot3D) chart.getPlot();
       plot.setLabelFont(new Font("����", Font.ITALIC, 18));
       // �趨����͸���ȣ�0-1.0֮�䣩
       plot.setBackgroundAlpha(0.9f);
       // �趨ǰ��͸���ȣ�0-1.0֮�䣩
       plot.setForegroundAlpha(0.50f);
       String unitStyle = "{0}={1}({2})";
       // ����ͼ����ʾ��ʽ
       plot.setLabelGenerator(new StandardPieSectionLabelGenerator(unitStyle,NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
       // �������ñ�ǩ��ʾ��ʽ
       plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator(unitStyle, NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
       
       
       return chart;
      }
       
      private DefaultPieDataset getDataset() {
         DefaultPieDataset dataset = new DefaultPieDataset();
           List list=pieCharDao.pieChar(getBiaoyin());
           Iterator it= list.iterator();  
        if(getBiaoyin().equals("flage"))
            {	  
	          while(it.hasNext()){  
	           Object[] obj=(Object[]) it.next();  
	     //ע�����������ת��  
	            int count=((Number)obj[0]).intValue();  	    
	             if(obj[1].equals(0)){obj[1]="��ʽ�����";}
	             if(obj[1].equals(2)){obj[1]="ͨ����ʽ���";}
	             if(obj[1].equals(3)){obj[1]="δͨ����ʽ���";}
	             if(obj[1].equals(4)){obj[1]="ͨ���������";}
	             if(obj[1].equals(5)){obj[1]="δͨ���������";}
	             dataset.setValue((Comparable) obj[1], count);
	             }
	  
              }
       else
         {
    	   while(it.hasNext()){  
             Object[] obj=(Object[]) it.next();  
                 //ע�����������ת��  
              int count=((Number)obj[0]).intValue();  
              dataset.setValue((Comparable) obj[1], count);
    /* System.out.println("count: "+count);  
      System.out.println(obj[0]+" "+obj[1]); */ 
             }
         }
        
        return dataset;
      } 
      
      public  String execute()
      {
    	  return "success";
      }

      public void setChart(JFreeChart chart) {
          this.chart = chart;
        }
public String getBiaoyin() {
	return biaoyin;
}

public void setBiaoyin(String biaoyin) {
	this.biaoyin = biaoyin;
}
public PieCharDao getPieCharDao() {
	return pieCharDao;
}
@Resource
public void setPieCharDao(PieCharDao pieCharDao) {
	this.pieCharDao = pieCharDao;
}
}
