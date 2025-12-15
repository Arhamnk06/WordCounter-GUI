import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordCounter {
    private JFrame frame;
    private JTextArea textArea;
    private JButton countButton, clearButton;
    private JLabel wordCountLabel, charCountLabel, lineCountLabel;
    private StatsDisplayPanel displayPanel;
    
    /**
     * Constructor for the Word Counter application
     * Sets up the main frame and all components
     */
    public WordCounter() {
        // Create main frame
        frame = new JFrame("Word Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        
        // Create text area with scroll pane
        textArea = new JTextArea(10, 30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        // Create buttons
        countButton = new JButton("Count");
        clearButton = new JButton("Clear");
        
        // Create labels to display counts
        wordCountLabel = new JLabel("Words: 0");
        charCountLabel = new JLabel("Characters: 0");
        lineCountLabel = new JLabel("Lines: 0");
        
        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(countButton);
        buttonPanel.add(clearButton);
        
        // Create stats panel
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(3, 1));
        statsPanel.add(wordCountLabel);
        statsPanel.add(charCountLabel);
        statsPanel.add(lineCountLabel);
        
        // Create stats display panel for bar chart
        displayPanel = new StatsDisplayPanel();
        
        // Add action listeners
        countButton.addActionListener(new CountButtonListener());
        clearButton.addActionListener(new ClearButtonListener());
        
        // Add panels to frame
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(statsPanel, BorderLayout.EAST);
        frame.add(displayPanel, BorderLayout.SOUTH);
        
        // Display the frame
        frame.setVisible(true);
    }
    
    /**
     * Returns the current word count
     */
    public int getWordCount() {
        String text = textArea.getText();
        if (text.isEmpty()) {
            return 0;
        }
        return text.split("\\s+").length;
    }
    
    /**
     * Returns the current character count
     */
    public int getCharCount() {
        return textArea.getText().length();
    }
    
    /**
     * Returns the current line count
     */
    public int getLineCount() {
        String text = textArea.getText();
        if (text.isEmpty()) {
            return 0;
        }
        return text.split("\n").length;
    }
    
    /**
     * ActionListener for the count button
     */
    private class CountButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int words = getWordCount();
            int chars = getCharCount();
            int lines = getLineCount();
            
            wordCountLabel.setText("Words: " + words);
            charCountLabel.setText("Characters: " + chars);
            lineCountLabel.setText("Lines: " + lines);
            
            displayPanel.updateStats(words, chars, lines);
            displayPanel.repaint();
        }
    }
    
    /**
     * ActionListener for the clear button
     */
    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText("");
            wordCountLabel.setText("Words: 0");
            charCountLabel.setText("Characters: 0");
            lineCountLabel.setText("Lines: 0");
            
            displayPanel.updateStats(0, 0, 0);
            displayPanel.repaint();
        }
    }
}