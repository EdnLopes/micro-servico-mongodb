package br.com.tnd.ms.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

public class MongoRepository {

	Datastore dataStore;

	public MongoRepository(Datastore dataStore) {
		this.dataStore = dataStore;
	}

	public <T> void salvar(T entidade) throws Exception {
		try {
			dataStore.save(entidade);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
		
	public <T> void salvarEdicao(T entidade) throws Exception {
		try {
			dataStore.merge(entidade);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public <T> void excluir(T entidade) throws Exception {
		try {
			dataStore.delete(entidade);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T getEntidadeById(Class<T> classe, String id) throws Exception {
		try {
			Query<?> query = dataStore.createQuery(classe).field("_id").equal(new ObjectId(id));
			return (T) query.asList().get(0);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage() + "id: "+ id);
		}
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<T> classe) throws Exception {
		try {
			Query<?> query = dataStore.createQuery(classe);
			return (List<T>) query.asList();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
