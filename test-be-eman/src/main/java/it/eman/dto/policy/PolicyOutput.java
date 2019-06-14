package it.eman.dto.policy;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@SuppressWarnings({"serial"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id","clientId","inceptionDate","email", "installmentPayment","amountInsured"})
public class PolicyOutput implements Serializable {
	
	@JsonProperty("id")
	private String id;
	@JsonProperty("amountInsured")
	private BigDecimal amountInsured;
	@JsonProperty("inceptionDate")
	private String inceptionDate;
	@JsonProperty("email")
	private String email;
	@JsonProperty("installmentPayment")
	private String installmentPayment;
	@JsonProperty("clientId")
	private String clientId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstallmentPayment() {
		return installmentPayment;
	}

	public void setInstallmentPayment(String installmentPayment) {
		this.installmentPayment = installmentPayment;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public BigDecimal getAmountInsured() {
		return amountInsured;
	}

	public void setAmountInsured(BigDecimal amountInsured) {
		this.amountInsured = amountInsured;
	}

	public String getInceptionDate() {
		return inceptionDate;
	}

	public void setInceptionDate(String inceptionDate) {
		this.inceptionDate = inceptionDate;
	}

}
