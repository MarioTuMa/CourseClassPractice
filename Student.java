public class Student extends Person{

  Student(String n, String e){
    super(n,e);
  }
  public String getName(){
    return name;
  }
  public int compareTo(Student other){
    int minL = name.length();
    if(other.getName().length()<minL){
      minL = other.getName().length();
    }
    for(int i = 0; i < minL; i++){
      if(name.charAt(i)<other.getName().charAt(i)){
        return -1;
      }
      if(name.charAt(i)>other.getName().charAt(i)){
        return 1;
      }
    }
    return 0;
  }
}
