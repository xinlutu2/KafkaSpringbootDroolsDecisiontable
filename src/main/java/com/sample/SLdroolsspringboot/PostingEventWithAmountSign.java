package com.sample.SLdroolsspringboot;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class PostingEventWithAmountSign {
	private String trnType;
	private String acctngEventType;
	private Date acctngEventDt;
	private int acctngTrtmtID;
	private String insuredInd;
	private double acctngEventAmt;
	private String amtSignCd;
	
	public String getTrnType() {
		return trnType;
	}
	public void setTrnType(String trnType) {
		this.trnType = trnType;
	}
	public String getAcctngEventType() {
		return acctngEventType;
	}
	public void setAcctngEventType(String acctngEventType) {
		this.acctngEventType = acctngEventType;
	}
	public Date getAcctngEventDt() {
		return acctngEventDt;
	}
	public void setAcctngEventDt(Date acctngEventDt) {
		this.acctngEventDt = acctngEventDt;
	}
	public int getAcctngTrtmtID() {
		return acctngTrtmtID;
	}
	public void setAcctngTrtmtID(int acctngTrtmtID) {
		this.acctngTrtmtID = acctngTrtmtID;
	}
	public String getInsuredInd() {
		return insuredInd;
	}
	public void setInsuredInd(String insuredInd) {
		this.insuredInd = insuredInd;
	}
	public double getAcctngEventAmt() {
		return acctngEventAmt;
	}
	public void setAcctngEventAmt(double acctngEventAmt) {
		this.acctngEventAmt = acctngEventAmt;
	}
	public String getAmtSignCd() {
		return amtSignCd;
	}
	public void setAmtSignCd(double amount) {
		if (amount > 0.0) {
			this.amtSignCd = "P";
		} else {
			this.amtSignCd = "N";
		}
	}
	public void copyDatatoNewOject(SLPostingEvent inputEvent) {
		this.trnType = inputEvent.getTrnType();
		this.acctngEventType = inputEvent.getAcctngEventType();
		this.acctngTrtmtID = inputEvent.getAcctngTrtmtID();
		this.insuredInd = inputEvent.getInsuredInd();
		this.acctngEventDt = inputEvent.getAcctngEventDt();
		this.acctngEventAmt = inputEvent.getAcctngEventAmt();
	}
	@Override
	public String toString() {
		return "PostingEventWithAmountSign [trnType=" + trnType + ", acctngEventType=" + acctngEventType
				+ ", acctngEventDt=" + acctngEventDt + ", acctngTrtmtID=" + acctngTrtmtID + ", insuredInd=" + insuredInd
				+ ", acctngEventAmt=" + acctngEventAmt + ", amtSignCd=" + amtSignCd + "]";
	}
}