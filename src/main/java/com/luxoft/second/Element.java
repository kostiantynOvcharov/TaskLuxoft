/*
We have a class : class Element { int num; String name; int age; }
please implement java method taking Collection as an argument and returning Collection
where all elements are unique by "num" and age>20. In case of ambiguity, put in target collection any of input elements.
* */
package com.luxoft.second;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;

public final class Element implements Comparable<Element> {

    private final int num;
    private final String name;
    private final int age;

    public Element(int num, String name, int age) {

        if (name == null) {
            throw new IllegalArgumentException("The element's name must be defined");
        }

        if (num < 0 || age < 0) {
            throw new IllegalArgumentException("The element's number and age must be positive");
        }

        this.num = num;
        this.name = name;
        this.age = age;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // if we don't using java8
    // tested by unit test ElementTest
    public static Collection<Element> getDistinctByNumAndAge(Collection<Element> elements) {

        if (elements == null) {
            throw new IllegalArgumentException("The target collection can't be null");
        }

        TreeSet<Element> uniqueElements = new TreeSet<Element>(new Comparator<Element>() {
            @Override
            public int compare(Element first, Element second) {
                return first.getNum() - second.getNum();
            }
        });

        for (Element element : elements) {
            if (element.getAge() > 20) {
                uniqueElements.add(element);
            }
        }
        return uniqueElements;
    }

    // if we are using java8
//    public static Collection<Element> getDistinctByNumAndAge(Collection<Element> elements){
//
//        Comparator<Element> comparator = Comparator.comparingInt(Element::getNum);
//        Stream<Element> stream = elements.stream().filter(element -> element.getAge() > 20);
//
//        return stream.collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Element element = (Element) o;
        return num == element.num && name.equals(element.name) && age == element.age;
    }

    @Override
    public int hashCode() {
        int result = num;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Element{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Element o) {
        int result = getNum() - o.getNum();
        if (result != 0) {
            return result;
        }
        result = getName().compareTo(o.getName());
        if (result != 0) {
            return result;
        }
        return getAge() - o.getAge();
    }
}