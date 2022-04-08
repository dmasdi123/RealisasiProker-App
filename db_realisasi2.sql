-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2019 at 07:54 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_realisasi2`
--

-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE `dosen` (
  `id_user` int(11) DEFAULT NULL,
  `idDosen` int(11) NOT NULL,
  `idJabatan` int(11) DEFAULT NULL,
  `NPP` int(11) DEFAULT NULL,
  `nama_dosen` varchar(254) DEFAULT NULL,
  `ttl_dosen` date DEFAULT NULL,
  `agama_dosen` varchar(254) DEFAULT NULL,
  `jenis_kelamin` varchar(254) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`id_user`, `idDosen`, `idJabatan`, `NPP`, `nama_dosen`, `ttl_dosen`, `agama_dosen`, `jenis_kelamin`) VALUES
(1, 1, 2, 98878765, 'Dr. Liam Cube', '2019-12-12', 'Islam', 'Laki - Laki'),
(2, 2, 1, 9888880, 'Kadek Wadek S.pd', '2019-12-05', 'Hindu', 'Laki - Laki'),
(3, 3, 2, 4564564, 'Dimas M.mk', '2019-12-19', 'Islam', 'Laki - Laki'),
(4, 4, 2, 2334343, 'Fauzi', '2019-12-12', 'Islam', 'Laki - Laki');

-- --------------------------------------------------------

--
-- Table structure for table `jabatan`
--

CREATE TABLE `jabatan` (
  `idJabatan` int(11) NOT NULL,
  `jabatan_dosen` varchar(254) DEFAULT NULL,
  `masaJabatan` varchar(254) DEFAULT NULL,
  `statusJabatan` varchar(254) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jabatan`
--

INSERT INTO `jabatan` (`idJabatan`, `jabatan_dosen`, `masaJabatan`, `statusJabatan`) VALUES
(1, 'wadek', '5 tahun', 'aktif'),
(2, 'prodi', '5 tahun', 'aktif'),
(3, 'admin', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `proker`
--

CREATE TABLE `proker` (
  `id_proker` int(11) NOT NULL,
  `Dosen_penanggung` varchar(254) DEFAULT NULL,
  `uraian_proker` varchar(254) DEFAULT NULL,
  `Status_proker` varchar(254) DEFAULT NULL,
  `anggaran_dana` int(11) DEFAULT NULL,
  `tglperencanaan_proker` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `proker`
--

INSERT INTO `proker` (`id_proker`, `Dosen_penanggung`, `uraian_proker`, `Status_proker`, `anggaran_dana`, `tglperencanaan_proker`) VALUES
(1, 'Prihatin S.pd', 'Proker acara 17 agustus', 'Approved', 3000000, '2019-12-11'),
(2, 'Sukaryanto S.pd, M.pd', 'Proker acara kumpul sedulur teknik', 'Approved', 4000000, '2019-12-01'),
(3, 'Hendro Siswanto S.pd, M.pd', 'Proker acara orling 2019', 'Rejected', 4000000, '2019-12-02'),
(4, 'Basuki S.pd', 'Kumpul sedulur teknik', 'On Prosess', 4000000, '2019-12-04');

-- --------------------------------------------------------

--
-- Table structure for table `realisasi`
--

CREATE TABLE `realisasi` (
  `id_laporan` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_proker` int(11) DEFAULT NULL,
  `tglRealisasi` date DEFAULT NULL,
  `anggaran` decimal(8,0) DEFAULT NULL,
  `deskripsi_laporan` varchar(254) DEFAULT NULL,
  `Status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `realisasi`
--

INSERT INTO `realisasi` (`id_laporan`, `id_user`, `id_proker`, `tglRealisasi`, `anggaran`, `deskripsi_laporan`, `Status`) VALUES
(1, 1, 2, '2019-07-02', '4000000', 'Sudah diperiksa', 'Approved'),
(2, 4, 1, '2019-12-27', '300000', 'oke', 'Approved'),
(3, 1, 1, '2019-12-12', '3000000', 'mantab bagus boss', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `idJabatan` int(11) DEFAULT NULL,
  `username` varchar(254) DEFAULT NULL,
  `password` varchar(254) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `idJabatan`, `username`, `password`) VALUES
(1, 2, 'liam', '123'),
(2, 1, 'wadek', 'wadek'),
(3, 2, 'dimas', 'dimas'),
(4, 2, 'fauzi', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`idDosen`),
  ADD UNIQUE KEY `id_user` (`id_user`),
  ADD UNIQUE KEY `id_user_2` (`id_user`),
  ADD KEY `FK_association3` (`idJabatan`);

--
-- Indexes for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`idJabatan`);

--
-- Indexes for table `proker`
--
ALTER TABLE `proker`
  ADD PRIMARY KEY (`id_proker`);

--
-- Indexes for table `realisasi`
--
ALTER TABLE `realisasi`
  ADD PRIMARY KEY (`id_laporan`),
  ADD KEY `FK_Association_6` (`id_proker`),
  ADD KEY `FK_association4` (`id_user`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `FK_association5` (`idJabatan`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dosen`
--
ALTER TABLE `dosen`
  ADD CONSTRAINT `FK_GENERALIZATION_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `FK_association3` FOREIGN KEY (`idJabatan`) REFERENCES `jabatan` (`idJabatan`);

--
-- Constraints for table `realisasi`
--
ALTER TABLE `realisasi`
  ADD CONSTRAINT `FK_Association_6` FOREIGN KEY (`id_proker`) REFERENCES `proker` (`id_proker`),
  ADD CONSTRAINT `FK_association4` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_association5` FOREIGN KEY (`idJabatan`) REFERENCES `jabatan` (`idJabatan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
