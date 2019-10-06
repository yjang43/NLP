package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.*;

public class Application extends JPanel {
  private JTextField textField;
  private JTextArea textArea;
  private static final int SCREEN_WIDTH = 500;
  private static final int SCREEN_HEIGHT = 300;
  private ArrayList<Integer> arr;
  
  /**
   * make text field and text area for input and output
   * @param arr
   */
  public Application(ArrayList<Integer> arr) {
    super(new BorderLayout());
    this.arr = arr;
    textField = new JTextField(0);
    textField.addActionListener(new GetTextListner());
    textArea = new JTextArea(10, 0);
    textArea.setEditable(false);
    add(textArea, BorderLayout.PAGE_START);
    add(textField, BorderLayout.PAGE_END);
  }
  
  public Dimension getPreferredSize() {
    return new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
}
  
  
  /**
   * when text field is pressed enter, output is shown in the text area
   * @author jang
   *
   */
  class GetTextListner implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      String text = textField.getText();
      System.out.println(text);
      textArea.setText(text);
      textField.selectAll();
    }
  }
  
  
  
  /**
   * pack components into a frame
   */
  public static void createAndShowGUI() {
      System.out.println("created " + SwingUtilities.isEventDispatchThread());
      JFrame f = new JFrame("Project: NLP");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JComponent newContentPane = new Application(new ArrayList<Integer>());
      newContentPane.setOpaque(true); //content panes must be opaque
      f.setContentPane(newContentPane);
      f.pack();
      f.setVisible(true);
  }
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        
        @Override
        public void run() {
            // TODO Auto-generated method stub
            createAndShowGUI();
        }
    });
  }
}

  
