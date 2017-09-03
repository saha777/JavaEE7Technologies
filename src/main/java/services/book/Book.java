package services.book;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllBooks", query = "SELECT b FROM Book b"),
        @NamedQuery(name = "findBookH2G2", query = "SELECT b FROM Book b WHERE b.title ='H2G2'")
})
public class Book{

    @Id @GeneratedValue
    private Long id;
    @NotNull
    private String title;
    private Float price;
    @Size(min = 10, max = 2000)
    private String descriptor;
    private String isbn;
    private Integer number;
    private Boolean illustrations;

    public Book(){}

    public Book(String title, Float price, String descriptor) {
        this.title = title;
        this.price = price;
        this.descriptor = descriptor;
    }

    public Book(String title, String descriptor, Float price, String isbn, int number, Boolean illustrations) {
        this.title = title;
        this.price = price;
        this.descriptor = descriptor;
        this.isbn = isbn;
        this.number = number;
        this.illustrations = illustrations;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public Integer getNumber() {
        return number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Boolean getIllustrations() {
        return illustrations;
    }

    public void setIllustrations(Boolean illustrations) {
        this.illustrations = illustrations;
    }
}