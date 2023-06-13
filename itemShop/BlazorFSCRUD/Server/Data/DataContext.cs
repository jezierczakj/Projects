using Microsoft.EntityFrameworkCore;

namespace BlazorFSCRUD.Server.Data
{
	public class DataContext : DbContext
	{
        public DataContext(DbContextOptions<DataContext> options) : base(options)
        {
            
        }
		protected override void OnModelCreating(ModelBuilder modelBuilder)
		{
			modelBuilder.Entity<Category>().HasData(
				new Category { Id = 1, Name = "PrivateUse" },
				new Category { Id = 2, Name = "Comertial" }
			);

			modelBuilder.Entity<Item>().HasData(
				new Item
				{
					Id = 1,
					Name = "Speakers",
					Material = "Plastic",
					Color = "Black",
					CategoryId = 1
				},
				new Item
				{
					Id = 2,
					Name = "Steamer",
					Material = "Aluminum",
					Color = "Grey",
					CategoryId = 2
				}
			);

		}

        public DbSet<Item> Items { get; set; }
		public DbSet<Category> Categories { get; set; }

	}
}
 