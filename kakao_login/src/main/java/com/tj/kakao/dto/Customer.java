package com.tj.kakao.dto;

import java.sql.Date;

public class Customer {
	private String cid      ;
	private String cpw      ;
	private String cname	;
	private String caddrnum	;
	private String cemail	;
	private String ctel	    ;
	private Date   crdate	;
	private Date   cbirth	;
	private String gcode    ;
	private String grade	;
	private int    cpoint	;
	private String csnsid	;
	private String cprovider;
	private int    startrow	;
	private int    endrow	;
	private String schitem	;
	private String schword	;
	public Customer() {}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCpw() {
		return cpw;
	}
	public void setCpw(String cpw) {
		this.cpw = cpw;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCaddrnum() {
		return caddrnum;
	}
	public void setCaddrnum(String caddrnum) {
		this.caddrnum = caddrnum;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCtel() {
		return ctel;
	}
	public void setCtel(String ctel) {
		this.ctel = ctel;
	}
	public Date getCrdate() {
		return crdate;
	}
	public void setCrdate(Date crdate) {
		this.crdate = crdate;
	}
	public Date getCbirth() {
		return cbirth;
	}
	public void setCbirth(Date cbirth) {
		this.cbirth = cbirth;
	}
	public String getGcode() {
		return gcode;
	}
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getCpoint() {
		return cpoint;
	}
	public void setCpoint(int cpoint) {
		this.cpoint = cpoint;
	}
	public String getCsnsid() {
		return csnsid;
	}
	public void setCsnsid(String csnsid) {
		this.csnsid = csnsid;
	}
	public String getCprovider() {
		return cprovider;
	}
	public void setCprovider(String cprovider) {
		this.cprovider = cprovider;
	}
	public int getStartrow() {
		return startrow;
	}
	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}
	public int getEndrow() {
		return endrow;
	}
	public void setEndrow(int endrow) {
		this.endrow = endrow;
	}
	public String getSchitem() {
		return schitem;
	}
	public void setSchitem(String schitem) {
		this.schitem = schitem;
	}
	public String getSchword() {
		return schword;
	}
	public void setSchword(String schword) {
		this.schword = schword;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cpw=" + cpw + ", cname=" + cname + ", caddrnum=" + caddrnum + ", cemail="
				+ cemail + ", ctel=" + ctel + ", crdate=" + crdate + ", cbirth=" + cbirth + ", gcode=" + gcode
				+ ", grade=" + grade + ", cpoint=" + cpoint + ", csnsid=" + csnsid + ", cprovider=" + cprovider
				+ ", startrow=" + startrow + ", endrow=" + endrow + ", schitem=" + schitem + ", schword=" + schword
				+ "]";
	}
}
