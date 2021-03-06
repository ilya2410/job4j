package ru.job4j.tracker;

import ru.job4j.start.Input;


public class AddItem extends BaseAction {

    public AddItem(int i, String a) {
        super(i, a);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------- Добавление новой заявки ---------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        tracker.add(item);
        System.out.println("------------ Новая заявка с Id : " + item.getId() + " -----------");
        System.out.println("------------ Новая заявка с Name : " + item.getName() + " -----------");
        System.out.println("------------ Новая заявка с Desc : " + item.getDecs() + " -----------");
    }
}
