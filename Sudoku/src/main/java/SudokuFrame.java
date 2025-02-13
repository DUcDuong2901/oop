import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SudokuFrame extends JFrame {

    JTextArea puzzleText;
    JTextArea solutionText;

    Box boxMenu;
    JButton checkButton;
    JCheckBox autoCheckBox;

    public SudokuFrame() {
        super("Sudoku Solver");

        setLayout(new BorderLayout(4, 4));


        puzzleText = new JTextArea(20, 35);
        solutionText = new JTextArea(20, 35);

        puzzleText.setBorder(new TitledBorder("Puzzle"));
        solutionText.setBorder(new TitledBorder("Solution"));
        solutionText.setEditable(false);


        boxMenu = Box.createHorizontalBox();
        checkButton = new JButton("Check");
        autoCheckBox = new JCheckBox("Auto Check");
        autoCheckBox.setSelected(true);

        boxMenu.add(checkButton);
        boxMenu.add(autoCheckBox);


        puzzleText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (autoCheckBox.isSelected())
                    reDrawSolutions();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (autoCheckBox.isSelected())
                    reDrawSolutions();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (autoCheckBox.isSelected())
                    reDrawSolutions();
            }
        });
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reDrawSolutions();
            }
        });


        add(boxMenu, BorderLayout.SOUTH);
        add(puzzleText, BorderLayout.CENTER);
        add(solutionText, BorderLayout.EAST);


        setLocationByPlatform(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void reDrawSolutions() {
        String solution = "";
        try {
            Sudoku sudoku = new Sudoku(puzzleText.getText());
            int count = sudoku.solve();
            if(count>0)
                solution = sudoku.getSolutionText();
            solution += "solutions:" + count + "\n";
            solution += "elapsed:" + sudoku.getElapsed() + "ms" + "\n";
        } catch (Exception ex) {
            solution = "Invalid data format";
        }
        solutionText.setText(solution);

    }


    public static void main(String[] args) {

        try {

            UIManager.getLookAndFeelDefaults()
                    .put("defaultFont", new Font("Arial", Font.BOLD, 16));
        } catch (Exception ignored) {
        }

        SudokuFrame frame = new SudokuFrame();
    }

}