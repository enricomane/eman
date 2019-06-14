package it.eman.service.client;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eman.dto.client.ClientDetailOutput;
import it.eman.dto.client.ClientDto;
import it.eman.dto.client.ClientOutput;
import it.eman.dto.client.ClientsDto;
import it.eman.dto.client.ClientsOutput;
import it.eman.dto.policy.PolicyDto;
import it.eman.service.policy.PolicyService;
import it.eman.utils.constants.Constants;
import it.eman.utils.helper.Helper;

@Service
public class ClientServiceImpl implements ClientService {

	private static Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Autowired
	private ClientsDto initClientsList;

	@Autowired
	private PolicyService policyService;

	@Override
	public ClientsOutput getClientsListOutput(String typeFilter, String filter) {
		return fromListDtoToListOutput(getClientsList(typeFilter, filter));
	}

	@Override
	public ClientDetailOutput getClientPolicies(String name) {

		ClientDetailOutput output = new ClientDetailOutput();
		populateClientsList();

		if (StringUtils.isBlank(name)) {
			logger.debug("Id not found");
			return null;
		}

		if (StringUtils.isNotBlank(name)) {

			Set<ClientDto> clients = getClientsList(Constants.NAME, name);
			Set<PolicyDto> policies = policyService.getPoliciesByClientsList(clients);

			if (Helper.nullSafeSet(clients)|| Helper.nullSafeSet(policies)) {
				output = createClientDetailOutput(clients, policies);
			}
		}

		return output;
	}

	@Override
	public ClientsDto getInitClientsList() {
		populateClientsList();
		return initClientsList;
	}

	private Set<ClientDto> getClientsList(String typeFilter, String filter) {
		Set<ClientDto> clientsFiltered = new HashSet<ClientDto>();
		populateClientsList();

		if (typeFilter != null && initClientsList != null && Helper.nullSafeSet(initClientsList.getClients())) {

			switch (typeFilter) {

			case Constants.ID:
				if (StringUtils.isNotBlank(filter)) {
					clientsFiltered = initClientsList.getClients().stream().filter(item -> item.getId().equals(filter))
							.collect(Collectors.toSet());
				} else {
					logger.debug("Filter not found");
				}
				break;

			case Constants.NAME:
				if (StringUtils.isNotBlank(filter)) {
					clientsFiltered = initClientsList.getClients().stream()
							.filter(item -> item.getName().equals(filter)).collect(Collectors.toSet());
				} else {
					logger.debug("Filter not found");
				}
				break;

			default:
				clientsFiltered = initClientsList.getClients();
				break;
			}
		} else {
			logger.error("Clients not found, Maibe list are empty");
		}

		return clientsFiltered;
	}

	private ClientDetailOutput createClientDetailOutput(Set<ClientDto> clients, Set<PolicyDto> policies) {
		ClientDetailOutput output = new ClientDetailOutput();

		if (Helper.nullSafeSet(clients)) {
			output.setClients(fromListDtoToListOutput(clients).getClients());
		}
		if (Helper.nullSafeSet(policies)) {
			output.setPolicies(policyService.fromListDtoToListOutput(policies).getPolicies());
		}

		return output;
	}

	private ClientsOutput fromListDtoToListOutput(Set<ClientDto> list) {

		ClientsOutput output = new ClientsOutput();

		if (Helper.nullSafeSet(list)) {
			list.stream().forEach(item -> output.getClients().add(fromDtoToOutput(item)));
		}

		return output;
	}

	private ClientOutput fromDtoToOutput(ClientDto item) {
		ClientOutput obj = null;

		if (item != null) {
			obj = new ClientOutput();
			obj.setId(item.getId());
			obj.setName(item.getName());
			obj.setEmail(item.getEmail());
			obj.setRole(item.getRole());
		}

		return obj;
	}

	private void populateClientsList() {
		if (initClientsList == null || !Helper.nullSafeSet(initClientsList.getClients())) {
			initClientsList = Helper.castObject(Helper.poulateObject(Constants.CLIENTS), ClientsDto.class);
		}
	}

}
