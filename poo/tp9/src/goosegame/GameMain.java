package goosegame;

public class GameMain {

  public static void main(String[] args) {
    Board goosegameBoard = new GoosegameBoard();
    goosegameBoard.initBoard();
    Game goosegame = new Game(goosegameBoard);
    Player p1 = new Player("Soldat 76", new StartCell());
    Player p2 = new Player("Winston", new StartCell());
    Player p3 = new Player("Mei", new StartCell());
    goosegame.addPlayer(p1);
    goosegame.addPlayer(p2);
    goosegame.addPlayer(p3);
    goosegame.play();
  }
}
