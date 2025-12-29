import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Список команд: ");
            System.out.println("\t1. Создать клиента.");
            System.out.println("\t2. Открыть дебетовый счёт.");
            System.out.println("\t3. Открыть кредитный счёт.");
            System.out.println("\t4. Пополнить.");
            System.out.println("\t5. Снять.");
            System.out.println("\t6. Перевести.");
            System.out.println("\t7. Показать счета клиента.");
            System.out.println("\t8. Показать транзакции.");
            System.out.println("\t9. Отчёт банка.");
            System.out.println("\t10. Выход.");
            System.out.println();
            System.out.println("Введите номер действия (целое число): ");

            int actionNumber = scanner.nextInt();   // todo: обработка не чисел

            switch(actionNumber) {
                case 1  -> System.out.println("Выбрана команда '1. Создать клиента'.\n");
                case 2  -> System.out.println("Выбрана команда '2. Открыть дебетовый счёт'.\n");
                case 3  -> System.out.println("Выбрана команда '3. Открыть кредитный счёт'.\n");
                case 4  -> System.out.println("Выбрана команда '4. Пополнить'.\n");
                case 5  -> System.out.println("Выбрана команда '5. Снять'.\n");
                case 6  -> System.out.println("Выбрана команда '6. Перевести'.\n");
                case 7  -> System.out.println("Выбрана команда '7. Показать счета клиента'.\n");
                case 8  -> System.out.println("Выбрана команда '8. Показать транзакции'.\n");
                case 9  -> System.out.println("Выбрана команда '9. Отчёт банка'.\n");
                case 10 -> System.out.println("Выбрана команда '10. Выход'.\n");
                default -> System.out.println("Введён некорректный номер команды. Повторите ввод.\n");
            }
        }
    }
}