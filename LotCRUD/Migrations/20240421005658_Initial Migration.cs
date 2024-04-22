using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace LotCRUD.Migrations
{
    /// <inheritdoc />
    public partial class InitialMigration : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Flights",
                columns: table => new
                {
                    Id = table.Column<Guid>(type: "uniqueidentifier", nullable: false),
                    NumerLotu = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    DataWylotu = table.Column<DateTime>(type: "datetime2", nullable: false),
                    MiejsceWylotu = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    MiejscePrzylotu = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    TypSamolotu = table.Column<string>(type: "nvarchar(max)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Flights", x => x.Id);
                });
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Flights");
        }
    }
}
