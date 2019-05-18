import java.util.*;
public class Course{
  private ArrayList<Nano> nanos;
  private ArrayList<Mentor> mentors;
  protected int mentorSize;
  protected int classSize;
  protected int name;
  Course(String name){
    nanos = new ArrayList<Nano>();
    mentors = new ArrayList<Mentor>();
    mentorSize = 0;
    classSize = 0;
    name = name;
  }
  public void addStudent(Nano s){
    nanos.add(s);
    classSize++;
  }
  public void addMentor(Mentor m){

    mentors.add(m);
    mentorSize=1;
  }
  public void addMentors(ArrayList<Mentor> ms){

    for(int i = 0; i < ms.size(); i++){
      mentors.add(ms.get(i));
    }
    mentorSize=mentors.size();
  }
  private void setMentor(Mentor m){
    mentors = new ArrayList<Mentor>();
    mentors.add(m);
    mentorSize=1;
  }
  public void removeMentor(Mentor m){
    for(int i = 0; i < mentors.size(); i++){
      if(mentors.get(i).equals(m)){
        mentors.remove(i);
      }
    }
  }
  public void removeStudent(Nano s){
    for(int i = 0; i < nanos.size(); i++){
      if(nanos.get(i).equals(s)){
        nanos.remove(i);
      }
    }
  }
  public boolean isNanoInTheClass(Nano d){
    for(int i = 0; i < nanos.size(); i++){
      if(nanos.get(i).equals(d)){
        return true;
      }
    }
    return false;
  }
  public ArrayList<Nano> rosterSortedAlphabetically(){
    for(int i = 1; i < nanos.size(); i++){
      for(int j = i; j > 0; j --){
        if(nanos.get(j).compareTo(nanos.get(j-1))<0){
          Nano temp = nanos.get(j);
          nanos.set(j,nanos.get(j-1));
          nanos.set(j-1,temp);
        }
      }
    }

    return nanos;
  }
  public String toString(ArrayList<Nano> ppl){
    String toReturn = "";
    for(int i = 0; i < ppl.size(); i++){
      toReturn+=ppl.get(i).getName()+" ";
    }
    return toReturn;
  }
  public static void main(String[] args){
    Mentor ricky = new Mentor("Ricky","ricky@gmail");
    Mentor julian = new Mentor("Julian","julian@gmail");
    Nano mario = new Nano("Mario","mario@gmail");
    Nano erin = new Nano("Erin","erin@gmail");
    Nano lucas = new Nano("Lucas","lucas@gmail");
    Nano giordan = new Nano("Giordan","giordan@gmail");
    Nano noah = new Nano("Noah","noah@gmail");
    Nano jude = new Nano("Jude","jude@gmail");
    Nano jordan = new Nano("Jordan","jordan@gmail");
    Nano olivia = new Nano("Olivia","olivia@gmail");
    Course course = new Course("Data Structures");
    course.addStudent(noah);
    course.addStudent(mario);
    course.addStudent(erin);
    course.addStudent(lucas);
    course.addStudent(giordan);
    System.out.println(course.classSize);
    course.setMentor(ricky);
    ArrayList<Mentor> newMentors = new ArrayList<Mentor>();
    newMentors.add(ricky);
    newMentors.add(julian);
    course.addMentors(newMentors);
    System.out.println(course.mentorSize);
    course.removeMentor(julian);
    course.removeStudent(giordan);
    System.out.print(course.isNanoInTheClass(mario)+" should be true \n");
    System.out.print(course.isNanoInTheClass(olivia)+" should be false \n");
    System.out.print(course.isNanoInTheClass(giordan)+" should be false \n");
    course.addStudent(giordan);
    //course.addStudent(noah);
    course.addStudent(jude);
    course.addStudent(jordan);
    course.addStudent(olivia);
    System.out.println(course.toString(course.rosterSortedAlphabetically())); // return a sorted list of names
  }
}
