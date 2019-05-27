package root;

import root.views.IView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Date;

public class ImageModel {

  public transient ArrayList<IView> observers;
  public String path;
  public Date creationDate;
  public String fileName;
  public transient BufferedImage data;
  public transient boolean addedToView;

  public ImageModel(File file) {
    this.creationDate = new Date();
    this.fileName = file.getName();
    this.addedToView = false;
    this.observers = new ArrayList<>();
    this.path = file.getAbsolutePath();

    try {
      this.data = ImageIO.read(file);
    } catch (IOException e) {

    }
  }

  public void addObserver(IView view) {
    this.observers.add(view);
  }

  public void notifyViews(Action a) {
    for (IView view : this.observers) {
      view.updateView(a);
    }
  }
}
