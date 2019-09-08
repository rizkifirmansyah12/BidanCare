-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 27, 2019 at 08:51 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

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
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `id_admin` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`id_admin`, `username`, `password`) VALUES
(1, 'admin', '123'),
(2, 'b', '1'),
(3, 'waluy', '1');

-- --------------------------------------------------------

--
-- Table structure for table `bidans`
--

CREATE TABLE `bidans` (
  `id_bidan` int(10) UNSIGNED NOT NULL,
  `nama_bidan` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `alamat_bidan` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `alamat_praktek` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `bidan_wilayah` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `waktu_tutup` time NOT NULL,
  `verifikasi` enum('verifikasi','belum') COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `opsi` enum('buka','tutup') COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_login` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `bidans`
--

INSERT INTO `bidans` (`id_bidan`, `nama_bidan`, `alamat_bidan`, `alamat_praktek`, `bidan_wilayah`, `lat`, `lng`, `waktu_tutup`, `verifikasi`, `opsi`, `id_login`) VALUES
(1, 'Umi Sumarno', 'Jl. Jawa IV', 'Jl. Jawa IV', 'Sumbersari', -8.170427, 113.715563, '00:00:00', NULL, 'buka', 1),
(2, 'Elly Yahya', 'Jl. Kaliurang', 'Jl. Kaliurang', 'Sumbersari', -8.1640867, 113.7317179, '00:00:00', NULL, 'tutup', NULL),
(3, 'Cindy Yosi Pratiwi', 'Jl. Kaliurang Perum Istana TIdar A1/07', 'Jl. Kaliurang Perum Istana TIdar A1/07', 'Sumbersari', 0, 0, '00:00:00', 'belum', 'buka', NULL),
(4, 'Fathul Listiani', 'Jl. Kawi 31', 'Jl. Kawi 31 RT 03 RW 13', 'Sumbersari', -8.1772737, 113.7178398, '00:00:00', NULL, 'buka', NULL),
(5, 'Nunia Agus Pujayanti', 'Jl. PB Sudirman XII/9 - Patrang', 'Jl. PB Sudirman XII/9 - Patrang', 'Sumbersari', -8.1593828, 113.7096292, '00:00:00', NULL, 'buka', NULL),
(6, 'Diah Aristanti', 'Jl. S. Parman X', 'Jl. S. Parman X', 'Sumbersari', -8.1833516, 113.7186519, '00:00:00', NULL, 'buka', NULL),
(7, 'Sri Ramadhani', 'Jl. Semeru Gg Lembah', 'Jl. Semeru Gg Lembah', 'Sumbersari', 0, 0, '00:00:00', NULL, 'buka', NULL),
(8, 'Dwi Melia', 'Jl. Sumatra III', 'Jl. Sumatra III', 'Sumbesari', -8.1717437, 113.7099361, '00:00:00', NULL, 'buka', NULL),
(9, 'Emilia Rahayu', 'Dusun Perangan RT. 04 RW. 02 Kradenan - Purwoharjo Banyuwangi', 'Jl. Sumatra III/3', 'Sumbersari', -8.1717437, 113.7099361, '00:00:00', NULL, 'buka', NULL),
(10, 'Veronica Vestin', 'Perum Karimata Dream Land / Jl. Gunung Agung III', 'Perum Karimata Dream Land / Jl. Gunung Agung III', 'Sumbersari', 0, 0, '00:00:00', NULL, 'buka', NULL),
(11, 'Nurika Santi Anggraeni', 'Perum Karimata Dream Land / Jl. Gunung Agung III', 'Perum Karimata Dream Land / Jl. Gunung Agung III', 'Sumbersari', 0, 0, '00:00:00', NULL, 'buka', NULL),
(12, 'Ernawati Anggraeni', 'Perum Karimata Dream Land / Jl. Gunung Agung III', 'Perum Karimata Dream Land / Jl. Gunung Agung III', 'Sumbersari', 0, 0, '00:00:00', NULL, 'buka', NULL),
(13, 'Rizki Fitrianingtiyas', 'Perum Karimata Dream Land / Jl. Gunung Agung III', 'Perum Karimata Dream Land / Jl. Gunung Agung III', 'Sumbersari', 0, 0, '00:00:00', NULL, 'buka', NULL),
(14, 'Uswatun Hasanah', 'Jl KH. Yasin', 'Jl KH Yasin RT. 1 RW. 9', 'Wirolegi', 0, 0, '00:00:00', NULL, 'buka', NULL),
(15, 'Krisna', 'Jl KH. Yasin', 'Jl KH. Yasin RT. 1 RW. 9', 'Wirolegi', 0, 0, '00:00:00', NULL, 'buka', NULL),
(16, 'Siti Nurfaizah', 'Jl. Kutai 112', 'Jl Kutai 112 RT. 03 RW. 14', 'Wirolegi', -8.1992407, 113.7331295, '00:00:00', NULL, 'buka', NULL),
(17, 'Elmi Izatul Lailia', 'Jl. MT. Haryono 211', 'Jl. Letjen Panjaitan No.42 Jember', 'Wirolegi', -8.1786008, 113.7067301, '00:00:00', NULL, 'buka', NULL),
(18, 'Narulita', 'Jl. Majapahit RT.1 RW.1', 'Jl. Majapahit RT.1 RW.1', 'Wirolegi', -8.1868557, 0, '00:00:00', NULL, 'buka', NULL),
(19, 'Arie Prahastutiningtyas', 'Jl. MT Haryono 148 Jember', 'Jl. MT Haryono 148 Jember', 'Wirolegi', 0, 0, '00:00:00', NULL, 'buka', NULL),
(20, 'Wji Rahayu', 'Jl. Sri Tanjung RT. 02 RW. 06', 'Jl. Sri Tanjung RT. 02 RW. 06', 'Wirolegi', 0, 0, '00:00:00', NULL, 'buka', NULL),
(21, 'Devi Saputri Hadifian', 'Jl. Yos Sudarso No. 63 Wirolegi', 'Jl. Yos Sudarso No. 63 Wirolegi', 'Wirolegi', 0, 0, '00:00:00', NULL, 'buka', NULL),
(22, 'Susiani', 'Jl. Yos Sudarso Perum Taman Bambu BB-2', 'Jl. Yos Sudarso Perum Taman Bambu BB-2', 'Wirolegi', -8.1899236, 113.74385, '00:00:00', NULL, 'buka', NULL),
(23, 'Putri', 'Jl. Yos Sudarso ', 'Jl. Yos Sudarso RT.1 RW. 3', 'Wirolegi', 0, 0, '00:00:00', NULL, 'buka', NULL),
(24, 'Susi', 'Jl. Yos Sudarso ', 'Jl. Yos Sudarso RT.1 RW. 3', 'Wirolegi', 0, 0, '00:00:00', NULL, 'buka', NULL),
(25, 'Nurul Hidayati', 'Jl. Yos Sudarso ', 'Jl. Yos Sudarso RT.1 RW. 3', 'Wirolegi', 0, 0, '00:00:00', NULL, 'buka', NULL),
(26, 'Henry Wulandari', 'Jl Sarangan', 'Jl. Sarangan', 'Antirogo', 0, 0, '00:00:00', NULL, 'buka', NULL),
(27, 'Maisaroh', 'Jl. Pangandaran', 'Jl. Pangandaran', 'Antirogo', 0, 0, '00:00:00', NULL, 'buka', NULL),
(28, 'Nurul', 'Jl. Pangandaran', 'Jl. Pangandaran', 'Antirogo', 0, 0, '00:00:00', NULL, 'buka', NULL),
(29, 'Nunuk', 'Jl. Danau Toba', 'Jl. Danau Toba', 'Tegal Gede', 0, 0, '00:00:00', NULL, 'buka', NULL),
(30, 'Ike Sulistiyani', 'Jl. Raden Patah', 'Jl. Raden Patah', 'Tegal Gede', 0, 0, '00:00:00', NULL, 'buka', NULL),
(31, 'Vivin Septiana', 'Jl. Tawangmangu DAM III No. 72 Tegalgede - Jember', 'Jl. Tawangmangu DAM III No. 72 Tegalgede - Jember', 'Tegalgede', 0, 0, '00:00:00', NULL, 'buka', NULL),
(32, 'Ely Yahya', 'Perum Permata Kampus', 'Perum Permata Kampus', 'Tegalgede', 0, 0, '00:00:00', NULL, 'buka', NULL),
(33, 'Jumilah', 'Perum Taman Kampus A1', 'Perum Taman Kampus A1', 'Tegalgede', 0, 0, '00:00:00', NULL, 'buka', NULL),
(34, 'Octaviana Cahya Ningrum', 'Jl. Danau Toba 50', 'Jl. Danau Toba 50', 'Tegalgede', 0, 0, '00:00:00', NULL, 'buka', NULL),
(35, 'Riningsih Hidayati', 'Jl. Piere Tendean', 'Jl. Piere Tendean', 'Karangrejo', 0, 0, '00:00:00', NULL, 'buka', NULL),
(36, 'Septiana Vergi C', 'Jl. Piere Tendean', 'Jl. Piere Tendean', 'Karangrejo', 0, 0, '00:00:00', NULL, 'buka', NULL),
(37, 'Dyah Aristanti', 'Jl. S. Parman Gg X/14', 'Jl. S. Parman Gg X/14', 'Karangrejo', 0, 0, '00:00:00', NULL, 'buka', NULL),
(38, 'Tyas Edi Winarsih', 'Jl. S. Parman No. 126', 'Jl. S. Parman No. 126', 'Karangrejo', 0, 0, '00:00:00', NULL, 'buka', NULL),
(39, 'Ismiati', 'Secaba', 'Jl. Tidar', 'Karangrejo', 0, 0, '00:00:00', NULL, 'buka', NULL),
(40, 'Aris Mariyati', 'Jl. Tidar Ligk. Plindu RT. 02 RW. 14', 'Jl. Tidar Ligk. Plindu RT. 02 RW. 14', 'Karangrejo', 0, 0, '00:00:00', NULL, 'buka', NULL),
(41, 'Yuni Handayani', 'Puri Bunga Nirwana', 'Puri Bunga Nirwana', 'Karangrejo', 0, 0, '00:00:00', NULL, 'buka', NULL),
(42, 'dwi', 'jember', 'jember', 'sumbersari', -31231241, -31231241, '00:00:00', NULL, 'buka', NULL),
(43, 'lope', 'jember', 'jbr', 'smbr', 0, 0, '07:30:00', NULL, 'buka', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `grup`
--

CREATE TABLE `grup` (
  `id_grup` int(11) NOT NULL,
  `ket` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grup`
--

INSERT INTO `grup` (`id_grup`, `ket`) VALUES
(1, 'user'),
(2, 'bidan'),
(3, 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id_login` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(9) NOT NULL,
  `id_grup` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id_login`, `username`, `password`, `id_grup`) VALUES
(1, 'umi', '1', 2),
(2, 'bejo', '1', 1),
(3, 'admin', '1', 3),
(4, 'kolo', '1', 1),
(6, 'op', '1', 3);

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
-- Table structure for table `tbl_verifikasi`
--

CREATE TABLE `tbl_verifikasi` (
  `id` int(11) NOT NULL,
  `verifikasi` varchar(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_verifikasi`
--

INSERT INTO `tbl_verifikasi` (`id`, `verifikasi`) VALUES
(1, 'belum'),
(2, 'verifikasi');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `id_login` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `id_login`, `username`, `password`) VALUES
(1, 2, 'bejo', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `bidans`
--
ALTER TABLE `bidans`
  ADD PRIMARY KEY (`id_bidan`),
  ADD KEY `id_login` (`id_login`);

--
-- Indexes for table `grup`
--
ALTER TABLE `grup`
  ADD PRIMARY KEY (`id_grup`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id_login`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `id_grup` (`id_grup`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_verifikasi`
--
ALTER TABLE `tbl_verifikasi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_login` (`id_login`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `bidans`
--
ALTER TABLE `bidans`
  MODIFY `id_bidan` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `grup`
--
ALTER TABLE `grup`
  MODIFY `id_grup` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id_login` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_verifikasi`
--
ALTER TABLE `tbl_verifikasi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bidans`
--
ALTER TABLE `bidans`
  ADD CONSTRAINT `bidans_ibfk_1` FOREIGN KEY (`id_login`) REFERENCES `login` (`id_login`);

--
-- Constraints for table `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`id_grup`) REFERENCES `grup` (`id_grup`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`id_login`) REFERENCES `login` (`id_login`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
