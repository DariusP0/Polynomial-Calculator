package org.Interfata;

import Polinom.Polinoame;

public class Main {
    public static void main(String[] args) {
        VModel vm = new VModel();
        View v = new View(vm);
        VController vc = new VController(vm,v);
        v.setVisible(true);
        Polinoame p1 = new Polinoame("x^2+3");
        Polinoame p2 = new Polinoame("2x-1");
        Polinoame p3 = new Polinoame("x^3-2x^2+6x-5");
        Polinoame p4 = new Polinoame("x^2-1");

    }
}