package model.dto;

public class Teacher {
	// ���� ��ȣ
	private int tNo;
	
	// ���� �̸�
	private String name;
	
	// ���� ����ó
	private String contactInfomation;
	
	// ���� �̸���
	private String email;
	
	// ���� ����
	private String major;
	
	// ���� ���
	private int career;

	public Teacher() {
		super();
	}

	public Teacher(int tNo, String name, String contactInfomation, String email, String major, int career) {
		super();
		this.tNo = tNo;
		this.name = name;
		this.contactInfomation = contactInfomation;
		this.email = email;
		this.major = major;
		this.career = career;
	}

	public int getNo() {
		return tNo;
	}

	public void setNo(int tNo) {
		this.tNo = tNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactInfomation() {
		return contactInfomation;
	}

	public void setContactInfomation(String contactInfomation) {
		this.contactInfomation = contactInfomation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[���� ��ȣ : ");
		builder.append(tNo);
		builder.append(", �̸� : ");
		builder.append(name);
		builder.append(", ����ó : ");
		builder.append(contactInfomation);
		builder.append(", �̸��� : ");
		builder.append(email);
		builder.append(", ���� : ");
		builder.append(major);
		builder.append(", ��� : ");
		builder.append(career);
		builder.append("]");
		return builder.toString();
	}
}
