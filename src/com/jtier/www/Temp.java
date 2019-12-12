package com.jtier.www;

import java.util.Optional;
import java.util.UUID;

public class Temp {

    public static void main(String[] args) {
        final String str = null;
        final UUID temp = Optional.Of(str);
        System.out.println(temp);
    }
}
