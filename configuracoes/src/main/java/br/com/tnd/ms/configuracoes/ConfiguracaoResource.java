package br.com.tnd.ms.configuracoes;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.tnd.ms.entidade.SigConfiguracao;
import br.com.tnd.ms.repository.MongoRepository;

@Path("/config")
public class ConfiguracaoResource {

    @GET
    @Path("/listar")
    @Produces(value=MediaType.APPLICATION_JSON)
    public Response getResources() {

		try {
			
		 	List<SigConfiguracao> config = new MongoRepository(MorphiaConnection.getDataStore()).findAll(SigConfiguracao.class);
		 	return Response.ok(config).build();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
   	
    }
    
    @GET
    @Path("/{id}")
    @Produces(value=MediaType.APPLICATION_JSON)
    public Response getResourcesPorId(@PathParam("id") String id) {

		try {
			
		 	SigConfiguracao config = new MongoRepository(MorphiaConnection.getDataStore()).getEntidadeById(SigConfiguracao.class, id);
		 	return Response.ok(config).build();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
   	
    }
    
    @POST
    @Path("/alterar")
    public Response alterarConfiguracao(SigConfiguracao config) {

		try {
			
		 	new MongoRepository(MorphiaConnection.getDataStore()).salvarEdicao(config);
		 	return Response.status(Response.Status.CREATED).entity(config).build();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
   	
    }
    
    @POST
    @Path("/salvar")
    public Response salvarConfiguracao(SigConfiguracao config) {

		try {
		 	new MongoRepository(MorphiaConnection.getDataStore()).salvar(config);
		 	return Response.status(Response.Status.CREATED).entity(config).build();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
   	
    }
    
    @POST
    @Path("/excluir")
    public Response excluirConfiguracao(SigConfiguracao config) {

		try {
		 	new MongoRepository(MorphiaConnection.getDataStore()).excluir(config);
		 	return Response.status(Response.Status.CREATED).entity(config).build();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
   	
    }
}
