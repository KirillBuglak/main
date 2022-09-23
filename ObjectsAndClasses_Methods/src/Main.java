public class Main {

    public static void main(String[] args) {
//        Basket basket = new Basket();
//        basket.add("Milk", 40);
//        basket.print("Milk");
//        basket.add("Honey", 380, 2, 500);
//        basket.print("All products");
//        System.out.println();
//        System.out.println("Total weight: " + basket.getTotalWeight() + " g");
//        System.out.println("Total price: " + basket.getTotalPrice() + " rub");

        Basket b1 = new Basket();
        b1.add("Bread",10,1);
        b1.add("Milk",20,1);

        Basket b2 = new Basket();
        b2.add("Bread",10,5);
        b2.add("Milk",10,1);

        System.out.println(Basket.getAllBasketsPrice());
        System.out.println(Basket.getAveragePriceOfBasket());
        System.out.println(Basket.getAveragePriceOfProduct());
        System.out.println(Basket.getBasketsCount());

    }
}
