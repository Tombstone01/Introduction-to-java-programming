package csc2a.model;

import csc2a.designpatterns.iRenderVisitor;

import java.io.Serializable;

/** @author Kananelo Khotle (217080976)
 */
public class Banana extends GameObject implements Serializable {

  private static final long serialVersionUID = 1L;
  private int w, h = 0;

  public Banana(double x_, double y_, int w_, int h_) {
    super((int)x_, (int)y_);

    w = w_;
    h = h_;
  }

  @Override
  public void accept(iRenderVisitor visitor) {
    visitor.render(this);    
  }

  public double getWidth() {
    return this.w;
  }

  public double getHeight() {
    return this.h;
  }
}