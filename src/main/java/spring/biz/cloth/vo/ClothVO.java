package spring.biz.cloth.vo;

import java.sql.Date;

public class ClothVO {
	private int clothid;
	private String userid;
	private String imgpath;
	private String imgname;
	private String season;
	private String kind;
	private String color;
	private Date reg_date;
	
	
	public ClothVO() {
		super();
	}
	public ClothVO(int clothid, String userid, String imgpath, String imgname, String season, String kind, String color,
			Date reg_date) {
		super();
		this.clothid = clothid;
		this.userid = userid;
		this.imgpath = imgpath;
		this.imgname = imgname;
		this.season = season;
		this.kind = kind;
		this.color = color;
		this.reg_date = reg_date;
	}
	public int getClothid() {
		return clothid;
	}
	public void setClothid(int clothid) {
		this.clothid = clothid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
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
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "ClothVO [clothid=" + clothid + ", userid=" + userid + ", imgpath=" + imgpath + ", imgname=" + imgname
				+ ", season=" + season + ", kind=" + kind + ", color=" + color + ", reg_date=" + reg_date + "]";
	}
	
}
