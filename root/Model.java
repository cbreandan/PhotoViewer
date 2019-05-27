package root;

import root.views.IView;
import java.util.*;
import java.io.File;
import java.util.*;
import javax.imageio.ImageIO;
import java.io.*;

public class Model {
  public ArrayList<ImageModel> images;
  public ArrayList<IView> observers;
  public String view;

  public transient int currentFilter;
  public transient boolean isFilterEnabled;

  public Model() {
    this.images = new ArrayList<>();
    this.observers = new ArrayList<>();
    this.view = "grid"; // grid or list
  }

  public int numCol() {
    if (this.view == "grid") {
      return 3;
    } else {
      return 1;
    }
  }

  public void setGridView() {
    this.view = "grid";
    this.notifyViews(Action.ChangeLayout);
    for (ImageModel imageModel : this.images) {
      imageModel.notifyViews(Action.ChangeLayout);
    }
  }

  public void setListView() {
    this.view = "list";
    this.notifyViews(Action.ChangeLayout);
    for (ImageModel imageModel : this.images) {
      imageModel.notifyViews(Action.ChangeLayout);
    }
  }

  public void addImages(File[] imageFiles) {
    for (File imageFile : imageFiles) {
      this.images.add(new ImageModel(imageFile));
    }
    this.notifyViews(Action.AddImage);
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
