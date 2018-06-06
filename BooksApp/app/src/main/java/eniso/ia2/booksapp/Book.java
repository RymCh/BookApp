package eniso.ia2.booksapp;

/**
 * Created by asus on 28/03/2018.
 */

public class Book
{
        private int id;
        private String title,author,genre,image,details;
        private int rating, userRating;



        public Book() {
        }

        public Book(String title, String author, String genre,int rating, String details,String imageUrl, int userRating) {
            this.title = title;
            this.author=author;
            this.rating = rating;
            this.genre = genre;
            this.image=image;
            this.details=details;
            this.userRating=userRating;

        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setImageUrl(String image) {
        this.image = image;
    }

    public String getImageUrl() {
        return image;
    }
    public void setDetails(String details) {
        this.details  = details;
    }

    public String getDetails(){
        return details;
    }
    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public int getUserRating() {
        return userRating;
    }

}
