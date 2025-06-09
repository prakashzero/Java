class add {
    static int staticvariable;
    int a=9;
    int b=6;
 public int MethodOverloading(int a, int b) {
  return a + b;
 }

 public double MethodOverloading(double a, double b) {
  return a + b;
 }

 public float MethodOverloading(float a, float b) {
  return a + b;
 }

 public static void sub(add obj1){
     System.out.println("static method "+staticvariable+" "+ obj1.a/obj1.b );

 }

 static {
     staticvariable=2;
     System.out.println("static block loads only once we can use for intiliaze the values");
 }

}

class Student{
  String name;
  int rollno;
  int marks;
}

public class Basic {
 public static void main(String args[]) {
  System.out.println("  bhanu");
  add a = new add();
  int b = a.MethodOverloading(2, 2);
  System.out.println(b);

  // why array needed
  // to store multiple value instead of using multiple variables you can use array
  int nums[] = { 2, 2, 3 };// fixed array elements
  nums[1] = 6;// overwriting the existing value
  System.out.println(nums[1]);
  int arr[] = new int[4];// you can add elements as your choice but still size is fixed
  // initially arr[] of size 4 will hold the data as 0. 0 0 0 0
  // you can replace as your choice
  for (int i = 0; i < arr.length; i++) {
   arr[i] = 4;
   System.out.println(arr[i]);
  }

  // multidimensional array

  int array[][] = new int[4][3];
  
System.out.println("multidimensional");
  for (int i = 0; i < 4; i++) {
   for (int j = 0; j < 3; j++) {
    array[i][j] = (int) (Math.random() * 100);
    
    //System.out.println(array[i][j] + " ");
   }
   //System.out.println();
  }

  //Enhanced for loop
  for(int c[]:array){
    for(int d:c){
     System.out.println(d+" ");
    }
    System.out.println();
  }

  Student s1=new Student();
  s1.name="Bhanu";
  s1.rollno=1;
  s1.marks=99;

  Student s2=new Student();
  s2.name="Prakash";
  s2.rollno=2;
  s2.marks=98;

  
  Student s3=new Student();
  s3.name="Sham";
  s3.rollno=3;
  s3.marks=98;

  Student student[]=new Student[3];
  student[0]=s1;
  student[1]=s2;
  student[2]=s3;

  // for(int i=0;i<student.length;i++){
  //   System.out.println(student[i].name+" "+student[i].rollno+" "+student[i].marks);
  // }

  for(Student s:student){
     System.out.println(s.name+" "+s.rollno+" "+s.marks);
  }

  String s="Bhanu";


  s=s+" Prakash";
  System.out.println(s);

  String ss="Bhanuu";
  String sss="Bhanuu";
  if(ss.equals(sss)){System.out.println(true);}

  StringBuffer sBuffer=new StringBuffer();
  System.out.println("created sBuffer "+sBuffer.capacity());
  sBuffer.append("Bhanu Prakash");
   System.out.println("After adding the Bhanu "+sBuffer.capacity());
  sBuffer.append(" something");

  System.out.println(sBuffer);

  add.staticvariable=3;

  add staticobject=new add();
  staticobject.staticvariable=909;
     System.out.println(staticobject.staticvariable);

     add obj1=new add();
     add.sub(obj1);










 }
}
