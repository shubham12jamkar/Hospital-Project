package com.yash.hospital.model;


public class patient {
	private int pid;
	private String pname;
	private long pmobno;
	private Doctor doctor;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public long getPmobno() {
		return pmobno;
	}
	public void setPmobno(long pmobno) {
		this.pmobno = pmobno;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	

}
