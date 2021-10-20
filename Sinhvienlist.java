package QuanLySinhVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Sinhvienlist {
    public static void main(String[] args) {
        ArrayList<Sinhvien> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String input, choose, chon;

        do {
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find/sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.println("Your Choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: //Create
                    int count = 0;
                    boolean test = true;
                    do {
                        Sinhvien sv = new Sinhvien();
                        sc.nextLine();
                        System.out.println("Enter ID: ");
                        do {
                            try {
                                sv.setId(Integer.parseInt(sc.nextLine()));
                                break;
                            } catch (NumberFormatException ex) {
                                System.out.println("ID must be number: ");
                            }
                        } while (true);

                        System.out.println("Enter Student's name: ");
                        do {
                            sv.setStudent_name(sc.nextLine());
                            if (sv.getStudent_name().matches("[a-z A-Z]+")) {
                                sv.setStudent_name(sv.getStudent_name());
                                break;
                            } else {
                                System.out.println("Student name must contains letter from a to z: ");
                            }
                        } while (true);

                        System.out.println("Enter Semester: ");
                        do {
                            sv.setSemester(sc.nextLine());
                            if (sv.getSemester().matches("[0-9]+")) {
                                sv.setSemester(sv.getSemester());
                                break;
                            } else {
                                System.out.println("Semester is number: ");
                            }
                        } while (true);

                        System.out.println("Course name (java, c, .net): ");
                        do {
                            sv.setCourse_name(sc.nextLine());
                            if (sv.getCourse_name().matches("java") || sv.getCourse_name().matches("c") || sv.getCourse_name().matches(".net")) {
                                sv.setCourse_name(sv.getCourse_name());
                                break;
                            } else {
                                System.out.println("Invalid Course: ");
                                continue;
                            }
                        } while (true);
                        list.add(sv);
                        count++;
                        if (count >= 4) {
                            System.out.println("Continues ?? Y for yes, N for no");
                            input = sc.nextLine();
                            if (input.equalsIgnoreCase("N")) {
                                test = false;
                            }
                        }
                    } while (test);

                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).displayData();
                    }
                    break;
                case 2:
                    System.out.println("Choose your funtion: Sort(S)/Find(F)");
                    chon = sc.next();
                    if (chon.equalsIgnoreCase("F")){
                        //Find
                        System.out.println("Enter name: ");
                        String search = sc.next();
                        for (int i = 0; i < list.size(); i++){
                            if (list.get(i).getStudent_name().contains(search)){
                                list.get(i).displayData();
                            }
                        }
                    } else if (chon.equalsIgnoreCase("S")) {
                        //Sort
                        System.out.println("Enter name: ");
                        Sinhvien sv = new Sinhvien();
                        Collections.sort(list, new Comparator<Sinhvien>() {
                            @Override
                            public int compare(Sinhvien o1, Sinhvien o2) {
                                return o1.getStudent_name().compareTo(o2.getStudent_name());
                            }
                        });
                        for (int i = 0; i < list.size(); i++) {
                            list.get(i).displayData();
                        }
                    }
                      else {
                    System.out.println("Can't Found !!");
                    }
                    break;
                case 3:
                    System.out.println("Choose your funtion: Update(U)/Delete(D)");
                    choose = sc.next();
                    if (choose.equalsIgnoreCase("U")) {
                        System.out.println("nhập id sinh viên: ");
                        int id = sc.nextInt();
                        boolean tim = false;
                        for (int i = 0; i < list.size(); i++) {
                            if (id == list.get(i).getId()) {
                                sc.nextLine();
                                System.out.println("Nhập tên muốn sửa: ");
                                list.get(i).setStudent_name(sc.nextLine());

                                System.out.println("Nhập học kỳ muốn sửa: ");
                                list.get(i).setSemester(sc.next());

                                System.out.println("Nhập khóa học muốn sửa: ");
                                list.get(i).setCourse_name(sc.nextLine());

                                tim = true;

                                System.out.println("Student after Edit: ");
                                list.get(i).displayData();
                                break;
                            }
                        }
                        if (tim == false) {
                            System.out.println("Student's ID doesn't match");
                        }
                    } else if (choose.equalsIgnoreCase("D")) {
                        System.out.println("Find ID: ");
                        int check3 = sc.nextInt();
                        for (int i = 0; i <= list.size() - 1; i++) {
                            if (list.get(i).getId() == check3) {
                                System.out.println("Delete complete !");
                                list.remove(i);
                            }
                        }
                    } else {
                        System.out.println("You Just Have two choices Bro!!, U or D: ");
                    }
                    break;
                case 4:
                    int count1 = 1;
                    for (int i = 0; i < list.size() - 1; i++){
                        for (int j = i + 1; j < list.size(); j++) {
                            if (list.get(i).getStudent_name().compareTo(list.get(j).getStudent_name())==0)
                            {
                                if (list.get(i).getCourse_name().equals(list.get(j).getCourse_name()))
                                {
                                    list.get(i).setCount1(list.get(i).getCount1()+1);
                                }
                            }
                        }
                    }
                    for (int i = 0; i < list.size(); i++)
                    {
                        System.out.println("Name: " +list.get(i).getStudent_name()+ " -- Courser name: " +list.get(i).getCourse_name()+ " -- " +list.get(i).getCount1());
                    }
                    break;
                case 5:
                    System.out.println("Tạm biệt Bờ Rô!!!");
                    System.exit(0);
                default:
                    System.out.println("There only 5 choices from 1 - 5!!");
                    break;
            }
        } while (true);
    }
}
