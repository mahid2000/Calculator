package calculator;

public class NumStack {
  
  private final Stack numStack;
  
  public NumStack() {
    this.numStack = new Stack();
  }
  
  public final void push(final float i) {
    this.numStack.push(new Entry(i));
}

}
