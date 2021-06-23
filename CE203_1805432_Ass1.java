package assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.awt.Color;

public class Main  extends JFrame { 
    private JPanel textPanel;
    private JPanel panel;
    private JPanel butPanel;
    private JPanel colPanel;
    private JTextField inp;
    private JTextArea res;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton bcol;
    JTextField textColor;
    JTextField textColor2;
    JTextField textColor3;
    List<Integer> userInput = new ArrayList<Integer>();
    int userID;



    public Main() {
        JPanel textPanel = new JPanel();
        JPanel panel = new JPanel();
        JPanel butPanel = new JPanel();
        JPanel colPanel = new JPanel();
        JLabel prompt = new JLabel("Type number, press return");
        JLabel color = new JLabel("Change text color");
        b1 = new JButton("Remove Duplicate IDs");
        b2 = new JButton("Sort IDs");
        b3 = new JButton("Display IDs");
        b4 = new JButton("Clear ID List");
        bcol = new JButton("Set Color");
        inp = new JTextField(6);
        textColor = new JTextField("0",3);
        textColor2 = new JTextField("0",3);
        textColor3 = new JTextField("0",3);
        res = new JTextArea(30,1);
        res.setEditable(false);
        res.setLineWrap(true);
        setLayout(new BorderLayout());
        textPanel.add(prompt);
        textPanel.add(inp);
        panel.add(res);
        butPanel.add(b1);
        butPanel.add(b2);
        butPanel.add(b3);
        butPanel.add(b4);
        add(textPanel, BorderLayout.NORTH);
        textPanel.add(color);
        textPanel.add(textColor); // Red value
        textPanel.add(textColor2); // Green value
        textPanel.add(textColor3); // Blue value
        textPanel.add(bcol);
        add(panel, BorderLayout.CENTER);
        add(butPanel, BorderLayout.SOUTH);

        inp.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent e) {
            try {
                boolean entered = true;
                userID = Integer.parseInt(inp.getText()); 
                while ((userID < 99999 || userID > 999999) && entered) { //checks value of the ID
                    JOptionPane.showMessageDialog(null, (inp.getText()) + " cannot be added to the list");
                    entered = false;
                }
                if (entered)
                {
                    userID = Integer.parseInt(inp.getText());
                    userInput.add(userID);
                    prompt.setText(userID + " Has been added to the list.");
                    entered = false;
                }

            }catch(Exception x) {
                JOptionPane.showMessageDialog(null, (inp.getText()) + " cannot be added to the list");
            }

        }
        });
        b1.addActionListener(new ActionListener() { // Removes duplicates
            public void actionPerformed( ActionEvent e) {
                Set<Integer> set  = new LinkedHashSet<Integer>(userInput);
                userInput.clear();
                userInput.addAll(set);
                for (Object o : userInput) {
                    res.append(String.valueOf(o) + "\n");}

            }
            });
        b2.addActionListener(new ActionListener() { // Sorts list in asc order
            public void actionPerformed( ActionEvent e) {
                Collections.sort(userInput);
                for (Object o : userInput) {
                    res.append(String.valueOf(o) + "\n");}

            }
        });
        b3.addActionListener(new ActionListener() { // Displays list
            public void actionPerformed( ActionEvent e) {
                for (Object o : userInput) {
                    res.append(String.valueOf(o) + "\n");}

           }

        });
        b4.addActionListener(new ActionListener() { // clears list completely
            public void actionPerformed( ActionEvent e) {
                userInput.clear();
                res.setText(String.valueOf(userInput));
                prompt.setText("All IDs have been removed");
            }

        });
// changes color of text/
        bcol.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent e) {
            int r = Integer.valueOf(textColor.getText());
            int g = Integer.valueOf(textColor2.getText());
            int b = Integer.valueOf(textColor3.getText());


                { try {

                    if (r > 255 || g > 255 || b > 255){
                        JOptionPane.showMessageDialog(null, "Value too high");
                    }
                    else
                    res.setForeground(new Color (r,g,b));
                }catch(Exception x) {

                    r = 0;
                    g = 0;
                    b = 0;
                    res.setForeground(new Color (r,g,b));
                    JOptionPane.showMessageDialog(null, "Invalid input");
                }

                }}

        });
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	// Close action.
    }



    public static void main( String[] args ) {
        Main a = new Main();

        a.setSize(640,480);
        a.setVisible(true);
    }
}

