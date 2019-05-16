package by.template.json;

import java.util.List;

public class Person {
    private String name;
    private Integer age;
    private Boolean isMarried;
    private List<String> hobbies;
    private List<Person> kids;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public Boolean getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(final Boolean isMarried) {
        this.isMarried = isMarried;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(final List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public List<Person> getKids() {
        return kids;
    }

    public void setKids(final List<Person> kids) {
        this.kids = kids;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ",\n age=" + age + ",\n isMarried=" + isMarried
                + ",\n hobbies=" + hobbies + ",\n kids=" + kids + "]";
    }

}
