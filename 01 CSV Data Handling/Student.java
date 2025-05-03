class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student { ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade + " }";
    }
}
