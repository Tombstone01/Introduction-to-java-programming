package csc2a.ptc.model;

public class Cell {

  // the position of the cell.
  private int x, y;

  // the height and width of the cell.
  private int w, h;

  public Cell(int x_, int y_, int w_, int h_) {
    this.x = x_;
    this.y = y_;
    this.w = w_;
    this.h = h_;
  }
}