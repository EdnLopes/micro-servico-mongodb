package br.com.tnd.ms.configuracoes;

import java.util.logging.Logger;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;


@ApplicationPath("/")
public class ConfiguracaoApplication extends ResourceConfig {
	
	public ConfiguracaoApplication() {
		// registra no Jersey os pacotes contendo as classes de resource REST
		packages("br.com.tnd.ms.configuracoes");

		// define como default o log do java
		Logger log = Logger.getGlobal();
		register(new LoggingFilter(log, true));

		// registrando filtro para liberacao de acesso Cross Domain
		register(new LiberaCrossDomainResponseFilter());
	}
}