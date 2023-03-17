package com.example.appcodingbat.service;

import org.springframework.stereotype.Service;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

@Service
public class SolutionService {


    public boolean evaluate(String code, String test) throws IOException {

        // Generate a test case
        String[] input = test.split(":")[0].split(",");
        int arg1 = Integer.parseInt(input[0]);
        int arg2 = Integer.parseInt(input[1]);
        System.out.println(arg1);
        System.out.println(arg2);

        int expectedOutput = Integer.parseInt(test.split(":")[1]);


        String filename = "Solution.java";
        File sourceFile = new File(filename);
        java.nio.file.Files.write(sourceFile.toPath(), code.getBytes());

        // Parse the user's code
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, filename);


        // Compile the user's code
        try {
            URLClassLoader clasLoader = URLClassLoader.newInstance(new URL[]{new File("").toURI().toURL()});
            Class<?> clazz = Class.forName("Solution", true, clasLoader);
            Method method = clazz.getMethod("solution", int.class, int.class);

            // Execute the test case
            int result = (int) method.invoke(null, arg1, arg2);
            System.out.println(result);
            // Return the evaluation result
            return result == expectedOutput;
        } catch (Exception e) {
            return false;
        }
    }

}
