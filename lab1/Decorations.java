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

    // ---------- конструкторы ----------

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
        this(type, metalCount, stoneCount, metalWeights, stoneCarats, stoneCosts,
                uniqueNumber, "Неизвестно");
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

    // ---------- get / set ----------

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

    public double[] getStoneCosts() { return stoneCosts; }
    public void setStoneCosts(double[] newCosts) {
        if (newCosts == null) return;
        this.stoneCount = (short) newCosts.length;
        this.stoneCosts = copyDoubleArray(newCosts, this.stoneCount);
    }

    public int getUniqueNumber() { return uniqueNumber; }
    public void setUniqueNumber(int uniqueNumber) { this.uniqueNumber = uniqueNumber; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    // ---------- вывод на экран ----------

    public void echo() {
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

    // ---------- свой ввод с клавиатуры (без Scanner) ----------

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
    public void input() {
        System.out.println("Введите вид украшения:");
        type = inString();

        System.out.println("Введите имя владельца:");
        ownerName = inString();

        System.out.println("Введите уникальный номер:");
        uniqueNumber = inInt();

        System.out.println("Введите количество металлов:");
        metalCount = inByte();
        metalWeights = new float[metalCount];
        for (int i = 0; i < metalCount; i++) {
            System.out.println("Вес металла " + (i + 1) + " (г):");
            metalWeights[i] = inFloat();
        }

        System.out.println("Введите количество камней:");
        stoneCount = (short) inInt();
        stoneCarats = new double[stoneCount];
        stoneCosts = new double[stoneCount];
        for (int i = 0; i < stoneCount; i++) {
            System.out.println("Караты камня " + (i + 1) + ":");
            stoneCarats[i] = inDouble();
            System.out.println("Стоимость камня " + (i + 1) + " (руб):");
            stoneCosts[i] = inDouble();
        }
    }

    // ---------- случайное заполнение ----------

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

    // ---------- вычисления ----------

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

    // ---------- работа с файлами (на оценку 10) ----------

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
