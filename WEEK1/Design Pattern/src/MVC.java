public class MVC{
    static class Student {
        private String name;
        private int id;
        private String grade;

        public Student(String name, int id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }
        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public String getGrade() {
            return grade;
        }
        public void setName(String name) {
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }
    static class StudentView {

        public void displayStudentDetails(Student student) {
            System.out.println("Student Details");
            System.out.println("----------------");
            System.out.println("Name  : " + student.getName());
            System.out.println("ID    : " + student.getId());
            System.out.println("Grade : " + student.getGrade());
            System.out.println();
        }
    }
    static class StudentController {

        private Student model;
        private StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) {
            model.setName(name);
        }

        public void setStudentId(int id) {
            model.setId(id);
        }

        public void setStudentGrade(String grade) {
            model.setGrade(grade);
        }

        public void updateView() {
            view.displayStudentDetails(model);
        }
    }

    public static void main(String[] args) {

        Student student = new Student("Rahul", 101, "A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);

        System.out.println("Original Student Details:");
        controller.updateView();

        controller.setStudentName("Priya");
        controller.setStudentId(102);
        controller.setStudentGrade("A+");

        System.out.println("Updated Student Details:");
        controller.updateView();
    }
}
