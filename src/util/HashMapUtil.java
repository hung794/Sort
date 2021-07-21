package util;

import entity.Teacher;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapUtil {

    public HashMap<String, Teacher> addFromFileToHashMap() {
        String filePath = "D:\\test.txt";
        HashMap<String, Teacher> listRead = new HashMap<>();
        try (Scanner s = new Scanner(new FileReader(filePath))) {
            while (s.hasNextLine()) {
                String[] result = Arrays.stream(s.nextLine().split("\\|")).map(String::trim).toArray(String[]::new);
                if (listRead.containsKey(result[0])) {
                    Teacher needUpdate = listRead.get(result[0]);
                    int newNumberOfCakes = needUpdate.getNumberOfCakes() + Integer.parseInt(result[3]);
                    needUpdate.setNumberOfCakes(newNumberOfCakes);
                    Date newDate = DateTimeUtil.parseDateFromString(result[2]);
                    if (newDate.compareTo(needUpdate.getDate()) > 0) {
                        needUpdate.setDate(newDate);
                    }
                } else {
                    Teacher teacher = new Teacher();
                    teacher.setId(result[0]);
                    teacher.setName(result[1]);
                    teacher.setDate(DateTimeUtil.parseDateFromString(result[2]));
                    teacher.setNumberOfCakes(Integer.parseInt(result[3]));
                    listRead.put(teacher.getId(), teacher);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return listRead;
    }
}