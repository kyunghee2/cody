package spring.biz.cloth.vo;

import java.sql.Date;

public class ClothHistoryVO {
	
	private String kind;
	private int clothid;
	private Date regdate;
	private String userid;
	private int temp;
	private int humidity;
	private int dust;
	
	
	public ClothHistoryVO() {
		super();
	}
	public ClothHistoryVO(String kind, int clothid, Date regdate, String userid, int temp, int humidity, int dust) {
		super();
		this.kind = kind;
		this.clothid = clothid;
		this.regdate = regdate;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
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
		return "ClothHistoryVO [kind=" + kind + ", clothid=" + clothid + ", regdate=" + regdate + ", userid=" + userid
				+ ", temp=" + temp + ", humidity=" + humidity + ", dust=" + dust + "]";
	}
	
	
	
}
