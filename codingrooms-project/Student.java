public class Student {
    private String name;
    private String id;
    private String grades;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }



    public Student() {
    }

    public Student(String name, String id, String grades) {
        this.name = name;
        this.id = id;
        this.grades = grades;
    }
}