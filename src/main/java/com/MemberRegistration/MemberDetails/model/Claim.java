package com.MemberRegistration.MemberDetails.model;

public class Claim {
 
	private String admissionDate;
	private String dischargeDate;
	private String providerName;
	private int totalbillAmount;
	public String getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public int getTotalbillAmount() {
		return totalbillAmount;
	}
	public void setTotalbillAmount(int totalbillAmount) {
		this.totalbillAmount = totalbillAmount;
	}
	
}
