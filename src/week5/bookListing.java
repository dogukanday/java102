package week5;

import java.util.*;

public class bookListing {

        public static void main(String[] args) {
            bookListing bl = new bookListing();
            Book book1 = bl.new Book("The Hobbit", 310, "J.R.R. Tolkien", "1937");
            Book book2 = bl.new Book("1984", 328, "George Orwell", "1949");
            Book book3 = bl.new Book("Brave New World", 268, "Aldous Huxley", "1932");
            Book book4 = bl.new Book("Fahrenheit 451", 194, "Ray Bradbury", "1953");
            Book book5 = bl.new Book("The Great Gatsby", 180, "F. Scott Fitzgerald", "1925");

            // Kitapları isme göre sıralayan TreeSet
            Set<Book> bookSetByName = new TreeSet<>();
            bookSetByName.add(book1);
            bookSetByName.add(book2);
            bookSetByName.add(book3);
            bookSetByName.add(book4);
            bookSetByName.add(book5);

            System.out.println("Books sorted by title:");
            for (Book book : bookSetByName) {
                System.out.println(book);
            }

            Set<Book> bookSetByPageCount = new TreeSet<>(new Comparator<Book>() {
                @Override
                public int compare(Book b1, Book b2) {
                    return Integer.compare(b1.getPageCount(), b2.getPageCount());
                }
            });

            bookSetByPageCount.add(book1);
            bookSetByPageCount.add(book2);
            bookSetByPageCount.add(book3);
            bookSetByPageCount.add(book4);
            bookSetByPageCount.add(book5);

            System.out.println("\nBooks sorted by page count:");
            for (Book book : bookSetByPageCount) {
                System.out.println(book);
            }
        }

    class Book implements Comparable<Book> {
        private String title;
        private int pageCount;
        private String author;
        private String publishDate;

        public Book(String title, int pageCount, String author, String publishDate) {
            this.title = title;
            this.pageCount = pageCount;
            this.author = author;
            this.publishDate = publishDate;
        }

        public String getTitle() {
            return title;
        }

        public int getPageCount() {
            return pageCount;
        }

        public String getAuthor() {
            return author;
        }

        public String getPublishDate() {
            return publishDate;
        }

        @Override
        public int compareTo(Book other) {
            return this.title.compareTo(other.title);
        }

        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", pageCount=" + pageCount +
                    ", author='" + author + '\'' +
                    ", publishDate='" + publishDate + '\'' +
                    '}';
        }

    }
}
