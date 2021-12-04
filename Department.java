import java.util.Vector;
import java.util.HashSet;

public class Department {
    private String name; 
   /**
   * the name of school “Dept of Computing and Info Science.”
   */
    private String id; 
    /**
     *  short name for courses “SOFE”, “ELEE”, “STAT”, etc
     */
    Vector<Course> courseList; 
    /**
     * all courses offered by the department
     */
    Vector<Student> registerList; 
    /**
     * all students taking courses in the department.
     * @return
     */

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Department(String name, String id) {
        /**
         * also initialize the vectors
         */
        this.name = name;
        this.id = id;
        courseList = new Vector<>();
        registerList = new Vector<>();
    }

    /**
     * adding course to the courseList of the department
     * @param course
     */
    public void offerCourse(Course course) {
        courseList.add(course);
    }

   
    public void printCoursesOffered() {
    	 /**
         *  printing all the courses offered by the department using Course's toString() method
         */
        for(Course course : courseList)
            System.out.println(course.toString());
    }

   
    public void printStudentsByName() {
    	 /**
         * printing all the students in the department using Student's toString() method
         */
       
        for(Student student : registerList)
            System.out.println(student.toString());
    }
    
    public boolean isStudentRegistered(Student student) {
    	/**
    	 *  checking if the given student is registered using Vector.contains() method
    	 */
        return registerList.contains(student);
    }

    
    public Vector<Student> studentsRegisteredInCourse(int number) {
    	/**
    	 * returning all the students registered in the given course using the course number(not code)
    	 */
        for (Course course : courseList) {
            if (course.getNumber() == number)
                return course.classList;
        }
        
        return null;
     /**
      *  if no student is registered, returning null
      */
    }

   
    public void printStudentsRegisteredInCourse(int number) {
    	 /**
    	  *  printing students registered in a course using the course number(not code)
    	  */
        
        if (studentsRegisteredInCourse(number).isEmpty()) {
            System.out.println("None");
            return;
        }
     /**
      * if there are no students registered in the given course, printing None
      */
                
        for (Student student : studentsRegisteredInCourse(number)) {
            System.out.println(student.getId() + ", " + student.getName());
        }
    }

   
    public Course largestCourse() {
    	 /**
    	  *  returning the course with highest number of students
    	  */
        
        int max = 0;
     /**
      * variable to store the max number of students
      */
        
        Course largCourse = new Course();
     /**
      *  variable to store the course with highest number of students
      */
        for (Course course : courseList) {
            if (course.classList.size() > max) {
                /**
                 *  if the current course has more students than max
                 */
                max = course.classList.size();
                largCourse = course;
            }
        }
        return largCourse;
    }

    public String toString() {
        /** returns a string representation of department name, number
        // of courses offered and number of students registered in the
        // department. Use the format:
        // ECSE: 53 courses, 460 students
         * 
         */
        return id + ": " + String.valueOf(courseList.size()) + " courses, " + String.valueOf(registerList.size()) + " students";
    }
}
