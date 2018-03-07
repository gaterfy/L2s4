import java.util.*;

public class Curriculum {
  private String name;
  private Map<Subject, Integer> subjects;

  public Curriculum(String name) {
    this.name = name;
    this.subjects = new HashMap<Subject, Integer>();
  }

  public String getName() {
    return this.name;
  }

  public Set<Subject> getSubjects() {
    return this.subjects.keySet();
  }

  public boolean contains(Subject subject) {
    return subjects.containsKey(subject);
  }

  public int coeffSubject(Subject subject) throws UnknownSubjectException {
    if (this.contains(subject)) {
      return this.subjects.get(subject);
    } else {
      throw new UnknownSubjectException(subject + " is unknown in " + this.name);
    }
  }

  public void addSubject(Subject subject, int coeff) throws AlreadyAddedSubjectException {
    if (this.contains(subject)) {
      throw new AlreadyAddedSubjectException(subject + " is already added");
    } else {
      this.subjects.put(subject, coeff);
    }
  }

  public void changeSubject(Subject subject, int coeff) throws UnknownSubjectException {
    if (this.contains(subject)) {
      this.subjects.replace(subject, coeff);
    } else {
      throw new UnknownSubjectException(subject + " is unknown in " + this.name);
    }
  }

  public void deleteSubject(Subject subject) throws UnknownSubjectException {
    if (this.contains(subject)) {
      this.subjects.remove(subject);
    } else {
      throw new UnknownSubjectException(subject + " is unknown in " + this.name);
    }
  }

  public String toString() {
    return this.name;
  }

  public static void main(String[] args) {
    Curriculum c = new Curriculum("Info");
    c.addSubject(Subject.TW2, 5);
    int coeffTW2 = c.coeffSubject(Subject.TW2);
    System.out.println(coeffTW2);
    c.addSubject(Subject.TW2, 5);
    System.out.println(c.getSubjects());
  }
}
