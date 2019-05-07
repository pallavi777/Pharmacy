package triarq.qore.pharmacy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pharmacy")
public class Pharmacy 
{
	@Id
	Long pharmacyid;
	String sname, scity, sstate,szip;
	Date activestarttime, activeendtime;
	Integer sservicelevel;
	String sncpdpid, saddressline1;
	public Long getPharmacyid() {
		return pharmacyid;
	}
	public void setPharmacyid(Long pharmacyid) {
		this.pharmacyid = pharmacyid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
	public String getSstate() {
		return sstate;
	}
	public void setSstate(String sstate) {
		this.sstate = sstate;
	}
	public String getSzip() {
		return szip;
	}
	public void setSzip(String szip) {
		this.szip = szip;
	}
	public Date getActivestarttime() {
		return activestarttime;
	}
	public void setActivestarttime(Date activestarttime) {
		this.activestarttime = activestarttime;
	}
	public Date getActiveendtime() {
		return activeendtime;
	}
	public void setActiveendtime(Date activeendtime) {
		this.activeendtime = activeendtime;
	}
	public Integer getSservicelevel() {
		return sservicelevel;
	}
	public void setSservicelevel(Integer sservicelevel) {
		this.sservicelevel = sservicelevel;
	}
	public String getSncpdpid() {
		return sncpdpid;
	}
	public void setSncpdpid(String sncpdpid) {
		this.sncpdpid = sncpdpid;
	}
	public String getSaddressline1() {
		return saddressline1;
	}
	public Pharmacy(Long pharmacyid, String sname, String scity, String sstate, String szip, Date activestarttime,
			Date activeendtime, Integer sservicelevel, String sncpdpid, String saddressline1) {
		super();
		this.pharmacyid = pharmacyid;
		this.sname = sname;
		this.scity = scity;
		this.sstate = sstate;
		this.szip = szip;
		this.activestarttime = activestarttime;
		this.activeendtime = activeendtime;
		this.sservicelevel = sservicelevel;
		this.sncpdpid = sncpdpid;
		this.saddressline1 = saddressline1;
	}
	public Pharmacy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setSaddressline1(String saddressline1) {
		this.saddressline1 = saddressline1;
	}
	
	

}
