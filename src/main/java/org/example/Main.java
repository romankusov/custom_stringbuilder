package org.example;

public class Main {
    public static void main(String[] args) {
        CustomStringBuilder builder = new CustomStringBuilder();
        //Добавление и удаление элементов повторяют соответсвующие методы StringBuilder.
        builder.append("First ").append("Second ").append("Third ");
        System.out.println("Ожидаемое значение First Second Third ");
        System.out.println(builder);
        builder.delete(5, 800);
        System.out.println("Значение после удаления элементов с 5 по последний");
        System.out.println(builder);
        //Вызов метода undo, должно вернуться предыдущее значение builder
        builder.undo();
        System.out.println("Ожидаемое значение First Second Third");
        System.out.println(builder);
        //Добавление новых элементов в builder
        builder.append("2");
        builder.append("3");
        builder.append("4");
        System.out.println("Ожидаемое значение First Second Third 234");
        System.out.println(builder);
        //Вызов метода undo() в количестве, очевидно превышащим количество сохраненных состояний,
        //не приводит к ошибке, а возвращает пустую строку
        builder.undo();
        builder.undo();
        builder.undo();
        builder.undo();
        builder.undo();
        builder.undo();
        builder.undo();
        builder.undo();
        System.out.println("Ожидаемое значение пустая строка");
        System.out.println(builder);
    }
}