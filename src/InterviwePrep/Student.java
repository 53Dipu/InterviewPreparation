package InterviwePrep;

public class Student {
    private int studentId;
    private String studName;
    private int studRollNumber;
    private Course course;              // for courseId
    private Tutor tutor;                // for tutorId

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public int getStudRollNumber() {
        return studRollNumber;
    }

    public void setStudRollNumber(int studRollNumber) {
        this.studRollNumber = studRollNumber;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
