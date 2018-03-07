package goosegame;
import java.util.*;

public class Game {
  /* the list of the players of the game */
  protected List<Player> thePlayers;

  /* the board of the game */
  protected Board board;

  /* tells whether a game is finished or not */
  private boolean endOfTheGame;

  /**
   * Constructs the goosegame
   * @param board the board of this Game
   */
  public Game(Board board) {
    this.board = board;
    this.thePlayers = new ArrayList<Player>();
    this.endOfTheGame = false;
  }

  /**
   * Adds a player into the list of players of this Game
   * @param p the player to add
   */
  public void addPlayer(Player p) {
    this.thePlayers.add(p);
  }

  /**
   * Plays one round of this game
   */
  public void play() {
    int nbOfCells = this.board.getNbOfCells()-1;
    System.out.println("=========\nGOOSEGAME\n=========\n");

    while (!this.endOfTheGame) {
      for (Player p : this.thePlayers) {
        if (p.getCell().canBeLeft()) {
          // set different indexes that will be used to handle the move of the player
          int result = p.twoDiceThrow();
          int currentCellIndex = p.getCell().getIndex();
          int cellAfterDiceThrowIndex = currentCellIndex + result;
          int destinationCellIndex;

          // handle the case where the player is not in the board
          if (cellAfterDiceThrowIndex > nbOfCells) {
            int nbOfMovesLeft = result - (nbOfCells - currentCellIndex);
            cellAfterDiceThrowIndex = nbOfCells - nbOfMovesLeft;
          }

          // get the cells
          Cell currentCell = this.board.getCell(currentCellIndex);
          Cell cellAfterDiceThrow = this.board.getCell(cellAfterDiceThrowIndex);

          // we get what will be the final cell index of the player depending on the effect of the cell
          destinationCellIndex = cellAfterDiceThrow.handleMove(result);
          /*
           handle this case again because a player can be on a cell with special effect even after being out
           of the board. Example : A player is in cell 62, throws 10, is on cell 54 (Goose cell) and moves
           forward for 10 cells, he is on the cell 64  : not possible
           */
          if (destinationCellIndex > nbOfCells) {
            int nbOfMovesLeft = result - (nbOfCells - destinationCellIndex);
            destinationCellIndex = nbOfCells - nbOfMovesLeft;
          }
          Cell destinationCell = this.board.getCell(destinationCellIndex);

          // Print the moves of the player
          System.out.print(p + " is in cell " + currentCellIndex + ", ");
          System.out.print(p + " throws " + result + " and reaches cell " + cellAfterDiceThrowIndex);
          System.out.print(" " + cellAfterDiceThrow);

          // If the cell has an effect (goose cell or teleport cell)
          if (destinationCellIndex != cellAfterDiceThrowIndex) {
            System.out.print(" and jumps to cell " + destinationCellIndex + " " + destinationCell);
          }

          // Player has moved, the cell has no player on it
          currentCell.setPlayer(null);

          // handling the busy case
          if (destinationCell.isBusy()) {
            Player p2 = destinationCell.getPlayer();
            // other player is sent back to the current cell
            p2.setCell(currentCell);
            currentCell.setPlayer(p2);
            System.out.print(" cell is busy, " + p2 + " is sent to " + currentCellIndex + " " + currentCell);
          }

          // player has a new cell
          p.setCell(destinationCell);
          destinationCell.setPlayer(p);

          // end of the move
          System.out.println();

          // if player has won
          if (p.getCell().getIndex() == nbOfCells) {
            System.out.println(p + " has won");
            this.endOfTheGame = true;
            break;
          }
        } else {
          System.out.println(p + " cannot play.");
        }
      }
    }
  }
}
