package it.eman.dto.client;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
public class ClientsDto implements Serializable {

	private Set<ClientDto> clients = new HashSet();

	public ClientsDto() {
		super();
	}

	public Set<ClientDto> getClients() {
		return clients;
	}

	public void setClients(Set<ClientDto> clients) {
		this.clients = clients;
	}

}
