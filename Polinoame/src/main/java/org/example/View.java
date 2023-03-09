package org.example;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class View extends JFrame{
    JFrame frame = new JFrame();
    private JTextField v_userInput = new JTextField( 20);
    private JTextField v_userInput2 = new JTextField( 20);
    private JTextField v_total = new JTextField(20);
    private JButton    addBtn = new JButton("Adunare");
    private JButton    subBtn    = new JButton("Scadere");
    private JButton clearBtn = new JButton("Clear");
    private VModel v_model;
    View(VModel model){

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        v_model = model;
        v_model.setValue(VModel.INITIAL_VALUE);
        v_total.setText(v_model.getValue());
        v_total.setEditable(false);
        JPanel content = new JPanel();
        panel.add(content);
        panel.add(Box.createRigidArea(new Dimension(30,10)));
        JPanel content2 = new JPanel();
        panel.add(content2,BorderLayout.SOUTH);
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Primul polinom: "));
        content.add(v_userInput);
        content.add(new JLabel("Al doilea polinom: "));
        content.add(v_userInput2);
        content2.setLayout(new FlowLayout());
        content2.add(addBtn);
        content2.add(subBtn);
        content2.add(new JLabel("Rezultat"));
        content2.add(v_total);
        content2.add(clearBtn);
        panel.add(content);
        panel.add(content2);
        this.setContentPane(panel);
        this.pack();
        this.setTitle("Calculator Polinoame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    void reset() {v_total.setText(VModel.INITIAL_VALUE);}
    String getPrimulPolinom() {return v_userInput.getText();}
    void setTotal(String Total){v_total.setText(Total);}
    void addAddListener(ActionListener A){addBtn.addActionListener(A);}
    void addSubListener(ActionListener S){subBtn.addActionListener(S);}
    void addClearListener(ActionListener cal) {
        clearBtn.addActionListener(cal);
    }
}
