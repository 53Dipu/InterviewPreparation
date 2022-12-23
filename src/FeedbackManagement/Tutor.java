package FeedbackManagement;

public class Tutor {
    private String tutorId;
    private String tutorName;
    private String courseId;

    public Tutor(String tutorId, String tutorName, String courseId) {
        this.tutorId = tutorId;
        this.tutorName = tutorName;
        this.courseId = courseId;
    }

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "tutorId=" + tutorId +
                ", tutorName='" + tutorName + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }
}
