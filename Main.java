class Student {
	String name;    //
	Float lazynass; // коэфициент лени от 0-1 где 1 это ленивый
	Byte IQ;        // (максимальное значение 127) 80-127
	int exams;      // кол-во экзаменов
	int marks[];     // кол-во оценок

	Student () {    // конструктор класса студент
		name = "Pantera";
		lazynass = 0.67f; // литерал f для float
		IQ = (byte)127;
		exams = 6;
		marks = new int[exams];
		for(int i = 0; i < exams; i++) {
			marks[i] = 7;
		}
	}

	Student (Float lazynass, Byte iq) { // конструктор с параметром
		name = "Erick";
		this.lazynass = lazynass; // чтобы небыло конфликта надо использовать this
		IQ = iq; // конфликта имён не будет так как разные регистры
		exams = 18;
		marks = new int[exams];
		for(int i = 0; i < exams; i++) {
			marks[i] = 8;
		}
	}

	Student (Student other) {    // конструктор копирования
		name = other.name;
		lazynass = other.lazynass;
		IQ = other.IQ;
		exams = other.exams;
		marks = new int[exams];
		for(int i = 0; i < exams; i++) {
			marks[i] = other.marks[i];
		}
	}

	void echo() {
		System.out.println("name: " + this.name);
		System.out.println("lazynass: " + this.lazynass);
		System.out.println("IQ: " + this.IQ);
		System.out.println("exams: " + this.exams);
		// вывод массива оценок
		System.out.print("marks:");
		for (int i = 0; i < exams; i++) {
			System.out.print(" " + this.marks[i]);
		}
		System.out.println("\n");
	}

	public static void main(String[] furry) { // Главная точка входа программы
 	//     // 1. Создание экземпляра через конструктор по умолчанию
 	//     Student vasia = new Student();
	 //    vasia.echo();

	 //    // 2. Создание экземпляра через конструктор с параметрами
	 //    Student erick = new Student(0.45f, (byte)110);
	 //    erick.echo();

	 //    // 3. Создание экземпляра через конструктор копирования
	 //    Student vasiaCopy = new Student(vasia);
	 //    vasiaCopy.echo();

		// //4. Привемр из айдитории
		// Student Artemii;
		// Artemii = new Student();
		// Artemii.echo();

		// создадим через цикол несколько 18 студентов
		// будем сохранять из в массив

		int student_count = 18;
		Student[] students = new Student[student_count];
		for (int i = 0; i < student_count; i+=3) {
			students[i] = new Student();
			students[i+1] = new Student((i * 0.01f), (byte)(100+i));
			students[i+2] = new Student(students[i]);
		}

		// вывод информации о студентах
		for (int i = 0; i < student_count; i++) {
			students[i].echo();
		}
	}

}
