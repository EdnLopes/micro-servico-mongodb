package br.com.tnd.ms.configuracoes;

import java.io.IOException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.converters.DateConverter;

public class MorphiaConnection extends Morphia {

	private static MorphiaConnection connection = null;

	private MorphiaConnection() {
		super();
	}

	public static synchronized Datastore getDataStore() throws IOException {
		if (connection == null) {
			connection = new MorphiaConnection();
			connection.mapPackage("br.com.tnd.ms.entidade");
			connection.getMapper().getConverters().addConverter(new DateConverter());
		}

		return connection.createDatastore(MongoConnection.getConnection(), "admin");
	}
}