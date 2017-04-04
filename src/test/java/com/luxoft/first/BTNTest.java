/*
We have a class representing binary tree nodes: class BTN { int val; BTN left; BTN right; }
please implement Java method to compare 2 such trees (returns: true if fully equal, false - otherwise)
* */
package com.luxoft.first;

import static com.luxoft.first.BTN.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class BTNTest {

    @Test
    public void compare_must_return_true_when_arguments_point_to_one_object() {
        // assign
        BTN btn1 = new BTN(0, null, null);

        // act
        boolean result = compare(btn1, btn1);

        // assert
        assertTrue(result);
    }

    @Test
    public void compare_must_return_true_when_both_arguments_are_null() {
        // act
        boolean result = compare(null, null);

        // assert
        assertTrue(result);
    }

    @Test
    public void compare_must_return_false_when_some_argument_is_null() {
        // assign
        BTN btn1 = new BTN(0, null, null);

        // act
        boolean result1 = compare(btn1, null);
        boolean result2 = compare(null, btn1);

        // assert
        assertFalse(result1);
        assertFalse(result2);
    }

    @Test
    public void compare_must_correctly_compare_leafs() {
        // assign
        BTN btn1 = new BTN(0, null, null);
        BTN btn2 = new BTN(0, null, null);
        BTN btn3 = new BTN(1, null, null);

        // act
        boolean result1 = compare(btn1, btn2);
        boolean result2 = compare(btn1, btn3);

        // assert
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    public void compare_must_correctly_compare_arguments_left_side() {
        // assign
        BTN leaf = new BTN(0, null, null);
        BTN btn1 = new BTN(1, leaf, null);
        BTN btn2 = new BTN(1, leaf, null);
        BTN btn3 = new BTN(2, btn1, null);
        BTN btn4 = new BTN(2, leaf, null);

        // act
        boolean result1 = compare(btn1, btn2);
        boolean result2 = compare(btn3, btn4);

        // assert
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    public void compare_must_correctly_compare_arguments_right_side() {
        // assign
        BTN leaf = new BTN(2, null, null);
        BTN btn1 = new BTN(1, null, leaf);
        BTN btn2 = new BTN(1, null, leaf);
        BTN btn3 = new BTN(0, null, btn1);
        BTN btn4 = new BTN(0, null, leaf);

        // act
        boolean result1 = compare(btn1, btn2);
        boolean result2 = compare(btn3, btn4);

        // assert
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    public void compare_must_correctly_compare_arguments_both_sides_and_values() {
        // assign
        BTN leaf1 = new BTN(0, null, null);
        BTN leaf2 = new BTN(3, null, null);
        BTN btn1 = new BTN(1, leaf1, leaf2);
        BTN btn2 = new BTN(1, leaf1, leaf2);
        BTN btn3 = new BTN(2, leaf1, leaf2);
        BTN btn4 = new BTN(2, btn1, leaf2);

        // act
        boolean result1 = compare(btn1, btn2);
        boolean result2 = compare(btn3, btn2);
        boolean result3 = compare(btn3, btn4);

        // assert
        assertTrue(result1);
        assertFalse(result2);
        assertFalse(result3);
    }
}
