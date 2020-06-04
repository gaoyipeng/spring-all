package com.sxdx.spring.security.oauth2.controller;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8TestController {

    public static void main1(String[] args) {
        /**
         * 函数式接口：Predicate
         */
        Predicate<Integer> isEven = (i) -> i%2 ==0 ;
        //判断： 是否为偶数
        System.out.println( isEven.test(18) );
        //判断： 大于10 且 为偶数
        System.out.println( isEven.and((i) -> i>10).test(18) );
        //判断： 小于10 或 为偶数
        System.out.println( isEven.or((i) -> i<10).test(18) );
        //判断： 奇数判断
        System.out.println( isEven.negate().test(18) );
    }
    public static void main2(String[] args) {
        /**
         * 函数式接口：Consumer
         */
        String str = "hello";
        Consumer<String> consumer = (i) -> System.out.println(i);
        //判断： 输出 "hello"
        consumer.accept(str);
        //判断： 输出"hello" 和 "hello world"
        consumer.andThen((i) -> System.out.println(i+" world")).accept(str);
    }

    public static void main3(String[] args) {
        /**
         * 函数式接口：Supplier
         */
        // 无参，直接返回一个String字符串
        Supplier<String> supplier = () -> new String("supplier");
        System.out.println(supplier.get());
    }

    public static void main(String[] args) {
        /**
         * 函数式接口：Function
         */
        // 接收一个Integer ,返回一个String
        Function<Integer,String> function = (i)-> {
            return Integer.toString(i);
        };
        //接收 integer 123 ，返回String "123"
        System.out.println(function.apply(123));
        System.out.println(function.apply(123) instanceof String);

        //compose 过程为：f(g(2))，也就是 (2*2)+1 ,即把g的执行结果当做f的参数
        Function<Integer, Integer> f = (x) -> x + 1;
        Function<Integer, Integer> g = (x) -> x * 2;
        f.compose(g).apply(2); // 5

        //andThen 过程为：g1(f1(2))，也就是(2+1)*2 ，即把f1的执行结果当做g1的参数
        Function<Integer, Integer> f1 = (x) -> x + 1;
        Function<Integer, Integer> g1 = (x) -> x * 2;
        f1.andThen(g1).apply(2); // 6

    }
}
