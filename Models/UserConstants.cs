namespace LotCRUD.Models
{
	public class UserConstants
	{
		public static List<UserModel> Users = new List<UserModel>()
		{
			new UserModel() { Username = "jason_admin",  Password = "MyPass_w0rd", Role = "Administrator" },
			new UserModel() { Username = "elyse_seller", Password = "MyPass_w0rd", Role = "Seller" },
		};
	}
}
