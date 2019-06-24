package spring.biz.cloth.vo;

import java.sql.Date;

public class ClothHistoryVO {
	
	private String kind;
	private int clothid;
	private Date regdate;
	private String userid;
	private String temp;
	private String humidity;
	private String dust;
	
	
	public ClothHistoryVO() {
		super();
	}
	public ClothHistoryVO(String kind, int clothid, Date regdate, String userid, String temp, String humidity, String dust) {
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
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getDust() {
		return dust;
	}
	public void setDust(String dust) {
		this.dust = dust;
	}

	@Override
	public String toString() {
		return "ClothHistoryVO [kind=" + kind + ", clothid=" + clothid + ", regdate=" + regdate + ", userid=" + userid
				+ ", temp=" + temp + ", humidity=" + humidity + ", dust=" + dust + "]";
	}
	
	
	
}
