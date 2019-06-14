package it.eman.dto.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import it.eman.dto.policy.PolicyOutput;
import it.eman.utils.helper.Helper;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "clients", "policies" })
@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
public class ClientDetailOutput implements Serializable {

	@JsonProperty("clients")
	private List<ClientOutput> clients = new ArrayList();

	@JsonProperty("policies")
	private List<PolicyOutput> policies = new ArrayList();

	public List<ClientOutput> getClients() {
		return clients;
	}

	public void setClientsSet(Set<ClientOutput> clients) {
		if (Helper.nullSafeSet(clients)) {
			this.clients = clients.stream().collect(Collectors.toList());
		} else {
			this.clients = new ArrayList();
		}
	}

	public List<PolicyOutput> getPolicies() {
		return policies;
	}

	public void setPoliciesSet(Set<PolicyOutput> policies) {
		if (Helper.nullSafeSet(policies)) {
			this.policies = policies.stream().collect(Collectors.toList());
		} else {
			this.policies = new ArrayList();
		}

	}

	public void setPolicies(List<PolicyOutput> policies) {
		this.policies = policies;
	}

	public void setClients(List<ClientOutput> clients) {
		this.clients = clients;
	}

}
