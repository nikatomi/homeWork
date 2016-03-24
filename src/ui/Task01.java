package ui;

import bll.*;
import model.Record;
import model.PhoneNumb;

import java.io.File;
import java.text.DateFormat;
import java.util.*;
import java.util.List;

/*

TODO падение приложения
Выберите репозиторий для работы
1.Бинарный файл
2.Файл *.CSV
3.Выход
1
1.Создать новый репозиторий
2.Выбрать репозиторий
3.Шаг назад
1
Введите имя нового репозитория
sdf
1.Добавить запись в репозиторий
2.Изменить запись в репозитории
3.Удалить запись из репозитория
4.Сортировать записи
5.Вывод на экран
6.Поиск записей
7.Выполнить шаг назад
ls
Exception in thread "main" java.util.InputMismatchException
	at java.util.Scanner.throwFor(Scanner.java:864)
	at java.util.Scanner.next(Scanner.java:1485)
	at java.util.Scanner.nextInt(Scanner.java:2117)
	at java.util.Scanner.nextInt(Scanner.java:2076)
	at ui.Task01.consolInterface(Task01.java:101)
	at ui.Task01.main(Task01.java:30)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:497)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)

Process finished with exit code 1

*/
public class Task01 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        int exit = 0, exitRep;
        Scanner sc = new Scanner(System.in);
        String nameRepositories;
        Repository repositories;
        while (exit == 0) {
            Menu.fileMenu();
            switch (sc.nextInt()) {
                case 1:
                    exitRep = 0;
                    while (exitRep == 0) {
                        Menu.repositoriesMenu();
                        switch (sc.nextInt()) {
                            case 1:
                                System.out.println("Введите имя нового репозитория");
                                nameRepositories = sc.next() + ".txt";
                                repositories = new BinarRepasitories(nameRepositories);
                                Task01.consolInterface(repositories);
                                break;
                            case 2:
                                System.out.println("Введите название репозитория");
                                nameRepositories = sc.next() + ".txt";
                                File file = new File(nameRepositories);
                                if (file.exists()) {
                                    repositories = new BinarRepasitories(nameRepositories);
                                    Task01.consolInterface(repositories);
                                } else {
                                    System.out.println("Такого репозитория не существует");
                                }
                                break;
                            case 3:
                                exitRep = 1;
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 2:

                    exitRep = 0;
                    while (exitRep == 0) {
                        Menu.repositoriesMenu();
                        switch (sc.nextInt()) {
                            case 1:
                                System.out.println("Введите имя нового репозитория");
                                nameRepositories = sc.next() + ".csv";
                                repositories = new CsvRepositories(nameRepositories);
                                Task01.consolInterface(repositories);
                                break;
                            case 2:
                                System.out.println("Введите название репозитория");
                                nameRepositories = sc.next() + ".csv";
                                File file = new File(nameRepositories);
                                if (file.exists()) {
                                    repositories = new CsvRepositories(nameRepositories);
                                    Task01.consolInterface(repositories);
                                } else {
                                    System.out.println("Такого репозитория не существует");
                                }
                                break;
                            case 3:
                                exitRep = 1;
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 3:
                    exit = 1;
                    break;
                default:
                    break;
            }
        }
    }

    public static void consolInterface(IntefaceRepository repositories) throws NoSuchFieldException, IllegalAccessException {
        int exit2, exit1, exit3, z;
        Scanner sc = new Scanner(System.in);
        List<Record> list;
        Date date = new Date();
        exit1 = 0;
            while (exit1 == 0) {
                // вызов главного меню
                Menu.mainMenu();
                // ссылке типа IntefaceRepository инициализируем экземпляр класcа бинарного файла
                switch (sc.nextInt()) {
                    case 1:
                        Record temp = new Record();
                        System.out.println("Введите фамилию");
                        temp.setLastname(sc.next());
                        System.out.println("Введите имя");
                        temp.setName(sc.next());
                        System.out.println("Введите телефон");
                        List<PhoneNumb> phoneNumbs = new ArrayList<>();
                        exit2 = 1;
                        while (exit2 != 0) {
                            PhoneNumb phone = new PhoneNumb();
                            phone.setType(sc.next());
                            phone.setNumber(sc.next());
                            phoneNumbs.add(phone);
                            Menu.phoneMenu();
                            exit2 = sc.nextInt();
                        }
                        temp.setPhoneNumb(phoneNumbs);
                        System.out.println("Введите тег");
                        temp.setTeg(sc.next());
                        repositories.sort(CompareField.compareID);
                        int i;
                        try {
                            i = repositories.getList().get(repositories.getList().size() - 1).getId() + 1;
                        } catch (Exception e) {
                            i = 0;
                        }
                        temp.setId(i);
                        temp.setDate(DateFormat.getDateInstance(DateFormat.SHORT).format(date));
                        repositories.addRecord(temp);
                        break;
                    case 2:
                        System.out.println("Введите фамилию");
                        z = repositories.search(sc.next());
                        if(z == -1){
                            System.out.println("Запись не найдена");
                            break;
                        }
                        list = repositories.getList();
                        temp = list.get(z);
                        exit3 = 0;
                        while (exit3 == 0) {
                            Menu.editMenu();
                            switch (sc.nextInt()) {
                                case 1:
                                    System.out.println("Введите новую фамилию");
                                    temp.setLastname(sc.next());
                                    break;
                                case 2:
                                    System.out.println("Введите новое имя");
                                    temp.setName(sc.next());
                                    break;
                                case 3:
                                    for (int j = 0; j < temp.getPhoneNumb().size(); j++) {
                                        System.out.println(j + 1 + "." + temp.getPhoneNumb().get(j).toString());
                                    }
                                    System.out.println("Выберите телефон ");
                                    int index = sc.nextInt() - 1;
                                    System.out.println("Введите новый телефон");
                                    temp.getPhoneNumb().get(index).setNumber(sc.next());
                                    break;
                                case 4:
                                    System.out.println("Введите новый тег");
                                    temp.setTeg(sc.next());
                                    break;
                                case 5:
                                    temp.setDate(DateFormat.getDateInstance(DateFormat.SHORT).format(date));
                                    repositories.editRecord(temp,z);
                                    exit3 = 1;
                                    break;
                                default:
                                    System.out.println("Ошибка ввода");
                                    break;
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Введите фамилию");
                        z = repositories.search(sc.next());
                        if(z == -1){
                            System.out.println("Запись не найдена");
                            break;
                        }
                        repositories.removeRecord(z);
                        break;
                    case 4:
                        Menu.sortMenu();
                        switch (sc.nextInt()) {
                            case 1:
                                repositories.sort(CompareField.compareLastName);
                                break;
                            case 2:
                                repositories.sort(CompareField.compareName);
                                break;
                            case 3:
                                repositories.sort(CompareField.compareTag);
                                break;
                            case 4:
                                repositories.sort(CompareField.compareID);
                                break;
                            default:
                                System.out.println("Ошибка ввода");
                                break;
                        }
                        break;
                    case 5:
                        for (Record h : repositories.getList()) {
                            System.out.println(h.toString());
                        }
                        break;
                    case 6:
                        Menu.searchMenu();
                        switch (sc.nextInt()) {
                            case 1:
                                System.out.println("Введите искомую фамилию");
                                String fieldName = "lastname";
                                list = repositories.searchRecord(sc.next(),fieldName);
                                for (Record h : list) {
                                    System.out.println(h.toString());
                                }
                                break;
                            case 2:
                                System.out.println("Введите имя");
                                list = repositories.searchRecord(sc.next(),"name");
                                for (Record h : list) {
                                    System.out.println(h.toString());
                                }
                                break;
                            case 3:
                                System.out.println("Введите тэг");
                                list = repositories.searchRecord(sc.next(),"teg");
                                for (Record h : list) {
                                    System.out.println(h.toString());
                                }
                                break;
                            case 4:
                                System.out.println("Введите дату");
                                list = repositories.searchRecord(sc.next(),"date");
                                for (Record h : list) {
                                    System.out.println(h.toString());
                                }
                                break;
                            default:
                                System.out.println("Ошибка ввода");
                                break;
                        }
                        break;
                    case 7:
                        exit1 = 1;
                        break;
                    default:
                        break;
                }
            }

    }
}
