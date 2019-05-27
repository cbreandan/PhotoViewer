package root.views;

import root.Model;
import root.views.buttons.ImportButton;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JToolBar implements IView {
  public JPanel leftPanel;
  public JButton gridButton;
  public JButton listButton;
  public JPanel centrePanel;
  public JLabel programTitle;
  public JPanel rightPanel;
  public ImportButton importButton;

  public Model model;

  public ToolBar(Model model) {
    this.model = model;
    this.model.addObserver(this);

    // left toolbar
    leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    gridButton = new JButton();
    Icon gridIcon = new ImageIcon("root/icons/grid.png");
    gridButton.setPreferredSize(new Dimension(30, 30));
    gridButton.setIcon(gridIcon);

    Border selectedBorder = new LineBorder(Color.BLACK, 2);
    gridButton.setBorder(selectedBorder);
    
    programTitle = new JLabel("Fotag!");

    listButton = new JButton();
    Icon listIcon = new ImageIcon("root/icons/list.png");
    listButton.setPreferredSize(new Dimension(30, 30));
    listButton.setIcon(listIcon);

    this.leftPanel.add(gridButton);
    gridButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        model.setGridView();
      }
    });
    this.leftPanel.add(listButton);
    listButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        model.setListView();
      }
    });
    this.add(this.leftPanel, BorderLayout.WEST);

    // centre toolbar
    centrePanel = new JPanel(new FlowLayout());
    this.add(programTitle);
    this.add(this.centrePanel, BorderLayout.CENTER);
    
    // right toolbar
    rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    this.importButton = new ImportButton(this.model);
    this.rightPanel.add(this.importButton);

    this.add(this.rightPanel, BorderLayout.EAST);
  }

  public void updateView(root.Action a) {
    Border selectedBorder = new LineBorder(Color.BLACK, 2);
    Border deselectedBorder = new LineBorder(Color.WHITE, 2);

    switch(a) {
      case ChangeLayout:
        if (this.model.view == "list") {
          this.listButton.setBorder(selectedBorder);
          this.gridButton.setBorder(deselectedBorder);
        } else if (this.model.view == "grid") {
          this.gridButton.setBorder(selectedBorder);
          this.listButton.setBorder(deselectedBorder);
        }
        break;
    }

    this.revalidate();
    this.repaint();
  }
}
