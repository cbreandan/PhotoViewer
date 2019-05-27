package root.views.buttons;

import root.ImageModel;
import root.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ImportButton extends JButton {
  public JFileChooser fileChooser;
  public Model model;

  public ImportButton(Model model) {
    this.model = model;

    this.fileChooser = new JFileChooser();
    fileChooser.setMultiSelectionEnabled(true);
    this.setPreferredSize(new Dimension(100, 30));

    this.setText("Import images");
    this.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
          File[] imageFiles = fileChooser.getSelectedFiles();
          model.addImages(imageFiles);
          /*
          for (File imageFile : imageFiles) {
            model.addImage(new ImageModel(imageFile));
          }*/
        }
      }
    });
  }
}
