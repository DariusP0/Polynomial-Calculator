package org.example;
import java.awt.event.*;
public class VController {
    private VModel v_model;
    private View v_view;

    VController(VModel model, View view) {
        v_model = model;
        v_view = view;
        view.addAddListener(new AddListener());
      /*  view.addSubListener(new SubListener());
        view.addClearListener(new ClearListener());*/
    }

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
               Polinoame polinom1 = new Polinoame(v_view.getUserInput1());
                Polinoame polinom2 = new Polinoame(v_view.getUserInput2());

                v_model.addTo(polinom1, polinom2);
                v_view.setTotal(v_model.getValue());

            } catch (NumberFormatException nfex) {
                v_view.showError("Bad input: '" +v_view.getUserInput1()+ "'");
            }
        }
    }
}