package spring.biz.cloth.vo;

import java.util.Date;

public class ClothHistoryVO {
	
	private String kind;
	private int clothid;
	private Date reg_date;
	private String userid;
	private int temp;
	private int humidity;
	private int dust;
	
	
	public ClothHistoryVO() {
		super();
	}
	public ClothHistoryVO(String kind, int clothid, Date reg_date, String userid, int temp, int humidity, int dust) {
		super();
		this.kind = kind;
		this.clothid = clothid;
		this.reg_date = reg_date;
		this.userid = userid;
		this.temp = temp;
		this.humidity = humidity;
		this.dust = dust;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getClothid() {
		return clothid;
	}
	public void setClothid(int clothid) {
		this.clothid = clothid;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public int getDust() {
		return dust;
	}
	public void setDust(int dust) {
		this.dust = dust;
	}
	@Override
	public String toString() {
		return "ClothHistoryVO [kind=" + kind + ", clothid=" + clothid + ", reg_date=" + reg_date + ", userid=" + userid
				+ ", temp=" + temp + ", humidity=" + humidity + ", dust=" + dust + "]";
	}
	
	
}
