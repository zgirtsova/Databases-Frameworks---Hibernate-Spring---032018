package LabStreamAPI;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main002IntStream {
    public static void main(String[] args) {
        int[] ints = {2,3,4,5,6};
        // за int[] се използва IntStream, аналогично на DoubleStream
        IntStream intStream = IntStream.of(ints);
        int max = intStream.max().getAsInt();
        System.out.println("Max value: " + max);

        List<Integer> listNum = new ArrayList<>();
        // za List<Integer> се използва list.stream() метода
        Stream<Integer> streamList = listNum.stream();
        IntStream newIntStream = streamList.mapToInt(n -> Integer.valueOf(n));
    }
}
