package model.dto;

public class Lecture {

	// �������� ���� ���� �̸�
	private String lectureName;
	
	// ����
	private Teacher teacher;
	
	// ���� ����
	private LectureInformation lectureInformation;
	
	// ������ ����
	private Student student;

	public Lecture() {
		super();
	}

	public Lecture(String lectureName, Teacher teacher, LectureInformation lectureInformation, Student student) {
		super();
		this.lectureName = lectureName;
		this.teacher = teacher;
		this.lectureInformation = lectureInformation;
		this.student = student;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public LectureInformation getLectureInformation() {
		return lectureInformation;
	}

	public void setLectureInformation(LectureInformation lectureInformation) {
		this.lectureInformation = lectureInformation;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n * ���� �̸� : ");
		builder.append(lectureName);
		builder.append("\n * ���� ���� : ");
		builder.append(teacher);
		builder.append("\n * ���� ���� : ");
		builder.append(lectureInformation);
		builder.append("\n * ������ ���� : ");
		builder.append(student);
		return builder.toString();
	}
	
}
