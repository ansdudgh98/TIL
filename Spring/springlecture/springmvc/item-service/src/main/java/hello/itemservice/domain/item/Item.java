package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data //실제론 굉장히 위험!
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private int quantity= 0;

    public Item() {
    }

    public Item(String itemName, Integer price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }


}
