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

	// ���� ����
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
		
		System.out.println(optLec.orElse("\n������ ���� ������ �����ϴ�."));
		
		
//		if (lecture != null) {
//			try {
//				service.lectureInsert(lecture);
//			} catch (LectureNameDuplicationException e) {
//				e.printStackTrace();
//				EndFailView.failView(e.getMessage());
//			}
//		} else {
//			EndFailView.failView("������ ���� ������ �����ϴ�.");
//		}
	}

	// ������ ��� ���� ���� ���
	public void getLectureList() {
		EndView.lectureListView(service.getLectureList());
	}

	// ���� ���� �˻�
	public void getLecture(String lectureName) {
		try {
			EndView.lectureView(service.getLecture(lectureName));
		} catch (LectureNotFoundException e) {
			// e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}

	// ������ ���� ���
	public void getLectureStudent(String lectureName) {
		try {
			EndView.lectureStudentView(service.getLectureStudent(lectureName));
		} catch (LectureNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}

	// ���� ���� ���
	public void getLectureTeacher(String lectureName) {
		try {
			EndView.lectureTeacherView(service.getLectureTeacher(lectureName));
		}catch (LectureNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}

	// ���� ���� ��¥ ���� �� �˻�
	public void lectureDateUpdate(String lectureName, String Information) {
		Optional<Object> optLec = Optional.ofNullable(lectureName);
		Optional<Object> optInfo = Optional.ofNullable(Information);
		optLec.ifPresent(data -> {
			boolean result = service.lectureDateUpdate(lectureName, Information);
			try {
				EndView.lectureView(service.getLecture(Information));
			} catch (LectureNotFoundException e) {
				e.printStackTrace();
				EndFailView.failView("\n���� ��¥ ���� �� �˻� ����");
			}
		});
		
		System.out.println(optLec.orElse("\n�������� �ʴ� ���� ���� �õ�"));
		System.out.println(optInfo.orElse("\n�����Ͻ� ��¥�� ����� �Է��ϼ���!"));
//		if (lectureName != null && Information != null) {
//			boolean result = service.lectureDateUpdate(lectureName, Information); // update
//
//			if (result) {
//				try {
//					EndView.lectureView(service.getLecture(lectureName)); // select
//				} catch (LectureNotFoundException e) {
//					e.printStackTrace();
//					EndFailView.failView("���� ��¥ ���� �� �˻� ����");
//				}
//			} else {
//				EndFailView.failView("�������� �ʴ� ���� ���� �õ�");
//			}
//		} else {
//			EndFailView.failView("�����Ͻ� ��¥�� ����� �Է��ϼ���!");
//		}
	}

	// ���� ���� ���� ���� �� �˻�
	public void lectureTeacherUpdate(String lectureName, Teacher teacher) {
		if (lectureName != null && teacher != null) {
			boolean result = service.lectureTeacherUpdate(lectureName, teacher);

			if (result) {
				try {
					EndView.lectureView(service.getLecture(lectureName));
				} catch (LectureNotFoundException e) {
					e.printStackTrace();
					EndFailView.failView("���� ���� ���� �� �˻� ����");
				}
			} else {
				EndFailView.failView("�������� �ʴ� ���� ���� �õ�");
			}
		} else {
			EndFailView.failView("�����Ͻ� ���� ������ ����� �Է��ϼ��䤷!");
		}
	}

	// ���� ������ ���� ����
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
		
		System.out.println(optLec.orElse(("\n�����Ͻ� ������ ������ ����� �Է��ϼ���!")));
		
//		if (lectureName != null && student != null) {
//			boolean result = service.lectureStudentUpdate(lectureName, student);

//			if (result) {
//				try {
//					EndView.lectureView(service.getLecture(lectureName));
//				} catch (LectureNotFoundException e) {
//					e.printStackTrace();
//					EndFailView.failView("������ ���� ���� �� �˻� ����");
//				}
//			} else {
//				EndFailView.failView("�������� �ʴ� ���� ���� �õ�");
//			}
//		} else {
//			EndFailView.failView("�����Ͻ� ������ ������ ����� �Է��ϼ���!");
//		}
	}

	// ���� ����
	public void lectureDelete(String lectureName) {
		
		Optional<Object> optLec = Optional.ofNullable(lectureName);
		optLec.ifPresent(data -> {
			boolean result = service.lectureDelete(lectureName);

			if (!result) {
				EndFailView.failView("������ ���ǰ� �������� �ʽ��ϴ�."); // �ٸ� ���� �Էµ� ��� �Ʒ� ���� �����..
			}
			
		});

		if (optLec.orElse(optLec).equals(lectureName)) {
			System.out.println("[" + optLec.orElse(lectureName) + "]" + " ���ǰ� �����Ǿ����ϴ�.");
		} else {
			System.out.println(optLec.orElse("�����Ϸ��� ���� �̸��� �Է��ϼ���!"));
		}

	}
//		if (lectureName != null) {
//			boolean result = service.lectureDelete(lectureName);
//
//			if (result) {
//				EndView.successView("'" + lectureName + "'" + "���ǰ� �����Ǿ����ϴ�.");
//			} else {
//				EndFailView.failView("������ ���ǰ� �����ϴ�.");
//			}
//		} else {
//			EndFailView.failView("�����Ϸ��� ���� �̸��� �Է��ϼ���!");
//		}
//	}

}
