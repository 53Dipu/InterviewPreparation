package FeedbackManagement;

public class Student {
    private String studentId;
    private String studName;
    private Integer studRollNumber;
    private String courseId;
    private String tutorId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public Integer getStudRollNumber() {
        return studRollNumber;
    }

    public void setStudRollNumber(Integer studRollNumber) {
        this.studRollNumber = studRollNumber;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public Student(String studentId, String studName, Integer studRollNumber, String courseId, String tutorId) {
        this.studentId = studentId;
        this.studName = studName;
        this.studRollNumber = studRollNumber;
        this.courseId = courseId;
        this.tutorId = tutorId;


    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studName='" + studName + '\'' +
                ", studRollNumber=" + studRollNumber +
                ", courseId='" + courseId + '\'' +
                ", tutorId='" + tutorId + '\'' +
                '}';
    }
}
