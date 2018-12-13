package util;

import org.springframework.stereotype.Component;

import com.sample.SLdroolsspringboot.SLJournalEntry;

@Component
public class OutputFormat {
	// The below code is for Option 1. Create SLJOURNALENTRY with static data attributes and then call the "createOutput" method below to move SLJOURNALENTRY data fields into
	// OUTPUT non static fields.
	public String pstngRuleSetCd;
	public String drSLAcctNm;
	public String drDbOrCrCd;
	public String drAcctngBasisCd;
	public String crSLAcctNm;
	public String crDbOrCrCd;
	public String crAcctngBasisCd;
	
	
	public String getPstngRuleSetCd() {
		return pstngRuleSetCd;
	}
	public void setPstngRuleSetCd(String pstngRuleSetCd) {
		this.pstngRuleSetCd = pstngRuleSetCd;
	}
	public String getDrSLAcctNm() {
		return drSLAcctNm;
	}
	public void setDrSLAcctNm(String drSLAcctNm) {
		this.drSLAcctNm = drSLAcctNm;
	}
	public String getDrDbOrCrCd() {
		return drDbOrCrCd;
	}
	public void setDrDbOrCrCd(String drDbOrCrCd) {
		this.drDbOrCrCd = drDbOrCrCd;
	}
	public String getDrAcctngBasisCd() {
		return drAcctngBasisCd;
	}
	public void setDrAcctngBasisCd(String drAcctngBasisCd) {
		this.drAcctngBasisCd = drAcctngBasisCd;
	}
	public String getCrSLAcctNm() {
		return crSLAcctNm;
	}
	public void setCrSLAcctNm(String crSLAcctNm) {
		this.crSLAcctNm = crSLAcctNm;
	}
	public String getCrDbOrCrCd() {
		return crDbOrCrCd;
	}
	public void setCrDbOrCrCd(String crDbOrCrCd) {
		this.crDbOrCrCd = crDbOrCrCd;
	}
	public String getCrAcctngBasisCd() {
		return crAcctngBasisCd;
	}
	public void setCrAcctngBasisCd(String crAcctngBasisCd) {
		this.crAcctngBasisCd = crAcctngBasisCd;
	}
	public OutputFormat createOutput(SLJournalEntry slje) {
		this.pstngRuleSetCd = slje.getPstngRuleSetCd();
		this.drSLAcctNm = slje.getDrSLAcctNm();
		this.drDbOrCrCd = slje.getDrDbOrCrCd();
		this.drAcctngBasisCd = slje.getDrAcctngBasisCd();
		this.crSLAcctNm = slje.getCrSLAcctNm();
		this.crDbOrCrCd = slje.getCrDbOrCrCd();
		this.crAcctngBasisCd = slje.getCrAcctngBasisCd();
		return this;
	}
	@Override
	public String toString() {
		return "OutputFormat [pstngRuleSetCd=" + pstngRuleSetCd + ", drSLAcctNm=" + drSLAcctNm + ", drDbOrCrCd="
				+ drDbOrCrCd + ", drAcctngBasisCd=" + drAcctngBasisCd + ", crSLAcctNm="
				+ crSLAcctNm + ", crDbOrCrCd=" + crDbOrCrCd + ", crAcctngBasisCd=" + crAcctngBasisCd + "]";
	}
	
	
}
