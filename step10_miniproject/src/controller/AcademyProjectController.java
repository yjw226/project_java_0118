package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import exception.LectureNameDuplicationException;
import exception.LectureNotFoundException;
import model.dto.Lecture;
import model.dto.Student;
import model.dto.Teacher;
import service.AcademyProjectService;
import view.EndFailView;
import view.EndView;

public class AcademyProjectController {

	private static AcademyProjectController instance = new AcademyProjectController();
	private AcademyProjectService service = AcademyProjectService.getInstance();

	private AcademyProjectController() {
	}

	public static AcademyProjectController getInstance() {
		return instance;
	}

	// 강의 생성
	public void lectureInsert(Lecture lecture) {
		Optional<Object> optLec = Optional.ofNullable(lecture);
		optLec.ifPresent(data->{
			try {
				service.lectureInsert(lecture);
			} catch (LectureNameDuplicationException e) {
				EndFailView.failView(e.getMessage());
				e.printStackTrace();
			}
		});
		
		System.out.println(optLec.orElse("\n저장할 강의 정보가 없습니다."));
		
		
//		if (lecture != null) {
//			try {
//				service.lectureInsert(lecture);
//			} catch (LectureNameDuplicationException e) {
//				e.printStackTrace();
//				EndFailView.failView(e.getMessage());
//			}
//		} else {
//			EndFailView.failView("저장할 강의 정보가 없습니다.");
//		}
	}

	// 개설된 모든 강의 정보 출력
	public void getLectureList() {
		EndView.lectureListView(service.getLectureList());
	}

	// 강의 정보 검색
	public void getLecture(String lectureName) {
		try {
			EndView.lectureView(service.getLecture(lectureName));
		} catch (LectureNotFoundException e) {
			// e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}

	// 수강생 정보 출력
	public void getLectureStudent(String lectureName) {
		try {
			EndView.lectureStudentView(service.getLectureStudent(lectureName));
		} catch (LectureNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}

	// 강사 정보 출력
	public void getLectureTeacher(String lectureName) {
		try {
			EndView.lectureTeacherView(service.getLectureTeacher(lectureName));
		}catch (LectureNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}

	// 강의 개강 날짜 변경 및 검색
	public void lectureDateUpdate(String lectureName, String Information) {
		Optional<Object> optLec = Optional.ofNullable(lectureName);
		Optional<Object> optInfo = Optional.ofNullable(Information);
		optLec.ifPresent(data -> {
			boolean result = service.lectureDateUpdate(lectureName, Information);
			try {
				EndView.lectureView(service.getLecture(Information));
			} catch (LectureNotFoundException e) {
				e.printStackTrace();
				EndFailView.failView("\n개강 날짜 변경 후 검색 실패");
			}
		});
		
		System.out.println(optLec.orElse("\n존재하지 않는 강의 수정 시도"));
		System.out.println(optInfo.orElse("\n변경하실 날짜를 제대로 입력하세요!"));
//		if (lectureName != null && Information != null) {
//			boolean result = service.lectureDateUpdate(lectureName, Information); // update
//
//			if (result) {
//				try {
//					EndView.lectureView(service.getLecture(lectureName)); // select
//				} catch (LectureNotFoundException e) {
//					e.printStackTrace();
//					EndFailView.failView("개강 날짜 변경 후 검색 실패");
//				}
//			} else {
//				EndFailView.failView("존재하지 않는 강의 수정 시도");
//			}
//		} else {
//			EndFailView.failView("변경하실 날짜를 제대로 입력하세요!");
//		}
	}

	// 강의 강사 정보 변경 및 검색
	public void lectureTeacherUpdate(String lectureName, Teacher teacher) {
		if (lectureName != null && teacher != null) {
			boolean result = service.lectureTeacherUpdate(lectureName, teacher);

			if (result) {
				try {
					EndView.lectureView(service.getLecture(lectureName));
				} catch (LectureNotFoundException e) {
					e.printStackTrace();
					EndFailView.failView("강사 정보 변경 후 검색 실패");
				}
			} else {
				EndFailView.failView("존재하지 않는 강의 수정 시도");
			}
		} else {
			EndFailView.failView("변경하실 강사 정보를 제대로 입력하세요ㅇ!");
		}
	}

	// 강의 수강생 정보 변경
	public void lectureStudentUpdate(String lectureName, Student student) {
		Map<String, Student> sUp = new HashMap<>();
		Optional<Object> optLec = Optional.ofNullable(sUp);
		optLec.ifPresent(data ->{
			boolean result = service.lectureStudentUpdate(lectureName, student);
			try {
				EndView.lectureView(service.getLecture(lectureName));
			} catch (LectureNotFoundException e) {
				EndFailView.failView(e.getMessage());
				e.printStackTrace();
			}
		});
		
		System.out.println(optLec.orElse(("\n변경하실 수강생 정보를 제대로 입력하세요!")));
		
//		if (lectureName != null && student != null) {
//			boolean result = service.lectureStudentUpdate(lectureName, student);

//			if (result) {
//				try {
//					EndView.lectureView(service.getLecture(lectureName));
//				} catch (LectureNotFoundException e) {
//					e.printStackTrace();
//					EndFailView.failView("수강생 정보 변경 후 검색 실패");
//				}
//			} else {
//				EndFailView.failView("존재하지 않는 강의 수정 시도");
//			}
//		} else {
//			EndFailView.failView("변경하실 수강생 정보를 제대로 입력하세요!");
//		}
	}

	// 강의 삭제
	public void lectureDelete(String lectureName) {
		
		Optional<Object> optLec = Optional.ofNullable(lectureName);
		optLec.ifPresent(data -> {
			boolean result = service.lectureDelete(lectureName);

			if (!result) {
				EndFailView.failView("삭제할 강의가 존재하지 않습니다."); // 다른 값이 입력될 경우 아래 문장 수행됨..
			}
			
		});

		if (optLec.orElse(optLec).equals(lectureName)) {
			System.out.println("[" + optLec.orElse(lectureName) + "]" + " 강의가 삭제되었습니다.");
		} else {
			System.out.println(optLec.orElse("삭제하려는 강의 이름을 입력하세요!"));
		}

	}
//		if (lectureName != null) {
//			boolean result = service.lectureDelete(lectureName);
//
//			if (result) {
//				EndView.successView("'" + lectureName + "'" + "강의가 삭제되었습니다.");
//			} else {
//				EndFailView.failView("삭제할 강의가 없습니다.");
//			}
//		} else {
//			EndFailView.failView("삭제하려는 강의 이름을 입력하세요!");
//		}
//	}

}
