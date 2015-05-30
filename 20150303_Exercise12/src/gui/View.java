package gui;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private Model model;
    private Controller ctrl;

    private JPanel panel;

    private JCheckBox checkbox;
    private JTextField anzahlMitarbeiter;
    private JTextArea mitarbeiter;
    private JScrollPane scroll;

    private JMenuBar menuB;
    private JMenu menu;
    private JMenuItem menuI;


    public View() {
        ctrl=new Controller(this);
        model=new Model(this);

        initFrame();
        setVisible(true);
    }

    private void initFrame() {
        setTitle("Hauptfenster");
        setSize(650, 500);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x=(int) (d.getWidth()/2-this.getWidth()/2);
        int y=(int) (d.getHeight()/2-this.getHeight()/2);
        setLocation(x, y);

        setResizable(false);
    }

    private void initComponents() {
        panel = new JPanel();

        menuB = new JMenuBar();

        menu = new JMenu("Datei");
    }
}
