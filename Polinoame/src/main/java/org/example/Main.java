package org.example;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        VModel vm = new VModel();
        View v = new View(vm);
        VController vc = new VController(vm,v);
        v.setVisible(true);
        Polinoame p3 = new Polinoame("-2x^3-x^5-5x+7");
        Polinoame p4 = new Polinoame("3x^3-x^2-7x-1");
        System.out.println(p3.derivative(p3));
        System.out.println(p3.getHash());
//        System.out.println(p4.getHash());
//        System.out.println(p3.sub(p3,p4));
    }
}