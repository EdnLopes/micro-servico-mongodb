package br.com.tnd.ms.entidade;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(value = "configuracoes", noClassnameStored = true)
public class SigConfiguracao {

	@Id
	private ObjectId id;
	
	private String nome;

	private String url;
	
	private String xmlRaiz;
	
	private String path;

	
	public SigConfiguracao() {
	}

	public String getId() {
		return id.toString();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getXmlRaiz() {
		return xmlRaiz;
	}

	public void setXmlRaiz(String xmlRaiz) {
		this.xmlRaiz = xmlRaiz;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "SigConfiguracao [id=" + id + ", nome=" + nome + "]";
	}

}
