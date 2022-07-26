package comparacaoArquivos.rest;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import comparacaoArquivos.dto.ComparacaoArquivoDTO;

@Path("/comparacao-arquivo")
public class ComparacaoArquivosREST {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response compararArquivos() {
		
		return Response.status(Response.Status.OK).build();
	}
	
}
