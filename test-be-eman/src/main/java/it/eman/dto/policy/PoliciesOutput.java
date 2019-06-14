package it.eman.dto.policy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PoliciesOutput implements Serializable {

	@JsonProperty("policies")
	private List<PolicyOutput> policies = new ArrayList();

	public List<PolicyOutput> getPolicies() {
		return policies;
	}

	public void setPolicies(List<PolicyOutput> policies) {
		this.policies = policies;
	}

}
