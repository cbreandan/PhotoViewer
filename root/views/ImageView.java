package root.views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImageView extends JPanel {
  public BufferedImage image;
  public Dimension dimensions;

  public ImageView(BufferedImage image) {
    this.dimensions = new Dimension(280, 180);
    this.image = image;
    this.setPreferredSize(dimensions);
    this.setMaximumSize(dimensions);
    this.setMinimumSize(dimensions);

    this.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(800, 600, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(imageIcon);
        JOptionPane.showMessageDialog(null, imageLabel, null, JOptionPane.PLAIN_MESSAGE);
      }
    });
  }

  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g2.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    this.revalidate();
  }
}
