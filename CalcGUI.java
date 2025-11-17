import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalcGUI extends JFrame implements ActionListener {
    private JTextField display;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton equalsButton, clearButton;
    
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;
    
    public CalcGUI() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5)); // 4x4 grid with 5px gaps
        
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            numberButtons[i].addActionListener(this);
        }
        
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equalsButton = new JButton("=");
        clearButton = new JButton("C");
        
        addButton.setFont(new Font("Arial", Font.PLAIN, 18));
        subButton.setFont(new Font("Arial", Font.PLAIN, 18));
        mulButton.setFont(new Font("Arial", Font.PLAIN, 18));
        divButton.setFont(new Font("Arial", Font.PLAIN, 18));
        equalsButton.setFont(new Font("Arial", Font.PLAIN, 18));
        clearButton.setFont(new Font("Arial", Font.PLAIN, 18));
        
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        equalsButton.addActionListener(this);
        clearButton.addActionListener(this);
        
        // Row 1: 7, 8, 9, /
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(divButton);
        
        // Row 2: 4, 5, 6, *
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(mulButton);
        
        // Row 3: 1, 2, 3, -
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(subButton);
        
        // Row 4: C, 0, =, +
        buttonPanel.add(clearButton);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(equalsButton);
        buttonPanel.add(addButton);
        
        add(buttonPanel, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText() + i);
            }
        }
        
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }
        
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }
        
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }
        
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }
        
        if (e.getSource() == equalsButton) {
            num2 = Double.parseDouble(display.getText());
            
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }
            
            display.setText(String.valueOf(result));
            num1 = result;
        }
        
        // Handle clear button
        if (e.getSource() == clearButton) {
            display.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalcGUI());
    }
}