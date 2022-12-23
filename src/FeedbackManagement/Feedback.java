package FeedbackManagement;

public class Feedback {
    private String feedbackId;
    private String nameOfTheTutor;
    private String nameOfTheCourse;
    private String nameOfTheStudent;
    private String  ratings;

    public Feedback(String feedbackId, String nameOfTheTutor, String nameOfTheCourse, String nameOfTheStudent, String ratings) {
        this.feedbackId = feedbackId;
        this.nameOfTheTutor = nameOfTheTutor;
        this.nameOfTheCourse = nameOfTheCourse;
        this.nameOfTheStudent = nameOfTheStudent;
        this.ratings = ratings;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getNameOfTheTutor() {
        return nameOfTheTutor;
    }

    public void setNameOfTheTutor(String nameOfTheTutor) {
        this.nameOfTheTutor = nameOfTheTutor;
    }

    public String getNameOfTheCourse() {
        return nameOfTheCourse;
    }

    public void setNameOfTheCourse(String nameOfTheCourse) {
        this.nameOfTheCourse = nameOfTheCourse;
    }

    public String getNameOfTheStudent() {
        return nameOfTheStudent;
    }

    public void setNameOfTheStudent(String nameOfTheStudent) {
        this.nameOfTheStudent = nameOfTheStudent;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId='" + feedbackId + '\'' +
                ", nameOfTheTutor='" + nameOfTheTutor + '\'' +
                ", nameOfTheCourse='" + nameOfTheCourse + '\'' +
                ", nameOfTheStudent='" + nameOfTheStudent + '\'' +
                ", ratings='" + ratings + '\'' +
                '}';
    }
}
