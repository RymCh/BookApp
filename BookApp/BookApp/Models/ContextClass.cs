using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace BookApp.Models
{
    public class ContextClass :DbContext
    {
     public DbSet<Book>Books { get; set; }
    }
}