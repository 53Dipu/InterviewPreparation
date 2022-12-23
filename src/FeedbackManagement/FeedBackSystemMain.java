package FeedbackManagement;

import java.util.*;

public class FeedBackSystemMain {
    public static Scanner sc = new Scanner(System.in);
    public static List<Course> courses = new ArrayList<>();
    public static List<Tutor> tutors = new ArrayList<>();
    public static List<Student> students = new ArrayList<>();
    private static FeedBackService feedbackService = new FeedBackService();
    private static List<Feedback> feedBacks = new ArrayList<>();
    private static Map<String, String> ratingMap = new HashMap<>();
    private static Map<String, List<Feedback>> courseFeedbackMap = new HashMap<>();
    private static Map<String, List<Feedback>> tutorFeedbackMap = new HashMap<>();
    private static Map<String, List<Feedback>> studentFeedbackMap = new HashMap<>();
    public static void main(String[] args) {

        //Call rating map
        getRatingMap();
        //Taking input for course
        inputCourseDetails();
        //Taking input for Tutor
        inputTutorDetails();
        //Taking input for Students
        inputStudentDetails();
        //Taking input for Feedback
        inputOfFeedback();

        //Create Map from Feedback list
        courseFeedbackMap = feedbackService.constructCourseFeedbackMapping(courses, feedBacks);
        System.out.println("Feed Back map based on Course :: "+courseFeedbackMap);

        System.out.println("Display the sorted element of Course: "+ feedbackService.displayFeedbackBasedOnName(courseFeedbackMap));

        //Create Tutor Feedback Map from Feedback list
        tutorFeedbackMap = feedbackService.constructTutorFeedbackMapping(tutors, feedBacks);
        System.out.println("Feed Back map Based on Tutor:: "+tutorFeedbackMap);

        //Create Student Feedback Map from Feedback list
        studentFeedbackMap = feedbackService.constructStudentFeedbackMapping(students, feedBacks);
        System.out.println("Feed Back map Based on Student:: "+studentFeedbackMap);

        System.out.println("Display Map based on Ratings ::" + feedbackService.displayFeedbackBasedRatings(tutorFeedbackMap));

    }
    public static List<Course> inputCourseDetails(){
        System.out.println("Please Enter the course Details ");
        int inputCounter = 0;
        do {
            System.out.println("Enter the CourseId : ");
            String courseId = sc.next();

            System.out.println("Input the course Name : ");
            String courseName = sc.next();

            courses.add(new Course(courseId,courseName));
            inputCounter++;

        } while (inputCounter < FeedBackSystemLimit.numberOfAllowedValidInput);
        return courses;
    }
    public static List<Tutor> inputTutorDetails(){
        System.out.println("Please Enter the Tutor Details ");
        int inputCounter = 0;
        do {
            System.out.println("Input CourseId for Tutor : ");
            String courseId = sc.next();

            if(feedbackService.validateCourseInput(courses,courseId)){
                System.out.println("Input tutorId : ");
                String tutorId = sc.next();

                System.out.println("Input TutorName : ");
                String tutorName = sc.next();

                tutors.add(new Tutor(tutorId, tutorName,courseId));

            }else {
                System.out.println("Please Input Valid Course Id : ");
            }

            inputCounter++;

        }while (inputCounter < FeedBackSystemLimit.numberOfAllowedValidInput);
        return tutors;

    }
    public static List<Student> inputStudentDetails() {
        System.out.println("Please Enter the Student Details ");
        int inputCounter = 0;
        String tutorId;
        do {
            System.out.println("input courseId for Student : ");
            String courseId = sc.next();

            System.out.println("Input tutorId : ");
            tutorId = sc.next();

        if (feedbackService.validateCourseInput(courses, courseId)
                && feedbackService.validateTutorInput(tutors, tutorId)) {
            System.out.println("Enter Student Id : ");
            String studId = sc.next();

            System.out.println("Input StudentName : ");
            String studName = sc.next();

            System.out.println("Enter Student Roll Number:");
            Integer studRollNo = sc.nextInt();
            students.add(new Student(studId, studName, studRollNo, courseId, tutorId));

        }
        inputCounter++;
        }while (inputCounter < FeedBackSystemLimit.numberOfAllowedValidInput);
        return students;
    }

        public static List<Feedback> inputOfFeedback() {
            System.out.println("Please Enter the FeedBack Details ");
        int inputCounter = 0;
        do {
            System.out.println("Enter the Name of The course for feedback :");
            String courseName = sc.next();

            System.out.println("Enter the Tutor Name: ");
            String tutorName = sc.next();

            System.out.println("Enter the Student Name :");
            String studName = sc.next();

            if (feedbackService.validateInputForFeedback(courses, tutors, students,
                    courseName, tutorName, studName)){
                System.out.println("Enter the Feedback Id :");
                String feedBackId = sc.next();

                System.out.println("Please enter the rating: ('O': Outstanding, 'G': Good, 'A':Average, 'P': poor )");
                String rating = sc.next();
                if (ratingMap.containsKey(rating)) {
                    feedBacks.add(new Feedback(feedBackId, tutorName, studName, courseName, rating));
                }
            }
            inputCounter++;

        } while(inputCounter < FeedBackSystemLimit.numberOfAllowedValidInput);
        return feedBacks;
    }

        public static Map<String, String> getRatingMap() {
        ratingMap.put("O","Outstanding");
        ratingMap.put("G","Good");
        ratingMap.put("A","Average");
        ratingMap.put("P","Poor");
        return ratingMap;
    }



}