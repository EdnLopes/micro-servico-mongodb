package br.com.tnd.ms.configuracoes;

import java.io.IOException;
import java.util.Arrays;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

public class LiberaCrossDomainResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {
        
        responseContext.getHeaders().put("Access-Control-Allow-Origin", Arrays.asList("http://localhost"));
        responseContext.getHeaders().put("Access-Control-Allow-Headers", Arrays.asList("Origin", "X-Requested-With", "Content-Type", "Accept"));
        responseContext.getHeaders().put("Access-Control-Allow-Methods", Arrays.asList("GET", "POST", "PUT", "DELETE"));
        
    }

}
