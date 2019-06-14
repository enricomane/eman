package it.eman.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import it.eman.dto.client.ClientsDto;
import it.eman.dto.gnome.BrastlewarkListDto;
import it.eman.dto.policy.PoliciesDto;
import it.eman.utils.constants.Constants;
import it.eman.utils.mapper.JsonObjMapper;

@Scope("singleton")
public class InitializerImpl implements Initializer {

	private static Logger logger = LoggerFactory.getLogger(InitializerImpl.class);

	public InitializerImpl() {
		super();
		Unirest.setObjectMapper(new JsonObjMapper());
	}

	@Override
	public ClientsDto populateClientsList() throws UnirestException {

		ClientsDto clientsDto = new ClientsDto();
		HttpResponse<ClientsDto> clients = Unirest.get(Constants.CLIENTS_URL).asObject(ClientsDto.class);
		clientsDto.setClients(clients.getBody().getClients());
		logger.debug("Clients: " + clientsDto.getClients().size());
		return clientsDto;
	}

	@Override
	public PoliciesDto populatePoliciesList() throws UnirestException {

		PoliciesDto policiesDto = new PoliciesDto();
		HttpResponse<PoliciesDto> policies = Unirest.get(Constants.POLICIES_URL).asObject(PoliciesDto.class);

		policiesDto.setPolicies(policies.getBody().getPolicies());
		logger.debug("Policies: " + policiesDto.getPolicies().size());
		return policiesDto;
	}

	@Override
	public BrastlewarkListDto populateBrastlewarkList() throws UnirestException {
		BrastlewarkListDto gnomeTown = new BrastlewarkListDto();
		HttpResponse<BrastlewarkListDto> gnomes = Unirest.get(Constants.GNOME_URL)
				.asObject(BrastlewarkListDto.class);

		gnomeTown.setBrastlewark(gnomes.getBody().getBrastlewark());
		logger.debug("Brastlewark: " + gnomeTown.getBrastlewark().size());
		return gnomeTown;
	}

}
