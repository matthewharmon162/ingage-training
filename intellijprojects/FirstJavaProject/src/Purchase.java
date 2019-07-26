import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Purchase {
    List<Book> items = new ArrayList<>();

    public void buy(Book item){
        items.add(item);
    }

    public String toString(){
        String result = "";
        BigDecimal total = BigDecimal.ZERO;
        for(Book item : items){
            result += item + "\n\n";
            total = total.add(item.getPrice());

        }

        result += "Total: $" + total;

        return result;
    }
}
