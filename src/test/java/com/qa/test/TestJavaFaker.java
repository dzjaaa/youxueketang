package com.qa.test;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：TestFaker
 * @ Author：duzhengjun
 * @ dateTime：2020/6/4 20:57
 */
public class TestJavaFaker {
    /**
     * 构造测试数据时，需要绞尽脑汁浪费时间，JavaFaker可以释放你的生产力
     * Faker是一个PHP库，可以为您生成假数据。无论您是需要引导数据库，创建美观的XML文档，填充持久性以进行压力测试还是匿名化来自生产服务的数据，Faker都是您的理想之选。
     *
     * Faker受到Perl的Data :: Faker和ruby的Faker的极大启发。
     *
     * Faker需要PHP> = 5.3.3。
     */
    public static class Student implements Comparable<Student>{

        /**
         * 姓名
         */
        private String name;


        /**
         * 分数
         */
        private double score;

        public Student(String name, double score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return Double.compare(this.score, o.score);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }

        /**
         * faker 指定汉语，默认英语
         */
        private static Faker FAKER = new Faker(Locale.CHINA);


        /**
         * 随机生成一定数量学生
         *
         * @param number 数量
         * @return 学生
         */
        public static List<Student> listStudentList(final int number) {
            return Stream.generate(() -> new Student(FAKER.name().fullName(), FAKER.number().randomDouble(2, 1, number))).limit(number).collect(Collectors.toList());
        }


        /**
         * main函数
         */
        public static void main(String[] args) {
            listStudentList(5).forEach(System.out::println);
        }



    }
}
