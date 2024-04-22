using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace LotCRUD.Models.Entities
{
    public class Flight
	{
		[Key]
		public Guid Id { get; set; }
		public string? NumerLotu { get; set; }
		public DateTime? DataWylotu { get; set; }
		public string? MiejsceWylotu { get; set; }
		public string? MiejscePrzylotu { get; set; }
		public string? TypSamolotu { get; set; }
	}
}
