package FeedbackManagement;

import java.util.*;
import java.util.stream.Collectors;

public class FeedBackService {
public boolean validateCourseInput(List<Course> courses, String courseId){
    if(courses != null && !courses.isEmpty()){
        return courses.stream().anyMatch(course -> course.getCourseId().equalsIgnoreCase(courseId));
    }else {
        return false;
    }
}
    public boolean validateTutorInput(List<Tutor> tutors, String tutorId) {
        if (tutors != null && !tutors.isEmpty()) {
            return tutors.stream().anyMatch(tutor -> tutor.getTutorId().equalsIgnoreCase(tutorId));
        } else {
            return false;
        }
    }
    public boolean validateInputForFeedback(List<Course> courses, List<Tutor> tutors, List<Student> students,
                                            String courseName, String tutorName, String studentName) {
    boolean flag1 = false, flag2=false, flag3 = false;
    if(courses != null && !courses.isEmpty()){
        flag1 = courses.stream().anyMatch(course -> course.getCourseName().equalsIgnoreCase(courseName));
    }
    if (tutors != null && !tutors.isEmpty()) {
        flag2 = tutors.stream().anyMatch(tutor -> tutor.getTutorName().equalsIgnoreCase(tutorName));
    }
    if(students != null && !students.isEmpty()){
        flag3 = students.stream().anyMatch(student -> student.getStudName().equalsIgnoreCase(studentName));
    }
    return flag1 && flag2 && flag3;
    }

    public Map<String, List<Feedback>> constructCourseFeedbackMapping(List<Course> courses, List<Feedback> feedBacks) {
        /*
         * courses : [C1, C2, C3]
         * feedBacks : [f1,f2,f3,f4,f5,f6]
         *
         * Java (C1), T1, S1 --> f1
         * Spring(C2), T1, S1 --> f2
         * Java(C1), T2, S1 --> f3
         * SQL(C3), T3, S2 --> f4
         * Java(C1), T3, S3 --> f5
         * Spring(C2), T2, S3 --> f6
         *
         * C1(Java): [f1, f3, f5]
         * C2(Spring): [f2, f6]
         * C3(SQL):[f4]
         *
         * */
        Map<String, List<Feedback>> feedbackMap = new HashMap<>();
        for(Feedback feedback: feedBacks) {
            String courseName = feedback.getNameOfTheCourse();
            String courseId = "";
            Optional<Course> optionalCourse = courses.stream().filter(course ->
                    course.getCourseName().equalsIgnoreCase(courseName)).findFirst();
            if (optionalCourse != null) {
                Course course = optionalCourse.get();
                courseId = course.getCourseId();
            }

            if (feedbackMap != null && !feedbackMap.isEmpty() && feedbackMap.containsKey(courseId)) {
                List<Feedback> receivedList = feedbackMap.get(courseId);
                receivedList.add(feedback);
                feedbackMap.put(courseId, receivedList);
            } else {
                List<Feedback> feedbackList = new ArrayList<>();
                feedbackList.add(feedback);
                feedbackMap.put(courseId, feedbackList);
            }
        }
        return feedbackMap;
    }

    public Map<String, List<Feedback>> constructTutorFeedbackMapping(List<Tutor> tutors, List<Feedback> feedBacks) {

        Map<String, List<Feedback>> feedbackMap = new HashMap<>();
        for (Feedback feedback : feedBacks) {
            String tutorName = feedback.getNameOfTheTutor();
            String tutorId = "";
            Optional<Tutor> optionalTutor = tutors.stream().filter(tutor ->
                    tutor.getTutorName().equalsIgnoreCase(tutorName)).findFirst();
            if (optionalTutor != null) {
                Tutor tutor = optionalTutor.get();
                tutorId = tutor.getTutorId();
            }

            if (feedbackMap != null && !feedbackMap.isEmpty() && feedbackMap.containsKey(tutorId)) {
                List<Feedback> receivedList = feedbackMap.get(tutorId);
                receivedList.add(feedback);
                feedbackMap.put(tutorId, receivedList);
            } else {
                List<Feedback> feedbackList = new ArrayList<>();
                feedbackList.add(feedback);
                feedbackMap.put(tutorId, feedbackList);
            }
        }
        return feedbackMap;
    }

    public Map<String, List<Feedback>> constructStudentFeedbackMapping(List<Student> students, List<Feedback> feedBacks) {

        Map<String, List<Feedback>> feedbackMap = new HashMap<>();
        for (Feedback feedback : feedBacks) {
            String studName = feedback.getNameOfTheStudent();
            String studId = "";
            Optional<Student> optionalStudent = students.stream().filter(student ->
                    student.getStudName().equalsIgnoreCase(studName)).findFirst();
            if (optionalStudent != null) {
                Student student = optionalStudent.get();
                studId = student.getStudentId();
            }

            if (feedbackMap != null && !feedbackMap.isEmpty() && feedbackMap.containsKey(studId)) {
                List<Feedback> receivedList = feedbackMap.get(studId);
                receivedList.add(feedback);
                feedbackMap.put(studId, receivedList);
            } else {
                List<Feedback> feedbackList = new ArrayList<>();
                feedbackList.add(feedback);
                feedbackMap.put(studId, feedbackList);
            }
        }
        return feedbackMap;
    }

    public Map<String, List<Feedback>> displayFeedbackBasedOnName(Map<String, List<Feedback>> inputCourseFeedbackMap)  {
        Map<String, List<Feedback>> sortedCourseFeedbackMap = new HashMap<>();
        for(Map.Entry<String, List<Feedback>> entry: inputCourseFeedbackMap.entrySet()) {
            List<Feedback> feedbackList = entry.getValue();
            feedbackList = feedbackList.stream().sorted(Comparator.comparing(Feedback :: getNameOfTheStudent)).collect(Collectors.toList());
            sortedCourseFeedbackMap.put(entry.getKey(), feedbackList);
        }
        return sortedCourseFeedbackMap;
    }

    public Map<String, List<Feedback>> displayFeedbackBasedRatings(Map<String, List<Feedback>> inputTutorFeedbackMap)  {
        Map<String, List<Feedback>> sortedCourseFeedbackMap = new HashMap<>();
        for(Map.Entry<String, List<Feedback>> entry: inputTutorFeedbackMap.entrySet()) {
            List<Feedback> feedbackList = entry.getValue();
            Collections.sort(feedbackList, (Comparator) (obj1, obj2) -> {
                Feedback fObj1 = (Feedback)obj1;
                Feedback fObj2 = (Feedback)obj2;
                if (fObj1.getRatings().equalsIgnoreCase(fObj2.getRatings())) {
                    return 0;
                } else {
                    if (fObj1.getRatings().equals('O') && (fObj2.getRatings().equals('G') || fObj2.getRatings().equals('A') || fObj2.getRatings().equals('P'))) {
                        return 1;
                    } else if ((fObj1.getRatings().equals('G') || fObj1.getRatings().equals('A') || fObj1.getRatings().equals('P')) && fObj2.getRatings().equals('O')) {
                        return -1;
                    } else if (fObj1.getRatings().equals('G') && (fObj2.getRatings().equals('A') || fObj2.getRatings().equals('P'))) {
                        return 1;
                    } else if ((fObj1.getRatings().equals('A') || fObj2.getRatings().equals('P')) && fObj2.getRatings().equals('G')) {
                        return -1;
                    } else if (fObj1.getRatings().equals('A') && fObj2.getRatings().equals('P')) {
                        return 1;
                    } else if (fObj1.getRatings().equals('P') && fObj1.getRatings().equals('A')) {
                        return -1;
                    }
                }
                return 0;
            });
            sortedCourseFeedbackMap.put(entry.getKey(), feedbackList);
        }
        return sortedCourseFeedbackMap;
    }
}