import java.util.*;

public class Student {

  private Identity id;
  private Curriculum curriculum;
  private Map<Subject, List<Float>> marks;

  public Student(Identity id, Curriculum curriculum) {
    this.id = id;
    this.curriculum = curriculum;
    this.marks = new HashMap<Subject, List<Float>>();
    for (Subject s : this.curriculum.getSubjects()) {
      this.marks.put(s, new ArrayList<Float>());
    }
  }

  public Identity getIdentity() {
    return this.id;
  }

  public Curriculum getCurriculum() {
    return this.curriculum;
  }

  public void setCurriculum(Curriculum curriculum) {
    this.marks.clear();
    this.curriculum = curriculum;
  }

  public Set<Subject> getSubjects() {
    return this.marks.keySet();
  }

  public List<Float> getMarksBySubject(Subject subject) throws UnknownSubjectException {
    if (this.marks.containsKey(subject)) {
      return this.marks.get(subject);
    } else {
      throw new UnknownSubjectException("No subject!");
    }
  }

  public void addMark(Float mark, Subject subject) throws UnknownSubjectException {
    List<Float> grades = this.getMarksBySubject(subject);
    grades.add(mark);
  }

  public float averageSubject(Subject subject) throws UnknownSubjectException, NoMarkException {
    List<Float> grades = this.getMarksBySubject(subject);
    if (grades.isEmpty()) {
      throw new NoMarkException("No grades!");
    }
    float result = 0;
    for (Float grade : grades) {
      result += grade;
    }
    return result/grades.size();
  }

  public float average() throws NoMarkException {
    float sum = 0;
    int sumCoeff = 0;
    for (Subject s : this.getSubjects()) {
      try {
        int coeff = this.curriculum.coeffSubject(s);
        sumCoeff += coeff;
        sum += this.averageSubject(s)*coeff;
      } catch (UnknownSubjectException e) {}
    }
    if (sumCoeff == 0)
      throw new NoMarkException("No grades!");
    else
      return sum/sumCoeff;
  }

  public boolean equals(Object o) {
    if (o instanceof Student) {
      Student theOther = (Student) o;
      return this.id == theOther.getIdentity() && this.curriculum == theOther.getCurriculum();
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    Identity id = new Identity("12345678", "Doe", "John");
    Curriculum c = new Curriculum("L2INFO");
    Student s = new Student(id, c);
  }
}
