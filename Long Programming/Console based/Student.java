class Student {
   private  int id;
   private  String name;
   private  String dept;
   private String DOB;
   StudentPerformance sp;

    public StudentPerformance getSp() {
        return sp;
    }

    public void setSp(StudentPerformance sp) {
        this.sp = sp;
    }
    public Student(String DOB, String dept, String name, int id) {

        this.DOB = DOB;
        this.dept = dept;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
}