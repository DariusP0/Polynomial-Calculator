package org.example;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        VModel vm = new VModel();
        View v = new View(vm);
        VController vc = new VController(vm,v);
        v.setVisible(true);
        Polinoame p1 = new Polinoame("x^1-1");
        Polinoame p2 = new Polinoame("2x-1");
        Polinoame p3 = new Polinoame("-2x^3-x^5-5x+7");
        Polinoame p4 = new Polinoame("3x^3-x^2-7x-1");
        System.out.println(p1.integral(p1));
        System.out.println(p1.multiply(p1,p2));
        System.out.println(p3.derivative(p3));
        System.out.println(p3.getHash());
//        System.out.println(p4.getHash());
//        System.out.println(p3.sub(p3,p4));
    }
}