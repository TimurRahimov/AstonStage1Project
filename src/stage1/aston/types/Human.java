package stage1.aston.types;

public class Human {
	private Sex sex;
	private int age;
	private String secondName;

	public enum Sex {MALE, FEMALE};

	public Human() {
		this.sex = Sex.MALE;
		age = 0;
		secondName = "";
	}

	public Human setSex(Human.Sex sex) {
		this.sex = sex;
		return this;
	}
	
	public Human setAge(int age) {
		if (age < 0) {
			age = 0;
		}
		this.age = age;
		return this;
	}
	
	public Human setSecondName(String secondName) {
		// Валидатор на не буквы.
		this.secondName = secondName;
		return this;
	}

	@Override
	public String toString() {
		var sexString = sex == Sex.MALE ? "мужчина" : "женщина";
		return sexString + ", " + age + ", " + secondName;
	}
	
}
