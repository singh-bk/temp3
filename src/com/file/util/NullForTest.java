package com.file.util;

import java.util.ArrayList;
import java.util.List;

public class NullForTest {

    public static void main(String[] args) {
        final List<String> list = new ArrayList();
        for(final String str: list) {
            System.out.println("here");
        }
        System.out.println("here2");
    }
}
