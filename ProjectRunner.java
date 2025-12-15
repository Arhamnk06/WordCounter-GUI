public class ProjectRunner {
    
    /*
     * Name: [YOUR NAME]
     * Student ID: [YOUR ID]
     * 
     ******** Project Description ********
     * 
     * This project is a Word Counter application that allows users to input text and analyze
     * it for word count, character count, and line count. The application displays these
     * statistics both as text labels and as an interactive bar chart visualization. Users
     * can input any text in the text area, click the "Count" button to analyze it, or click
     * the "Clear" button to reset the input and statistics. The bar chart visualizes the
     * relative values of each statistic, and includes interactive elements where bars change
     * color when the mouse hovers over them.
     * 
     * 
     ******** Swing Requirement ********
     * 
     * The program satisfies the requirement of having at least 3 unique Swing components:
     * 1. JTextArea - Used for text input in WordCounter.java (line 22)
     * 2. JButton - Used for the count and clear actions in WordCounter.java (lines 27-28)
     * 3. JLabel - Used to display statistics in WordCounter.java (lines 31-33)
     * Additional components include JFrame for the main window, JScrollPane for the text area,
     * and multiple JPanels for organizing the layout.
     * 
     * 
     ******** 2D Graphics Requirement ********
     *
     * The program satisfies the requirement of having at least 1 JPanel used for drawing by
     * implementing the StatsDisplayPanel class (StatsDisplayPanel.java). This panel serves as
     * the canvas where the bar chart visualization is drawn. The drawing is implemented in the
     * paintComponent() method (lines 56-107) which draws three colored bars representing word,
     * character, and line counts. The height of each bar is proportional to its count value,
     * scaled appropriately to fit within the panel.
     * 
     * 
     ******** Event Listener Requirement ********
     *
     * The program satisfies the requirement of having at least one ActionListener and at least
     * one MouseListener:
     * 1. ActionListener - Implemented as CountButtonListener (lines 91-103) and ClearButtonListener
     *    (lines 108-120) in WordCounter.java. These listeners respond to button clicks to perform
     *    the count and clear operations, which update both the text labels and the bar chart.
     * 2. MouseListener/MouseMotionListener - Implemented as BarMouseListener (lines 112-118) and
     *    BarMouseMotionListener (lines 123-151) in StatsDisplayPanel.java. These listeners handle
     *    mouse interactions with the bar chart, creating a hover effect that changes the color of
     *    bars when the mouse moves over them.
     */

    public static void main(String[] args) {
        // Create the word counter application
        new WordCounter();
    }
}