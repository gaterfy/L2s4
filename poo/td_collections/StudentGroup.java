import java.util.*;

public class StudentGroup {
  private String name;
  private Curriculum curriculum;
  private Set<Student> students;

  public StudentGroup(String name, Curriculum curriculum) {
    this.name = name;
    this.curriculum = curriculum;
    this.students = new HashSet<Student>();
  }

  public void addStudent(Student student) {
    this.students.add(student);
  }

  public void removeStudent(Student student) {
    this.students.remove(student);
  }

  public float averageSubject(Subject subject) throws UnknownSubjectException, NoMarkException {
    if (!this.curriculum.contains(s)) {
      throw new UnknownSubjectException("Unknown subject");
    }
    float sum = 0;
    for (Student s : this.students) {
      sum += s.averageSubject(subject);
    }
    return sum/this.students.size();
  }

  public float average() {
    float sum = 0;
    int nb = 0;
    for (Student s : this.students) {
      try {
        sum += s.average();
        nb++;
      } catch (UnknownSubjectException e) {}
        catch (NoMarkException e1) {}
    }
    if (nb == 0) {
      throw NoMarkException("No grades!");
    } else {
      return sum/ nb;
    }
  }
}
