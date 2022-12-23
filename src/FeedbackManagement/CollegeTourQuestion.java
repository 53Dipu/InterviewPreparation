package FeedbackManagement;

import java.util.Scanner;

public class CollegeTourQuestion {
    public static void main(String[] args) {

       /* Background of the Requirements: In College, students are required to provide feedback on each tutor associated to the college and mapped to the each courses that Students has enrolled.
        In feedback form below question has be incorporated,
        1. Name of the tutor
        2. Name of Course associated to the tutor
        3. Name of the Student
        4. Rating ('O' : Outstanding, 'G': Good, 'A': Average, 'P': Poor)
        When feedback form filled up then the feedback for the course will be mapped with the feedback based on the courseId. One course can have multiple feedback (list of feedback form)

Feedback will be mapped to the tutor based on the tutorId.

Once Student provide feedback then same feedback form will be mapped with the Student based on the studentId.
One Course can have multiple tutor associated, a student can provide feedback for different tutor for the same course. On student can have multiple feeback form associated(list of feedback).

Now Class that needs to be created,
	 i) Course -> courseId, courseName
	ii) Tutor -> tutorId, tutorName, courseId
   	iii) Student -> studentId, studName, studRollNumber, courseId, tutorId
    	iv) Feedback -> feedabckId, nameOfTheTutor, nameOfTheCourse, nameOfTheStudent, rating

Populate all the necessary Information of the Course, Tutor, and Student.
While taking iput make sure maintain the order, like course will be taking input first with courseId and CourseName. Then take input for Tutor, where use the courseId entered in the previous steps.
Likewise for students also use the courseId and tutorId will be the matching that entered for Course and Tutor respectively.

Store all the information of Course, Tutor, Student in List and then use it across.

Once we have all the required info then take the input of the feedback form. In the feedback form enter the name of the student, tutor, course present in the above list of input that has been taken.

When we provide input in the feedback form then search the courseName in the courceList (input taken above) and the get the courseId associated with the course, next prepare one Map for course
and put the courseId as key and entire feedback corresponding to that as value.

Similarly create another 2 map one related to Tutor and another with Students.

Once we prepare the 3 Map courseFeedbackMap:: (courseId (key), List<Feedback> (if more than one feeback associated with the same Course)/Feedback (Value)),
						  studentFeedbackMap:: (studentId (Key), List<Feedback> (if more than one feeback associated with the same Student)/Feedback (Value)),
						  tutorFeedbackMap:: (tutorId, List<Feedback> (if more than one feedback associated with same tutor)/Feedback (Value))

Please bring out put of the below requirements,

  i) Display courseFeedbackMap based on the shorted order(ascending) of the Student Name.
 ii) Display tutorFeedbackMap based on the shorted order of the tutorId.
iii) Display studentFeedbackMap based on the shorted order(Descending) of the Tutor Name.
 iv) Display tutorFeedbackMap based sorted order of the feedback Rating given.
		Like if Rating given as 'O' then it will be high priority, if given 'G' then next to 'O', then 'A' and 'P'
		so order would : 'O' > 'G' > 'A' > 'P'. (Create one Comparator and put logic like below)
		if (obj1.getRating().equlasIgnoreCase(obj2.getRating())) {
			return 0;
		} else {
			if (obj1.getRating().equals('O') && (obj2.getRating().equals('G') || obj2.getRating().equals('A') || obj2.getRating().equals('P'))) {
				return 1;
			} else if ((obj1.getRating().equals('G') || obj1.getRating().equals('A') || obj1.getRating().equals('P')) && obj2.getRating().equals('O')) {
				return -1;
			} else if (obj1.getRating().equals('G') && (obj2.getRating().equals('A') || obj2.getRating().equals('P'))) {
				return 1;
			} else if ((obj1.getRating().equals('A') || obj2.getRating().equals('P')) && obj2.getRating().equals('G')) {
				return -1;
			} else if (obj1.getRating().equals('A') && obj2.getRating().equals('P')) {
				return 1;
			} else if (obj1.getRating().equals('P') && obj1.getRating().equals('A')) {
				return -1;
			}
		}
*/

        Scanner sc = new Scanner(System.in);

        System.out.println("Input TourId");
        Integer tourId = sc.nextInt();

        System.out.println("Input name of the Tour");
        String TourName = sc.next();

        System.out.println("Input name of Course associated to the tutor");
        String Course = sc.next();

        System.out.println("Input CourseID");
        Integer CourseId = sc.nextInt();

        System.out.println("Input StudentId");
        Integer studentId = sc.nextInt();

        System.out.println("Input name of the student");
        String studentName = sc.next();

        System.out.println("Input the ratings if ('O' : Outstanding, 'G': Good, 'A': Average, 'P': Poor)");
        String rating = sc.next();

        switch(rating){
            case "O" :
                System.out.println("You receive an Outstanding");
                break;
            case "G":
                System.out.println("You receive a Good");
                break;
            case "A":
                System.out.println("You receive an Average");
                break;
            case "P":
                System.out.println("You receive a Poor");
                break;

        }

    }
}
