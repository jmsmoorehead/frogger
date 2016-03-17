import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JFrame
{
    public Menu()
    {
        UI();
    }

    private void UI()
    {

        //------------------
        //      Panels
        //------------------

        //Background
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.setBackground(Color.DARK_GRAY);
        add(backgroundPanel);

        //Logo
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel1.setBackground(Color.DARK_GRAY);
        panel1.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.BLACK, Color.LIGHT_GRAY));
        backgroundPanel.add(panel1, BorderLayout.NORTH);

        //Game Button Column
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.setBackground(Color.DARK_GRAY);
        backgroundPanel.add(panel2, BorderLayout.WEST);

        //Game Display
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel3.setBackground(Color.GRAY);
        panel3.setBorder(new LineBorder(Color.black, 2));
        backgroundPanel.add(panel3);


        //------------------
        //      Buttons
        //------------------

        JButton pongButton = new JButton("Pong");
        pongButton.setIcon(new ImageIcon("images\\pong.png"));
        pongButton.setRolloverIcon(new ImageIcon("images\\pong2.png"));
        pongButton.setPressedIcon(new ImageIcon("images\\pong3.png"));
        pongButton.setFocusPainted(false);
        pongButton.setMargin(new Insets(0, 0, 0, 0));
        pongButton.setContentAreaFilled(false);
        pongButton.setBorderPainted(false);
        pongButton.setOpaque(false);
        pongButton.setBorder(new LineBorder(Color.DARK_GRAY, 5, true));
        pongButton.setForeground(Color.DARK_GRAY);
        pongButton.setIconTextGap(-45);
        panel2.add(pongButton, BorderLayout.NORTH);

        JButton froggerButton = new JButton("Frogger");
        froggerButton.setIcon(new ImageIcon("images\\frogger.png"));
        froggerButton.setRolloverIcon(new ImageIcon("images\\frogger2.png"));
        froggerButton.setPressedIcon(new ImageIcon("images\\frogger3.png"));
        froggerButton.setFocusPainted(false);
        froggerButton.setMargin(new Insets(0, 0, 0, 0));
        froggerButton.setContentAreaFilled(false);
        froggerButton.setBorderPainted(false);
        froggerButton.setOpaque(false);
        froggerButton.setForeground(Color.DARK_GRAY);
        froggerButton.setIconTextGap(-53);
        panel2.add(froggerButton, BorderLayout.CENTER);

        JButton minesweeperButton = new JButton("Mine");
        minesweeperButton.setIcon(new ImageIcon("images\\minesweeper.png"));
        minesweeperButton.setRolloverIcon(new ImageIcon("images\\minesweeper2.png"));
        minesweeperButton.setPressedIcon(new ImageIcon("images\\minesweeper3.png"));
        minesweeperButton.setFocusPainted(false);
        minesweeperButton.setMargin(new Insets(0, 0, 0, 0));
        minesweeperButton.setContentAreaFilled(false);
        minesweeperButton.setBorderPainted(false);
        minesweeperButton.setOpaque(false);
        minesweeperButton.setForeground(Color.DARK_GRAY);
        minesweeperButton.setIconTextGap(-45);
        panel2.add(minesweeperButton, BorderLayout.SOUTH);

        //------------------
        //      Labels
        //------------------

        //Create Logo for top portion of UI.
        JLabel taco = new JLabel();
        taco.setText("Taco");
        taco.setForeground(Color.GREEN);
        taco.setFont(new Font("Ravie", Font.PLAIN, 35));
        panel1.add(taco);

        //Taco Text
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("images\\taco.png"));
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        panel1.add(logo);

        //Games Text
        JLabel games = new JLabel();
        games.setText("Games");
        games.setForeground(Color.GREEN);
        games.setFont(new Font("Ravie", Font.PLAIN, 35));
        panel1.add(games);

        setTitle("Team Taco - Java Games");
        setSize(450, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        System.out.println("TEST");

        //------------------
        //      Listeners
        //------------------

        pongButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                panel3.removeAll();
                panel3.add(new PongComponent());
                panel3.setPreferredSize(new Dimension(450, 300));
                pack();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
            }
        });

        froggerButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                panel3.removeAll();
                panel3.add(new FroggerComponent());
                panel3.setPreferredSize(new Dimension(550, 350));
                pack();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
            }
        });

        minesweeperButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                panel3.removeAll();
                DrawingClass drw = new DrawingClass();
                drw.setAll();
                drw.getContentPane().setBackground(Color.GRAY);
                panel3.add(drw.getContentPane());
                panel3.setPreferredSize(new Dimension(450, 300));
                pack();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
            }
        });


        //Make it look prettier.
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }

    public static void main(String[] args)
    {
        Menu menu = new Menu();
        menu.setVisible(true);
    }
}