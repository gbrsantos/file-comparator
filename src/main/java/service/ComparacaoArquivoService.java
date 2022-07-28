package service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import comparacaoArquivos.dto.ComparacaoArquivoDTO;
import de.redsix.pdfcompare.CompareResultImpl;
import de.redsix.pdfcompare.PdfComparator;
import de.redsix.pdfcompare.RenderingException;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

public class ComparacaoArquivoService {

	
	private String extractTextFromScannedDocument(PDDocument document) throws IOException, TesseractException {

		// Extract images from file
		PDFRenderer pdfRenderer = new PDFRenderer(document);
		StringBuilder out = new StringBuilder();
		

		//In case you don't have your own tessdata, let it also be extracted for you
		File tessDataFolder = LoadLibs.extractTessResources("tessdata");

		//Set the tessdata path
		

		ITesseract _tesseract = new Tesseract();
		_tesseract.setDatapath(tessDataFolder.getAbsolutePath());
		//_tesseract.setDatapath("tessdata");
		_tesseract.setLanguage("eng");

		for (int page = 0; page < document.getNumberOfPages(); page++) {
		    BufferedImage bufferedImage = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);

		    // Create a temp image file
		    File tempFile = File.createTempFile("tempfile_" + page, ".png");
		    ImageIO.write(bufferedImage, "png", tempFile);

		    String result = _tesseract.doOCR(tempFile);
		    out.append(result);

		    // Delete temp file
		    tempFile.delete();

		}

		return out.toString();

	    }

	public Double verificarPorcentagem(File file1, File file2) throws IOException {
		
		CompareResultImpl resultFinal;
		
		try {
			PdfComparator pdf = new PdfComparator(convertFileToInputStream(file1), convertFileToInputStream(file2));
			resultFinal = pdf.compare();
		} catch (RenderingException e) {			
			e.printStackTrace();
			throw e;
		} catch (IOException e) {			
			e.printStackTrace();
			throw e;
		}
		Map<Integer, Double> intervaloValoresFinais = resultFinal.getPageDiffsInPercent();

		Double porcentagem = Double.parseDouble(intervaloValoresFinais.toString().substring(3, 5));
		return porcentagem;
	}

	private InputStream convertFileToInputStream(File file) throws IOException {
		try {
			InputStream targetStream = FileUtils.openInputStream(file);
			return targetStream;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
}
