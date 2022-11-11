package com.app.warehouse.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.warehouse.model.ShipmentType;

public class ShipmentTypeExcel  extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model,
			Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		// download the file 
		response.addHeader("Content-Disposition","attachment;filename=shipmentType.xlsx");
		
		// read data from controller
		@SuppressWarnings("unchecked")
		List<ShipmentType>list=(List<ShipmentType>)model.get("obs");
		//create sheet
				Sheet sheet=workbook.createSheet("shipmentType");
				setHead(sheet);
				setBody(sheet,list);
	}

	private void setHead(Sheet sheet) {
			Row row=sheet.createRow(0);
			row.createCell(0).setCellValue("ID");
			row.createCell(1).setCellValue("ShipmentMode");
			row.createCell(2).setCellValue("ShipmentCode");
			row.createCell(3).setCellValue("EnabelShipment");
			row.createCell(4).setCellValue("Description");
			
		
	}

	private void setBody(Sheet sheet, List<ShipmentType> list) {
			
			int rowNum=1;
			for(ShipmentType st:list)
			{
				Row row=sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(st.getId());
				row.createCell(1).setCellValue(st.getShipmentMode());
				row.createCell(2).setCellValue(st.getShipmentCode());
				row.createCell(3).setCellValue(st.getEnableShipment());
				row.createCell(4).setCellValue(st.getDescription());
				
			}
	}

}
