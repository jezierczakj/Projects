﻿using LotCRUD.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.IdentityModel.Tokens;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;

namespace LotCRUD.Controllers
{
	[Route("/login")]
	[ApiController]
	public class LoginController : Controller
	{

		private IConfiguration _config;

		public LoginController(IConfiguration config)
		{
			_config = config;
		}

		[HttpPost]
		public IActionResult Login(UserLogin userLogin)
		{
			var user = Authenticate(userLogin);


			if (user != null)
			{
				var token = Generate(user);
				return Ok(token);
			}

			return NotFound("User not found");
		}

		private string Generate(UserModel user)
		{
			var securityKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(_config["Jwt:Key"]));
			var credentials = new SigningCredentials(securityKey, SecurityAlgorithms.HmacSha256);

			var claims = new[]
			{
				new Claim(ClaimTypes.NameIdentifier, user.Username),
				new Claim(ClaimTypes.Role, user.Role)
			};

			var token = new JwtSecurityToken(_config["Jwt:Issuer"],
			  _config["Jwt:Audience"],
			  claims,
			  expires: DateTime.Now.AddMinutes(60),
			  signingCredentials: credentials);

			return new JwtSecurityTokenHandler().WriteToken(token);
		}

		private UserModel Authenticate(UserLogin userLogin)
		{
			var currentUser = UserConstants.Users.FirstOrDefault(o => o.Username.ToLower() == userLogin.Username.ToLower() && o.Password == userLogin.Password);

			if (currentUser != null)
			{
				return currentUser;
			}

			return null;
		}
	}
}
