class Student {
	String name;
	float laziness; // примитивный тип вместо Float
	byte iq;        // примитивный тип вместо Byte
	int exams;
	int[] marks;    // стиль Java: тип[] имяПеременной
	static int nzStuck;

	Student() {
		name = "Pantera";
		laziness = 0.67f;
		iq = 127;
		exams = 6;
		marks = new int[exams];
		for (int i = 0; i < exams; i++) {
			marks[i] = 7;
		}
		nzStuck++;
	}

	Student(float laziness, byte iq) {
		name = "Erick";
		this.laziness = laziness;
		this.iq = iq;
		exams = 18;
		marks = new int[exams];
		for (int i = 0; i < exams; i++) {
			marks[i] = 8;
		}
		nzStuck++;
	}

	Student(Student other) {
		name = other.name;
		laziness = other.laziness;
		iq = other.iq;
		exams = other.exams;
		marks = new int[exams];
		for (int i = 0; i < exams; i++) {
			marks[i] = other.marks[i];
		}
		nzStuck++;
	}

	void echo() {
		System.out.println("name: " + this.name);
		System.out.println("laziness: " + this.laziness);
		System.out.println("iq: " + this.iq);
		System.out.println("exams: " + this.exams);
		System.out.print("marks:");
		for (int i = 0; i < exams; i++) {
			System.out.print(" " + this.marks[i]);
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		int studentCount = 18;
		Student[] students = new Student[studentCount];

		for (int i = 0; i < studentCount; i += 3) {
			students[i] = new Student();
			students[i + 1] = new Student((i * 0.01f), (byte) (100 + i));
			students[i + 2] = new Student(students[i]);
		}

		// // Вывод информации о студентах
		// for (int i = 0; i < studentCount; i++) {
		// 	students[i].echo();
		// }

		// 1-й способ поиска студента с наименьшим IQ
		byte lowestIq = students[0].iq;
		int lowestIqIndex = 0;
		for (int i = 1; i < studentCount; i++) {
			if (students[i].iq < lowestIq) {
				lowestIq = students[i].iq;
				lowestIqIndex = i;
			}
		}

		System.out.println("Lowest IQ: " + students[lowestIqIndex].iq + " at index " + lowestIqIndex);
		students[lowestIqIndex].echo();

		// 2-й способ поиска (по объекту)
		Student charle = students[0];
		for (int i = 1; i < students.length; i++) {
			if (students[i].iq < charle.iq) {
				charle = students[i];
			}
		}
		System.out.println("Charle Leclerc:");
		charle.echo();

		System.out.println("было созданно студентов: " + Student.nzStuck);
	}
}
