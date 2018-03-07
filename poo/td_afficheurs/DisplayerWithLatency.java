public class DisplayerWithLatency extends LedDisplayer {
  protected int latency;

  public DisplayerWithLatency(int width, int latency) {
    super(width);
    this.latency = latency;
  }

  public void setMessage(String message) {
    String copyMessage = message;
    for (int i = 0; i < this.latency; i++) {
      copyMessage += " ";
    }
    super.setMessage(copyMessage);
  }
}
