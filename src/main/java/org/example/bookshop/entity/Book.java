package org.example.bookshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Book extends IdClass{
    private String title;
    private double price;
    private int stock;
    private String imageUrl;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate yearPublished;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Author author;

    public Book(String title, double price, int stock, LocalDate yearPublished) {
        this.title = title;
        this.price = price;
        this.stock = stock;
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
