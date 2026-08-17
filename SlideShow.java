package SlideShow;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Southern New Hampshire University
 * CS-250: Software Development Lifecycle
 * Module 5-2 Assignment: Product Application
 * 
 * Author: Deepesh Koirala
 * Professor: Deron Dantzler
 * Date: August 2, 2026
 * 
 * Project Name: Top 5 Wellness Destinations SlideShow
 * 
 * Description: This application displays a slideshow of wellness and detox
 * travel destinations for SNHU Travel's booking tool. The slide show
 * features five destinations with images and descriptions, allowing
 * users to navigate between slides using Previous and Next buttons.
 * 
 * MODIFICATION HISTORY:
 * - Original version: Generic top destinations with placeholder text
 * - Current version: Updated to detox/wellness travel focus per Product
 *   Owner's request. Added clickable images and text boxes with color
 *   change on hover and click, title label, developer name, and
 *   country information with wellness focus.
 * 
 * IMAGE CREDITS (Unsplash):
 * #1 Grand Canyon - existing image
 * #2 Bali Rice Terraces - Jason Cooper
 * #3 Blue Lagoon, Iceland - Leo Visions
 * #4 Sedona Red Rocks - Max Harlynking
 * #5 Banff National Park - Jacky Huang
 */
public class SlideShow extends JFrame {

    private JPanel slidePane;
    private CardLayout card;
    private JButton btnPrev;
    private JButton btnNext;
    private String[] packageLinks;

    public SlideShow() throws HeadlessException {
        initComponent();
    }

    private void initComponent() {
        card = new CardLayout();
        slidePane = new JPanel();
        btnPrev = new JButton();
        btnNext = new JButton();

        packageLinks = new String[]{
            "https://www.snhutravel.com/packages/grand-canyon-wellness",
            "https://www.snhutravel.com/packages/bali-wellness",
            "https://www.snhutravel.com/packages/iceland-geothermal",
            "https://www.snhutravel.com/packages/sedona-wellness",
            "https://www.snhutravel.com/packages/banff-wellness"
        };

        setSize(900, 700);
        setLocationRelativeTo(null);
        setTitle("SNHU Travel - Top Destinations");
        getContentPane().setLayout(new BorderLayout(0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ============================================================
        // TOP LABEL: "Top 5 Wellness Destinations"
        // ============================================================
        JLabel topLabel = new JLabel("Top 5 Wellness Destinations", SwingConstants.CENTER);
        topLabel.setFont(new Font("Arial", Font.BOLD, 18));
        topLabel.setForeground(new Color(44, 62, 80));
        topLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 8, 0));
        getContentPane().add(topLabel, BorderLayout.NORTH);

        // Slide pane
        slidePane.setLayout(card);

        // Create slides
        for (int i = 1; i <= 5; i++) {
            final int slideIndex = i;
            
            // ============================================================
            // MAIN SLIDE PANEL
            // ============================================================
            JPanel slidePanel = new JPanel(new BorderLayout());
            slidePanel.setBackground(Color.WHITE);
            slidePanel.setBorder(BorderFactory.createEmptyBorder(3, 20, 3, 20));

            // ============================================================
            // IMAGE - Large image (850x470) matching text box width
            // ============================================================
            JLabel imageLabel = new JLabel();
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imageLabel.setText(getResizeIcon(slideIndex));

            // ============================================================
            // TEXT BOX - Blue background with white text
            // Color: Color.BLUE matching the Module 5 screenshot
            // ============================================================
            JPanel textBox = new JPanel(new BorderLayout());
            textBox.setBackground(Color.BLUE);
            textBox.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLUE, 2),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
            ));
            textBox.setCursor(new Cursor(Cursor.HAND_CURSOR));

            // Destination name with country
            JLabel nameLabel = new JLabel(getDestinationName(slideIndex), SwingConstants.CENTER);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
            nameLabel.setForeground(Color.WHITE);

            // Wellness focus
            JLabel focusLabel = new JLabel(getWellnessFocus(slideIndex), SwingConstants.CENTER);
            focusLabel.setFont(new Font("Arial", Font.ITALIC, 14));
            focusLabel.setForeground(Color.WHITE);

            // Description
            JLabel descLabel = new JLabel(getDescription(slideIndex), SwingConstants.CENTER);
            descLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            descLabel.setForeground(Color.WHITE);

            // Add text components to text box
            JPanel textContentPanel = new JPanel(new BorderLayout());
            textContentPanel.setBackground(Color.BLUE);
            textContentPanel.add(nameLabel, BorderLayout.NORTH);
            textContentPanel.add(focusLabel, BorderLayout.CENTER);
            textContentPanel.add(descLabel, BorderLayout.SOUTH);
            
            textBox.add(textContentPanel, BorderLayout.CENTER);

            // ============================================================
            // CLICK FUNCTIONALITY - Opens link on click
            // Blue -> Lighter blue on click, then opens link
            // ============================================================
            textBox.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    try {
                        textBox.setBackground(new Color(100, 150, 255));
                        textContentPanel.setBackground(new Color(100, 150, 255));
                        Desktop.getDesktop().browse(new URI(packageLinks[slideIndex - 1]));
                        new Thread(() -> {
                            try { Thread.sleep(200); } catch (Exception ex) {}
                            textBox.setBackground(Color.BLUE);
                            textContentPanel.setBackground(Color.BLUE);
                        }).start();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Unable to open link: " + ex.getMessage());
                        textBox.setBackground(Color.BLUE);
                        textContentPanel.setBackground(Color.BLUE);
                    }
                }
                
                public void mouseEntered(MouseEvent e) {
                    textBox.setBackground(new Color(50, 100, 255));
                    textContentPanel.setBackground(new Color(50, 100, 255));
                }
                
                public void mouseExited(MouseEvent e) {
                    textBox.setBackground(Color.BLUE);
                    textContentPanel.setBackground(Color.BLUE);
                }
            });

            // ============================================================
            // MAKE IMAGE CLICKABLE TOO
            // ============================================================
            imageLabel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    try {
                        textBox.setBackground(new Color(100, 150, 255));
                        textContentPanel.setBackground(new Color(100, 150, 255));
                        Desktop.getDesktop().browse(new URI(packageLinks[slideIndex - 1]));
                        new Thread(() -> {
                            try { Thread.sleep(200); } catch (Exception ex) {}
                            textBox.setBackground(Color.BLUE);
                            textContentPanel.setBackground(Color.BLUE);
                        }).start();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Unable to open link: " + ex.getMessage());
                        textBox.setBackground(Color.BLUE);
                        textContentPanel.setBackground(Color.BLUE);
                    }
                }
                
                public void mouseEntered(MouseEvent e) {
                    imageLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
                
                public void mouseExited(MouseEvent e) {
                    imageLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            });

            slidePanel.add(imageLabel, BorderLayout.CENTER);
            slidePanel.add(textBox, BorderLayout.SOUTH);
            
            slidePane.add(slidePanel, "card" + i);
        }

        getContentPane().add(slidePane, BorderLayout.CENTER);

        // ============================================================
        // BOTTOM PANEL: Navigation Buttons + Developer Name
        // ============================================================
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.WHITE);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 8));
        buttonPanel.setBackground(Color.WHITE);

        btnPrev.setText("Previous");
        btnPrev.setFont(new Font("Arial", Font.PLAIN, 14));
        btnPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.previous(slidePane);
            }
        });
        buttonPanel.add(btnPrev);

        btnNext.setText("Next");
        btnNext.setFont(new Font("Arial", Font.PLAIN, 14));
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.next(slidePane);
            }
        });
        buttonPanel.add(btnNext);

        bottomPanel.add(buttonPanel, BorderLayout.CENTER);

        // ============================================================
        // DEVELOPER NAME: "Developed by Deepesh Koirala"
        // ============================================================
        JLabel nameLabel = new JLabel("Developed by Deepesh Koirala", SwingConstants.RIGHT);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        nameLabel.setForeground(Color.GRAY);
        nameLabel.setBorder(BorderFactory.createEmptyBorder(3, 0, 8, 15));
        bottomPanel.add(nameLabel, BorderLayout.SOUTH);

        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
    }

    private String getResizeIcon(int i) {
        String image = "";
        if (i == 1) {
            image = "<html><body><img width='850' height='470' src='" + getClass().getResource("/resources/TestImage1.jpg") + "'</body></html>";
        } else if (i == 2) {
            image = "<html><body><img width='850' height='470' src='" + getClass().getResource("/resources/TestImage2.jpg") + "'</body></html>";
        } else if (i == 3) {
            image = "<html><body><img width='850' height='470' src='" + getClass().getResource("/resources/TestImage3.jpg") + "'</body></html>";
        } else if (i == 4) {
            image = "<html><body><img width='850' height='470' src='" + getClass().getResource("/resources/TestImage4.jpg") + "'</body></html>";
        } else if (i == 5) {
            image = "<html><body><img width='850' height='470' src='" + getClass().getResource("/resources/TestImage5.jpg") + "'</body></html>";
        }
        return image;
    }

    private String getDestinationName(int i) {
        String name = "";
        if (i == 1) {
            name = "#1 Grand Canyon, Arizona, USA";
        } else if (i == 2) {
            name = "#2 Bali Rice Terraces, Indonesia";
        } else if (i == 3) {
            name = "#3 Blue Lagoon, Iceland";
        } else if (i == 4) {
            name = "#4 Sedona Red Rocks, Arizona, USA";
        } else if (i == 5) {
            name = "#5 Banff National Park, Alberta, Canada";
        }
        return name;
    }

    private String getWellnessFocus(int i) {
        String focus = "";
        if (i == 1) {
            focus = "Best for Wellness Retreats";
        } else if (i == 2) {
            focus = "Best for Tranquility";
        } else if (i == 3) {
            focus = "Best for Geothermal Healing";
        } else if (i == 4) {
            focus = "Best for Spiritual Renewal";
        } else if (i == 5) {
            focus = "Best for Nature Immersion";
        }
        return focus;
    }

    private String getDescription(int i) {
        String desc = "";
        if (i == 1) {
            desc = "Spectacular canyon views, hiking, and mindfulness experiences.";
        } else if (i == 2) {
            desc = "Experience tranquility among Indonesia's most serene landscapes.";
        } else if (i == 3) {
            desc = "Soak in healing mineral waters under the Nordic sky.";
        } else if (i == 4) {
            desc = "Recharge at Arizona's most powerful energy vortex sites.";
        } else if (i == 5) {
            desc = "Immerse yourself in the Canadian Rockies' pristine wilderness.";
        }
        return desc;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SlideShow ss = new SlideShow();
                ss.setVisible(true);
            }
        });
    }
}