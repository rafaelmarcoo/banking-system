-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 10, 2024 at 07:35 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `onlinebanking`
--

-- --------------------------------------------------------

--
-- Table structure for table `manubay_history`
--

CREATE TABLE `manubay_history` (
  `Date` varchar(50) DEFAULT NULL,
  `Transaction` varchar(100) DEFAULT NULL,
  `InitialBalance` int(11) DEFAULT NULL,
  `FinalBalance` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `manubay_history`
--

INSERT INTO `manubay_history` (`Date`, `Transaction`, `InitialBalance`, `FinalBalance`) VALUES
('29 June 2024', 'Opening Account', 0, 0),
('30 June 2024', 'Deposit', 0, 100),
('30 June 2024', 'Deposit', 0, 100),
('30 June 2024', 'Deposit', 0, 1000),
('30 June 2024', 'Deposit', 0, 100),
('30 June 2024', 'Deposit', 0, 1000),
('30 June 2024', 'Deposit', 0, 123),
('30 June 2024', 'Deposit', 0, 123),
('04 July 2024', 'Deposit', 123, 123),
('04 July 2024', 'Deposit', 123, 123123),
('04 July 2024', 'Deposit', 123123, 456),
('04 July 2024', 'Deposit', 456, 123),
('04 July 2024', 'Deposit', 123, 600),
('04 July 2024', 'Deposit', 600, 1000),
('04 July 2024', 'Deposit', 1000, 1200),
('04 July 2024', 'Deposit', 1200, 1700),
('04 July 2024', 'Deposit', 1700, 2200),
('04 July 2024', 'Deposit', 2200, 2500),
('04 July 2024', 'Deposit', 2500, 2700),
('04 July 2024', 'Deposit', 2700, 3000),
('04 July 2024', 'Deposit', 3000, 3500),
('04 July 2024', 'Deposit', 3500, 4000),
('04 July 2024', 'Deposit', 4000, 5000),
('04 July 2024', 'Deposit', 5000, 5000),
('04 July 2024', 'Deposit', 5000, 6023),
('05 July 2024', 'Withdraw', 6023, 5023),
('05 July 2024', 'Deposit', 5023, 5146),
('06 July 2024', 'Deposit', 5146, 5390),
('06 July 2024', 'Deposit', 5390, 5500),
('06 July 2024', 'Deposit', 5500, 5750),
('07 July 2024', 'Deposit', 5750, 6250),
('07 July 2024', 'Withdraw', 6250, 1250),
('07 July 2024', 'Deposit', 1250, 1750),
('07 July 2024', 'Deposit', 1750, 2000),
('07 July 2024', 'Deposit', 2000, 7000),
('07 July 2024', 'Deposit', 7000, 7500),
('07 July 2024', 'Withdraw', 7500, 6270),
('07 July 2024', 'Deposit', 6270, 157831),
('07 July 2024', 'Withdraw', 157831, 137831),
('07 July 2024', 'Withdraw', 137831, 17831),
('07 July 2024', 'Withdraw', 17831, 5831),
('07 July 2024', 'Deposit', 5831, 6081),
('07 July 2024', 'Deposit', 6081, 6281),
('07 July 2024', 'Deposit', 6281, 7532),
('07 July 2024', 'Withdraw', 7532, 2987),
('07 July 2024', 'Deposit', 2987, 3487),
('07 July 2024', 'Deposit', 3487, 3987),
('07 July 2024', 'Deposit', 3987, 4437),
('07 July 2024', 'Deposit', 4437, 4937),
('07 July 2024', 'Withdraw', 4937, 2937),
('07 July 2024', 'Deposit', 2937, 3437),
('07 July 2024', 'Deposit', 3437, 3937),
('07 July 2024', 'Withdraw', 3937, 2437),
('07 July 2024', 'Deposit', 2437, 7437),
('07 July 2024', 'Deposit', 7437, 8672),
('07 July 2024', 'Withdraw', 8672, 7459),
('08 July 2024', 'Deposit', 7459, 8459),
('08 July 2024', 'Withdraw', 8459, 3459),
('08 July 2024', 'Deposit', 3459, 4459),
('10 July 2024', 'Deposit', 4459, 9459),
('10 July 2024', 'Withdraw', 9459, 1459),
('10 July 2024', 'Deposit', 1459, 9459),
('10 July 2024', 'Withdraw', 9459, 1459),
('10 July 2024', 'Deposit', 1459, 2659),
('10 July 2024', 'Withdraw', 2659, 1459),
('10 July 2024', 'Deposit', 1459, 4459),
('10 July 2024', 'Deposit', 4459, 7459),
('10 July 2024', 'Withdraw', 7459, 4459),
('10 July 2024', 'Deposit', 4459, 7459),
('10 July 2024', 'Withdraw', 7459, 2459);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
