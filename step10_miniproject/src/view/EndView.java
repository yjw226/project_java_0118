package view;

import java.util.ArrayList;
import java.util.Optional;

import model.dto.Lecture;

public class EndView {

	// 개설된 모든 강의 출력
	public static void lectureListView(ArrayList<Lecture> allLecture) {
		Optional<Object> optLec = Optional.ofNullable(allLecture);
		optLec.ifPresent(data -> {
			allLecture.stream().forEach(project -> System.out.println("[개설된 강의 : " + project));
		});
		
//		if (allLecture != null) {
//			int lectureSize = allLecture.size();
//
//			for (int index = 0; index < lectureSize; index++) {
//				if (allLecture.get(index) != null) {
//					System.out.println("[개설된 강의 : " + (index + 1) + "] " + allLecture.get(index));
//				}
//			}
//		} else {
//			System.out.println("현재 개설된 강의가 없습니다.");
//		}
	}

	// 강의 이름 입력 받아 출력
	public static void lectureView(Lecture lecture) {
//		lecture = null;
		Optional<Object> optLec = Optional.ofNullable(lecture);
		System.out.println(optLec.orElse("해당 강의는 존재하지 않습니다."));
//		if (lecture != null) {
//			System.out.println(lecture);
//		} else {
//			System.out.println("해당 강의는 존재하지 않습니다.");
//		}
	}

	// 수강생 정보 출력
	public static void lectureStudentView(Lecture lecture) {
		Optional<Object> optLec = Optional.ofNullable(lecture.getStudent());
		System.out.println(optLec.orElse("해당 강의의 학생이 존재하지 않습니다."));
		
//		if (lecture.getStudent() != null) {
//			System.out.println(lecture.getStudent());
//		} else {
//			System.out.println("해당 강의의 학생이 존재하지 않습니다.");
//		}
	}
	
	// 강사 정보 출력
	public static void lectureTeacherView(Lecture lecture) {
		Optional<Object> optLec = Optional.ofNullable(lecture.getTeacher());
		System.out.println(optLec.orElse("해당 강의의 강사가 존재하지 않습니다."));
		
//		if(lecture.getTeacher() != null) {
//			System.out.println(lecture.getTeacher());
//		}else {
//			System.out.println("해당 강의의 강사가 존재하지 않습니다.");
//		}
	}
	

	public static void successView(String message) {
		System.out.println(message);
		}
	
}