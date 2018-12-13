package com.sample.SLdroolsspringboot;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class SLJournalEntry {
	public static String pstngRuleSetCd;
	public static String drSLAcctNm;
	public static String drDbOrCrCd;
	public static String drAcctngBasisCd;
	public static String crSLAcctNm;
	public static String crDbOrCrCd;
	public static String crAcctngBasisCd;
	
	public static String getPstngRuleSetCd() {
		return pstngRuleSetCd;
	}
	public static void setPstngRuleSetCd(String pstngRuleSetCd) {
		SLJournalEntry.pstngRuleSetCd = pstngRuleSetCd;
	}
	public static String getDrSLAcctNm() {
		return drSLAcctNm;
	}
	public static void setDrSLAcctNm(String drSLAcctNm) {
		SLJournalEntry.drSLAcctNm = drSLAcctNm;
	}
	public static String getDrDbOrCrCd() {
		return drDbOrCrCd;
	}
	public static void setDrDbOrCrCd(String drDbOrCrCd) {
		SLJournalEntry.drDbOrCrCd = drDbOrCrCd;
	}
	public static String getDrAcctngBasisCd() {
		return drAcctngBasisCd;
	}
	public static void setDrAcctngBasisCd(String drAcctngBasisCd) {
		SLJournalEntry.drAcctngBasisCd = drAcctngBasisCd;
	}
	public static String getCrSLAcctNm() {
		return crSLAcctNm;
	}
	public static void setCrSLAcctNm(String crSLAcctNm) {
		SLJournalEntry.crSLAcctNm = crSLAcctNm;
	}
	public static String getCrDbOrCrCd() {
		return crDbOrCrCd;
	}
	public static void setCrDbOrCrCd(String crDbOrCrCd) {
		SLJournalEntry.crDbOrCrCd = crDbOrCrCd;
	}
	public static String getCrAcctngBasisCd() {
		return crAcctngBasisCd;
	}
	public static void setCrAcctngBasisCd(String crAcctngBasisCd) {
		SLJournalEntry.crAcctngBasisCd = crAcctngBasisCd;
	}
	
	@Override
	public String toString() {
		return "OutputFormat [pstngRuleSetCd=" + pstngRuleSetCd + ", drSLAcctNm=" + drSLAcctNm + ", drDbOrCrCd=" + drDbOrCrCd + ", drAcctngBasisCd=" + drAcctngBasisCd + ", crSLAcctNm=" + crSLAcctNm + ", crDbOrCrCd=" + crDbOrCrCd
				+ ", crAcctngBasisCd=" + crAcctngBasisCd + "]";
	}
}
