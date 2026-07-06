import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    interface Observer {
        void update(String stockName, double price);
    }
    interface Stock {
        void registerObserver(Observer observer);
        void deregisterObserver(Observer observer);
        void notifyObservers();
    }
    static class StockMarket implements Stock {
        private List<Observer> observers = new ArrayList<>();
        private String stockName;
        private double stockPrice;
        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
            System.out.println("Observer Registered.");
        }
        @Override
        public void deregisterObserver(Observer observer) {
            observers.remove(observer);
            System.out.println("Observer Removed.");
        }
        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(stockName, stockPrice);
            }
        }
        public void setStock(String stockName, double stockPrice) {
            this.stockName = stockName;
            this.stockPrice = stockPrice;

            System.out.println("\nStock Updated:");
            System.out.println("Stock: " + stockName);
            System.out.println("Price: Rs." + stockPrice);

            notifyObservers();
        }
    }
    static class MobileApp implements Observer {

        private String userName;

        public MobileApp(String userName) {
            this.userName = userName;
        }

        @Override
        public void update(String stockName, double price) {
            System.out.println("Mobile App (" + userName + ") : "
                    + stockName + " price updated to Rs." + price);
        }
    }
    static class WebApp implements Observer {

        private String userName;

        public WebApp(String userName) {
            this.userName = userName;
        }

        @Override
        public void update(String stockName, double price) {
            System.out.println("Web App (" + userName + ") : "
                    + stockName + " price updated to Rs." + price);
        }
    }
    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobile = new MobileApp("Rahul");
        Observer web = new WebApp("Priya");
        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);
        stockMarket.setStock("TCS", 3850.50);

        stockMarket.setStock("Infosys", 1620.75);
        stockMarket.deregisterObserver(web);
        stockMarket.setStock("Reliance", 2985.00);
    }
}
