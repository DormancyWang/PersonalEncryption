package Cryptography;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    Window(){
        setTitle("Personal Encryption");
        setBounds(300,300,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel up = new JPanel();
        JPanel down = new JPanel();

        JTextArea input =new JTextArea(7,30);
        input.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(input);

        JTextArea output =new JTextArea(7,30);
        input.setLineWrap(true);
        JScrollPane jsp2 = new JScrollPane(output);

        JButton jb = new JButton("输入");
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Process pro = new Process();
                pro.setPlaintext(input.getText().toCharArray());
                pro.Affine_encrytion();
                pro.P();
                pro.S();
                output.setText(pro.getHex());
            }
        });
        up.add(jsp);
        up.add(jb);
        add(up,BorderLayout.NORTH);

        down.add(jsp2);

        add(down,BorderLayout.CENTER);

        setVisible(true);
    }
}
