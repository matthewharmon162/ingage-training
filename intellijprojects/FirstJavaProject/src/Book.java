import java.math.BigDecimal;

public class Book {
    private String title;
    private String author;
    private BigDecimal price;

    public Book(String title, String author, String price){
        this.title = title;
        this.author = author;
        this.price = new BigDecimal(price);

    }

    public String toString(){
        return getTitle() + " - " + getAuthor() + "\n$" + getPrice();
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public BigDecimal getPrice(){
        return price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }
}
