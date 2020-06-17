package watermark;


//import java.awt.FontMetrics;
import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.util.Properties;


import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

//import javax.swing.JLabel;



public class PdfInsertPicture {
	/**
	 * 给pdf文件添加水印
	 * 
	 * @param InPdfFile
	 *            要加水印的原pdf文件路径
	 * @param outPdfFile
	 *            加了水印后要输出的路径
	 * @param markImagePath
	 *            水印图片路径
	 * @param pageSize
	 *            原pdf文件的总页数（该方法是我当初将数据导入excel中然后再转换成pdf所以我这里的值是用excel的行数计算出来的，
	 *            如果不是我这种可以 直接用reader.getNumberOfPages()获取pdf的总页数）
	 * @throws Exception
	 */
	
	public static void main(String[] args) throws Exception {
//		PdfPhoto p = new PdfPhoto();
//		String InPdfFile = "C:/Users/study/Desktop/temp.pdf";
//		String outPdfFile = "C:/Users/study/Desktop/target.pdf";
//		String[] markImagePath = {"C:/Users/study/Desktop/sign.jpg"};
//		p.addPdfMark(InPdfFile, outPdfFile, markImagePath);
	}
	
	public void addPdfMark(String InPdfFile, String outPdfFile, String markImagePath) throws Exception {
		// 插入坐标 (Properties是读取Java的配置文件)
//		Properties properties = new Properties();
//		InputStream is = null;
//		//is = this.getClass().getClassLoader().getResourceAsStream("com/connor/jk/pdf/operate/PDFInfo.properties");
//		is = this.getClass().getClassLoader().getResourceAsStream(null);
//		properties.load(is);
		
		
		// PDF 输入文件
		PdfReader reader = new PdfReader(InPdfFile, "PDF".getBytes());
		
		Rectangle pageSize2 = reader.getPageSize(1);
        float height = pageSize2.getHeight();
        float width = pageSize2.getWidth();
        System.out.println(width+"------------"+height);
		// PDF 输出文件
		PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(outPdfFile));
		// 水印图片
		Image img = null;
		//for (int j = 0; j < markImagePath.length; j++) {
			img = Image.getInstance(markImagePath);//获取图片实例
			img.scaleAbsolute(88, 88);// 缩放图片
			//img.setAbsolutePosition(335, 175);
			//图片放的位置
			img.setAbsolutePosition(width-150, 50);
			// 获取pdf的页数
			int pageSize = reader.getNumberOfPages();// 获取输入文件的页数
			for (int i = 1; i <= pageSize; i++) {
				//
				PdfContentByte under = stamp.getOverContent(i);// 
				PdfGState gs = new PdfGState();
				gs.setFillOpacity(1.0f);// 设置透明度为1.0
				under.setGState(gs);
				under.addImage(img);
			}
		//}
		stamp.close();
		reader.close();
	}
	
//	public Float[] getSize(Rectangle rectangle) {
//		Float[] sizef = new Float[2];
//		float toleft = rectangle.getLeft();
//		float tobottom = rectangle.getBottom();
//		float toright = rectangle.getRight();
//		float totop = rectangle.getTop();
//
//		JFomPdfBean bean = new JFomPdfBean();
//		bean.setH(toright - toleft);// PDF的宽
//		bean.setW(totop - tobottom);// PDF的高
//		sizef[0]=bean.getH();
//		sizef[1]=bean.getW();
//
//		return sizef;
//	}
	
}

