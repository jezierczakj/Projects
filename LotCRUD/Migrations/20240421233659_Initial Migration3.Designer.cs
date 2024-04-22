﻿// <auto-generated />
using System;
using LotCRUD.Data;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;

#nullable disable

namespace LotCRUD.Migrations
{
    [DbContext(typeof(ApplicationDBContext))]
    [Migration("20240421233659_Initial Migration3")]
    partial class InitialMigration3
    {
        /// <inheritdoc />
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "7.0.18")
                .HasAnnotation("Relational:MaxIdentifierLength", 128);

            SqlServerModelBuilderExtensions.UseIdentityColumns(modelBuilder);

            modelBuilder.Entity("LotCRUD.Models.Entities.Flight", b =>
                {
                    b.Property<Guid>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("uniqueidentifier");

                    b.Property<DateTime?>("DataWylotu")
                        .HasColumnType("datetime2");

                    b.Property<string>("MiejscePrzylotu")
                        .HasColumnType("nvarchar(max)");

                    b.Property<string>("MiejsceWylotu")
                        .HasColumnType("nvarchar(max)");

                    b.Property<string>("NumerLotu")
                        .HasColumnType("nvarchar(max)");

                    b.HasKey("Id");

                    b.ToTable("Flights");
                });
#pragma warning restore 612, 618
        }
    }
}