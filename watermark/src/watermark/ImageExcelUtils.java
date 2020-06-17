package watermark;


import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
//import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import sun.font.FontDesignMetrics;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageExcelUtils {



public static boolean createSignTextImg( String date, String jpgname) {
	
	String doctorName = "发行";
	String hospitalName = "不得复印";
    int width = 120; //255
    int height = 120; //100
    FileOutputStream out = null;
    
    Font doctorNameFont = new Font(null, Font.BOLD, 20);
    Font othorTextFont = new Font(null, Font.BOLD, 20);
    try { // 宽度、高度
        BufferedImage bimage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bimage.createGraphics();
        bimage = g.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
    	
		g.dispose();
		g = bimage.createGraphics();
      
        //bimage = g.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        //g.setColor(bgcolor);
       // g.setColor(Color.getColor("#00000000"));
        //设置颜色
        //g.setColor(Color.WHITE);
        //填充区域
      //  g.fillRect(0, 0,width, height);
        //设置画笔颜色
        g.setColor(new Color(204,41,41));
       //设置画笔宽度
        g.setStroke(new BasicStroke(2));
      
        // g.fillRect(0, 0, width, height); // 画矩形
        
        g.drawOval(2, 2, width-5, height-5);  //画圆形
        
        // 去除锯齿(当设置的字体过大的时候,会出现锯齿)
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       // g.setColor(Color.RED);
//        g.fillRect(0, 0, 8, height);
//        g.fillRect(0, 0, width, 8);
//        g.fillRect(0, height - 8, width, height);
//        g.fillRect(width - 8, 0, width, height);

     //  g.setColor(fontcolor); // 字的颜色
        g.setFont(doctorNameFont); //  字体字形字号
        FontMetrics fm = FontDesignMetrics.getMetrics(doctorNameFont);
        FontDesignMetrics.getMetrics(doctorNameFont);
        int font1_Hight = fm.getHeight();
        int strWidth = fm.stringWidth(doctorName);
        int y = 35;
        int x = (width - strWidth) / 2;
        g.drawString(doctorName, x, y); // 在指定坐标除添加文字

        g.setFont(othorTextFont); // 字体字形字号

        fm = FontDesignMetrics.getMetrics(othorTextFont);
        int font2_Hight = fm.getHeight();
        strWidth = fm.stringWidth(date);
        x = (width - strWidth) / 2;
        g.drawString(date, x, y + font1_Hight); // 在指定坐标除添加文字

        strWidth = fm.stringWidth(hospitalName);
        x = (width - strWidth) / 2;
        g.drawString(hospitalName, x, y + font1_Hight + font2_Hight); // 在指定坐标除添加文字
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        g.dispose();
        
        out = new FileOutputStream(jpgname); // 指定输出文件
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bimage);
        param.setQuality(50f, true);
        encoder.encode(bimage, param); // 存盘
        out.flush();
        return true;
    } catch (Exception e) {
        return false;
    }finally{
        if(out!=null){
            try {
                out.close();
            } catch (IOException e) {
            }
        }
    }
}
public static void main(String[] args) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
//		Date date = new Date(System.currentTimeMillis());
//		String time = sdf.format(date);
//		createSignTextImg(time,"C:\\Users\\study\\Desktop\\pdf.png");
}
}