public class Clock {
  private LedDisplayer displayer;
  public Clock(LedDisplayer a) {
    this.displayer = a;
  }

  public void tryIt(String message, int nbTop) {
    this.displayer.setMessage(message);
    for (int i = 0; i < nbTop; i++) {
      this.displayer.shift();
      System.out.println("|" + this.displayer.textOnScreen() + "|");
    }
  }

  public static void main(String[] args) {
    new Clock(new LedDisplayer(5)).tryIt("thomas", 10);
    System.out.println();
    new Clock(new DisplayerWithLatency(8,5)).tryIt("please", 15);
    System.out.println();
    new Clock(new SpeedDisplayer(5,3,2)).tryIt("Abcd", 8);
  }
}
