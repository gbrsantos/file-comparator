package comparacaoArquivos.rest;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

import javax.crypto.SecretKey;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/login")
public class AuthREST {
	
	@Context
	private HttpServletRequest request;
	
	@Context
	private HttpServletResponse response;
	
	protected void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	protected void setResponse(HttpServletResponse response) {
		this.response = response;
	}	 
		
		@POST
	    @Produces(MediaType.TEXT_PLAIN)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response login()
	    {
	        try{
//	            if(usuario.getUsuario() == null || usuario.getSenha() == null) {
//	            	return Response.status(Response.Status.PRECONDITION_FAILED).build();          	            	
//	            }
//	            AuthService service = new AuthService();
//	            Usuario buscado = null;
//	            buscado = service.verificarLogin(usuario);
//	            if(buscado == null)
//	            	return Response.status(Response.Status.FORBIDDEN).build(); 
//	            if(!verificarCredenciais(usuario, buscado))
//	            	return Response.status(Response.Status.FORBIDDEN).build();
	            HttpSession session = request.getSession();
	            Random random = new SecureRandom();
	            String token = new BigInteger(130, random).toString(32);	            
	            session.setAttribute("token", token);
	            session.setAttribute("expira", LocalDateTime.now().plusHours(2));
                return Response.status(Response.Status.OK).entity(token).build();
	        }
	        catch(Exception ex)
	        {
	        	ex.printStackTrace();
	            return Response.status(
							Response.Status.INTERNAL_SERVER_ERROR
						).entity(ex.getMessage())
						.build();
	        } 
	    }	
		
}
