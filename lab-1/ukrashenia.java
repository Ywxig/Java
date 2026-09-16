import java.util.Scanner;

class Decorations {
    // кол-во проданных украшений
    static int totalCreated = 0;
    String type;          // тип украшения
    byte metalCount;      // число металлов
    short stoneCount;     // чмисло камней
    float[] metalWeights; // вес металлов
    double[] stoneCarats; // караты камней

    double[] stoneCosts; // цена каждого камня
    int uniqueNumber;    // уникальный номер украшения

    String ownerName;    // имя владельца

    // обычный конструктор
    Decorations() {
        this.type = "Колье";
        this.metalCount = 2;
        this.stoneCount = 3;
        this.metalWeights = new float[]{15.5f, 8.2f};
        this.stoneCarats = new double[]{1.2, 2.5, 0.8};
        this.stoneCosts = new double[]{45000.0, 120000.0, 25000.0};
        this.uniqueNumber = 1001;
        this.ownerName = "Артемий Тросчак";
        totalCreated++;
    }

    // констурктор с параметрами
    Decorations( String type, byte metalCount, short stoneCount, float[] metalWeights, double[] stoneCarats, double[] stoneCosts, int uniqueNumber, String ownerName ) {
        this.type = type;
        this.metalCount = metalCount;
        this.stoneCount = stoneCount;

        this.metalWeights = new float[metalCount];
        for (int i = 0; i < metalCount; i++ ) { // заполняем this.metalWeight числами из передонного нами пареметра
            this.metalWeights[i] = metalWeights[i];
        }

        this.stoneCarats = new double[stoneCount];
        for (int i = 0; i < stoneCount; i++) {
            this.stoneCarats[i] = stoneCarats[i];
        }

        this.stoneCosts = new double[stoneCount];
        for (int i = 0; i < stoneCount; i++) {
            this.stoneCosts[i] = stoneCosts[i];
        }

        this.uniqueNumber = uniqueNumber;
        this.ownerName = ownerName;
        totalCreated++;

    }

    // констурктор с параметрами
    Decorations( String type, byte metalCount, short stoneCount, float[] metalWeights, double[] stoneCarats, double[] stoneCosts, int uniqueNumber ) {
        this.type = type;
        this.metalCount = metalCount;
        this.stoneCount = stoneCount;

        this.metalWeights = new float[metalCount];
        for (int i = 0; i < metalCount; i++ ) { // заполняем this.metalWeight числами из передонного нами пареметра
            this.metalWeights[i] = metalWeights[i];
        }

        this.stoneCarats = new double[stoneCount];
        for (int i = 0; i < stoneCount; i++) {
            this.stoneCarats[i] = stoneCarats[i];
        }

        this.stoneCosts = new double[stoneCount];
        for (int i = 0; i < stoneCount; i++) {
            this.stoneCosts[i] = stoneCosts[i];
        }

        this.uniqueNumber = uniqueNumber;
        this.ownerName = "null";
        totalCreated++;

    }

    // констурктор копирования
    Decorations( Decorations other ) {
        this.type = other.type;
        this.metalCount = other.metalCount;
        this.stoneCount = other.stoneCount;

        this.metalWeights = new float[other.metalCount];
        for (int i = 0; i < other.metalCount; i++ ) { // заполняем this.metalWeight числами из передонного нами пареметра
            this.metalWeights[i] = other.metalWeights[i];
        }

        this.stoneCarats = new double[other.stoneCount];
        for (int i = 0; i < other.stoneCount; i++) {
            this.stoneCarats[i] = other.stoneCarats[i];
        }

        this.stoneCosts = new double[other.stoneCount];
        for (int i = 0; i < other.stoneCount; i++) {
            this.stoneCosts[i] = stoneCosts[i];
        }

        this.uniqueNumber = other.uniqueNumber;
        this.ownerName = other.ownerName;
        totalCreated++;
    }

    public void echo() {
        System.out.println("Вид украшения: " + type);
        System.out.println("Уникальный номер: " + uniqueNumber);
        System.out.println("Владелец: " + ownerName);
        System.out.println("Число металлов: " + metalCount);
        System.out.print("Вес металлов (г): ");

        if (metalWeights != null) {
            for (float w : metalWeights) {
                System.out.print(w + " ");
            }
        }
        System.out.println();

        System.out.println("Число камней: " + stoneCount);
        System.out.print("Каратность камней: ");
        if (stoneCarats != null) {
            for (double c : stoneCarats) {
                System.out.print(c + " ");
            }
        }
        System.out.println();

        System.out.print("Стоимость камней (руб): ");
        if (stoneCosts != null) {
            for (double s : stoneCosts) {
                System.out.print(s + " ");
            }
        }
    }

    // Функции доступа (get) и изменения (set) полей класса
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public byte getMetalCount() { return metalCount; }
    public void setMetalCount(byte metalCount) { this.metalCount = metalCount; }

    public short getStoneCount() { return stoneCount; }
    public void setStoneCount(short stoneCount) { this.stoneCount = stoneCount; }

    // ГЕТЕР для получения массива весов металлов
    public float[] getMetalWeights() {
        return metalWeights;
    }

    // СЕТЕР для установки весов металлов (зависит от metalCount)
    public void setMetalWeights(float[] newWeights) {
        // Шаг 1: Проверяем, что переданный массив не пустой
        if (newWeights == null) {
            return;
        }

        // Шаг 2: Обновляем число металлов (metalCount) в соответствии с длиной нового массива
        this.metalCount = (byte) newWeights.length;

        // Шаг 3: Создаем новый массив нужного размера в памяти объекта
        this.metalWeights = new float[this.metalCount];

        // Шаг 4: Копируем каждый элемент из переданного массива в наш массив
        for (int i = 0; i < this.metalCount; i++) {
            this.metalWeights[i] = newWeights[i];
        }
    }

    // ГЕТЕР для получения массива каратов камней
    public double[] getStoneCarats() {
        return stoneCarats;
    }

    // СЕТЕР для установки каратов камней (зависит от stoneCount)
    public void setStoneCarats(double[] newCarats) {
        // Шаг 1: Проверка на null
        if (newCarats == null) {
            return;
        }

        // Шаг 2: Обновляем число камней (stoneCount) под размер нового массива
        this.stoneCount = (short) newCarats.length;

        // Шаг 3: Выделяем память под новый массив каратов
        this.stoneCarats = new double[this.stoneCount];

        // Шаг 4: Поэлементно копируем значения
        for (int i = 0; i < this.stoneCount; i++) {
            this.stoneCarats[i] = newCarats[i];
        }
    }

    // ГЕТЕР для получения массива стоимостей камней
    public double[] getStoneCosts() {
        return stoneCosts;
    }

    // СЕТЕР для установки стоимостей камней (также зависит от stoneCount)
    public void setStoneCosts(double[] newCosts) {
        // Шаг 1: Проверка на null
        if (newCosts == null) {
            return;
        }

        // Шаг 2: Обновляем число камней (stoneCount), так как стоимость зависит от количества камней
        this.stoneCount = (short) newCosts.length;

        // Шаг 3: Выделяем память под новый массив стоимостей
        this.stoneCosts = new double[this.stoneCount];

        // Шаг 4: Копируем элементы
        for (int i = 0; i < this.stoneCount; i++) {
            this.stoneCosts[i] = newCosts[i];
        }
    }

    public int getUniqueNumber() { return uniqueNumber; }
    public void setUniqueNumber(int uniqueNumber) { this.uniqueNumber = uniqueNumber; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    // Функция заполнения всех полей с клавиатуры
    public void readFromKeyboard() {
        Scanner scanner = new Scanner(System.in); // экземпляр класса сканера для считывания с клавиотуры

        System.out.print("Введите вид украшения: ");
        type = scanner.next();

        System.out.print("Введите уникальный номер: ");
        uniqueNumber = scanner.nextInt();

        System.out.print("Введите имя владельца: ");
        scanner.nextLine(); // очистка буфера после nextInt()
        ownerName = scanner.nextLine();

        System.out.print("Введите число металлов (byte): ");
        metalCount = scanner.nextByte();

        System.out.print("Введите число камней (short): ");
        stoneCount = scanner.nextShort();

        metalWeights = new float[metalCount];
        System.out.println("Введите вес " + metalCount + " металлов (через пробел):");
        for (int i = 0; i < metalCount; i++) {
            metalWeights[i] = scanner.nextFloat();
        }

        stoneCarats = new double[stoneCount];
        System.out.println("Введите каратность " + stoneCount + " камней (через пробел):");
        for (int i = 0; i < stoneCount; i++) {
            stoneCarats[i] = scanner.nextDouble();
        }

        stoneCosts = new double[stoneCount];
        System.out.println("Введите стоимость " + stoneCount + " камней (через пробел):");
        for (int i = 0; i < stoneCount; i++) {
            stoneCosts[i] = scanner.nextDouble();
        }
    }

    public double sumOfStones() {
        double sum = 0;
        for (int i = 0; i < stoneCount; i++) {
            sum += stoneCosts[i];
        }
        return sum;
    }

    public double theMostBigestStone() {
        double max = stoneCarats[0];
        for (int i = 1; i < stoneCount; i++) {
            if (stoneCarats[i] > max) {
                max = stoneCarats[i];
            }
        }
        return max;
    }

    public float totalWeightOfMetals() {
        float totalWeight = 0;
        for (int i = 0; i < stoneCount; i++) {
            totalWeight += stoneCarats[i];
        }
        return totalWeight;
    }



}

class Main {
    public static void main(String[] args) {
        Decorations ring = new Decorations();
        System.out.println("--- Исходное украшение ---");
        ring.echo();

        // Тестируем сеттеры (изменяем данные через set-методы)
        System.out.println("\n--- Тестирование сеттеров (Setters) ---");
        ring.setType("Браслет");
        ring.setUniqueNumber(777);
        ring.setOwnerName("Иван Иванов");
        
        // Сеттер металлов автоматически обновит metalCount
        float[] newWeights = {25.4f, 10.1f, 5.5f};
        ring.setMetalWeights(newWeights);

        // Сеттер карат автоматически обновит stoneCount
        double[] newCarats = {3.1, 4.2};
        ring.setStoneCarats(newCarats);

        // Сеттер стоимости камней
        double[] newCosts = {150000.0, 200000.0};
        ring.setStoneCosts(newCosts);

        System.out.println("\n--- Украшение после работы сеттеров ---");
        ring.echo();

        // Тестируем геттеры (получаем данные через get-методы)
        System.out.println("\n--- Тестирование геттеров (Getters) ---");
        System.out.println("Полученный тип через get: " + ring.getType());
        System.out.println("Полученный номер через get: " + ring.getUniqueNumber());
        System.out.println("Полученный владелец через get: " + ring.getOwnerName());
        System.out.println("Полученное число металлов через get: " + ring.getMetalCount());
        System.out.println("Полученное число камней через get: " + ring.getStoneCount());
    }
}
