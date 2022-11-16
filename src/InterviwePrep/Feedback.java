package InterviwePrep;

public class Feedback {
    private int feedbackId;
    private String nameOfTheTutor;
    private String nameOfTheCourse;
    private String nameOfTheStudent;
    private String  rating;

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
