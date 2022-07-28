package comparacaoArquivos.dto;

import java.io.InputStream;

public class ComparacaoArquivoDTO {
	
	private InputStream arquivo1;
	
	private InputStream arquivo2;
	
	private Long porcentagem;

	public ComparacaoArquivoDTO() {
		
	}

	public InputStream getArquivo1() {
		return arquivo1;
	}

	public void setArquivo1(InputStream arquivo1) {
		this.arquivo1 = arquivo1;
	}

	public InputStream getArquivo2() {
		return arquivo2;
	}

	public void setArquivo2(InputStream arquivo2) {
		this.arquivo2 = arquivo2;
	}

	public Long getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(Long porcentagem) {
		this.porcentagem = porcentagem;
	}
	
	
}
