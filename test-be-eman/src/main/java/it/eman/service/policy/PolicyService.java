package it.eman.service.policy;

import java.util.Set;

import it.eman.dto.client.ClientDto;
import it.eman.dto.policy.PoliciesDto;
import it.eman.dto.policy.PoliciesOutput;
import it.eman.dto.policy.PolicyDto;

public interface PolicyService {

	PoliciesDto getInitPoliciesList();

	PoliciesOutput getPoliciesListOutput(String typeFilter, String filter);

	Set<PolicyDto> getPoliciesList(String name, String name2);

	Set<PolicyDto> getPoliciesByClientsList(Set<ClientDto> clients);

	PoliciesOutput fromListDtoToListOutput(Set<PolicyDto> list);
}
