import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameButton extends JFrame implements ActionListener{
    JFrame frame = new JFrame();
    JButton onButton = new JButton("ON");
    JButton offButton = new JButton("OFF");
    JButton[] buttons = new JButton[10];
    JButton[] buttons2 = new JButton[6];  
    String[] addedbutton = {".", "=", "/", "*", "+", "-"};
    Container  c = getContentPane();

    public JFrameButton(){
        c.setLayout(new FlowLayout());
        for(int index = 0; index < buttons.length; index++){
            buttons[index] = new JButton("" + index);
            buttons[index].setEnabled(false);
            c.add(buttons[index]);
        }

        for(int index =0; index < buttons2.length; index++ ){
            buttons2[index] = new JButton(addedbutton[index]);
            buttons2[index].setEnabled(false);
            c.add(buttons2[index]);
        }


        c.add(onButton);
        c.add(offButton);
        offButton.setEnabled(false);

        onButton.addActionListener(this);
        offButton.addActionListener(this);


        onButton.setIcon(new ImageIcon("realbutton.jpg"));
        offButton.setIcon(new ImageIcon("realbutton.jpg"));

        onButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        offButton.setFont(new Font("Tahoma", Font.BOLD, 16));

        onButton.setRolloverIcon(new ImageIcon("rollover.jpg"));
        offButton.setRolloverIcon(new ImageIcon("rollover.jpg"));


        setVisible(true);
        setSize(200,420);
        setLocation(300,-1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculator");
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == onButton){
            for(int i = 250; i < 450; i++ ){
                setSize(i,350);
                c.setBackground(Color.BLACK);

                for(int index = 0; index < buttons.length; index++){
                    buttons[index].setEnabled(true);
                    buttons[index].setForeground(Color.blue);
                    buttons[index].setBackground(Color.WHITE);
                    buttons[index].setFont(new Font("Tahoma", Font.BOLD, 16));

                }
        
                for(int index = 0; index < buttons2.length; index++ ){
                    buttons2[index].setEnabled(true);
                    buttons2[index].setBackground(Color.WHITE);
                    buttons2[index].setForeground(Color.BLACK);
                    buttons2[index].setFont(new Font("Tahoma", Font.BOLD, 16));
                }
                onButton.setEnabled(false);
                offButton.setEnabled(true);

            }
        }

        if(e.getSource() == offButton){
            for(int i = 450; i > 250; i--){
                setSize(i,420);
                c.setBackground(Color.WHITE);

                for(int index = 0; index < buttons.length; index++){
                    buttons[index].setEnabled(false);
                    buttons[index].setBackground(Color.white);
                    buttons[index].setForeground(Color.gray);
                    buttons[index].setFont(new Font("Tahoma", Font.BOLD, 16));
                }
        
                for(int index = 0; index < buttons2.length; index++ ){
                    buttons2[index].setEnabled(false);
                    buttons2[index].setBackground(Color.WHITE);
                    buttons2[index].setForeground(Color.gray);
                    buttons2[index].setFont(new Font("Tahoma", Font.BOLD, 16));
                }
                onButton.setEnabled(true);
                offButton.setEnabled(false);
            }

        }

    } 


    public static void main(String[]args){

        new JFrameButton();
    }
    
}
