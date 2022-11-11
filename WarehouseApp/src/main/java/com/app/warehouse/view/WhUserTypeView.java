package com.app.warehouse.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.warehouse.model.WHUserType;

public class WhUserTypeView  extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
			// download the file
			response.addHeader("Content-Disposition", "attachment;filename=whuserType.xlsx");
			//read data from controller
			@SuppressWarnings("unchecked")
			List<WHUserType> list=(List<WHUserType>)model.get("obs");
			//create sheet
			Sheet sheet=workbook.createSheet("WHuserType");
			setHead(sheet);
			setBody(sheet,list);
	}

	private void setHead(Sheet sheet) {
				
			Row row=sheet.createRow(0);
			row.createCell(0).setCellValue("ID");
			row.createCell(1).setCellValue("USER TYPE");
			row.createCell(2).setCellValue("USER CODE");
			row.createCell(3).setCellValue("USER FOR");
			row.createCell(4).setCellValue("USER EMAIL");
			row.createCell(5).setCellValue("USER CONTACT");
			row.createCell(6).setCellValue("USER ID TYPE");
			row.createCell(7).setCellValue("IF OTHER");
			row.createCell(8).setCellValue("ID NUMBER");
			
	}

	private void setBody(Sheet sheet, List<WHUserType> list) {
			int rowNum=1;
			for(WHUserType wt:list)
			{
					Row row=sheet.createRow(rowNum++);
					row.createCell(0).setCellValue(wt.getId());
					row.createCell(1).setCellValue(wt.getUserType());
					row.createCell(2).setCellValue(wt.getUserCode());
					row.createCell(3).setCellValue(wt.getUserFor());
					row.createCell(4).setCellValue(wt.getUserEmail());
					row.createCell(5).setCellValue(wt.getUserContact());
					row.createCell(6).setCellValue(wt.getUserIdType());
					row.createCell(7).setCellValue(wt.getIfOther());
					row.createCell(8).setCellValue(wt.getIdNumber());
			}
		
	}

}
