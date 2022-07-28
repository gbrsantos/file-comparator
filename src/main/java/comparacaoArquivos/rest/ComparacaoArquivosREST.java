package comparacaoArquivos.rest;



import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataParam;

import comparacaoArquivos.dto.ComparacaoArquivoDTO;
import service.ComparacaoArquivoService;

@Path("/comparacao-arquivo")
public class ComparacaoArquivosREST {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response compararArquivos(@FormDataParam("file1") File arquivo1, @FormDataParam("file2") File arquivo2) {
		if(arquivo1 == null || arquivo2 == null)
			return Response.status(Response.Status.PRECONDITION_FAILED).entity("Insira os 2 arquivos").build();
		try {
			ComparacaoArquivoService service = new ComparacaoArquivoService();;
			Double porcentagem = service.verificarPorcentagem(arquivo1, arquivo2);
			return Response.ok(porcentagem).build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
		}		
	}	
}
