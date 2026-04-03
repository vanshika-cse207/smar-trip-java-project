package smartrip.tourism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    String username;
    JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, checkPackages, bookPackage, viewPackage, viewHotels;
    JButton destinations, bookHotel, viewBookHotel, payments, calculators, notepad, about, deletePersonalDetails;

    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(Image image) {
            this.backgroundImage = image;
            setLayout(new BorderLayout());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    public Dashboard(String username) {
        this.username = username;

        setTitle("Smartrip Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(1024, 768));

        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/home.png"));
        Image bgImage = bgIcon.getImage();

        BackgroundPanel backgroundPanel = new BackgroundPanel(bgImage);
        setContentPane(backgroundPanel);

        JPanel container = new JPanel(new BorderLayout(20, 20));
        container.setOpaque(false);
        container.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        backgroundPanel.add(container, BorderLayout.CENTER);

        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT));
        header.setOpaque(false);
        header.setPreferredSize(new Dimension(0, 80));

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/dashboard2.png"));
        Image iconImg = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel iconLabel = new JLabel(new ImageIcon(iconImg));
        header.add(iconLabel);

        JLabel heading = new JLabel("Dashboard");
        heading.setForeground(Color.black);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 32));
        header.add(heading);

        container.add(header, BorderLayout.NORTH);

        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(300, 0));
        sidebar.setOpaque(false);

        Font buttonFont = new Font("Segoe UI", Font.BOLD, 19);
        Color buttonFg = Color.black;  // Black text

        addPersonalDetails = createButton("Add Personal Details", buttonFont, buttonFg, "Add your personal details");
        updatePersonalDetails = createButton("Update Personal Details", buttonFont, buttonFg, "Update existing personal details");
        viewPersonalDetails = createButton("View Details", buttonFont, buttonFg, "View your personal information");
        deletePersonalDetails = createButton("Delete Personal Details", buttonFont, buttonFg, "Delete your personal details");
        checkPackages = createButton("Check Packages", buttonFont, buttonFg, "Browse available packages");
        bookPackage = createButton("Book Package", buttonFont, buttonFg, "Book your desired package");
        viewPackage = createButton("View Package", buttonFont, buttonFg, "View your booked packages");
        viewHotels = createButton("View Hotels", buttonFont, buttonFg, "See hotels available");
        bookHotel = createButton("Book Hotel", buttonFont, buttonFg, "Book a hotel room");
        viewBookHotel = createButton("View Book Hotel", buttonFont, buttonFg, "View your hotel bookings");
        destinations = createButton("Destinations", buttonFont, buttonFg, "Explore destinations");
        payments = createButton("Payments", buttonFont, buttonFg, "Manage payments");
        calculators = createButton("Calculator", buttonFont, buttonFg, "Open calculator");
        notepad = createButton("Notepad", buttonFont, buttonFg, "Open notepad");
        about = createButton("About", buttonFont, buttonFg, "About Smartrip application");

        JButton[] buttons = {
            addPersonalDetails, updatePersonalDetails, viewPersonalDetails, deletePersonalDetails,
            checkPackages, bookPackage, viewPackage, viewHotels, bookHotel, viewBookHotel,
            destinations, payments, calculators, notepad, about
        };

        for (JButton btn : buttons) {
            btn.setMaximumSize(new Dimension(300, 50));
            sidebar.add(btn);
            sidebar.add(Box.createVerticalStrut(5));
        }

        addPersonalDetails.addActionListener(this);
        updatePersonalDetails.addActionListener(this);
        viewPersonalDetails.addActionListener(this);
        deletePersonalDetails.addActionListener(this);
        checkPackages.addActionListener(this);
        bookPackage.addActionListener(this);
        viewPackage.addActionListener(this);
        viewHotels.addActionListener(this);
        bookHotel.addActionListener(this);
        viewBookHotel.addActionListener(this);
        destinations.addActionListener(this);
        payments.addActionListener(this);
        calculators.addActionListener(this);
        notepad.addActionListener(this);
        about.addActionListener(this);

        container.add(sidebar, BorderLayout.WEST);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false);

        JLabel welcomeText = new JLabel("Welcome to Smartrip Jharkhand Eco Tours");
        welcomeText.setFont(new Font("Segoe UI", Font.BOLD, 46));
        welcomeText.setForeground(Color.black);
        centerPanel.add(welcomeText);

        container.add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JButton createButton(String text, Font font, Color fg, String tooltip) {
        JButton btn = new JButton(text);
        btn.setFont(font);
        btn.setForeground(fg);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.setContentAreaFilled(false);
        btn.setOpaque(false);

        btn.setToolTipText(tooltip);

        // Hover zoom effect
        btn.addMouseListener(new MouseAdapter() {
            Font originalFont = btn.getFont();
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setFont(originalFont.deriveFont(originalFont.getSize() * 1.1f)); // 10% zoom
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setFont(originalFont);
            }
        });

        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        if (source == addPersonalDetails) {
            new AddCustomer(username);
        } else if (source == viewPersonalDetails) {
            new ViewCustomer(username);
        } else if (source == updatePersonalDetails) {
            new UpdateCustomer(username);
        } else if (source == deletePersonalDetails) {
            JOptionPane.showMessageDialog(this, "Delete Personal Details clicked");
        } else if (source == checkPackages) {
            new CheckPackage();
        } else if (source == bookPackage) {
            new BookPackage(username);
        } else if (source == viewPackage) {
            new ViewPackage(username);
        } else if (source == viewHotels) {
            new CheckHotels();
        } else if (source == destinations) {
            new Destinations();
        } else if (source == bookHotel) {
            new BookHotel(username);
        } else if (source == viewBookHotel) {
            new ViewBookedHotel(username);
        } else if (source == payments) {
            new Payment();
        } else if (source == calculators) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (source == notepad) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (source == about) {
            new About();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Dashboard("User"));
    }
}

