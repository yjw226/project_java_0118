package model.dto;

public class LectureInformation {
	
	// ���� �̸�
	private String lectureInfoName;
	
	// ���� �̸�
	private String testName;
	
	// ���� ������
	private String StartDate;
	
	// ���� ������
	private String EndDate;
	
	public LectureInformation() {
		super();
	}

	public LectureInformation(String lectureInfoName, String testName, String startDate, String endDate) {
		super();
		this.lectureInfoName = lectureInfoName;
		this.testName = testName;
		StartDate = startDate;
		EndDate = endDate;
	}

	public String getLetureName() {
		return lectureInfoName;
	}

	public void setLetureName(String lectureInfoName) {
		this.lectureInfoName = lectureInfoName;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[���Ǹ� : ");
		builder.append(lectureInfoName);
		builder.append(", ����� : ");
		builder.append(testName);
		builder.append(", ������ : ");
		builder.append(StartDate);
		builder.append(", ������ : ");
		builder.append(EndDate);
		builder.append("]");
		return builder.toString();
	}
	
}
