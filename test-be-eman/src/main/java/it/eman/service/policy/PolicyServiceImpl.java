package it.eman.service.policy;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eman.dto.client.ClientDto;
import it.eman.dto.policy.PoliciesDto;
import it.eman.dto.policy.PoliciesOutput;
import it.eman.dto.policy.PolicyDto;
import it.eman.dto.policy.PolicyOutput;
import it.eman.utils.constants.Constants;
import it.eman.utils.helper.Helper;

@Service
public class PolicyServiceImpl implements PolicyService {

	private static Logger logger = LoggerFactory.getLogger(PolicyServiceImpl.class);

	@Autowired
	private PoliciesDto initPoliciesList;

	@Override
	public PoliciesOutput getPoliciesListOutput(String typeFilter, String filter) {
		return fromListDtoToListOutput(this.getPoliciesList(typeFilter, filter));
	}

	@Override
	public Set<PolicyDto> getPoliciesList(String typeFilter, String filter) {
		Set<PolicyDto> policiesFiltered = new HashSet<PolicyDto>();
		populatePoliciesList();

		if (typeFilter != null && initPoliciesList != null && Helper.nullSafeSet(initPoliciesList.getPolicies())) {

			switch (typeFilter) {

			case Constants.ID:
				if (StringUtils.isNotBlank(filter)) {
					policiesFiltered = initPoliciesList.getPolicies().stream()
							.filter(item -> item.getClientId().equals(filter)).collect(Collectors.toSet());
				} else {
					logger.debug("Filter not found");
				}
				break;
				
			default:
				policiesFiltered = null;
				break;
			}
		} else {
			logger.error("Policies not found, Maibe list are empty");
		}

		return policiesFiltered;

	}

	@Override
	public PoliciesDto getInitPoliciesList() {
		populatePoliciesList();
		return initPoliciesList;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Set<PolicyDto> getPoliciesByClientsList(Set<ClientDto> clients) {

		Set<PolicyDto> policiesFiltered = new HashSet();

		if (Helper.nullSafeSet(clients)) {
			for (ClientDto client : clients) {
				Set<PolicyDto> policies = getPoliciesList(Constants.ID, client.getId());
				if (Helper.nullSafeSet(policies)) {
					policiesFiltered.addAll(policies);
				}
			}
		}

		return policiesFiltered;

	}

	@Override
	public PoliciesOutput fromListDtoToListOutput(Set<PolicyDto> list) {

		PoliciesOutput output = new PoliciesOutput();
		if (Helper.nullSafeSet(list)) {
			list.stream().forEach(item -> output.getPolicies().add(fromDtoToOutput(item)));
		}

		return output;
	}

	private PolicyOutput fromDtoToOutput(PolicyDto item) {
		PolicyOutput obj = new PolicyOutput();

		if (item != null) {
			obj.setId(item.getId());
			obj.setAmountInsured(item.getAmountInsured());
			obj.setEmail(item.getEmail());
			obj.setClientId(item.getClientId());
			obj.setInceptionDate(item.getInceptionDate());
			obj.setInstallmentPayment(item.getInstallmentPayment());
		}

		return obj;
	}

	private void populatePoliciesList() {
		if (initPoliciesList == null || !Helper.nullSafeSet(initPoliciesList.getPolicies())) {
			initPoliciesList = Helper.castObject(Helper.poulateObject(Constants.POLICIES), PoliciesDto.class);
		}
	}

}
