package view;

import java.util.ArrayList;
import java.util.Optional;

import model.dto.Lecture;

public class EndView {

	// ������ ��� ���� ���
	public static void lectureListView(ArrayList<Lecture> allLecture) {
		Optional<Object> optLec = Optional.ofNullable(allLecture);
		optLec.ifPresent(data -> {
			allLecture.stream().forEach(project -> System.out.println("[������ ���� : " + project));
		});
		
//		if (allLecture != null) {
//			int lectureSize = allLecture.size();
//
//			for (int index = 0; index < lectureSize; index++) {
//				if (allLecture.get(index) != null) {
//					System.out.println("[������ ���� : " + (index + 1) + "] " + allLecture.get(index));
//				}
//			}
//		} else {
//			System.out.println("���� ������ ���ǰ� �����ϴ�.");
//		}
	}

	// ���� �̸� �Է� �޾� ���
	public static void lectureView(Lecture lecture) {
//		lecture = null;
		Optional<Object> optLec = Optional.ofNullable(lecture);
		System.out.println(optLec.orElse("�ش� ���Ǵ� �������� �ʽ��ϴ�."));
//		if (lecture != null) {
//			System.out.println(lecture);
//		} else {
//			System.out.println("�ش� ���Ǵ� �������� �ʽ��ϴ�.");
//		}
	}

	// ������ ���� ���
	public static void lectureStudentView(Lecture lecture) {
		Optional<Object> optLec = Optional.ofNullable(lecture.getStudent());
		System.out.println(optLec.orElse("�ش� ������ �л��� �������� �ʽ��ϴ�."));
		
//		if (lecture.getStudent() != null) {
//			System.out.println(lecture.getStudent());
//		} else {
//			System.out.println("�ش� ������ �л��� �������� �ʽ��ϴ�.");
//		}
	}
	
	// ���� ���� ���
	public static void lectureTeacherView(Lecture lecture) {
		Optional<Object> optLec = Optional.ofNullable(lecture.getTeacher());
		System.out.println(optLec.orElse("�ش� ������ ���簡 �������� �ʽ��ϴ�."));
		
//		if(lecture.getTeacher() != null) {
//			System.out.println(lecture.getTeacher());
//		}else {
//			System.out.println("�ش� ������ ���簡 �������� �ʽ��ϴ�.");
//		}
	}
	

	public static void successView(String message) {
		System.out.println(message);
		}
	
}