package model;

import java.io.Serializable;


public class UserBean implements Serializable,Comparable<UserBean> {
	

	private Integer id;
	
	private String firstName;
	private String email;
	private String password;
	
	private String info;
	private String job;
	private String phone;
	private String city;
	private String street;
		

	public UserBean() {}
	public UserBean(String email, String password) {
		super();
		this.id=null;
		this.firstName=null;
		this.email = email;
		this.password = password;
		this.info=null;
		this.job=null;
		this.phone=null;
		this.city=null;
		this.street=null;
	}
	
	public UserBean(Integer id) {
		super();
		this.id=id;
		this.firstName=null;
		this.email = null;
		this.password = null;
		this.info=null;
		this.job=null;
		this.phone=null;
		this.city=null;
		this.street=null;
	}
	
	
	public UserBean(Integer id,String firstName, String email, String password , String info, String job , String phone, String city, String street ) {
		super();
		this.id=id;
		this.firstName = firstName;
		this.email = email;
		this.password = password;
		this.info=info;
		this.job=job;
		this.phone=phone;
		this.city=city;
		this.street=street;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBean other = (UserBean) obj;
		if (this.compareTo(other)==0)
			return true;
		else
			return false;
	}

	@Override
	public int compareTo(UserBean o) {
		return this.email.compareTo(o.getEmail());
	}
	
}
