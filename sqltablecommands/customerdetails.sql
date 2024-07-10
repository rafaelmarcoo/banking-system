-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 10, 2024 at 07:39 AM
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
-- Table structure for table `customerdetails`
--

CREATE TABLE `customerdetails` (
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Balance` int(11) NOT NULL,
  `Unit` varchar(50) NOT NULL,
  `Street` varchar(50) NOT NULL,
  `Suburb` varchar(50) NOT NULL,
  `PostalCode` varchar(50) NOT NULL,
  `PhoneNumber` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `JoinDate` varchar(50) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customerdetails`
--

INSERT INTO `customerdetails` (`FirstName`, `LastName`, `Balance`, `Unit`, `Street`, `Suburb`, `PostalCode`, `PhoneNumber`, `Email`, `JoinDate`, `Username`, `Password`) VALUES
('Rafael Marco', 'Manubay', 2459, '123', '456 Lol Street', 'Bikini Bottom', '789', '123456789', 'rafael@marco.com', '29 June 2024', 'rafael', 'marco'),
('Lebron', 'James', 4887, '123', '456 Venice Street', 'LA', '123', '456789453', 'lebron@james.com', '29 June 2024', 'lebron', 'james');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
