package br.com.tnd.ms.configuracoes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

public class MongoConnection extends MongoClient {

	private static MongoConnection connection = null;

	private MongoConnection(List<ServerAddress> lista, List<MongoCredential> listaCred) {
		super(lista, listaCred);
	}

	@SuppressWarnings("deprecation")
	public static synchronized MongoClient getConnection() throws IOException {
		if (connection == null) {
			List<ServerAddress> lista = new ArrayList<>();
			lista.add(new ServerAddress("localhost", Integer.valueOf("27017")));
			
			List<MongoCredential> listaCred = new ArrayList<>();
//			listaCred.add(MongoCredential.createCredential(System.getenv("DATABASE_SIG"),
//					System.getenv("USER_DATABASE_SIG"), System.getenv("PASSWORD_DATABASE_SIG").toCharArray()));

			connection = new MongoConnection(lista, listaCred);
			connection.setWriteConcern(WriteConcern.W3);
		}

		return connection;
	}
}