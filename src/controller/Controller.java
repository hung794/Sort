package controller;

import entity.Teacher;
import util.DateTimeUtil;
import util.HashMapUtil;

import java.io.*;
import java.util.*;

public class Controller {

    private final Scanner input = new Scanner(System.in);
    private final HashMapUtil hashMapUtil = new HashMapUtil();
    private final String filePath = "D:\\test.txt";

    public void saveToFile() {
        Teacher teacher = new Teacher();
        boolean Saved = false;
        File file = new File(filePath);
        file.setWritable(true);
        System.out.print("Teacher ID: ");
        String id = input.nextLine();
        teacher.setId(id);
        System.out.print("Teacher name: ");
        String name = input.nextLine();
        teacher.setName(name);
        System.out.print("Date: ");
        String strDate = input.nextLine();
        Date date = DateTimeUtil.parseDateFromString(strDate);
        teacher.setDate(date);
        System.out.print("Number of cakes: ");
        String strNumberOfCakes = input.nextLine();
        int numberOfCakes = Integer.parseInt(strNumberOfCakes);
        teacher.setNumberOfCakes(numberOfCakes);
        try {
            FileWriter fw = new FileWriter(filePath, true);
            fw.write(teacher + "\r\n");
            Saved = true;
            fw.close();
        } catch (Exception e) {
            System.out.println("Save failed!");
        }
        if(Saved){
            System.out.println("Save success!");
        }
        file.setReadOnly();
    }

    public void readFile() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        if (fileInputStream != null) {
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
            try {
                fileInputStream.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public void findTop3() {
        HashMap<String, Teacher> listRead = hashMapUtil.addFromFileToHashMap();
        Set<Map.Entry<String, Teacher>> entrySet = listRead.entrySet();
        List<Map.Entry<String, Teacher>> list = new ArrayList<>(entrySet);
        list.sort((o1, o2) -> {
            if (o1.getValue().getNumberOfCakes() == o2.getValue().getNumberOfCakes()) {
                return o2.getValue().getDate().compareTo(o1.getValue().getDate());
            }
            return Integer.compare(o2.getValue().getNumberOfCakes(), o1.getValue().getNumberOfCakes());
        });
        for (int i = 0; i < 3 && i < list.size(); i++) {
            System.out.println(list.get(i).getValue().toStringForSort());
        }
    }
}
