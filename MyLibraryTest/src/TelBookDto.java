
public class TelBookDto {
	int seq;
	String name;
	int age;
	String gender;
	String tel;
	String address;
	String regdate;
	
	public TelBookDto() {}
			
	public TelBookDto(int seq, String name, int age, String gender, String tel, String address, String regdate) {
		super();
		this.seq = seq;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.tel = tel;
		this.address = address;
		this.regdate = regdate;
	}
	public TelBookDto(String name, int age, String gender, String tel, String address) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.tel = tel;
		this.address = address;
	}	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}
