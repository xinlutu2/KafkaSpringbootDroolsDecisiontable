package com.sample.SLdroolsspringboot;

import org.springframework.stereotype.Component;

@Component
public class SLJournalEntry {
	public String pstngRuleSetCd;
	public  String drSLAcctNm;
	public  String drDbOrCrCd;
	public  String drAcctngBasisCd;
	public  String crSLAcctNm;
	public  String crDbOrCrCd;
	public  String crAcctngBasisCd;
	
	public String getPstngRuleSetCd() {
		return pstngRuleSetCd;
	}
	public void setPstngRuleSetCd(String pstngRuleSetCd) {
		this.pstngRuleSetCd = pstngRuleSetCd;
	}
	public  String getDrSLAcctNm() {
		return drSLAcctNm;
	}
	public  void setDrSLAcctNm(String drSLAcctNm) {
		this.drSLAcctNm = drSLAcctNm;
	}
	public  String getDrDbOrCrCd() {
		return drDbOrCrCd;
	}
	public  void setDrDbOrCrCd(String drDbOrCrCd) {
		this.drDbOrCrCd = drDbOrCrCd;
	}
	public  String getDrAcctngBasisCd() {
		return drAcctngBasisCd;
	}
	public  void setDrAcctngBasisCd(String drAcctngBasisCd) {
		this.drAcctngBasisCd = drAcctngBasisCd;
	}
	public  String getCrSLAcctNm() {
		return crSLAcctNm;
	}
	public  void setCrSLAcctNm(String crSLAcctNm) {
		this.crSLAcctNm = crSLAcctNm;
	}
	public  String getCrDbOrCrCd() {
		return crDbOrCrCd;
	}
	public  void setCrDbOrCrCd(String crDbOrCrCd) {
		this.crDbOrCrCd = crDbOrCrCd;
	}
	public  String getCrAcctngBasisCd() {
		return crAcctngBasisCd;
	}
	public  void setCrAcctngBasisCd(String crAcctngBasisCd) {
		this.crAcctngBasisCd = crAcctngBasisCd;
	}
	@Override
	public String toString() {
		return "SLJournalEntry [pstngRuleSetCd=" + pstngRuleSetCd + ", drSLAcctNm=" + drSLAcctNm + ", drDbOrCrCd="
				+ drDbOrCrCd + ", drAcctngBasisCd=" + drAcctngBasisCd + ", crSLAcctNm=" + crSLAcctNm + ", crDbOrCrCd="
				+ crDbOrCrCd + ", crAcctngBasisCd=" + crAcctngBasisCd + "]";
	}	
}
