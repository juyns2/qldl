-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema qldl
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `qldl` ;

-- -----------------------------------------------------
-- Schema qldl
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `qldl` ;
SHOW WARNINGS;
USE `qldl` ;

-- -----------------------------------------------------
-- Table `admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `admin` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `admin` (
  `idAdmin` INT NOT NULL,
  `pass` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NOT NULL,
  `status` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idAdmin`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `chitietdattour`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chitietdattour` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `chitietdattour` (
  `idChiTietDT` INT NOT NULL,
  `ngayKhoiHanh` DATETIME NULL DEFAULT NULL,
  `soLuong` INT NULL DEFAULT NULL,
  `thongTin` VARCHAR(250) COLLATE 'utf8mb3_unicode_ci' NULL DEFAULT NULL,
  `_idTour` INT NOT NULL,
  `_idDatTour` INT NOT NULL,
  PRIMARY KEY (`idChiTietDT`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `comment` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `comment` (
  `idComment` INT NOT NULL,
  `noiDung` VARCHAR(250) COLLATE 'utf8mb3_unicode_ci' NOT NULL,
  `vote` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`idComment`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `dattour`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dattour` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `dattour` (
  `idDatTour` INT NOT NULL AUTO_INCREMENT,
  `ngayDat` DATETIME NULL DEFAULT NULL,
  `_idKhachHang` INT NOT NULL,
  PRIMARY KEY (`idDatTour`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `khachhang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `khachhang` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `khachhang` (
  `idKhachHang` INT NOT NULL AUTO_INCREMENT,
  `hoTen` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NOT NULL,
  `gioiTinh` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NOT NULL,
  `email` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NULL DEFAULT NULL,
  `diaChi` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NULL DEFAULT NULL,
  `soCMT` VARCHAR(15) COLLATE 'utf8mb3_unicode_ci' NULL DEFAULT NULL,
  `soDT` VARCHAR(15) COLLATE 'utf8mb3_unicode_ci' NULL DEFAULT NULL,
  `user` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NOT NULL,
  `pass` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NOT NULL,
  `avater` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NOT NULL,
  PRIMARY KEY (`idKhachHang`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `khuvuc`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `khuvuc` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `khuvuc` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) COLLATE 'utf8mb3_unicode_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `loaitour`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `loaitour` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `loaitour` (
  `idLoaiTour` INT NOT NULL,
  `tenLoai` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`idLoaiTour`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `new2`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `new2` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `new2` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `nhanvien`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nhanvien` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `idNhanVien` INT NOT NULL AUTO_INCREMENT,
  `hoTen` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NOT NULL,
  `gioiTinh` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NOT NULL,
  `email` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NULL DEFAULT NULL,
  `diaChi` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NULL DEFAULT NULL,
  `soCMT` VARCHAR(15) COLLATE 'utf8mb3_unicode_ci' NULL DEFAULT NULL,
  `soDT` VARCHAR(15) COLLATE 'utf8mb3_unicode_ci' NULL DEFAULT NULL,
  `user` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NOT NULL,
  `pass` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NOT NULL,
  `_idQLNhanVien` INT NOT NULL,
  PRIMARY KEY (`idNhanVien`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `qlnhanvien`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `qlnhanvien` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `qlnhanvien` (
  `idQLNhanVien` INT NOT NULL,
  `loaiNhanVien` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`idQLNhanVien`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tintuc`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tintuc` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tintuc` (
  `idTinTuc` INT NOT NULL AUTO_INCREMENT,
  `noiDung` VARCHAR(250) COLLATE 'utf8mb3_unicode_ci' NOT NULL,
  PRIMARY KEY (`idTinTuc`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tour`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tour` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tour` (
  `idTour` INT NOT NULL AUTO_INCREMENT,
  `tenTour` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NULL DEFAULT NULL,
  `giaTour` DECIMAL(10,0) NULL DEFAULT NULL,
  `ngayKhoiHanh` DATETIME NULL DEFAULT NULL,
  `diaDiemKhoiHanh` VARCHAR(45) COLLATE 'utf8mb3_unicode_ci' NULL DEFAULT NULL,
  `noiDung` VARCHAR(250) COLLATE 'utf8mb3_unicode_ci' NULL DEFAULT NULL,
  `_idLoaiTour` INT NULL DEFAULT NULL,
  `_idComment` INT NULL DEFAULT NULL,
  `image` VARCHAR(250) COLLATE 'utf8mb3_unicode_ci' NULL DEFAULT NULL,
  `khuvuc_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idTour`))
ENGINE = InnoDB
AUTO_INCREMENT = 23;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
