using System.ComponentModel.DataAnnotations;
using LotCRUD.Models.Entities;

namespace LotCRUD.Models
{
    public class AddFlightViewModel
    {
		[Required(ErrorMessage = "Numer lotu wymagany")]
        [DisplayFormat(DataFormatString = "{A-Z}")]
        public string? NumerLotu { get; set; }


        [Required(ErrorMessage = "Data lotu wymagana")]
        public DateTime? DataWylotu { get; set; }


        [Required(ErrorMessage = "Miejsce wylotu wymagane")]
        public string? MiejsceWylotu { get; set; }


        [Required(ErrorMessage = "Miejsce przylotu wymagane")]
        public string? MiejscePrzylotu { get; set; }

        [Required(ErrorMessage = "Typ samolotu wymagany")]
        public string? TypSamolotu { get; set; }
    }
}
