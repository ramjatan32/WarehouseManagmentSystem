package com.app.warehouse.view;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.warehouse.model.WHUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhuserTypePdf  extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(
			Map<String, Object> model,
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response
			) throws Exception {

		// download file
		response.addHeader("Content-Disposition", "attachment;filename=whuserTypep.pdf");
		
		//Font size and 
		Font font=new Font(Font.HELVETICA,20,Font.BOLD, Color.ORANGE);
		
		@SuppressWarnings("unchecked")
		List<WHUserType>list=(List<WHUserType>)model.get("list");
		
		Paragraph p=new Paragraph("WELCOME TO WHUSER TYPE",font);
		p.setAlignment(Element.ALIGN_CENTER);
		document.add(p);
		
		PdfPTable table=new PdfPTable(9);
		table.setSpacingBefore(4.0f);
		table.setTotalWidth(new float[] {1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f});
		table.addCell("ID");
		table.addCell("USER TYPE");
		table.addCell("USER CODE");
		table.addCell("USER FOR");
		table.addCell("USER EMAIL");
		table.addCell("USER CONTACT");
		table.addCell("USER ID TYPE");
		table.addCell("IF OTHER");
		table.addCell("ID NUMBER");
		
		for(WHUserType wt:list)
		{
			table.addCell(wt.getId());
			table.addCell(wt.getUserType());
			table.addCell(wt.getUserCode());
			table.addCell(wt.getUserFor());
			table.addCell(wt.getUserEmail());
			table.addCell(wt.getUserContact());
			table.addCell(wt.getUserIdType());
			table.addCell(wt.getIfOther());
			table.addCell(wt.getIdNumber());
		}
		document.add(table);
	}

}
