package QuanLySinhVien;

public class Sinhvien {
    private int id;
    private String student_name;
    private String semester;
    private String course_name;
    private int count1 = 1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCount1() {
        return count1;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }

    public void displayData() {
        System.out.printf("ID: %s || Name: %s || Semester: %s || Course: %s\n", id, student_name, semester, course_name);
    }
}
