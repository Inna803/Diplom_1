package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    // переменные для хранения параметров тестовых данных
    private final String bunName;
    private final float bunPrice;

    private Bun bun; // объект Bun для тестирования

    // конструктор класса, принимающий параметры тестовых данных
    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    // метод, возвращающий коллекцию массивов объектов с тестовыми данными
    @Parameterized.Parameters(name = "Name: {0}, Price: {1}")
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {"Обычная", 1},      // Обычная булочка с ценой 1
                {"Вкусная", 20},     // Вкусная булочка с ценой 20
                {"Съедобная", 300},  // Съедобная булочка с ценой 300
                {"Флот", 0.01F},     // булочка "Флот" с ценой 0.01
                {"Бесценная", 0},    // булочка "Бесценная" с ценой 0
                {" ", 0},            // булочка с пустым именем и ценой 0
                {"", 0},             // булочка с пустым именем и ценой 0
                {null, 0},           // булочка с нулевым именем и ценой 0
                {"Отрицательная", -100},  // булочка "Отрицательная" с отрицательной ценой -100
                {"Цифровая_1234", 1234},  // булочка "Цифровая_1234" с ценой 1234
                {"$%#^@&$$(%^^)символьная", 0},   // булочка с символами в имени и ценой 0
                {"ОченьОченьОченьДлинноеИмяДляБулочки", Float.MAX_VALUE}   // булочка с очень длинным именем и максимальной ценой
        });
    }

    @Before
    public void setUp() {
        // создаем новый объект Bun с заданными именем и ценой перед каждым тестом
        bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void testGetName() {
        // проверяем, что метод getName() возвращает ожидаемое имя
        String actual = bun.getName();
        assertEquals("The name of the bun does not match the specified!", bunName, actual);
    }

    @Test
    public void testGetPrice() {
        // проверяем, что метод getPrice() возвращает ожидаемую цену
        float actual = bun.getPrice();
        assertEquals("The price of the bun does not match the specified!", bunPrice, actual, 0);
    }
}
