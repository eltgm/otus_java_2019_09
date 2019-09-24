package ru.otus.l011;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * Created by tully.
 *
 * Example for L01
 *
 * To start the application:
 * mvn package
 * java -cp ./target/L01-maven-jar-with-dependencies.jar ru.otus.l011.Main
 * java -jar ./target/L01-maven-jar-with-dependencies.jar
 *
 * To unzip the jar:
 * 7z x -oJAR ./target/L01-maven-jar-with-dependencies.jar
 * unzip -l ./target/L01-maven-jar-with-dependencies.jar
 *
 * To build:
 * mvn package
 * mvn clean compile
 * mvn assembly:single
 * mvn clean compile assembly:single
 */
public class Main {
    private static final int MEASURE_COUNT = 1;

    public static void main(String... args) {
        List<Integer> example = new ArrayList<>();
        int min = 0;
        int max = 999_999;
        for (int i = min; i < max + 1; i++) {
            example.add(i);
        }

        List<Integer> result = new ArrayList<>();
        Collections.shuffle(example);
        calcTime(() -> result.addAll(Lists.reverse(example)));
        System.out.println(result);
    }

    private static void calcTime(Runnable runnable) {
        long startTime = System.nanoTime();
        for (int i = 0; i < MEASURE_COUNT; i++) {
            runnable.run();
        }
        long finishTime = System.nanoTime();
        long timeNs = (finishTime - startTime) / MEASURE_COUNT;
        System.out.println("Time spent: " + timeNs + "ns (" + timeNs / 1_000_000 + "ms)");
    }
}
