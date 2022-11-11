package com.app.warehouse.view;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.warehouse.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response
			) throws Exception {

		// download the document
		response.addHeader("Content-Disposition", "attachment;filename=Uompdf.pdf");
		
		//provide custom font details
		Font f=new Font(Font.HELVETICA,20, Font.BOLD, Color.BLUE);
		
		//create element of paragraph with font
		Paragraph p=new Paragraph("WELCOME TO UOM TYPE ",f);
		p.setAlignment(Element.ALIGN_CENTER);
		
		//add element to document else  it will not display at PDF
		document.add(p);
		

		//reading data from Controller using Model
		@SuppressWarnings("unchecked")
		List<Uom>list=(List<Uom>)model.get("list");
		
		//Create one table with no.of columns to be display
		PdfPTable table =new PdfPTable(4);
		table.setSpacingBefore(4.0f);
		table.setTotalWidth(new float [] {2.0f,1.0f,1.5f,2.0f});
		
		
		table.addCell("ID");
		table.addCell("UOM TYPE");
		table.addCell("UOM MODEL");
		table.addCell("DESCRIPTION");
		
		for(Uom u:list)
		{
			table.addCell(u.getId());
			table.addCell(u.getUomType());
			table.addCell(u.getUomModel());
			table.addCell(u.getDescription());
		}
		
		document.add(table);
	}

}
