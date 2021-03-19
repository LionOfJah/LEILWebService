package com.icicibank.apimgmt.model;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonIgnoreProperties
public class RequestModel {

	@JsonProperty("ReferenceNumber")
	private String referenceNumber;
	
	@JsonProperty("ClientId")
	private String clientId;
	
	@JsonProperty("Checksum")
	private String checkSum;
	
	@JsonProperty("LEINumber")
	private String leiNumber;
	
	@JsonProperty("Identifier")
	private String identifier;
	
	public RequestModel() {
	
		
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getCheckSum() {
		return checkSum;
	}
	public void setCheckSum(String checkSum) {
		this.checkSum = checkSum;
	}
	public String getLeiNumber() {
		return leiNumber;
	}
	public void setLeiNumber(String leiNumber) {
		this.leiNumber = leiNumber;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	@Override
	public String toString() {
		return "RequestModel [referenceNumber=" + referenceNumber + ", clientId=" + clientId + ", checkSum=" + checkSum
				+ ", leiNumber=" + leiNumber + ", identifier=" + identifier + "]";
	}
	
}
