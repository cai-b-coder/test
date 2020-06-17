package watermark;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

/**
 * 生成水印图片 (pdf的)
 */
public final class ImagePdfUtils {
	
	
	
 public static void main(String[] args) throws IOException {
//	SimpleDateFormat formatter= new SimpleDateFormat("yyyy.MM.dd");
//	Date date = new Date(System.currentTimeMillis());
//	String time = formatter.format(date);
//	//createWaterMark("文字水印效果","C:\\Siemens\\Teamcenter11\\sign.png");
//	createWaterMark(time,"C:\\Siemens\\Teamcenter11\\sign.png");
 }
 
  
	  
	/**
	 * 
	 * @param content
	 * @throws IOException
	 * 
	 */
	public static void createWaterMark(String content,String path) throws IOException{

		String one = "发 行";
		String three = "不得复印";
		Integer width = 600;
		Integer height = 450;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);// 获取bufferedImage对象
		String fontType = "宋体";
		Integer fontStyle = Font.BOLD;//文字加粗
		Integer fontSize = 70;
		Font font = new Font(fontType, fontStyle, fontSize);
		Graphics2D g2d = image.createGraphics(); // 获取Graphics2d对象
		image = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
	
		g2d.dispose();
		g2d = image.createGraphics();
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(6));
		g2d.drawOval(2, 2, width-5, height-5);  //画一个圆形
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//g2d.setColor(new Color(0, 0, 0, 50)); //设置字体颜色和透明度
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(1)); // 设置字体
		g2d.setFont(font); // 设置字体类型  加粗 大小
		//g2d.rotate(Math.toRadians(-10),(double) image.getWidth() / 2, (double) image.getHeight() / 2);//设置倾斜度
		
		FontRenderContext context = g2d.getFontRenderContext();
		Rectangle2D bounds = font.getStringBounds(content, context);
		double x = (width - bounds.getWidth()) / 2;
		double y = (height - bounds.getHeight()) / 2;
		double ascent = -bounds.getY();
		double baseY = y + ascent;
		// 写入水印文字原定高度过小，所以累计写水印，增加高度
		g2d.drawString(content, (int)x, (int)baseY); //时间

		g2d.drawString(one,(int)x+105, 150); 		//发行
		g2d.drawString(three, (int)x+50, 350);		//不得复印
		
		// 设置透明度
		//g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
		// 释放对象
		g2d.dispose();
		ImageIO.write(image, "png", new File(path));
	}
   
	
}