package org.example;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

public class View extends JFrame{
    JFrame frame = new JFrame();
    private JTextField v_userInput = new JTextField( 20);
    private JTextField v_userInput2 = new JTextField( 20);
    private JTextField v_total = new JTextField(20);
    private JButton    addBtn = new JButton("Adunare");
    private JButton    subBtn    = new JButton("Scadere");
    private JButton derBtn = new JButton("Derivare");

    private JButton intBtn = new JButton("Integral");
    private JButton mulBtn = new JButton("Inmultire");
    private JButton clearBtn = new JButton("Clear");
    private VModel v_model;
    View(VModel model){

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        v_model = model;
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
        content.setLayout(new FlowLayout());
        content.add(addBtn);
        content.add(subBtn);
        content.add(derBtn);
        content.add(intBtn);
        content.add(mulBtn);
        content.add(new JLabel("Rezultat"));
        content.add(v_total);
        content.add(clearBtn);
        panel.add(content);
        panel.add(content2);
        this.setContentPane(panel);
        this.pack();
        this.setTitle("Calculator Polinoame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void reset() {v_total.setText(VModel.INITIAL_VALUE);}
    void setTotal(String Total){v_total.setText(Total);
        System.out.println(Total);}
    void addAddListener(ActionListener A){addBtn.addActionListener(A);}
    void addSubListener(ActionListener S){subBtn.addActionListener(S);}
    void addDerListener(ActionListener D){derBtn.addActionListener(D);}
    void addIntListener(ActionListener I){intBtn.addActionListener(I);}
    void addMulListener(ActionListener M){mulBtn.addActionListener(M);}
    void addClearListener(ActionListener cal) {
        clearBtn.addActionListener(cal);
    }
    String getUserInput1() {
        return v_userInput.getText();
    }
    String getUserInput2(){ return v_userInput2.getText();}
    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

}
