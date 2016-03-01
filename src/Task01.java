import java.util.*;

/**
 * Created by Андрей on 24.02.16.
 */
public class Task01 {
    public static void main(String[] args) {
        List<Zapis> book = new ArrayList<Zapis>();
        int exit = 0,exit2;
        int i = 0;
        String st;
        Scanner sc = new Scanner(System.in);
        while(exit == 0){
            System.out.println("1.Добавить запись");
            System.out.println("2.Удалить запись");
            System.out.println("3.Изминить запись");
            System.out.println("4.Сортировать запись");
            System.out.println("5.Выход");
            System.out.println("6.Вывод в консоль");
            System.out.println("Выберите действие");
            switch (sc.nextInt()){
                case 1:
                    Zapis temp = new Zapis();
                    System.out.println("Введите имя");
                    temp.setName(sc.next());
                    System.out.println("Фамилия");
                    temp.setLastname(sc.next());
                    System.out.println("Введите номер телефона");
                    List<PhoneNumb>phones = new ArrayList<>();
                    int k = 1;
                    while(k != 0){
                        PhoneNumb telefon = new PhoneNumb();
                        telefon.setType(sc.next());
                        telefon.setNumber(sc.next());
                        phones.add(telefon);
                        System.out.println("1.Добавить телефон");
                        System.out.println("0.Продолжить ");
                        k = sc.nextInt();
                    }
                    temp.setPhoneNumb(phones);
                    System.out.println("Введите тэг");
                    temp.setTeg(sc.next());
                    book.add(temp);
                    temp.setId(i);
                    i++;
                    break;
                case 2:
                    System.out.println("Введите фамилию для удаления записи");
                    st = sc.next();
                    for(int j = 0;j<book.size();j++){
                        if(book.get(j).getLastname().equals(st)){
                            book.remove(j);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Введите фамилию для редактирования");
                    st = sc.next();
                    for(int j = 0;j<book.size();j++){
                        if(book.get(j).getLastname().equals(st)){
                            exit2 = 0;
                            while (exit2 == 0) {
                                System.out.println("1.Изменить имя");
                                System.out.println("2.Изменить номер телефона");
                                System.out.println("3.Изменить тег");
                                System.out.println("4.Выход");
                                System.out.println("выберите действие");
                                switch (sc.nextInt()) {
                                    case 1:
                                        System.out.println("Введите имя");
                                        book.get(j).setName(sc.next());
                                        break;
                                    case 2:
                                        for(int l = 0;l<book.get(j).getPhoneNumb().size();l++) {
                                            System.out.println(l+1+"."+book.get(j).getPhoneNumb().get(l).toString());
                                        }
                                        System.out.println("Какой номер необходимо изменить?");
                                        int tempPhone = sc.nextInt()+1;
                                        System.out.println("Введите новый номер телефона");
                                        book.get(j).getPhoneNumb().get(tempPhone).setNumber(sc.next());
                                       // System.out.println("Введите номер телефона");
                                       // book.get(j).getPhoneNumb().setNumber(sc.next());
                                        break;
                                    case 3:
                                        System.out.println("Введите тег");
                                        book.get(j).setTeg(sc.next());
                                        break;
                                    case 4:
                                        exit2 = 1;
                                        break;
                                    default:
                                        System.out.println("Ошибка ввода");
                                        break;
                                }
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("1.Сортировать по имени");
                    System.out.println("2.Сортировать по фамилии");
                    System.out.println("3.Сортировать по тeгу");
                    System.out.println("4.Сортировать по типу телефона");
                    System.out.println("выберите действие");
                    switch (sc.nextInt()){
                        case 1:
                            Collections.sort(book,new CompName());
                            break;
                        case 2:
                            Collections.sort(book,new CompLastname());
                            break;
                        case 3:
                            Collections.sort(book,new CompTeg());
                            break;
                        case 4:
                         //   Collections.sort(book,new CompPhone());
                            break;
                        default:
                            System.out.println("Ошибка ввода!");
                            break;
                    }
                    break;
                case 5:
                    exit = 1;
                    break;
                case 6:
                    System.out.println("---------------------------------------------------------");
                    for(Zapis h : book){
                        System.out.println(h.getId()+" "+h.getLastname()+" "+h.getName()+" "+" "+h.getTeg());
                        for(PhoneNumb p : h.getPhoneNumb()){
                            System.out.println(p.getNumber()+" "+p.getType());
                        }
                    }
                    System.out.println("---------------------------------------------------------");
                    break;
                default:
                    System.out.println("Не корректно введены данные");
                    break;
            }
        }
    }
}
