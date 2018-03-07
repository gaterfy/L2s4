public class LedDisplayer {

  protected String message;
  protected int width;
  protected int index;
  protected String onScreen;

  public LedDisplayer(int width) {
    this.width = width;
  }

  public void setMessage(String message) {
    this.message = message;
    this.index = -1;
    this.onScreen = "";
    for (int i = 0; i < width; i++) {
      this.onScreen += " ";
    }
  }

  public void shift() {
    this.index = (this.index + 1) % this.message.length();
    this.onScreen = this.onScreen.substring(1) + this.message.charAt(this.index);
  }

  public String textOnScreen() {
    return this.onScreen;
  }
}
