package com.epaxera.arithmetic;

public class DivideImpl implements Dividable {
        ///łaka maka fą
    @Override public double division(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException();
        } else {
            //Sixth comment
            return a / b;
        }

    }
}
