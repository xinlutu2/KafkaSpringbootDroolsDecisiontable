package com.sample.SLdroolsspringboot;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class PostingEventWithAmountSign {
	public String amtSignCd;
	public String trnType;
	public String acctngEventType;
	public int acctngTrtmtID;
	public String insuredInd;
	public Date acctngEventDt;
	
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
	public Date getAcctngEventDt() {
		return acctngEventDt;
	}
	public void setAcctngEventDt(Date acctngEventDt) {
		this.acctngEventDt = acctngEventDt;
	}
	public String getAmtSignCd() {
		return amtSignCd;
	}
	public void setAmtSignCd(String amtSignCd) {
		this.amtSignCd = amtSignCd;
	}
	public PostingEventWithAmountSign createPstngEvntWithSign(SLPostingEvent pstngEvent) {
		this.trnType = pstngEvent.getTrnType();
		this.acctngEventType = pstngEvent.getAcctngEventType();
		this.acctngTrtmtID = pstngEvent.getAcctngTrtmtID();
		this.insuredInd = pstngEvent.getInsuredInd();
		this.acctngEventDt = pstngEvent.getAcctngEventDt();
		return this;
	}
	
	public String populateAmtSignCd(double amount) {
		if (amount > 0) {
			return "P";
		} else {
			return "N";
		}
	}
	@Override
	public String toString() {
		return "PostingEventWithAmountSign [amtSignCd=" + amtSignCd + ", trnType=" + trnType + ", acctngEventType="
				+ acctngEventType + ", acctngTrtmtID=" + acctngTrtmtID + ", insuredInd=" + insuredInd
				+ ", acctngEventDt=" + acctngEventDt + "]";
	}	
	
}
