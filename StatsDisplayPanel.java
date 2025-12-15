import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StatsDisplayPanel extends JPanel {
    private int wordCount;
    private int charCount;
    private int lineCount;
    private Color wordBarColor;
    private Color charBarColor;
    private Color lineBarColor;
    private String hoveredBar;
    
    /**
     * Constructor for the stats display panel
     */
    public StatsDisplayPanel() {
        this.wordCount = 0;
        this.charCount = 0;
        this.lineCount = 0;
        
        // Set default colors
        this.wordBarColor = Color.BLUE;
        this.charBarColor = Color.GREEN;
        this.lineBarColor = Color.RED;
        this.hoveredBar = "";
        
        // Set panel properties
        setPreferredSize(new Dimension(400, 200));
        setBackground(Color.WHITE);
        
        // Add mouse listener for hover effect
        addMouseListener(new BarMouseListener());
        addMouseMotionListener(new BarMouseMotionListener());
    }
    
    /**
     * Update the statistics to be displayed
     */
    public void updateStats(int wordCount, int charCount, int lineCount) {
        this.wordCount = wordCount;
        this.charCount = charCount;
        this.lineCount = lineCount;
    }
    
    /**
     * Overrides the paintComponent method to draw the bar chart
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // Draw title
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("Text Statistics", 20, 30);
        
        // Get max value for scaling
        int maxValue = Math.max(wordCount, Math.max(charCount, lineCount));
        if (maxValue == 0) maxValue = 1; // Avoid division by zero
        
        // Calculate bar width and spacing
        int barWidth = 60;
        int barSpacing = 30;
        int startX = 50;
        int maxBarHeight = 100;
        
        // Draw word count bar
        int wordBarHeight = (int)((double)wordCount / maxValue * maxBarHeight);
        if (wordBarHeight < 1 && wordCount > 0) wordBarHeight = 1; // Ensure visible if not zero
        
        g2d.setColor(wordBarColor);
        if (hoveredBar.equals("word")) {
            g2d.setColor(wordBarColor.darker());
        }
        g2d.fillRect(startX, getHeight() - 50 - wordBarHeight, barWidth, wordBarHeight);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(startX, getHeight() - 50 - wordBarHeight, barWidth, wordBarHeight);
        g2d.drawString("Words", startX + 10, getHeight() - 30);
        g2d.drawString(String.valueOf(wordCount), startX + 10, getHeight() - 50 - wordBarHeight - 5);
        
        // Draw character count bar
        int charBarHeight = (int)((double)charCount / maxValue * maxBarHeight);
        if (charBarHeight < 1 && charCount > 0) charBarHeight = 1;
        
        g2d.setColor(charBarColor);
        if (hoveredBar.equals("char")) {
            g2d.setColor(charBarColor.darker());
        }
        g2d.fillRect(startX + barWidth + barSpacing, getHeight() - 50 - charBarHeight, barWidth, charBarHeight);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(startX + barWidth + barSpacing, getHeight() - 50 - charBarHeight, barWidth, charBarHeight);
        g2d.drawString("Chars", startX + barWidth + barSpacing + 10, getHeight() - 30);
        g2d.drawString(String.valueOf(charCount), startX + barWidth + barSpacing + 10, getHeight() - 50 - charBarHeight - 5);
        
        // Draw line count bar
        int lineBarHeight = (int)((double)lineCount / maxValue * maxBarHeight);
        if (lineBarHeight < 1 && lineCount > 0) lineBarHeight = 1;
        
        g2d.setColor(lineBarColor);
        if (hoveredBar.equals("line")) {
            g2d.setColor(lineBarColor.darker());
        }
        g2d.fillRect(startX + 2 * (barWidth + barSpacing), getHeight() - 50 - lineBarHeight, barWidth, lineBarHeight);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(startX + 2 * (barWidth + barSpacing), getHeight() - 50 - lineBarHeight, barWidth, lineBarHeight);
        g2d.drawString("Lines", startX + 2 * (barWidth + barSpacing) + 10, getHeight() - 30);
        g2d.drawString(String.valueOf(lineCount), startX + 2 * (barWidth + barSpacing) + 10, getHeight() - 50 - lineBarHeight - 5);
    }
    
    /**
     * Mouse listener for bar chart interaction
     */
    private class BarMouseListener extends MouseAdapter {
        @Override
        public void mouseExited(MouseEvent e) {
            hoveredBar = "";
            repaint();
        }
    }
    
    /**
     * Mouse motion listener for bar chart hover effect
     */
    private class BarMouseMotionListener extends MouseMotionAdapter {
        @Override
        public void mouseMoved(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            
            // Calculate bar positions
            int barWidth = 60;
            int barSpacing = 30;
            int startX = 50;
            
            // Check if mouse is over word bar
            if (x >= startX && x <= startX + barWidth) {
                hoveredBar = "word";
            } 
            // Check if mouse is over char bar
            else if (x >= startX + barWidth + barSpacing && x <= startX + 2 * barWidth + barSpacing) {
                hoveredBar = "char";
            } 
            // Check if mouse is over line bar
            else if (x >= startX + 2 * (barWidth + barSpacing) && x <= startX + 3 * barWidth + 2 * barSpacing) {
                hoveredBar = "line";
            } else {
                hoveredBar = "";
            }
            
            repaint();
        }
    }
}