public class Basket {

    private static int basketsCount = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;
    private static double allBasketsPrice = 0;
    private static int allBasketsProducts = 0;

    public Basket() {
        increaseBasketsCount(1);
        items = "Список товаров:";
        this.limit = 1000000;

    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int price) {
        this();
        this.items += items;
        this.totalPrice += price;
        increaseAllBasketProducts(1);
        increaseAllBasketPrice(this.totalPrice);
    }

    public static int getBasketsCount() {
        return basketsCount;
    }

    public static double getAllBasketsPrice() {
        return allBasketsPrice;
    }

    private static void increaseBasketsCount(int basketsCount) {
        Basket.basketsCount += basketsCount;
    }

    private static void increaseAllBasketPrice(int price) {
        Basket.allBasketsPrice += price;
    }

    private static void increaseAllBasketProducts(int allBasketsProducts) {
        Basket.allBasketsProducts += allBasketsProducts;
    }

    public static double getAveragePriceOfProduct() {
        return allBasketsPrice / allBasketsProducts;
    }

    public static double getAveragePriceOfBasket() {
        return allBasketsPrice / basketsCount;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        add(name, price, count, 0);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }
        totalPrice += count * price;
        totalWeight += count * weight;
        items += "\n" + name + " - " +
                count + " шт. - " + price + " - " + weight;
        increaseAllBasketProducts(count);
        increaseAllBasketPrice(price*count);
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}