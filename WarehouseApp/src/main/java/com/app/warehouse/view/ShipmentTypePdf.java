package com.app.warehouse.view;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.warehouse.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdf  extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(
			Map<String, Object> model,
			Document document,
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response
			) throws Exception {
		
		// download the file
		response.addHeader("Content-Disposition", "attachment;filename=shipmentTypepdf.pdf");
		
		//font 
		Font f=new Font(Font.HELVETICA, 29,Font.BOLD, Color.BLUE);
		
		Paragraph p=new Paragraph("WELCOME TO SHIPMENT TYPE ",f);
		p.setAlignment(Element.ALIGN_CENTER);
		
		document.add(p);
		
		@SuppressWarnings("unchecked")
		List<ShipmentType> list=(List<ShipmentType>)model.get("list");
		
		PdfPTable table=new PdfPTable(5);
		table.setSpacingBefore(4.0f);
		//table.setTotalWidth(new Float[] {1.0f,1.0f,1.0f,1.0f,1.0f});
		table.setTotalWidth(new float[] {1.0f,1.0f,1.5f,1.0f,1.0f});
		
		table.addCell("ID");
		table.addCell("SHIPMENTTYPE");
		table.addCell("SHIPMENTMODE");
		table.addCell("SHIPMENT ENABLE");
		table.addCell("DESCRIPTION");
		
		for(ShipmentType st:list)
		{
			table.addCell(st.getId().toString());
			table.addCell(st.getShipmentMode());
			table.addCell(st.getShipmentCode());
			table.addCell(st.getEnableShipment());
			table.addCell(st.getDescription());
		}
		document.add(table);
	}

}
