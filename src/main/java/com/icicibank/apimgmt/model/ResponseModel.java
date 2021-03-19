package com.icicibank.apimgmt.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "ReferenceNumber", "ValidityStatus", "LEIDetails", "HttpStatusCode", "ErrorMessage", "ErrorCode",
		"Signature" })
public class ResponseModel {

	@JsonProperty("ReferenceNumber")
	private String referenceNumber;
	
	@JsonProperty("ValidityStatus")
	private String validityStatus;
	
	@JsonProperty("LEIDetails")
	private String lEIDetails;
	
	@JsonProperty("HttpStatusCode")
	private Integer httpStatusCode;
	
	@JsonProperty("ErrorMessage")
	private String errorMessage;
	
	@JsonProperty("ErrorCode")
	private String errorCode;
	
	@JsonProperty("Signature")
	private String signature;
	
	
	@JsonProperty("ReferenceNumber")
	public String getReferenceNumber() {
		return referenceNumber;
	}

	@JsonProperty("ReferenceNumber")
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	@JsonProperty("ValidityStatus")
	public String getValidityStatus() {
		return validityStatus;
	}

	@JsonProperty("ValidityStatus")
	public void setValidityStatus(String validityStatus) {
		this.validityStatus = validityStatus;
	}

	@JsonProperty("LEIDetails")
	public String getLEIDetails() {
		return lEIDetails;
	}

	@JsonProperty("LEIDetails")
	public void setLEIDetails(String lEIDetails) {
		this.lEIDetails = lEIDetails;
	}

	@JsonProperty("HttpStatusCode")
	public Integer getHttpStatusCode() {
		return httpStatusCode;
	}

	@JsonProperty("HttpStatusCode")
	public void setHttpStatusCode(Integer httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	@JsonProperty("ErrorMessage")
	public String getErrorMessage() {
		return errorMessage;
	}

	@JsonProperty("ErrorMessage")
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@JsonProperty("ErrorCode")
	public String getErrorCode() {
		return errorCode;
	}

	@JsonProperty("ErrorCode")
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@JsonProperty("Signature")
	public String getSignature() {
		return signature;
	}

	@JsonProperty("Signature")
	public void setSignature(String signature) {
		this.signature = signature;
	}

	

	@Override
	public String toString() {
		return "ResponseModel [referenceNumber=" + referenceNumber + ", validityStatus=" + validityStatus
				+ ", lEIDetails=" + lEIDetails + ", httpStatusCode=" + httpStatusCode + ", errorMessage=" + errorMessage
				+ ", errorCode=" + errorCode + ", signature=" + signature + "]";
	}

	
}
