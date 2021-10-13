
package modelo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class PlantillaPDF {
  private String escuela;
  private String codigoPlan;
  private String fechaVigencia;
  private int totalCursos;
  private int totalCreditos;
  private ArrayList<Object[]> infoCursos;
  private Document documento;
  private FileOutputStream archivo;
  private Paragraph titulo;
  
  public PlantillaPDF(String pEscuela, String pCodigoPlan, String pFechaVigencia ,
          ArrayList<Object[]> pInfoCursos,
          int pTotalCursos, int pTotalCreditos){
    this.escuela = pEscuela;
    this.codigoPlan = pCodigoPlan;
    this.fechaVigencia = pFechaVigencia;
    this.infoCursos = pInfoCursos;
    this.totalCursos = pTotalCursos;
    this.totalCreditos = pTotalCreditos;
    documento = new Document();
    titulo = new Paragraph("Planes de Estudio");
  }
  
  public boolean crearPlantilla(){
    try {
      this.archivo = new FileOutputStream("planestudio.pdf");
      PdfWriter.getInstance(documento, archivo);
      documento.open();
      titulo.setAlignment(1);
      documento.add(titulo);
      documento.add(Chunk.NEWLINE);
      documento.add(new Paragraph("Escuela propietaria: " + escuela));
      documento.add(new Paragraph("Fecha de vigencia: " + fechaVigencia));
      documento.add(Chunk.NEWLINE);
      
      PdfPTable tabla = new PdfPTable(5);
      tabla.setWidthPercentage(100);
      PdfPCell codigoCurso = new PdfPCell(new Phrase("Código del curso"));
      PdfPCell nombreCurso = new PdfPCell(new Phrase("Nombre del curso"));
      PdfPCell bloque = new PdfPCell(new Phrase("Bloque"));
      PdfPCell horasClase = new PdfPCell(new Phrase("Horas de clase"));
      PdfPCell creditos = new PdfPCell(new Phrase("Créditos"));
      
      codigoCurso.setBackgroundColor(BaseColor.BLUE);
      nombreCurso.setBackgroundColor(BaseColor.BLUE);
      bloque.setBackgroundColor(BaseColor.BLUE);
      horasClase.setBackgroundColor(BaseColor.BLUE);
      creditos.setBackgroundColor(BaseColor.BLUE);
      
      tabla.addCell(codigoCurso);
      tabla.addCell(nombreCurso);
      tabla.addCell(bloque);
      tabla.addCell(horasClase);
      tabla.addCell(creditos);
      
      for (Object[] fila : this.infoCursos){
        for (int i = 0; i < fila.length; i++){
          tabla.addCell(fila[i].toString());
        }
      }
      
      documento.add(tabla);
      
      documento.add(Chunk.NEWLINE);
      documento.add(new Paragraph("Cursos totales: " + totalCursos));
      documento.add(new Paragraph("Créditos totales: " + totalCreditos));
     
      documento.close();
      return true;
      
    } catch (FileNotFoundException | DocumentException e){
      System.err.println(e.getMessage());
      return false;
    }
  }
}
