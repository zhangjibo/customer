package mydbutils;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Member {
    private int id;
    private String regName;
    private String pwd;
    private String mobilePhone;
    private int type;
    private BigDecimal leaveAmount;
    private Timestamp regTime;
    public Member() {
	super();
    }
    public Member(int id, String regName, String pwd, String mobilePhone, int type, BigDecimal leaveAmount,
	    Timestamp regTime) {
	super();
	this.id = id;
	this.regName = regName;
	this.pwd = pwd;
	this.mobilePhone = mobilePhone;
	this.type = type;
	this.leaveAmount = leaveAmount;
	this.regTime = regTime;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRegName() {
        return regName;
    }
    public void setRegName(String regName) {
        this.regName = regName;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public BigDecimal getLeaveAmount() {
        return leaveAmount;
    }
    public void setLeaveAmount(BigDecimal leaveAmount) {
        this.leaveAmount = leaveAmount;
    }
    public Timestamp getRegTime() {
        return regTime;
    }
    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }
    @Override
    public String toString() {
	return "Member [id=" + id + ", regName=" + regName + ", pwd=" + pwd + ", mobilePhone=" + mobilePhone + ", type="
		+ type + ", leaveAmount=" + leaveAmount + ", regTime=" + regTime + "]\n";
    }
    
    

}
