package bll;

public class Menu {
    public static void mainMenu(){
        System.out.println("1.Добавить запись в репозиторий");
        System.out.println("2.Изменить запись в репозитории");
        System.out.println("3.Удалить запись из репозитория");
        System.out.println("4.Сортировать записи");
        System.out.println("5.Вывод на экран");
        System.out.println("6.Поиск записей ");
        System.out.println("7.Выполнить шаг назад");
    }
    public static void fileMenu(){
        System.out.println("Выберите репозиторий для работы");
        System.out.println("1.Бинарный файл");
        System.out.println("2.Файл *.CSV");
        System.out.println("3.Выход");
    }
    public static void editMenu(){
        System.out.println("1.Редактировать фамилия");
        System.out.println("2.Редактировать имя");
        System.out.println("3.Редактировать телефон");
        System.out.println("4.Редактировать тег");
        System.out.println("5.Назад");
    }
    public  static void phoneMenu(){
        System.out.println("1.Добавить телефон");
        System.out.println("0.Продолжить");
    }
    public static void sortMenu(){
        System.out.println("1.Сортировать по фамилии");
        System.out.println("2.Сортировать по имени");
        System.out.println("3.Сортировать по тэгу");
        System.out.println("4.Сортировать по ID");
    }
    public static void searchMenu(){
        System.out.println("1.Поиск по фамилии");
        System.out.println("2.Поиск по имени");
        System.out.println("3.Поиск по тэгу");
        System.out.println("4.Поиск по дате");
    }
}
