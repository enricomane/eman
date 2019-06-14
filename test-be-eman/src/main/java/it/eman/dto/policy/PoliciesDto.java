package it.eman.dto.policy;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
public class PoliciesDto implements Serializable {

	private Set<PolicyDto> policies = new HashSet();

	public PoliciesDto() {
		super();
	}

	public Set<PolicyDto> getPolicies() {
		return policies;
	}

	public void setPolicies(Set<PolicyDto> policies) {
		this.policies = policies;
	}

}
