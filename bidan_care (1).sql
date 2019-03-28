-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 28, 2019 at 06:48 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bidan_care`
--

-- --------------------------------------------------------

--
-- Table structure for table `bidan`
--

CREATE TABLE `bidan` (
  `id_bidan` int(10) UNSIGNED NOT NULL,
  `nama_bidan` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `alamat_bidan` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `alamat_praktek` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `bidan_wilayah` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `bidan`
--

INSERT INTO `bidan` (`id_bidan`, `nama_bidan`, `alamat_bidan`, `alamat_praktek`, `bidan_wilayah`, `lat`, `lng`) VALUES
(1, 'Umi Sumarno', 'Jl. Jawa IV', 'Jl. Jawa IV', 'Sumbersari', -8.170427, 113.715563),
(2, 'Elly Yahya', 'Jl. Kaliurang', 'Jl. Kaliurang', 'Sumbersari', -8.1640867, 113.7317179),
(3, 'Cindy Yosi Pratiwi', 'Jl. Kaliurang Perum Istana TIdar A1/07', 'Jl. Kaliurang Perum Istana TIdar A1/07', 'Sumbersari', 0, 0),
(4, 'Fathul Listiani', 'Jl. Kawi 31', 'Jl. Kawi 31 RT 03 RW 13', 'Sumbersari', -8.1772737, 113.7178398),
(5, 'Nunia Agus Pujayanti', 'Jl. PB Sudirman XII/9 - Patrang', 'Jl. PB Sudirman XII/9 - Patrang', 'Sumbersari', -8.1593828, 113.7096292),
(6, 'Diah Aristanti', 'Jl. S. Parman X', 'Jl. S. Parman X', 'Sumbersari', -8.1833516, 113.7186519),
(7, 'Sri Ramadhani', 'Jl. Semeru Gg Lembah', 'Jl. Semeru Gg Lembah', 'Sumbersari', 0, 0),
(8, 'Dwi Melia', 'Jl. Sumatra III', 'Jl. Sumatra III', 'Sumbesari', -8.1717437, 113.7099361),
(9, 'Emilia Rahayu', 'Dusun Perangan RT. 04 RW. 02 Kradenan - Purwoharjo Banyuwangi', 'Jl. Sumatra III/3', 'Sumbersari', -8.1717437, 113.7099361),
(10, 'Veronica Vestin', 'Perum Karimata Dream Land / Jl. Gunung Agung III', 'Perum Karimata Dream Land / Jl. Gunung Agung III', 'Sumbersari', 0, 0),
(11, 'Nurika Santi Anggraeni', 'Perum Karimata Dream Land / Jl. Gunung Agung III', 'Perum Karimata Dream Land / Jl. Gunung Agung III', 'Sumbersari', 0, 0),
(12, 'Ernawati Anggraeni', 'Perum Karimata Dream Land / Jl. Gunung Agung III', 'Perum Karimata Dream Land / Jl. Gunung Agung III', 'Sumbersari', 0, 0),
(13, 'Rizki Fitrianingtiyas', 'Perum Karimata Dream Land / Jl. Gunung Agung III', 'Perum Karimata Dream Land / Jl. Gunung Agung III', 'Sumbersari', 0, 0),
(14, 'Uswatun Hasanah', 'Jl KH. Yasin', 'Jl KH Yasin RT. 1 RW. 9', 'Wirolegi', 0, 0),
(15, 'Krisna', 'Jl KH. Yasin', 'Jl KH. Yasin RT. 1 RW. 9', 'Wirolegi', 0, 0),
(16, 'Siti Nurfaizah', 'Jl. Kutai 112', 'Jl Kutai 112 RT. 03 RW. 14', 'Wirolegi', -8.1992407, 113.7331295),
(17, 'Elmi Izatul Lailia', 'Jl. MT. Haryono 211', 'Jl. Letjen Panjaitan No.42 Jember', 'Wirolegi', -8.1786008, 113.7067301),
(18, 'Narulita', 'Jl. Majapahit RT.1 RW.1', 'Jl. Majapahit RT.1 RW.1', 'Wirolegi', -8.1868557, 113.7389414),
(19, 'Arie Prahastutiningtyas', 'Jl. MT Haryono 148 Jember', 'Jl. MT Haryono 148 Jember', 'Wirolegi', 0, 0),
(20, 'Wji Rahayu', 'Jl. Sri Tanjung RT. 02 RW. 06', 'Jl. Sri Tanjung RT. 02 RW. 06', 'Wirolegi', 0, 0),
(21, 'Devi Saputri Hadifian', 'Jl. Yos Sudarso No. 63 Wirolegi', 'Jl. Yos Sudarso No. 63 Wirolegi', 'Wirolegi', 0, 0),
(22, 'Susiani', 'Jl. Yos Sudarso Perum Taman Bambu BB-2', 'Jl. Yos Sudarso Perum Taman Bambu BB-2', 'Wirolegi', -8.1899236, 113.74385),
(23, 'Putri', 'Jl. Yos Sudarso ', 'Jl. Yos Sudarso RT.1 RW. 3', 'Wirolegi', 0, 0),
(24, 'Susi', 'Jl. Yos Sudarso ', 'Jl. Yos Sudarso RT.1 RW. 3', 'Wirolegi', 0, 0),
(25, 'Nurul Hidayati', 'Jl. Yos Sudarso ', 'Jl. Yos Sudarso RT.1 RW. 3', 'Wirolegi', 0, 0),
(26, 'Henry Wulandari', 'Jl Sarangan', 'Jl. Sarangan', 'Antirogo', 0, 0),
(27, 'Maisaroh', 'Jl. Pangandaran', 'Jl. Pangandaran', 'Antirogo', 0, 0),
(28, 'Nurul', 'Jl. Pangandaran', 'Jl. Pangandaran', 'Antirogo', 0, 0),
(29, 'Nunuk', 'Jl. Danau Toba', 'Jl. Danau Toba', 'Tegal Gede', 0, 0),
(30, 'Ike Sulistiyani', 'Jl. Raden Patah', 'Jl. Raden Patah', 'Tegal Gede', 0, 0),
(31, 'Vivin Septiana', 'Jl. Tawangmangu DAM III No. 72 Tegalgede - Jember', 'Jl. Tawangmangu DAM III No. 72 Tegalgede - Jember', 'Tegalgede', 0, 0),
(32, 'Ely Yahya', 'Perum Permata Kampus', 'Perum Permata Kampus', 'Tegalgede', 0, 0),
(33, 'Jumilah', 'Perum Taman Kampus A1', 'Perum Taman Kampus A1', 'Tegalgede', 0, 0),
(34, 'Octaviana Cahya Ningrum', 'Jl. Danau Toba 50', 'Jl. Danau Toba 50', 'Tegalgede', 0, 0),
(35, 'Riningsih Hidayati', 'Jl. Piere Tendean', 'Jl. Piere Tendean', 'Karangrejo', 0, 0),
(36, 'Septiana Vergi C', 'Jl. Piere Tendean', 'Jl. Piere Tendean', 'Karangrejo', 0, 0),
(37, 'Dyah Aristanti', 'Jl. S. Parman Gg X/14', 'Jl. S. Parman Gg X/14', 'Karangrejo', 0, 0),
(38, 'Tyas Edi Winarsih', 'Jl. S. Parman No. 126', 'Jl. S. Parman No. 126', 'Karangrejo', 0, 0),
(39, 'Ismiati', 'Secaba', 'Jl. Tidar', 'Karangrejo', 0, 0),
(40, 'Aris Mariyati', 'Jl. Tidar Ligk. Plindu RT. 02 RW. 14', 'Jl. Tidar Ligk. Plindu RT. 02 RW. 14', 'Karangrejo', 0, 0),
(41, 'Yuni Handayani', 'Puri Bunga Nirwana', 'Puri Bunga Nirwana', 'Karangrejo', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2019_03_03_021150_create_table_bidan', 1),
(2, '2019_03_03_021221_create_table_user', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(10) UNSIGNED NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`) VALUES
(1, 'bejo', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bidan`
--
ALTER TABLE `bidan`
  ADD PRIMARY KEY (`id_bidan`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bidan`
--
ALTER TABLE `bidan`
  MODIFY `id_bidan` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
