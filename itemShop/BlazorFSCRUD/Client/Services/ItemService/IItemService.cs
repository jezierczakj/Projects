using BlazorFSCRUD.Client.Pages;
using BlazorFSCRUD.Shared;
using System.ComponentModel.DataAnnotations;

namespace BlazorFSCRUD.Client.Services.ItemService
{
	public interface IItemService
	{
		List<Item> Items { get; set; }
		List<Category> Categories { get; set; }
		Task GetCategory();
		Task GetItems();
		Task<Item> GetSingleItem(int id);

		Task CreateItem(Item item);
		Task UpdateItem(Item hero);
		Task DeleteItem(int id);
	}
}
