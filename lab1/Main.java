import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;


// Класс "Ювелирное украшение"
class Decorations {

    // статическое поле - сколько украшений всего создано
    static int totalCreated = 0;

    // обязательные поля
    String type;            // вид украшения
    byte metalCount;        // число металлов
    short stoneCount;       // число камней
    float[] metalWeights;   // вес каждого металла
    double[] stoneCarats;   // караты каждого камня
    double[] stoneCosts;    // стоимость каждого камня

    // необязательные поля
    int uniqueNumber;
    String ownerName;

    //  конструкторы

    // конструктор по умолчанию
    Decorations() {
        this.type = "Кольцо";
        this.metalCount = 1;
        this.stoneCount = 1;
        this.metalWeights = new float[]{10.0f};
        this.stoneCarats = new double[]{1.0};
        this.stoneCosts = new double[]{10000.0};
        this.uniqueNumber = 0;
        this.ownerName = "Неизвестно";
        totalCreated++;
    }

    // конструктор с параметрами (с владельцем)
    Decorations(String type, byte metalCount, short stoneCount,
                float[] metalWeights, double[] stoneCarats, double[] stoneCosts,
                int uniqueNumber, String ownerName) {
        this.type = type;
        this.metalCount = metalCount;
        this.stoneCount = stoneCount;
        this.metalWeights = copyFloatArray(metalWeights, metalCount);
        this.stoneCarats = copyDoubleArray(stoneCarats, stoneCount);
        this.stoneCosts = copyDoubleArray(stoneCosts, stoneCount);
        this.uniqueNumber = uniqueNumber;
        this.ownerName = ownerName;
        totalCreated++;
    }

    // конструктор с параметрами (без владельца)
    Decorations(String type, byte metalCount, short stoneCount,
                float[] metalWeights, double[] stoneCarats, double[] stoneCosts,
                int uniqueNumber) {
                    this.type = type;
                    this.metalCount = metalCount;
                    this.stoneCount = stoneCount;
                    this.metalWeights = copyFloatArray(metalWeights, metalCount);
                    this.stoneCarats = copyDoubleArray(stoneCarats, stoneCount);
                    this.stoneCosts = copyDoubleArray(stoneCosts, stoneCount);
                    this.uniqueNumber = uniqueNumber;
                    this.ownerName = "Unknown";
                    totalCreated++;
    }

    // конструктор копирования
    Decorations(Decorations other) {
        this.type = other.type;
        this.metalCount = other.metalCount;
        this.stoneCount = other.stoneCount;
        this.metalWeights = copyFloatArray(other.metalWeights, other.metalCount);
        this.stoneCarats = copyDoubleArray(other.stoneCarats, other.stoneCount);
        this.stoneCosts = copyDoubleArray(other.stoneCosts, other.stoneCount);
        this.uniqueNumber = other.uniqueNumber;
        this.ownerName = other.ownerName;
        totalCreated++;
    }

    // конструктор, читающий поля из текстового файла (для оценки 10)
    Decorations(String fileName) {
        loadFromFile(fileName);
        totalCreated++;
    }

    // вспомогательные функции копирования массивов (чтобы не повторять код)
    private static float[] copyFloatArray(float[] src, int n) {
        float[] result = new float[n];
        for (int i = 0; i < n; i++) {
            result[i] = src[i];
        }
        return result;
    }

    private static double[] copyDoubleArray(double[] src, int n) {
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            result[i] = src[i];
        }
        return result;
    }

    //  get / set

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public byte getMetalCount() { return metalCount; }
    public void setMetalCount(byte metalCount) { this.metalCount = metalCount; }

    public short getStoneCount() { return stoneCount; }
    public void setStoneCount(short stoneCount) { this.stoneCount = stoneCount; }

    public float[] getMetalWeights() { return metalWeights; }
    public void setMetalWeights(float[] newWeights) {
        if (newWeights == null) return;
        this.metalCount = (byte) newWeights.length;
        this.metalWeights = copyFloatArray(newWeights, this.metalCount);
    }

    public double[] getStoneCarats() { return stoneCarats; }
    public void setStoneCarats(double[] newCarats) {
        if (newCarats == null) return;
        this.stoneCount = (short) newCarats.length;
        this.stoneCarats = copyDoubleArray(newCarats, this.stoneCount);
    }

    public void setStoneCarat(int index, double carat) {
        if (index < 0 || index >= stoneCount) return;
        this.stoneCarats[index] = carat;
    }

    public double[] getStoneCosts() { return stoneCosts; }
    public void setStoneCosts(double[] newCosts) {
        if (newCosts == null) return;
        this.stoneCount = (short) newCosts.length;
        this.stoneCosts = copyDoubleArray(newCosts, this.stoneCount);
    }

    public void setStoneCost(int index, double cost) {
        if (index < 0 || index >= stoneCount) return;
        this.stoneCosts[index] = cost;
    }

    public int getUniqueNumber() { return uniqueNumber; }
    public void setUniqueNumber(int uniqueNumber) { this.uniqueNumber = uniqueNumber; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    //  вывод на экран

    public void printInfo() {
        System.out.println("Вид украшения: " + type);
        System.out.println("Уникальный номер: " + uniqueNumber);
        System.out.println("Владелец: " + ownerName);

        System.out.println("Число металлов: " + metalCount);
        System.out.print("Вес металлов (г): ");
        for (int i = 0; i < metalCount; i++) {
            System.out.print(metalWeights[i] + " ");
        }
        System.out.println();

        System.out.println("Число камней: " + stoneCount);
        System.out.print("Караты камней: ");
        for (int i = 0; i < stoneCount; i++) {
            System.out.print(stoneCarats[i] + " ");
        }
        System.out.println();

        System.out.print("Стоимость камней (руб): ");
        for (int i = 0; i < stoneCount; i++) {
            System.out.print(stoneCosts[i] + " ");
        }
        System.out.println();
    }

    //  свой ввод с клавиатуры (без Scanner)

    public static String inString() {
        String str = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static int inInt() {
        return Integer.parseInt(inString());
    }

    public static float inFloat() {
        return Float.parseFloat(inString());
    }

    public static double inDouble() {
        return Double.parseDouble(inString());
    }

    public static byte inByte() {
        return Byte.parseByte(inString());
    }

    // функция, заполняющая все поля объекта значениями с клавиатуры
    // функция, заполняющая все поля объекта значениями с клавиатуры
    public void input() {
        System.out.println("Введите вид украшения:");
        type = inString();

        System.out.println("Введите имя владельца:");
        ownerName = inString();

        System.out.println("Введите уникальный номер:");
        uniqueNumber = inInt();

        // проверяем именно то, что только что ввели
        do {
            System.out.println("Введите количество металлов (2-127):");
            metalCount = inByte();
        } while (metalCount <= 1 || metalCount > 127);

        metalWeights = new float[metalCount];
        for (int i = 0; i < metalCount; i++) {
            float w;
            do {
                System.out.println("Вес металла " + (i + 1) + " (г):");
                w = inFloat();
            } while (w <= 0);
            metalWeights[i] = w;
        }

        do {
            System.out.println("Введите количество камней (0 и больше):");
            stoneCount = (short) inInt();
        } while (stoneCount < 0);

        stoneCarats = new double[stoneCount];
        stoneCosts = new double[stoneCount];
        for (int i = 0; i < stoneCount; i++) {
            double carat;
            do {
                System.out.println("Караты камня " + (i + 1) + ":");
                carat = inDouble();
            } while (carat <= 0);
            stoneCarats[i] = carat;

            double cost;
            do {
                System.out.println("Стоимость камня " + (i + 1) + " (руб):");
                cost = inDouble();
            } while (cost < 0);
            stoneCosts[i] = cost;
        }
    }

    //  случайное заполнение

    // функция, заполняющая все поля вызывающего объекта случайными значениями
    public void fillRandom() {
        String[] types = {"Кольцо", "Браслет", "Колье", "Серьги", "Кулон"};
        Random rnd = new Random();

        type = types[rnd.nextInt(types.length)];
        ownerName = "Владелец" + rnd.nextInt(1000);
        uniqueNumber = rnd.nextInt(9000) + 1000;

        metalCount = (byte) (rnd.nextInt(3) + 1);
        metalWeights = new float[metalCount];
        for (int i = 0; i < metalCount; i++) {
            metalWeights[i] = (float) (rnd.nextDouble() * 20 + 1);
        }

        stoneCount = (short) (rnd.nextInt(4) + 1);
        stoneCarats = new double[stoneCount];
        stoneCosts = new double[stoneCount];
        for (int i = 0; i < stoneCount; i++) {
            stoneCarats[i] = rnd.nextDouble() * 5 + 0.1;
            stoneCosts[i] = rnd.nextDouble() * 100000 + 5000;
        }
    }

    //  вычисления

    // сумма стоимости всех камней
    public double sumOfStones() {
        double sum = 0;
        for (int i = 0; i < stoneCount; i++) {
            sum += stoneCosts[i];
        }
        return sum;
    }

    // самый крупный камень (в каратах)
    public double biggestStoneCarat() {
        double max = stoneCarats[0];
        for (int i = 1; i < stoneCount; i++) {
            if (stoneCarats[i] > max) {
                max = stoneCarats[i];
            }
        }
        return max;
    }

    // общий вес всех металлов
    public float totalWeightOfMetals() {
        float total = 0;
        for (int i = 0; i < metalCount; i++) {
            total += metalWeights[i];
        }
        return total;
    }

    // сравнение двух украшений по стоимости камней
    public void compareByStoneCost(Decorations other) {
        double myCost = this.sumOfStones();
        double otherCost = other.sumOfStones();

        System.out.println("Украшение \"" + this.type + "\": стоимость камней = " + myCost);
        System.out.println("Украшение \"" + other.type + "\": стоимость камней = " + otherCost);

        if (myCost > otherCost) {
            System.out.println("Первое украшение дороже по камням.");
        } else if (myCost < otherCost) {
            System.out.println("Второе украшение дороже по камням.");
        } else {
            System.out.println("Стоимость камней одинаковая.");
        }
    }

    // статическая функция сравнения двух украшений по весу металлов
    public static void compareByMetalWeight(Decorations a, Decorations b) {
        float weightA = a.totalWeightOfMetals();
        float weightB = b.totalWeightOfMetals();
        float diff = weightA - weightB;

        System.out.println("Украшение \"" + a.type + "\": вес металлов = " + weightA + " г");
        System.out.println("Украшение \"" + b.type + "\": вес металлов = " + weightB + " г");

        if (diff > 0) {
            System.out.println("Первое украшение тяжелее на " + diff + " г.");
        } else if (diff < 0) {
            System.out.println("Первое украшение легче на " + (-diff) + " г.");
        } else {
            System.out.println("Вес металлов одинаковый.");
        }
    }

    //  работа с файлами (на оценку 10)

    // сохранить все поля в текстовый файл
    public void saveToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(type);
            writer.println(uniqueNumber);
            writer.println(ownerName);

            writer.println(metalCount);
            for (int i = 0; i < metalCount; i++) {
                writer.println(metalWeights[i]);
            }

            writer.println(stoneCount);
            for (int i = 0; i < stoneCount; i++) {
                writer.println(stoneCarats[i]);
            }
            for (int i = 0; i < stoneCount; i++) {
                writer.println(stoneCosts[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // загрузить все поля из текстового файла (используется конструктором)
    private void loadFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            type = reader.readLine();
            uniqueNumber = Integer.parseInt(reader.readLine());
            ownerName = reader.readLine();

            metalCount = Byte.parseByte(reader.readLine());
            metalWeights = new float[metalCount];
            for (int i = 0; i < metalCount; i++) {
                metalWeights[i] = Float.parseFloat(reader.readLine());
            }

            stoneCount = Short.parseShort(reader.readLine());
            stoneCarats = new double[stoneCount];
            for (int i = 0; i < stoneCount; i++) {
                stoneCarats[i] = Double.parseDouble(reader.readLine());
            }

            stoneCosts = new double[stoneCount];
            for (int i = 0; i < stoneCount; i++) {
                stoneCosts[i] = Double.parseDouble(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


// MAIN
// дальше идёт обособленный класс майн для взода в программу

public class Main {
    public static void main(String[] args) {

        System.out.println(" Покупка украшений \n");

        // 1. конструктор по умолчанию
        Decorations d1 = new Decorations();
        System.out.println(" Украшение 1 (конструктор по умолчанию) ");
        d1.printInfo();
        System.out.println();

        // 2. конструктор с параметрами и владельцем
        Decorations d2 = new Decorations(
                "Серьги", (byte) 2, (short) 2,
                new float[]{5.5f, 3.2f},
                new double[]{0.5, 0.7},
                new double[]{15000.0, 18000.0},
                2002, "Мария Ионеску"
        );
        System.out.println(" Украшение 2 (конструктор с параметрами и владельцем) ");
        d2.printInfo();
        System.out.println();

        // 3. конструктор с параметрами без владельца
        Decorations d3 = new Decorations(
                "Браслет", (byte) 1, (short) 1,
                new float[]{20.0f},
                new double[]{1.0},
                new double[]{50000.0},
                3003
        );
        System.out.println(" Украшение 3 (конструктор без владельца) ");
        d3.printInfo();
        System.out.println();

        // 4. конструктор копирования
        Decorations d4 = new Decorations(d2);
        d4.setUniqueNumber(4004);
        System.out.println(" Украшение 4 (копия украшения 2) ");
        d4.printInfo();
        System.out.println();

        // 5. украшение со случайными полями
        Decorations d5 = new Decorations();
        d5.fillRandom();
        System.out.println(" Украшение 5 (случайные значения) ");
        d5.printInfo();
        System.out.println();

        // 6. украшение с клавиатуры
        Decorations d6 = new Decorations();
        System.out.println(" Украшение 6: введите данные с клавиатуры ");
        d6.input();
        System.out.println(" Украшение 6 (введено с клавиатуры) ");
        d6.printInfo();
        System.out.println();

        // сохраняем каждое украшение в файл, имя файла = имя объекта
        d1.saveToFile("d1.txt");
        d2.saveToFile("d2.txt");
        d3.saveToFile("d3.txt");
        d4.saveToFile("d4.txt");
        d5.saveToFile("d5.txt");
        d6.saveToFile("d6.txt");

        // 7. конструктор, читающий украшение из файла
        Decorations d7 = new Decorations("d2.txt");
        System.out.println(" Украшение 7 (загружено из файла d2.txt) ");
        d7.printInfo();
        System.out.println();

        //клад
        System.out.println(" Формируем клад \n");

        Decorations[] treasure = new Decorations[5];
        treasure[0] = new Decorations();                     // по умолчанию
        treasure[1] = new Decorations(d3);                    // копия
        treasure[2] = new Decorations(                        // с параметрами
                "Колье", (byte) 3, (short) 2,
                new float[]{12.0f, 8.0f, 4.0f},
                new double[]{2.0, 1.5},
                new double[]{80000.0, 60000.0},
                5005, "Николай Ротару"
        );
        treasure[3] = new Decorations();
        treasure[3].fillRandom();                              // случайное
        treasure[4] = new Decorations("d1.txt");               // из файла

        System.out.println(" Содержимое клада ");
        for (int i = 0; i < treasure.length; i++) {
            System.out.println("Сокровище " + (i + 1) + ":");
            treasure[i].printInfo();
            System.out.println();
        }

        // сравнение пар украшений
        System.out.println(" Сравнение по стоимости камней ");
        treasure[0].compareByStoneCost(treasure[1]);
        System.out.println();
        treasure[2].compareByStoneCost(treasure[3]);
        System.out.println();

        System.out.println(" Сравнение по весу металлов ");
        Decorations.compareByMetalWeight(treasure[0], treasure[1]);
        System.out.println();
        Decorations.compareByMetalWeight(treasure[2], treasure[3]);
        System.out.println();

        // ищем украшение с самым крупным камнем
        String bestType = treasure[0].getType();
        double bestCarat = treasure[0].biggestStoneCarat();
        for (int i = 1; i < treasure.length; i++) {
            double carat = treasure[i].biggestStoneCarat();
            if (carat > bestCarat) {
                bestCarat = carat;
                bestType = treasure[i].getType();
            }
        }
        System.out.println("Украшение с самым крупным камнем: " + bestType
                + " (" + bestCarat + " карат)");

        // число всех созданных украшений
        System.out.println("Всего создано украшений: " + Decorations.totalCreated);

        System.out.println("УРРРААА ! ! !");
    }
}
