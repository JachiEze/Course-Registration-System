import java.util.Vector;


public class Student extends Person{
    private String id;
    private Vector<Course> courses; 
    /** contains all courses the student is registered in
     * 
     */

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    /** constructor
     * 
     * @param id
     * @param name
     */
    public Student(String id, String name) {
        /** initialize name and id. Also initialize the Vector
         * 
         */
        this.id = id;
        this.name = name;
        courses = new Vector<>();
    }

   
    public void registerFor(Course course) {
    	 /** registering the student for the given course
    	  * 
    	  */
        if (!courses.contains(course)) {
            courses.add(course);
            course.classList.add(this);
            course.getDept().registerList.add(this);
        }
    }

    public boolean isRegisteredInCourse(Course course) {
        return courses.contains(course);
    }

    public String toString() {
        /**return a string representation of a student using the following format:
        // 100234546 John McDonald
        // Registered courses: ELEE 2110, ELEE 2790, SOFE 2710, SOFE 2800, SOFE 2850
        // StringBuilder sb = new StringBuilder(id).append(" ").append(name).append("\nRegistered courses: ").append(courses.get(0).getCode()).append(" ").append(courses.get(0).getTitle());
         * 
         */

        StringBuilder sb = new StringBuilder(id).append(" ").append(name);
        
        for (Course course : courses) {
            sb.append(", ");
            sb.append(course.getCode()).append(" ").append(course.getTitle());
        }
        return sb.toString();
    }
}