using LotCRUD.Data;
using LotCRUD.Models;
using LotCRUD.Models.Entities;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace LotCRUD.Controllers
{
    public class FlightsController : Controller
    {
        private readonly ApplicationDBContext dbContext;

        public FlightsController(ApplicationDBContext dbContext)
        {
            this.dbContext = dbContext;
        }

        [Authorize(Roles = "Seller")]
        [HttpGet]
        public IActionResult Add()
        {
            return View();
        }

        [Authorize(Roles = "Seller")]
        [HttpPost]
        
        public async Task<IActionResult> Add(AddFlightViewModel viewModel)
        {
            var flight = new Flight
            {
                NumerLotu = viewModel.NumerLotu,
                DataWylotu = viewModel.DataWylotu,
                MiejsceWylotu = viewModel.MiejsceWylotu,
                MiejscePrzylotu = viewModel.MiejscePrzylotu,
                TypSamolotu = viewModel.TypSamolotu
            };
            if (ModelState.IsValid)
            {
                await dbContext.Flights.AddAsync(flight);
                await dbContext.SaveChangesAsync();

                return RedirectToAction("List", "Flights");
            }
            
            return View();
        }

        [HttpGet]
        public async Task<IActionResult> List()
        {
            var flights = await dbContext.Flights.ToListAsync();

            return View(flights);
        }

        
        [HttpGet]
        public async Task<IActionResult> Edit(Guid id)
        {
            var flight = await dbContext.Flights.FindAsync(id);

            return View(flight);
        }

        [HttpPost]
        public async Task<IActionResult> Edit(Flight viewModel)
        {
            var flight = await dbContext.Flights.FindAsync(viewModel.Id);

            if (flight is not null)
            {
                flight.NumerLotu = viewModel.NumerLotu;
                flight.DataWylotu = viewModel.DataWylotu;
                flight.MiejsceWylotu = viewModel.MiejsceWylotu;
                flight.MiejscePrzylotu = viewModel.MiejscePrzylotu;
                flight.TypSamolotu = viewModel.TypSamolotu;

                await dbContext.SaveChangesAsync();
            }

            return RedirectToAction("List", "Flights");
        }

        [Authorize(Roles = "Administrator")]
        [HttpPost]
        public async Task<IActionResult> Delete(Flight viewModel)
        {
            var flight = await dbContext.Flights.AsNoTracking().FirstOrDefaultAsync(x=>x.Id == viewModel.Id);
            if(flight is not null)
            {
                dbContext.Flights.Remove(flight);
                await dbContext.SaveChangesAsync();
            }
            return RedirectToAction("List", "Flights");
        }
    }
}
