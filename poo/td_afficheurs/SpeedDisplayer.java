public class SpeedDisplayer extends DisplayerWithLatency {
  private int speed;

  public SpeedDisplayer(int width, int latency, int speed) {
    super(width, latency);
    this.speed = speed;
  }

  public void shift() {
    for (int i = 0; i < this.speed; i++) {
      super.shift();
    }
  }
}
