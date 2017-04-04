/*
We have a class : class Element { int num; String name; int age; }
please implement java method taking Collection as an argument and returning Collection
where all elements are unique by "num" and age>20. In case of ambiguity, put in target collection any of input elements.
* */
package com.luxoft.second;

import java.util.*;

import static com.luxoft.second.Element.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ElementTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructor_must_throw_exception_if_name_is_null() {

        Element element = new Element(0, null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_must_throw_exception_if_num_is_negative() {

        Element element = new Element(-1, "name", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_must_throw_exception_if_age_is_negative() {

        Element element = new Element(0, "name", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getDistinctByNumAndAge_must_throw_exception() {
        // act
        Collection<Element> result = getDistinctByNumAndAge(null);

        // assert;
        assertTrue(result.isEmpty());
    }

    @Test
    public void getDistinctByNumAndAge_must_return_empty_collection_when_argument_is_empty() {
        // assign
        Collection<Element> collection = new ArrayList<Element>();

        // act
        Collection<Element> result = getDistinctByNumAndAge(collection);

        // assert;
        assertTrue(result.isEmpty());
    }

    @Test
    public void getDistinctByNumAndAge_must_return_empty_collection_when_elements_do_not_match_criterion() {
        // assign
        Element element1 = new Element(1, "element1", 18);
        Element element2 = new Element(1, "element2", 19);
        Element element3 = new Element(1, "element3", 20);
        Collection<Element> collection = Arrays.asList(element1, element2, element3);

        // act
        Collection<Element> result = getDistinctByNumAndAge(collection);

        // assert;
        assertTrue(result.isEmpty());
    }

    @Test
    public void getDistinctByNumAndAge_must_return_collection_with_one_element_only() {
        // assign
        Element element1 = new Element(1, "element1", 21);
        Element element2 = new Element(1, "element2", 22);
        Element element3 = new Element(1, "element3", 23);
        Collection<Element> collection = Arrays.asList(element1, element2, element3);

        // act
        Collection<Element> result = getDistinctByNumAndAge(collection);

        // assert;
        assertTrue(result.size() == 1);
        assertTrue(result.iterator().next().equals(element1));
    }

    @Test
    public void getDistinctByNumAndAge_must_return_collection_with_elements_by_unique_num_and_criterion() {
        // assign
        Element element1 = new Element(1, "element1", 19);
        Element element2 = new Element(1, "element2", 20);
        Element element3 = new Element(1, "element3", 21);
        Element element4 = new Element(1, "element4", 21);
        Element element5 = new Element(2, "element5", 22);
        Element element6 = new Element(2, "element6", 23);
        Element element7 = new Element(3, "element7", 24);

        Collection<Element> collection =
                Arrays.asList(element1, element2, element3, element4, element5, element6, element7);

        // act
        Collection<Element> result = getDistinctByNumAndAge(collection);

        // assert;
        Iterator<Element> iterator = result.iterator();
        assertTrue(result.size() == 3);
        assertTrue(iterator.next().equals(element3));
        assertTrue(iterator.next().equals(element5));
        assertTrue(iterator.next().equals(element7));
    }
}