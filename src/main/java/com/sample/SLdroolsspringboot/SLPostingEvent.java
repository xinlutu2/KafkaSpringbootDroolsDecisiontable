package com.sample.SLdroolsspringboot;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class SLPostingEvent {
	public String trnType;
	public String acctngEventType;
	public Date acctngEventDt;
	public int acctngTrtmtID;
	public String insuredInd;
	public double acctngEventAmt;
	
	/*public double positiveAmt = 1;
	public double negativeAmt = -1;*/
	
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
	
	@Override
	public String toString() {
		return "SLPostingEvent [trnType=" + trnType + ", acctngEventType=" + acctngEventType + ", acctngEventDt="
				+ acctngEventDt + ", acctngTrtmtID=" + acctngTrtmtID + ", insuredInd=" + insuredInd
				+ ", acctngEventAmt=" + acctngEventAmt + "]";
	}
	/*public double isValuePositive(double amount) {
		if (amount > 0) {
			return positiveAmt;
		} else {
			return negativeAmt;
		}
	}*/

}
