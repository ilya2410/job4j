package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Пирамида в псевдографике.
 *
 * @author Ilya Khayarov (ilya.ssb.ru@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * Правосторонний треугольник.
     *
     * @param height Высота.
     * @return Возвращает строку, представляющую данные в этой строке.
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }
    /**
     * Левосторонний треугольник.
     *
     * @param height Высота.
     * @return Возвращает строку, представляющую данные в этой строке.
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }
    /**
     * Пирамида.
     *
     * @param height Высота пирамиды.
     * @return Возвращает строку, представляющую данные в этой строке.
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }
    private String loopBy(int height, int widht, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != widht; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}