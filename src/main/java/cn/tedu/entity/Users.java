package cn.tedu.entity;
/**
 * 员工人员信息表users
 */
import java.io.Serializable;
import java.util.Date;

import cn.tedu.utils.DateUtils;


public class Users implements Serializable{
	private int id;
	private String username;
	private String password;
	private int sex;
	private Date birthday;
	private Date createtime;	//创建时间
	private int isadmin;		//是否为管理员
	private String content;		//人员简介
	
	private String sexStr;
	private String isadminStr;
	
	private String birthdayStr;
	private String createtimeStr;
	

	//是否管理员数字转为字符串，0代表否，1代表是
	public String getIsadminStr() {
		return isadmin==0?"否":"是";
		
	}
	//人员性别数字转换成字符
	public String getSexStr() {
		if(this.sex==0) {
			return "男";
		}else {
			return "女";
		}
	}
	
	//生日Date类型转换为字符串
	public String getBirthdayStr() {
		return DateUtils.getDateString(this.birthday);
	}
	
	public String getCreatetimeStr() {
		return createtimeStr;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//对性别的get方法进行改动如果值是sex值是0就返回字符串男,1就返回女

	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(int isadmin) {
		this.isadmin = isadmin;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", birthday="
				+ birthday + ", createtime=" + createtime + ", isadmin=" + isadmin + ", content=" + content + "]";
	}
	public Users(int id, String username, String password, int sex, Date birthday, Date createtime, int isadmin,
			String content) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.createtime = createtime;
		this.isadmin = isadmin;
		this.content = content;
	}
	public Users(String name) {
		this.username = name;
	}
	
	
	
	
	
}
