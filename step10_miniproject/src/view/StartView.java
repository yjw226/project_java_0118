package view;

import controller.AcademyProjectController;
import model.dto.Lecture;
import model.dto.LectureInformation;
import model.dto.Student;
import model.dto.Teacher;

public class StartView {

	public static void main(String[] args) {
		
		// ����
		// ��ȣ, �̸�, ����ó, �̸���, ����, ���
		Teacher teacher1 = new Teacher(11, "������", "010-1111-2222", "jongwon@playdata.com", "����", 5);
		Teacher teacher2 = new Teacher(22, "������", "010-3333-2322", "jiwon@playdata.com", "�߱���", 6);
		Teacher teacher3 = new Teacher(33, "�迹��", "010-9877-6544", "yeji@playdata.com", "�Ϻ���", 3);
		
		// ������
		// ��ȣ, �̸�, ����ó, ������, ��ϳ�¥
		Student student1 = new Student(1, "������", "010-4567-3453", "jlptN2��", "2022-01-11");
		Student student2 = new Student(2, "������", "010-3232-4555", "HSK5�޹�", "2021-12-5");
		Student student3 = new Student(3, "������", "010-2342-2525", "flex�Ϻ���", "2022-01-02");
		Student student4 = new Student(4, "����ǥ", "010-5253-4543", "TOEFL��5�ϰ��Ư��", "2021-11-23");
		Student student5 = new Student(5, "������", "010-4333-6567", "�Ѵ޿ϼ�900��", "2022-01-09");
		Student student6 = new Student(6, "������", "010-2222-2344", "HSK5�޹�", "2021-10-25");
		Student student7 = new Student(7, "�弱��", "010-4235-5667",  "TOEFL��5�ϰ��Ư��", "2021-09-30");
		Student student8 = new Student(8, "������", "010-1445-0999", "flex�Ϻ���", "2022-01-07");
		
		// ����
		// ���� �̸�, ����, �����̸�, ������¥, ������¥
		LectureInformation lectureInformation1 = new LectureInformation("�Ѵ޿ϼ�900��", "TOEIC", "2022-02-01", "2022-03-01");
		LectureInformation lectureInformation2 = new LectureInformation("HSK5�޹�", "HSK", "2022-02-05", "2022-04-04");
		LectureInformation lectureInformation3 = new LectureInformation("jlptN2��", "jlpt", "2022-02-10", "2022-04-09");
		LectureInformation lectureInformation4 = new LectureInformation("TOEFL��5�ϰ��Ư��", "TOEFL", "2022-01-24", "202202-28");
		LectureInformation lectureInformation5 = new LectureInformation("flex�Ϻ���", "flex", "2022-01-31", "2022-02-20");
		
		// �������� ���� 
		Lecture toeicTest = new Lecture("01�Ѵ޿ϼ�900��", teacher1, lectureInformation1, student5);
		Lecture hskTest = new Lecture("02HSK5�޹�", teacher2, lectureInformation2, student2);
		Lecture jlptTest = new Lecture("03jlptN2��",  teacher3, lectureInformation3, student1);
		Lecture toeflTest = new Lecture("04TOEFL��5�ϰ��Ư��", teacher1, lectureInformation4, student4);
		Lecture flexTest = new Lecture("05flex�Ϻ���", teacher3, lectureInformation4, student3);
		
		AcademyProjectController controller = AcademyProjectController.getInstance();
		
		System.out.println("---- ���� ���� ----");
		controller.lectureInsert(toeicTest);
		controller.lectureInsert(null);
		controller.lectureInsert(hskTest);
		controller.lectureInsert(jlptTest);
		controller.lectureInsert(toeflTest);
		controller.lectureInsert(flexTest);
		
		// ������ ��� ���� ���� ���
		System.out.println("\n--- ��� ���� ���� ---");
		controller.getLectureList();
		
		// ���� ���� �˻�
		System.out.println("\n\n--- 04TOEFL��5�ϰ��Ư�� ���� �˻� ---");
		controller.getLecture("04TOEFL��5�ϰ��Ư��");
		
		System.out.println("\n--- 05flex�Ϻ��� ���� �˻� ---");
		controller.getLecture("05flex�Ϻ���");
		
		// ������ ���� ���
		System.out.println("\n\n--- 04TOEFL��5�ϰ��Ư�� ������ ���� ---");
		controller.getLectureStudent("04TOEFL��5�ϰ��Ư��");
		
		System.out.println("\n--- 05flex�Ϻ��� ������ ���� ---");
		controller.getLectureStudent("05flex�Ϻ���");
		
		// ���� ���� ���
		System.out.println("\n\n--- 04TOEFL��5�ϰ��Ư�� ���� ���� ---");
		controller.getLectureTeacher("04TOEFL��5�ϰ��Ư��");
		
		System.out.println("\n--- 05flex�Ϻ��� ���� ���� ---");
		controller.getLectureTeacher("05flex�Ϻ���");
		
		// 04TOEFL��5�ϰ��Ư�� ���� ���� ��¥ ���� �� �˻�
		System.out.println("\n\n--- 04TOEFL��5�ϰ��Ư�� ���� ���� ��¥ ���� ---");
		controller.lectureDateUpdate("04TOEFL��5�ϰ��Ư��", null);
		
		System.out.println("\n\n--- 04TOEFL��5�ϰ��Ư�� ���� ���� ��¥ �纯�� --- ");
		controller.lectureDateUpdate(null, "2022-02-01");
		
		System.out.println("\n\n--- 04TOEFL��5�ϰ��Ư�� ���� ���� ��¥ ����� ���� ---");
		controller.lectureDateUpdate("04TOEFL��5�ϰ��Ư��", "2022-02-01");
		
		// 04TOEFL��5�ϰ��Ư�� ���� ����
		System.out.println("\n\n--- 04TOEFL��5�ϰ��Ư�� ���� ���� ---");
		controller.lectureTeacherUpdate("04TOEFL��5�ϰ��Ư��", teacher2);
		
		// 04TOEFL��5�ϰ��Ư�� ������ ����
		System.out.println("\n\n--- 04TOEFL��5�ϰ��Ư�� ������ ���� ---");
		controller.lectureStudentUpdate(null, student7);
		
		// 04TOEFL��5�ϰ��Ư�� ���� ����
		System.out.println("\n\n--- 04TOEFL��5�ϰ��Ư�� ���� ���� ---");
		controller.lectureDelete("null");
		
		System.out.println("\n\n ---- ���Է� -----");
		controller.lectureDelete("04TOEFL��5�ϰ��Ư��");
		controller.getLecture("04TOEFL��5�ϰ��Ư��");
	}
}
