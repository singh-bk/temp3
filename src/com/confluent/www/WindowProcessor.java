package com.confluent.www;

public interface WindowProcessor {
    /** puts or replaces a previous key value pairing */
    void put(String key, int value);

    /** gets the most recent value for the key */
    Integer get(String key);

    /** gets the average for all values within the window */
    double getAverage();
}
