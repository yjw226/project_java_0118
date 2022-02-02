package model.dto;

public class Student {
	
	// ������ ��ȣ
	private int sNo;
	
	// ������ �̸�
	private String name;
	
	// ������ ����ó
	private String contactInformation;
	
	// �����ϰ� �ִ� ����
	private String lectureName;
	
	// ��� ��¥
	private String regDate;
	
	public Student() {
		super();
	}

	public Student(int sNo, String name, String contactInformation, String lectureName, String regDate) {
		super();
		this.sNo = sNo;
		this.name = name;
		this.contactInformation = contactInformation;
		this.lectureName = lectureName;
		this.regDate = regDate;
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactInfomation() {
		return contactInformation;
	}

	public void setContactInfomation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[�л� ��ȣ : ");
		builder.append(sNo);
		builder.append(", �̸� : ");
		builder.append(name);
		builder.append(", ����ó : ");
		builder.append(contactInformation);
		builder.append(", �������� ���� : ");
		builder.append(lectureName);
		builder.append(", ��ϳ�¥ : ");
		builder.append(regDate);
		builder.append("]");
		return builder.toString();
	}

	
}
