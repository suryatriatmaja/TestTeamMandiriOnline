-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 14, 2019 at 06:47 
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `data_calaon_pegawai`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_pelamar`
--

CREATE TABLE `data_pelamar` (
  `id` varchar(99) NOT NULL,
  `nama` varchar(9999) NOT NULL,
  `alamat` varchar(9999) NOT NULL,
  `tempat_tanggal_lahir` varchar(9999) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_pelamar`
--

INSERT INTO `data_pelamar` (`id`, `nama`, `alamat`, `tempat_tanggal_lahir`) VALUES
('1', 'surya', 'permata hijau', 'batusangkar 22-12-1996'),
('2', 'jaka', 'ph', 'jkt 22-12-1996'),
('5', 'amin', 'cipete', 'jakarta 20-11-1994'),
('6', 'sadrak', 'jakarta', 'jakarta 06-10-1880'),
('7', 'baskara', 'cibubur', 'cibubur 16-09-1994'),
('8', 'anggit', 'ciledug', 'ciledug 11-11-1996');

-- --------------------------------------------------------

--
-- Table structure for table `result`
--

CREATE TABLE `result` (
  `id` varchar(99) NOT NULL,
  `nama` varchar(9999) NOT NULL,
  `alamat` varchar(9999) NOT NULL,
  `tempat_tanggal_lahir` varchar(9999) NOT NULL,
  `jurusan` varchar(9999) NOT NULL,
  `posisi_lamaran` varchar(9999) NOT NULL,
  `score_final` int(11) NOT NULL,
  `status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `result`
--

INSERT INTO `result` (`id`, `nama`, `alamat`, `tempat_tanggal_lahir`, `jurusan`, `posisi_lamaran`, `score_final`, `status`) VALUES
('1', 'surya', 'permata hijau', 'batusangkar 22-12-1996', 'Sistem Informasi', 'Backend Developer', 233, 'LULUS'),
('2', 'jaka', 'ph', 'jkt 22-12-1996', 'Sistem Informasi', 'Backend Developer', 73, 'TIDAK LULUS');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_penilaian`
--

CREATE TABLE `tabel_penilaian` (
  `id` varchar(99) NOT NULL,
  `jurusan` varchar(9999) NOT NULL,
  `posisi_lamaran` varchar(9999) NOT NULL,
  `nilai_sikap` int(11) NOT NULL,
  `nilai_wawancara` int(11) NOT NULL,
  `nilai_technical_test` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_penilaian`
--

INSERT INTO `tabel_penilaian` (`id`, `jurusan`, `posisi_lamaran`, `nilai_sikap`, `nilai_wawancara`, `nilai_technical_test`) VALUES
('1', 'Sistem Informasi', 'Backend Developer', 100, 100, 100),
('2', 'Sistem Informasi', 'Backend Developer', 10, 50, 40),
('3', 'biologi', 'OB', 100, 100, 100),
('5', 'kemoterapi', 'tukang pijit', 90, 90, 90);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_pelamar`
--
ALTER TABLE `data_pelamar`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `result`
--
ALTER TABLE `result`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tabel_penilaian`
--
ALTER TABLE `tabel_penilaian`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
