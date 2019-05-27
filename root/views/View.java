package root.views;

import javax.swing.*;

import root.Model;

import java.awt.*;

public class View extends JPanel implements IView {
  private Model model;
  ToolBar toolBar;
  GridPane gridPane;
  public JScrollPane scrollPane;

  /**
   * Create a new View.
   */
  public View(Model model) {
    this.model = model;
    this.toolBar = new ToolBar(this.model);
    this.gridPane = new GridPane(this.model);
    this.scrollPane = new JScrollPane(this.gridPane);

    this.setLayout(new BorderLayout());
    this.add(this.toolBar, BorderLayout.PAGE_START);
    this.add(this.scrollPane, BorderLayout.CENTER);
  }

  public void updateView(root.Action a) {
    // XXX Fill this in with the logic for updating the view when the model
    // changes.
    System.out.println("Model changed!");
    this.revalidate();
    this.repaint();
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
  }
}
