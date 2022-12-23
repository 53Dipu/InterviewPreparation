package FeedbackManagement;

public class Course {
    private String CourseId;
    private String courseName;

    public Course(String courseId, String courseName) {
        CourseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseId() {
        return CourseId;
    }

    public void setCourseId(String courseId) {
        CourseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "CourseId='" + CourseId + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
