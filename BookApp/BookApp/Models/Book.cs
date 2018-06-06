using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace BookApp.Models
{
    public class Book
    {
        public int Id { get; set; }
        [Required(ErrorMessage = "Title is required")]
        public string Title { get; set; }
        [Required(ErrorMessage = "Author is required")]
        public string Author { get; set; }
        [Required(ErrorMessage = "Rating is required")]
        [Range(0, 5, ErrorMessage = "Rating should lie b/w 0 and 5")]
        public int Rating { get; set; }
        [Required(ErrorMessage = "Genre is required")]
        public string Genre { get; set; }
        public String Details { get; set; }
        public String Image { get; set; }
        public int UserRating { get; set; }
    }
}