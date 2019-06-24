package spring.biz.cloth.vo;

import java.sql.Date;

public class ClothHistoryVO {
	
	private String kind;
	private int clothid;
	private Date regdate;
	private String userid;
	private String temp;
	private String humidity;
	
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	private String dust;
	private String imgpath;
	private String imgname;
	
	
	public ClothHistoryVO() {
		super();
	}
	
	public ClothHistoryVO(String kind, int clothid, Date regdate, String userid, String temp, String humidity,
			String dust, String imgpath, String imgname) {
		super();
		this.kind = kind;
		this.clothid = clothid;
		this.regdate = regdate;
		this.userid = userid;
		this.temp = temp;
		this.humidity = humidity;
		this.dust = dust;
		this.imgpath = imgpath;
		this.imgname = imgname;
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
				+ ", temp=" + temp + ", humidity=" + humidity + ", dust=" + dust + ", imgpath=" + imgpath + ", imgname="
				+ imgname + "]";
	}

	
	
	
}
