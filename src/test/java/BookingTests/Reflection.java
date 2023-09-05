package BookingTests;

import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

public class Reflection {

    public void countOfMethodsAndWriteMethodsInFile() {
        Class<SearchResultTests> methods = SearchResultTests.class;
        Method[] declaredMethods = methods.getDeclaredMethods();
        int count = 0;
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Test.class)) {
                count++;
            }
        }
        System.out.println("Number of methods: " + count);

        try (FileWriter writer = new FileWriter("Methods.txt", false)) {
            for (int i = 0; i < count; i++) {
                writer.write(String.valueOf(declaredMethods[i]));
                if (i == count - 1) {
                    break;
                }
                writer.write("," + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {

        Reflection reflection = new Reflection();
        reflection.countOfMethodsAndWriteMethodsInFile();
    }
}
