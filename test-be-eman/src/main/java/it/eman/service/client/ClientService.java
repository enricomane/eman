package it.eman.service.client;

import it.eman.dto.client.ClientDetailOutput;
import it.eman.dto.client.ClientsDto;
import it.eman.dto.client.ClientsOutput;

public interface ClientService {

	ClientsDto getInitClientsList();

	ClientDetailOutput getClientPolicies(String name);

	ClientsOutput getClientsListOutput(String typeFilter, String filter);

}
