package com.app.warehouse.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.warehouse.model.Uom;

public class UomExcelView  extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		//1. download file name
		response.addHeader("Content-Disposition", "attachment;filename=UomType.xlsx");
		
		// read data from controller
		@SuppressWarnings("unchecked")
		List<Uom> list=(List<Uom>)model.get("obs");
		
		//create sheet
		Sheet sheet=workbook.createSheet("UomType");
		
		setHead(sheet);
		setBody(sheet,list);
	}

	private void setHead(Sheet sheet) {
			Row row=sheet.createRow(0);
			row.createCell(0).setCellValue("ID");
			row.createCell(1).setCellValue("UOM TYPE");
			row.createCell(2).setCellValue("UOM MODEL");
			row.createCell(3).setCellValue("DESCRIPTION");
	}
	private void setBody(Sheet sheet, List<Uom> list) {
			int rowNum=1;
			for(Uom um:list)
			{
				Row row=sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(um.getId());
				row.createCell(1).setCellValue(um.getUomType());
				row.createCell(2).setCellValue(um.getUomModel());
				row.createCell(3).setCellValue(um.getDescription());
				
			}

	}
}
