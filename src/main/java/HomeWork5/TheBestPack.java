package HomeWork5;

import java.util.*;

public class TheBestPack {


    public static void main(String[] args) {
        TreeMap<Double,String> result = new TreeMap<>();
        Bag bag = new Bag(5);
        ArrayList<Item> itemsInTheRoom = new ArrayList<>();
        itemsInTheRoom.add(new Item(100.00, 0.2, "ring"));
        itemsInTheRoom.add(new Item(22.5, 0.5, "book"));
        itemsInTheRoom.add(new Item(3950.0, 4.25, "laptop"));
        itemsInTheRoom.add(new Item(4000.00, 5.00, "tv"));
        itemsInTheRoom.add(new Item(600.00, 0.425, "necklace"));
        itemsInTheRoom.add(new Item(250.25, 0.5, "phone"));
        itemsInTheRoom.add(new Item(300.00, 0.050, "money"));
        itemsInTheRoom.add(new Item(150.00, 0.2, "ring2"));
        itemsInTheRoom.add(new Item(12.75, 0.65, "book2"));
        itemsInTheRoom.add(new Item(500.00, 3.015, "painting"));
        itemsInTheRoom.add(new Item(225.23, 0.75, "headphones"));
        find(itemsInTheRoom.size(), itemsInTheRoom,bag,result);
        System.out.println(result.lastEntry());

    }



    private static void find(int length, ArrayList<Item> itemsInTheRoom, Bag bag, TreeMap<Double,String> result) {
        if (length == 1) {
            return;
        }
        for (int i = 0; i < length; i++) {
            find(length - 1, itemsInTheRoom, bag, result);
            double capacity = 0;
            double totalPrice = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                double weight = itemsInTheRoom.get(j).getWeight();
                double price = itemsInTheRoom.get(j).getPrice();
                if ((capacity + weight) <= bag.getCapacity()) {
                    capacity += weight;
                    totalPrice += price;
                    sb.append(itemsInTheRoom.get(j) + ", ");
                }
            }
            sb.append("TOTAL WEIGHT: " + capacity);
            result.put(totalPrice, sb.toString());
            rotate(length, itemsInTheRoom);
        }

    }

    private static void rotate(int length, ArrayList<Item> itemsInTheRoom) {
        int first = itemsInTheRoom.size()-length;
        Item temp = itemsInTheRoom.get(first);
        itemsInTheRoom.remove(first);
        itemsInTheRoom.add(temp);
    }
}



