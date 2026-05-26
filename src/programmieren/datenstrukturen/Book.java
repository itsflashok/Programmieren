package programmieren.datenstrukturen;

public class Book {
    private String author;
    private String title;
    private int year;
    private String publisher;

    public Book(String author, String title, int year, String publisher) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return year == other.year
                && author.equals(other.author)
                && title.equals(other.title)
                && publisher.equals(other.publisher);
    }

    @Override
    public int hashCode() {
        int result = author.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + year;
        result = 31 * result + publisher.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return author + " | " + title + " | " + year + " | " + publisher;
    }

    public String toFileString() {
        return author + ";" + title + ";" + year + ";" + publisher;
    }
}
