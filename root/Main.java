package root;

import root.views.View;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    Model model = new Model();
    View view = new View(model);
    model.addObserver(view);

    // Set up the window.
    JFrame window = new JFrame("Fotag");
    window.setTitle("Fotag");
    window.setMinimumSize(new Dimension(128, 128));
    window.setSize(800, 600);
    window.setContentPane(view);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}
