package watermark;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelInsertPicture {
	public static void main(String[] args) throws IOException {
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
//		Date date = new Date(System.currentTimeMillis());
//		String time = formatter.format(date);
//		
//		 String InPdfFile = "C:/Users/study/Desktop/temp.xlsx";
//		 String outPdfFile = "C:/Users/study/Desktop/target.xlsx";
//		 String[] markImagePath = {"C:\\Siemens\\Teamcenter11\\2.png"};
//		 ExcelPhoto g = new  ExcelPhoto();
//		 g.addExcelfMark(InPdfFile, outPdfFile, markImagePath);
	}
	
	public  void addExcelfMark(String InPdfFile, String outPdfFile, String markImagePath) throws IOException{
		// 读取excel文档
		// 找到第一个工作页
		FileInputStream fis = new FileInputStream(InPdfFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = null;
		//水映图片路径
		String imgPath = markImagePath;
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			//得到sheet页
			sheet = wb.getSheetAt(i);
			//得到所有列
			int coloumNum = sheet.getRow(0).getPhysicalNumberOfCells()-2;
			//得到所有行
			int rowNum = sheet.getPhysicalNumberOfRows()-2;
			
			//ExcelWaterRemarkUtils.putWaterRemarkToExcel(wb, sheet, imgPath, 0, 10, 9, 52, 3, 50, 1, 1);
			ExcelWater.putWaterRemarkToExcel(wb, sheet, imgPath, coloumNum, rowNum);
		}
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			wb.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		wb.close();
		byte[] content = os.toByteArray();

		File file1 = new File(outPdfFile);// Excel文件生成后存储的位置。
		OutputStream fos = null;

		try {
			fos = new FileOutputStream(file1);
			fos.write(content);
			os.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
