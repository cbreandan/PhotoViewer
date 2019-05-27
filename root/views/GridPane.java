package root.views;

import root.ImageModel;
import root.Model;
import root.views.buttons.SingleView;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GridPane extends JPanel implements IView {
  Model model;
  ArrayList<ImageModel> imagesToDisplay;

  public GridPane(Model model) {
    this.model = model;
    this.model.addObserver(this);
    this.setLayout(new GridLayout(0, this.model.numCol()));

    this.imagesToDisplay = this.model.images;
  }

  public void updateView(root.Action a) {
    switch (a) {
      case AddImage:
        this.setLayout(new GridLayout(0, this.model.numCol()));
        break;
      case ChangeLayout:
        this.setLayout(new GridLayout(0, this.model.numCol()));
        break;
      case Resize:
        this.setLayout(new GridLayout(0, this.model.numCol()));
        break;
    }

    this.revalidate();
    this.repaint();
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (ImageModel imageModel:this.imagesToDisplay) {
      if (!imageModel.addedToView) {
        SingleView gt = new SingleView(imageModel, model);
        this.add(gt);
        imageModel.addedToView = true;
      }
    }
    this.setLayout(new GridLayout(0, this.model.numCol()));
    this.revalidate();
  }
}
