import bl.BinarRepasitories;
import bl.CsvRepositories;
import bl.Repositories;
import model.Field;
import model.PhoneNumb;
import bl.Menu;
import java.text.DateFormat;
import java.util.*;
import java.util.List;

public class Task01 {
    public static void main(String[] args) {
        int exit = 0, exit2, exit1 = 0, exit3;
        Scanner sc = new Scanner(System.in);
        Date date = new Date();
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
                                repositories.sortId();
                                int i;
                                try {
                                     i = repositories.getList().get(repositories.getList().size()-1).getId()+1;
                                }catch (Exception e){
                                     i = 0;
                                }
                                temp.setId(i);
                                temp.setDate(DateFormat.getDateInstance(DateFormat.SHORT).format(date));
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
                                            temp.setDate(DateFormat.getDateInstance(DateFormat.SHORT).format(date));
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
                                Menu.searchMenu();
                                List<Field>list;
                                switch (sc.nextInt()){
                                    case 1:
                                        System.out.println("Введите искомую фамилию");
                                        list = repositories.searchLastName(sc.next());
                                        for(Field h : list){
                                            System.out.println(h.toString());
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Введите имя");
                                        list = repositories.searchName(sc.next());
                                        for(Field h : list){
                                            System.out.println(h.toString());
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Введите тэг");
                                        list = repositories.searchTag(sc.next());
                                        for(Field h : list){
                                            System.out.println(h.toString());
                                        }
                                        break;
                                    case 4:
                                        System.out.println("Введите дату");
                                        list = repositories.searchDate(sc.next());
                                        for(Field h : list){
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
                    break;
                case 2:
                    CsvRepositories csvRepositories = new CsvRepositories();
                    List<Field> list = new ArrayList<>();
                    switch (sc.nextInt()){
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
                            //csvRepositories.sortId();
                            int i;
                            try {
                                i = csvRepositories.getList().get(csvRepositories.getList().size()-1).getId()+1;
                            }catch (Exception e){
                                i = 0;
                            }

                            temp.setId(i);
                            temp.setDate(DateFormat.getDateInstance(DateFormat.SHORT).format(date));
                            csvRepositories.addField(temp);
                            break;
                        case 2:
                            for (Field h : csvRepositories.getList()) {
                                System.out.println(h.toString());
                            }
                            break;
                        default:
                            break;
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
}
