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
       chart = ChartFactory.createPieChart3D("征集表分析", getDataset(), true,false, false);
       chart.setTitle(new TextTitle("征集表分析", new Font("黑体", Font.ITALIC,22)));
       LegendTitle legend = chart.getLegend();
       legend.setItemFont(new Font("宋体", Font.ITALIC, 14));
       PiePlot3D plot = (PiePlot3D) chart.getPlot();
       plot.setLabelFont(new Font("隶书", Font.ITALIC, 18));
       // 设定背景透明度（0-1.0之间）
       plot.setBackgroundAlpha(0.9f);
       // 设定前景透明度（0-1.0之间）
       plot.setForegroundAlpha(0.50f);
       String unitStyle = "{0}={1}({2})";
       // 设置图例显示样式
       plot.setLabelGenerator(new StandardPieSectionLabelGenerator(unitStyle,NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
       // 设置引用标签显示样式
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
	     //注意这里的类型转化  
	            int count=((Number)obj[0]).intValue();  	    
	             if(obj[1].equals(0)){obj[1]="形式审核中";}
	             if(obj[1].equals(2)){obj[1]="通过形式审核";}
	             if(obj[1].equals(3)){obj[1]="未通过形式审核";}
	             if(obj[1].equals(4)){obj[1]="通过技术审核";}
	             if(obj[1].equals(5)){obj[1]="未通过技术审核";}
	             dataset.setValue((Comparable) obj[1], count);
	             }
	  
              }
       else
         {
    	   while(it.hasNext()){  
             Object[] obj=(Object[]) it.next();  
                 //注意这里的类型转化  
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
