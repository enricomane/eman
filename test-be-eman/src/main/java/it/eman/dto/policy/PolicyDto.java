package it.eman.dto.policy;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class PolicyDto implements Serializable {

	private String id;
	private BigDecimal amountInsured;
	private String inceptionDate;
	private String email;
	private String installmentPayment;
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
