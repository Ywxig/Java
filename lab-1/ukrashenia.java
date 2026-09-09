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

    public float[] getMetalWeights() { return metalWeights; }
    public void setMetalWeights(float[] metalWeights) { this.metalWeights = metalWeights; }

    public double[] getStoneCarats() { return stoneCarats; }
    public void setStoneCarats(double[] stoneCarats) { this.stoneCarats = stoneCarats; }

    public double[] getStoneCosts() { return stoneCosts; }
    public void setStoneCosts(double[] stoneCosts) { this.stoneCosts = stoneCosts; }

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
        ring.echo();
        ring.sumOfStones();

        System.out.println("\n\nЗаполняем украшение с клавиатуры:");
        Decorations userDecor = new Decorations();
        userDecor.readFromKeyboard();

        System.out.println("\nРезультат ввода:");
        userDecor.echo();
    }
}
