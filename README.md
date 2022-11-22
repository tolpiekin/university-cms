# Task 3.2 Bootstrap project

Assignment
Create new Spring Boot project using Initializer with dependencies:
Spring Web (Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.)
Spring Data JPA (Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.)
Thymeleaf (A modern server-side Java template engine for both web and standalone environments. Allows HTML to be correctly displayed in browsers and as static prototypes.)
Flyway Migration (Version control for your database so you can migrate from any version (incl. an empty database) to the latest version of the schema.)
H2 Database or PostgreSQL Driver of your choice
Create model and schema initalizing sql migration script according with your UML diagrama

Create JPA repositories and service layer with base CRUD operations

Important:

From now on you should cover all your code (repository, service) with test in case you add any logic like custom query or multiple repository/service calls in one method

Example:

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

        // should not be covered with test 
	Optional<Group> findByGroupName(String name) throws SQLException;

        // sould be covered with test
	@Query(value = "SELECT gr.* "
			+ "FROM Groups gr inner join (SELECT COUNT(student_id) as studCount, group_id as group_id_counter FROM Students "
			+ "group by group_id " + ") as counter on group_id = group_id_counter "
			+ "WHERE studCount <= :stdCount", nativeQuery = true)
	List<Group> findWithEquelOrLessStudents(@Param("stdCount") int count) throws SQLException;
}


@Service
public class StudentService {

        // should not be covered with tests
        @Transactional
	public void deleteById(Long id) throws SQLException {
		studentRepository.delete(studentOpt.get());
	}
  
       // should be covered with test
       @Transactional
	public Student addCourse(Long studentId, Long courseId) throws SQLException {
	
		var student = studentRepository.findById(studentId);
		var course = courseRepository.findById(courseId);

		if (course.isPresent() && student.isPresent()) {
			Optional<Course> courseInStudent = student.get().getCourses().stream()
					.filter(c -> c.getId().equals(courseId)).findFirst();
			if (courseInStudent.isEmpty()) {
				student.get().getCourses().add(course.get());
				studentRepository.save(student.get());
				return student.get();
			}
		}

		throw new Somexception("Could not add student to course");
	}

}