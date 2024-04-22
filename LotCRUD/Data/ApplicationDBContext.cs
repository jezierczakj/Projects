using LotCRUD.Models;
using LotCRUD.Models.Entities;
using Microsoft.EntityFrameworkCore;

namespace LotCRUD.Data
{
	public class ApplicationDBContext : DbContext
	{
        public ApplicationDBContext(DbContextOptions<ApplicationDBContext> options): base(options)
        {
             
        }

        public DbSet<Flight> Flights { get; set; }
    }
}
