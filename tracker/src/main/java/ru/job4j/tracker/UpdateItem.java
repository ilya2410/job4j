package ru.job4j.tracker;

import ru.job4j.start.Input;

public class UpdateItem extends BaseAction {

    public UpdateItem(int i, String a) {
        super(i, a);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите id заявки для поиска :");
        Item item = tracker.findById(id);
        String name = input.ask("Введите новое имя заявки :");
        String desc = input.ask("Введите новое описание заявки :");
        Item item2 = new Item(name, desc, System.currentTimeMillis());
        if (item != null) {
            System.out.println("------------------ Заявка найдена -------------------");
            tracker.replace(id, item2);
            System.out.println("----------- Замена заявки прошла успешно ------------");
        } else {
            System.out.println("----------------- Заявка не найдена -----------------");
        }
    }
}

