package it.eman.dto.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings({"serial","rawtypes", "unchecked"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientsOutput implements Serializable{
	
	@JsonProperty("clients")
	private List<ClientOutput> clients = new ArrayList();

	public List<ClientOutput> getClients() {
		return clients;
	}

	public void setClients(List<ClientOutput> clients) {
		this.clients = clients;
	}
	
}
