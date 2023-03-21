package org.Interfata;
import Polinom.Polinoame;

import java.awt.event.*;
import java.util.HashMap;

public class VController {
    private VModel v_model;
    private View v_view;

    VController(VModel model, View view) {
        v_model = model;
        v_view = view;
        view.addAddListener(new AddListener());
        view.addSubListener(new SubListener());
        view.addClearListener(new ClearListener());
        view.addDerListener(new DerListener());
        view.addMulListener(new MulListener());
        view.addIntListener(new IntListener());
    }

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                Polinoame polinom1 = new Polinoame(v_view.getUserInput1());
                Polinoame polinom2 = new Polinoame(v_view.getUserInput2());

                HashMap<Double,Double> h = new HashMap( v_model.addTo(polinom1, polinom2));
                v_model.faString(h);
                v_view.setTotal(v_model.getValue());

            } catch (NumberFormatException nfex) {
                v_view.showError("Bad input: '" + v_view.getUserInput1() + "'");
            }
        }
    }

        class SubListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                try {

                    Polinoame polinom1 = new Polinoame(v_view.getUserInput1());
                    Polinoame polinom2 = new Polinoame(v_view.getUserInput2());

                    HashMap<Double,Double> h = new HashMap(v_model.subTo(polinom1, polinom2));
                    System.out.println(h);
                    v_model.faString(h);
                    v_view.setTotal(v_model.getValue());

                } catch (NumberFormatException nfex) {
                    v_view.showError("Bad input: '" + v_view.getUserInput1() + "'");
                }
            }
        }
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            v_model.reset();
            v_view.reset();
        }
    }
    class DerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {

                Polinoame polinom1 = new Polinoame(v_view.getUserInput1());

                HashMap<Double,Double> h = new HashMap(v_model.derTo(polinom1));

                v_model.faString(h);
                v_view.setTotal(v_model.getValue());

            } catch (NumberFormatException nfex) {
                v_view.showError("Bad input: '" + v_view.getUserInput1() + "'");
            }
        }
    }
    class MulListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {

                Polinoame polinom1 = new Polinoame(v_view.getUserInput1());
                Polinoame polinom2 = new Polinoame(v_view.getUserInput2());

                HashMap<Double,Double> h = new HashMap(v_model.mulTo(polinom1, polinom2));
                System.out.println(h);
                v_model.faString(h);
                v_view.setTotal(v_model.getValue());

            } catch (NumberFormatException nfex) {
                v_view.showError("Bad input: '" + v_view.getUserInput1() + "'");
            }
        }
    }
    class IntListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {

                Polinoame polinom1 = new Polinoame(v_view.getUserInput1());

                HashMap<Double,Double> h = new HashMap(v_model.intTo(polinom1));

                v_model.faString(h);
                v_view.setTotal(v_model.getValue());

            } catch (NumberFormatException nfex) {
                v_view.showError("Bad input: '" + v_view.getUserInput1() + "'");
            }
        }
    }
}

