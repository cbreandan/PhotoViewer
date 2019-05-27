package root.views.buttons;

import root.*;
import root.views.IView;
import root.views.ImageView;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingleView extends JPanel implements IView {
  ImageModel imageModel;
  Model model;
  ImageView imageView;
  JLabel nameLabel;
  JLabel dateLabel;
  JPanel infoPanel;

  public SingleView(ImageModel imageModel, Model model) {
    this.model = model;

    this.imageModel = imageModel;
    this.imageModel.addObserver(this);

    this.infoPanel = new JPanel();
    this.infoPanel.setLayout(new BoxLayout(this.infoPanel, BoxLayout.Y_AXIS));

    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.setBorder(BorderFactory.createLineBorder(Color.black));

    this.add(Box.createHorizontalGlue());
    this.add(Box.createVerticalGlue());
    this.imageView = new ImageView(this.imageModel.data);
    this.add(this.imageView);

    this.nameLabel = new JLabel(this.imageModel.fileName);
    this.dateLabel = new JLabel(this.imageModel.creationDate.toString());
    this.infoPanel.add(this.nameLabel);
    this.infoPanel.add(this.dateLabel);

    this.nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    this.dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    this.add(this.infoPanel);

    this.add(Box.createHorizontalGlue());
    this.add(Box.createVerticalGlue());
  }

  public void updateView(root.Action a) {
    switch (a) {
      case ChangeLayout:
        if (this.model.view == "list") {
          this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        } else if (this.model.view == "grid") {
          this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }

        break;
    }

    this.revalidate();
    this.repaint();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.revalidate();
  }
}
