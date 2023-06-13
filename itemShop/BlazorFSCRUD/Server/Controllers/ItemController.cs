using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace BlazorFSCRUD.Server.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ItemController : ControllerBase
    {
        private readonly DataContext _context;
        public ItemController(DataContext context)
        {
            _context = context;

        }

        [HttpGet]
        public async Task<ActionResult<List<Item>>> GetItems()
        {
            var  items = await _context.Items.Include(sh=>sh.Category).ToListAsync();
            return Ok(items);
        }

		[HttpGet("categories")]
		public async Task<ActionResult<List<Category>>> GetCategories()
		{
			var categories = await  _context.Categories.ToListAsync();

			return Ok(categories);
		}


		[HttpGet("{id}")]
        public async Task<ActionResult<Item>> GetSingleItem(int id)
        {
            var item = await  _context.Items
                .Include(h =>h.Category)
                .FirstOrDefaultAsync(h=>h.Id ==id);
            if(item==null)
            {
                return NotFound("Sorry, no item here/");
            }
            return Ok(item);
        }

		[HttpPost]
		public async Task<ActionResult<List<Item>>> CreateItem(Item item)
		{
            item.Category = null;
            _context.Items.Add(item);
            await _context.SaveChangesAsync();

			return Ok(await GetDbItems());
		}

        [HttpPut("{id}")]
        public async Task<ActionResult<List<Item>>> UpdateItem(Item item, int id)
        {
            var dbItem = await _context.Items
                .Include(sh => sh.Category)
                .FirstOrDefaultAsync(sh => sh.Id == id);
            if (dbItem == null)
                return NotFound("Sorry no item for you");

            dbItem.Name = item.Name;
            dbItem.Material = item.Material;
            dbItem.Color = item.Color;
            dbItem.CategoryId = item.CategoryId;
            await _context.SaveChangesAsync();


            return Ok(await GetDbItems());
        }

		[HttpDelete("{id}")]
		public async Task<ActionResult<List<Item>>> DeleteItem(int id)
		{
			var item = await _context.Items
				.Include(sh => sh.Category)
				.FirstOrDefaultAsync(sh => sh.Id == id);
			if (item == null)
				return NotFound("Sorry no item for you");

            _context.Items.Remove(item);
			await _context.SaveChangesAsync();

			return Ok(await GetDbItems());
		}


	private async Task<List<Item>> GetDbItems()
        {
            return await _context.Items.Include(sh=> sh.Category).ToListAsync();
        }
	}
}
