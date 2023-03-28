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
import java.util.Arrays;
import java.util.List;

@Service
public class SolutionService {


    public List<Boolean> evaluate(String code, String test) throws IOException {

        // Generate a test case
        String[] input = test.split(":")[0].split(",");
        boolean arg1 = Boolean.parseBoolean(input[0]);
        boolean arg2 = Boolean.parseBoolean(input[1]);
        boolean expectedOutput = Boolean.parseBoolean(test.split(":")[1]);


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
            Method method = clazz.getMethod("sleepIn", boolean.class, int[].class);

            // Execute the test case
            System.out.println(method.getReturnType());
            System.out.println(Arrays.toString(method.getParameterTypes()));
//            System.out.println(method.);
            boolean result = (boolean) method.invoke(sourceFile, arg1, arg2);
            System.out.println("result:" + (result == expectedOutput));
            // Return the evaluation result
            List<Boolean> list = new ArrayList<>();
            list.add(result == expectedOutput);
            list.add(result);
            return list;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
