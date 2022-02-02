package service;

import java.util.ArrayList;

import exception.LectureNameDuplicationException;
import exception.LectureNotFoundException;
import model.dto.Lecture;
import model.dto.Student;
import model.dto.Teacher;

public class AcademyProjectService {
	private static AcademyProjectService instance = new AcademyProjectService();
	
	private AcademyProjectService() {}
	public static AcademyProjectService getInstance() {
		return instance;
	}
	
	private ArrayList<Lecture> lectureList = new ArrayList<Lecture>();
	
	// ��� ���� �˻�
	public ArrayList<Lecture> getLectureList() {
		return lectureList;
	}
	
	// ���� ����
	public void lectureInsert(Lecture lecture) throws LectureNameDuplicationException {
		for(Lecture l : lectureList) {
			if(l.getLectureName().equals(lecture.getLectureName())) {
				throw new LectureNameDuplicationException("�̹� �����ϴ� �����Դϴ�.");
			}
		}
		lectureList.add(lecture);
	}
	
	// ���� ���� �˻�
	public Lecture getLecture(String lectureName) throws LectureNotFoundException {
		for(Lecture l : lectureList) {
			if(l.getLectureName().equals(lectureName)) {
				return l;
			}
		}
		throw new LectureNotFoundException("��û�Ͻ� ���Ǵ� �������� �ʽ��ϴ�.");
	}
	
	// ���� �̸����� ������ ���
	public Lecture getLectureStudent(String lectureName) throws LectureNotFoundException {
		for(Lecture l : lectureList) {
			if(l.getLectureName().equals(lectureName)) {
				return l;
			}
		}
		throw new LectureNotFoundException("��û�Ͻ� ���Ǵ� �������� �ʽ��ϴ�.");
	}
	
	// ���� �̸����� ���� ���
	public Lecture getLectureTeacher(String lectureName) throws LectureNotFoundException {
		for(Lecture l : lectureList) {
			if(l.getLectureName().equals(lectureName)) {
				return l;
			}
		}
		throw new LectureNotFoundException("��û�Ͻ� ���Ǵ� �������� �ʽ��ϴ�.");
	}
	
	// ���� ���� ��¥ ����
	public boolean lectureDateUpdate(String lectureName, String information) {
		for(Lecture l : lectureList) {
			if(l.getLectureName().equals(lectureName)) {
				l.getLectureInformation().setStartDate(information);
				return true;
			}
		}
		return false;
	}
	
	// ���� ���� ����
	public boolean lectureTeacherUpdate(String lectureName, Teacher teacher) {
		for(Lecture l : lectureList) {
			if(l.getLectureName().equals(lectureName)) {
				l.setTeacher(teacher);
				return true;
			}
		}
		return false;
	}
	
	// ���� ������ ���� ����
	public boolean lectureStudentUpdate(String lectureName, Student student) {
		for(Lecture l : lectureList) {
			if(l.getLectureName().equals(lectureName)) {
				l.setStudent(student);
				return true;
			}
		}
		return false;
	}
	
	// ���� ����
	public boolean lectureDelete(String lectureName) {
		Lecture lecture = null;
		int count = lectureList.size();
		
		for(int i = 0; i < count; i++) {
			lecture = lectureList.get(i);
			
			if(lecture.getLectureName().equals(lectureName)) {
				lectureList.remove(i);
				return true;
			}
		}
		return false;
	}
}
