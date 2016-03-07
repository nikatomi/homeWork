import model.BinarRepasitories;
import model.Repositories;
import model.Field;
import model.PhoneNumb;
import bl.Menu;
import bl.CompareField;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Task01 {
    public static void main(String[] args) {
        int exit = 0, exit2, i = 0, exit1 = 0, exit3 = 0;
        Scanner sc = new Scanner(System.in);
        while (exit == 0) {
            Menu.fileMenu();
            switch (sc.nextInt()) {
                case 1:
                    while (exit1 == 0) {
                        // вызов главного меню
                        Menu.mainMenu();
                        // ссылке типа Repositories инициализируем экземпляр класcа бинарного файла
                        Repositories repositories = new BinarRepasitories();
                        switch (sc.nextInt()) {
                            case 1:
                                Field temp = new Field();
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
                                temp.setId(i);
                                i++;
                                repositories.addField(temp);
                                break;
                            case 2:
                                System.out.println("Введите фамилию");
                                temp = repositories.search(sc.next());
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
                                            repositories.editField(temp);
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
                                temp = repositories.search(sc.next());
                                repositories.removeField(temp);
                                break;
                            case 4:
                                Menu.sortMenu();
                                switch(sc.nextInt()){
                                    case 1:
                                        repositories.sortLastName();
                                        break;
                                    case 2:
                                        repositories.sortName();
                                        break;
                                    case 3:
                                        repositories.sortTag();
                                        break;
                                    case 4:
                                        repositories.sortId();
                                        break;
                                    default:
                                        System.out.println("Ошибка ввода");
                                        break;
                                }
                                break;
                            case 5:
                                for (Field h : repositories.getList()) {
                                    System.out.println(h.toString());
                                }
                                break;
                            case 6:
                                exit1 = 1;
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 2:
                    break;
                case 3:
                    exit = 1;
                    break;
                default:
                    break;
            }
        }
    }
}
