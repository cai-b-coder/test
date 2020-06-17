package watermark;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Runner {
	public static void main(String[] args) throws Exception {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
		Date date = new Date(System.currentTimeMillis());
		String time = formatter.format(date);
//		ImageExcelUtils.createSignTextImg(time, "C:\\Siemens\\Teamcenter11\\excel.png");
		ImagePdfUtils.createWaterMark(time, "C:\\Siemens\\Teamcenter11\\pdf.png");
//		ImageWordUtils.createSignTextImg(time, "C:\\Siemens\\Teamcenter11\\word.png");
		
//		 PdfInsertPicture pdf = new PdfInsertPicture();
//		 String InPdfFile = "C:/Users/study/Desktop/temp.pdf";
//		 String outPdfFile = "C:/Users/study/Desktop/tempff.pdf";
//		 String markImagePath = "C:/Users/study/Desktop/pdf.png";
//		 pdf.addPdfMark(InPdfFile, outPdfFile, markImagePath);
//		 
//		 ExcelInsertPicture excel = new ExcelInsertPicture();
//		 String InPdfFile2 = "C:/Users/study/Desktop/temp.xlsx";
//		 String outPdfFile2 = "C:/Users/study/Desktop/target.xlsx";
//		 String markImagePath2 = "C:/Users/study/Desktop/excel.png";
//		 excel.addExcelfMark(InPdfFile2, outPdfFile2, markImagePath2);
//		 
//		  WordInsertPicture wordObj = WordInsertPicture.getInstance();
//		  //wordObj.addWaterMark("c://pngpict//横琴网上办事大厅网络拓扑图.docx","c://pngpict//shuiyinImage.png");
//		  wordObj.addWaterMark("C:/Users/study/Desktop/temp.doc",
//				  "C:/Users/study/Desktop/tempssssssss.docx",
//				  "C:/Users/study/Desktop/word.png");
		
		String inputPath = args[0];
		String outPath = args[1];
		String markImagePath = "";
		if(outPath.endsWith("pdf")){
			 markImagePath = "C:\\Siemens\\Teamcenter11\\pdf.png" ;
			 PdfInsertPicture pdf = new PdfInsertPicture();
			 pdf.addPdfMark(inputPath, outPath, markImagePath);
			 //System.out.println("pdf添加水映成功");
		}
		//else if(outPath.endsWith("doc")||outPath.endsWith("docx")){
		else if(outPath.endsWith("word")){
			 markImagePath = "C:\\Siemens\\Teamcenter11\\word.png" ;
			 WordInsertPicture wordObj = WordInsertPicture.getInstance();		
			 wordObj.addWaterMark(inputPath, outPath, markImagePath,wordObj);
			// System.out.println("word添加水印成功");
		}
		//else if(outPath.endsWith("xls")||outPath.endsWith("xlsx")){
		else if(outPath.endsWith("excel")){
			markImagePath = "C:\\Siemens\\Teamcenter11\\excel.png";
			ExcelInsertPicture excel = new ExcelInsertPicture();
			excel.addExcelfMark(inputPath, outPath, markImagePath);
			//System.out.println("excel添加水印成功");
		}
		else{
			System.out.println("没有对应的文档可以添加水映");
		}
		
		/*
	type_class : ItemRevision
	type_class : Dataset
	type_class : Dataset
	type_class : Dataset
	111111111
	second_tag_type => PDF
	insert_pdf

	java -jar "C:\Siemens\Teamcenter11\bin\insert_pdf.jar"
	"C:\Users\ADMINI~1\AppData\Local\Temp\f__pdf_b2t03b08ie2e1.pdf.pdf"
	"C:\Users\ADMINI~1\AppData\Local\Temp\f__pdf_b2t03b08ie2e1.pdf"
	pdf水印添加成功
			 */
	
	}
}
