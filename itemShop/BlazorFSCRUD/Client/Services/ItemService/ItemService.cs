using BlazorFSCRUD.Client.Pages;
using BlazorFSCRUD.Shared;
using Microsoft.AspNetCore.Components;
using System.Net.Http.Json;

namespace BlazorFSCRUD.Client.Services.ItemService
{
	public class ItemService : IItemService
	{
		private readonly HttpClient _http;
		private readonly NavigationManager _navigationManager;

		public ItemService(HttpClient http, NavigationManager navigationManager)
		{
			_http = http;
			_navigationManager = navigationManager;
		}
		public List<Item> Items { get; set; } = new List<Item>();
		public List<Category> Categories { get; set; } = new List<Category>();

		public async Task CreateItem(Item item)
		{
			var result = await _http.PostAsJsonAsync("api/Item", item);
			await SetItems(result);
		}

		private async Task SetItems(HttpResponseMessage result)
		{
			var response = await result.Content.ReadFromJsonAsync<List<Item>>();
			Items = response;
			_navigationManager.NavigateTo("Items");
		}

		public async Task DeleteItem(int id)
		{
			var result = await _http.DeleteAsync($"api/Item/{id}");
			await SetItems(result);
		}

		public async Task GetCategory()
		{
			var result = await _http.GetFromJsonAsync<List<Category>>("api/Item/categories");
			if (result != null)
				Categories = result;
		}

		public async Task<Item> GetSingleItem(int id)
		{
			var result = await _http.GetFromJsonAsync<Item>($"api/Item/{id}");
			if (result != null)
				return result;
			throw new Exception("Item not found!");
		}

		public async Task GetItems()
		{
			var result = await _http.GetFromJsonAsync<List<Item>>("api/Item");
			if (result != null)
				Items = result;
		}

		public async Task UpdateItem(Item item)
		{
			var result = await _http.PutAsJsonAsync($"api/Item/{item.Id}", item);
			await SetItems(result);
		}
	}
}
