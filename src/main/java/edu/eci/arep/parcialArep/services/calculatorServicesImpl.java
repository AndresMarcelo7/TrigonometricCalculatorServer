package edu.eci.arep.parcialArep.services;

import java.util.ArrayList;

public class calculatorServicesImpl implements calculatorServices  {

    @Override
    public double calculateCos(double n) {
        return Math.cos(n);
    }

    @Override
    public double calculateSin(double n) {
        return Math.sin(n);
    }

    @Override
    public double calculateTan(double n) {
        return Math.tan(n);
    }
}
