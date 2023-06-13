using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlazorFSCRUD.Shared
{
    public class Item
    {
        public int Id { get; set; }
        [Required(ErrorMessage = "Name field can not be empty")]
        [MinLength(3)]
        public string Name { get; set; } = string.Empty;
		[Required]
        [MinLength(3)]
		public string Material { get; set; } = string.Empty;
		[Required(ErrorMessage = "Color field can not be empty")]
		[MinLength(3)]
		public string Color { get; set; } = string.Empty;
		public Category? Category { get; set; }
        public int CategoryId { get; set; }
    }
}
