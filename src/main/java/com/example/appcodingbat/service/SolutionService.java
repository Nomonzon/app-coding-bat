package com.example.appcodingbat.service;

import lombok.SneakyThrows;
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


    @SneakyThrows
    public List<Object> evaluate(String code, String test, String parameters) throws IOException {

        String[] parameter = parameters.split(",");
        String[] input = test.split(":")[0].split(",");

        String filename = "Solution.java";
        File sourceFile = new File(filename);
        java.nio.file.Files.write(sourceFile.toPath(), code.getBytes());

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, filename);
        Method method;
        URLClassLoader clasLoader = URLClassLoader.newInstance(new URL[]{new File("").toURI().toURL()});
        Class<?> clazz = Class.forName("Solution", true, clasLoader);
        String expectedOutput = test.split(":")[1];

        if (parameter[0].equals("Boolean") && parameter[1].equals("Boolean")) {
            boolean arg1 = Boolean.parseBoolean(input[0]);
            boolean arg2 = Boolean.parseBoolean(input[1]);
            method = clazz.getMethod("solution", boolean.class, boolean.class);
            String result = String.valueOf(method.invoke(sourceFile, arg1, arg2));
            return checkResult(expectedOutput, result);

        } else {
            int arg1 = Integer.parseInt(input[0]);
            int arg2 = Integer.parseInt(input[1]);
            method = clazz.getMethod("solution", int.class, int.class);
            String result = String.valueOf(method.invoke(sourceFile, arg1, arg2));
            return checkResult(expectedOutput, result);
        }
    }

    public List<Object> checkResult(String exceptedResult, String result) {
        List<Object> list = new ArrayList<>();
        list.add(result.equals(exceptedResult));
        list.add(result);
        return list;
    }


}

