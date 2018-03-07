/**
 * StockMain class : a class that uses Stock class and executes its methods
 *
 * @author : LOMBART Thomas - VASILEV Martin
 */

public class StockMain {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("usage: java StockMain <unEntier>");
      System.exit(0);
    }
    Stock someStock = new Stock();
    someStock.add(Integer.parseInt(args[0]));
    System.out.println(someStock.getQuantity());
  }
}
