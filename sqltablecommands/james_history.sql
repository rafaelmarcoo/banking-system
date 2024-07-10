-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 10, 2024 at 07:34 AM
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
-- Table structure for table `james_history`
--

CREATE TABLE `james_history` (
  `Date` varchar(50) DEFAULT NULL,
  `Transaction` varchar(100) DEFAULT NULL,
  `InitialBalance` int(11) DEFAULT NULL,
  `FinalBalance` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `james_history`
--

INSERT INTO `james_history` (`Date`, `Transaction`, `InitialBalance`, `FinalBalance`) VALUES
('29 June 2024', 'Opening Account', 0, 0),
('05 July 2024', 'Deposit', 0, 1000),
('05 July 2024', 'Withdraw', 1000, 500),
('05 July 2024', 'Withdraw', 500, 380),
('06 July 2024', 'Deposit', 380, 500),
('06 July 2024', 'Deposit', 500, 750),
('06 July 2024', 'Deposit', 750, 1470),
('06 July 2024', 'Deposit', 1470, 1700),
('06 July 2024', 'Withdraw', 1700, 1500),
('06 July 2024', 'Deposit', 1500, 1650),
('06 July 2024', 'Deposit', 1650, 1800),
('06 July 2024', 'Deposit', 1800, 2000),
('06 July 2024', 'Withdraw', 1800, 1700),
('06 July 2024', 'Deposit', 1700, 2000),
('06 July 2024', 'Deposit', 2000, 2250),
('06 July 2024', 'Withdraw', 2250, 2038),
('06 July 2024', 'Deposit', 2250, 2412),
('06 July 2024', 'Deposit', 2412, 2500),
('06 July 2024', 'Deposit', 2500, 2756),
('06 July 2024', 'Deposit', 2756, 2879),
('06 July 2024', 'Deposit', 2879, 2902),
('06 July 2024', 'Deposit', 2902, 2927),
('06 July 2024', 'Deposit', 2927, 3177),
('06 July 2024', 'Deposit', 3177, 3197),
('06 July 2024', 'Deposit', 3177, 3379),
('06 July 2024', 'Deposit', 3379, 3479),
('06 July 2024', 'Deposit', 3479, 3979),
('06 July 2024', 'Deposit', 3479, 4229),
('06 July 2024', 'Deposit', 4229, 4352),
('06 July 2024', 'Deposit', 4352, 4464),
('06 July 2024', 'Deposit', 4464, 4489),
('06 July 2024', 'Deposit', 4489, 4612),
('06 July 2024', 'Withdraw', 4489, 489),
('06 July 2024', 'Deposit', 489, 945),
('06 July 2024', 'Withdraw', 489, 464),
('06 July 2024', 'Deposit', 489, 889),
('06 July 2024', 'Withdraw', 489, 239),
('06 July 2024', 'Deposit', 239, 739),
('06 July 2024', 'Deposit', 239, 241),
('06 July 2024', 'Deposit', 241, 491),
('06 July 2024', 'Deposit', 241, 243),
('06 July 2024', 'Deposit', 241, 243),
('06 July 2024', 'Deposit', 241, 12574),
('06 July 2024', 'Deposit', 241, 243),
('06 July 2024', 'Deposit', 241, 243),
('06 July 2024', 'Deposit', 241, 262),
('06 July 2024', 'Deposit', 241, 454),
('06 July 2024', 'Deposit', 454, 456),
('06 July 2024', 'Deposit', 454, 456),
('06 July 2024', 'Deposit', 454, 455),
('06 July 2024', 'Deposit', 455, 611),
('06 July 2024', 'Deposit', 455, 611),
('06 July 2024', 'Deposit', 611, 734),
('06 July 2024', 'Deposit', 734, 857),
('06 July 2024', 'Deposit', 857, 980),
('06 July 2024', 'Deposit', 980, 1000),
('06 July 2024', 'Deposit', 1000, 1120),
('06 July 2024', 'Withdraw', 1120, 1240),
('06 July 2024', 'Withdraw', 1240, 1120),
('06 July 2024', 'Withdraw', 1120, 865),
('06 July 2024', 'Deposit', 865, 985),
('06 July 2024', 'Deposit', 985, 1235),
('07 July 2024', 'Deposit', 1235, 1240),
('07 July 2024', 'Deposit', 1240, 1740),
('07 July 2024', 'Deposit', 1740, 2240),
('07 July 2024', 'Withdraw', 2240, 1040),
('07 July 2024', 'Deposit', 1040, 6040),
('07 July 2024', 'Deposit', 6040, 11040),
('07 July 2024', 'Withdraw', 11040, 2040),
('07 July 2024', 'Withdraw', 2040, 1840),
('07 July 2024', 'Withdraw', 1840, 1590),
('10 July 2024', 'Deposit', 1590, 4590),
('10 July 2024', 'Withdraw', 4590, 4090),
('10 July 2024', 'Deposit', 4090, 6090),
('10 July 2024', 'Withdraw', 6090, 1090),
('10 July 2024', 'Deposit', 1090, 6090),
('10 July 2024', 'Withdraw', 6090, 4887);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
