package Logica;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeradorDeRelatorios {
	public static void gerarRelatorioCompleto(CentralDeInformacoes c) {
		Document documento = new Document(PageSize.A4);
		
		if(c.getLeiloesCadastrados().size()!=0) {
			try {
				FileOutputStream os = new FileOutputStream("Relatório Completo.pdf");
				PdfWriter.getInstance(documento, os);
				documento.open();

				for (Usuario usuario : c.getUsuariosCadastrados()) {
					documento.add(new Paragraph(usuario.getNome()));

					for(Leilao leilao: c.recuperarLeiloesDeUmUsuario(usuario.getNome()))
						documento.add(new Paragraph(leilao.getInformacoesL()));
					documento.add(new Paragraph("\n"));
				}

				documento.close();
			} catch (DocumentException de) {
				System.err.println(de.getMessage());
			} catch (IOException io) {
				System.err.println(io.getMessage());
			}
		}
	}
}