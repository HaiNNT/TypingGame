-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 27, 2014 at 04:38 AM
-- Server version: 5.5.32
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `typinggame`
--
CREATE DATABASE IF NOT EXISTS `typinggame` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `typinggame`;

-- --------------------------------------------------------

--
-- Table structure for table `tgarticle`
--

CREATE TABLE IF NOT EXISTS `tgarticle` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) NOT NULL,
  `Content` text NOT NULL,
  `DateCreated` datetime NOT NULL,
  `Name` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `UserId` (`UserId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `tgarticle`
--

INSERT INTO `tgarticle` (`Id`, `UserId`, `Content`, `DateCreated`, `Name`) VALUES
(1, 3, 'This is article 1 content', '2014-10-14 00:00:00', 'Article 1'),
(2, 3, 'This is article 2 content', '2014-10-23 00:00:00', 'Article 2'),
(3, 3, 'This is article 3 content', '2014-10-22 00:00:00', 'Article 3'),
(4, 3, 'This is article 4 content', '2014-10-16 00:00:00', 'Article 4'),
(5, 3, 'This is article 5 content', '2014-10-27 10:31:49', 'Article 5');

-- --------------------------------------------------------

--
-- Table structure for table `tgmatch`
--

CREATE TABLE IF NOT EXISTS `tgmatch` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Mode` varchar(255) NOT NULL,
  `CreatedDate` datetime NOT NULL,
  `UserId` int(11) NOT NULL,
  `ArticleId` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `UserId` (`UserId`),
  KEY `ArticleId` (`ArticleId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=63 ;

--
-- Dumping data for table `tgmatch`
--

INSERT INTO `tgmatch` (`Id`, `Mode`, `CreatedDate`, `UserId`, `ArticleId`) VALUES
(21, 'friend', '2014-10-23 17:26:01', 2, 1),
(22, 'random', '2014-10-23 17:29:19', 2, 1),
(23, 'random', '2014-10-23 17:30:26', 2, 1),
(24, 'random', '2014-10-23 17:34:53', 2, 1),
(25, 'random', '2014-10-23 17:35:17', 2, 1),
(26, 'random', '2014-10-23 19:07:04', 2, 1),
(27, 'random', '2014-10-23 19:08:19', 2, 1),
(28, 'random', '2014-10-23 20:23:56', 1, 1),
(29, 'friend', '2014-10-24 08:06:56', 1, 1),
(30, 'friend', '2014-10-24 08:13:12', 1, 1),
(31, 'random', '2014-10-24 08:13:44', 1, 1),
(32, 'random', '2014-10-24 08:42:44', 2, 1),
(33, 'friend', '2014-10-24 09:58:06', 2, 1),
(34, 'friend', '2014-10-24 10:03:06', 1, 1),
(35, 'friend', '2014-10-24 10:14:08', 1, 1),
(36, 'friend', '2014-10-24 10:20:05', 1, 1),
(37, 'friend', '2014-10-24 10:20:26', 1, 1),
(38, 'random', '2014-10-24 10:59:51', 2, 1),
(39, 'random', '2014-10-24 11:03:06', 2, 1),
(40, 'random', '2014-10-24 11:07:41', 2, 1),
(41, 'random', '2014-10-24 11:21:32', 2, 2),
(42, 'random', '2014-10-24 11:22:41', 2, 1),
(43, 'random', '2014-10-24 11:23:59', 2, 2),
(44, 'random', '2014-10-24 11:25:33', 2, 2),
(45, 'random', '2014-10-24 20:13:05', 1, 2),
(46, 'random', '2014-10-24 20:13:29', 1, 1),
(47, 'random', '2014-10-25 16:11:08', 1, 2),
(48, 'random', '2014-10-25 18:04:16', 1, 1),
(49, 'random', '2014-10-26 15:12:44', 1, 1),
(50, 'random', '2014-10-26 15:33:20', 2, 2),
(51, 'random', '2014-10-26 16:57:36', 1, 2),
(52, 'random', '2014-10-26 17:10:44', 1, 1),
(53, 'random', '2014-10-26 17:32:26', 1, 1),
(54, 'random', '2014-10-26 20:29:53', 1, 1),
(55, 'friend', '2014-10-26 20:32:30', 1, 1),
(56, 'friend', '2014-10-26 21:28:19', 1, 1),
(57, 'friend', '2014-10-26 21:28:41', 1, 1),
(58, 'random', '2014-10-26 21:28:55', 1, 1),
(59, 'random', '2014-10-26 22:59:56', 1, 1),
(60, 'random', '2014-10-26 23:22:36', 6, 2),
(61, 'random', '2014-10-26 23:25:53', 2, 2),
(62, 'random', '2014-10-27 10:13:20', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tgresult`
--

CREATE TABLE IF NOT EXISTS `tgresult` (
  `UserId` int(11) NOT NULL,
  `MatchId` int(11) NOT NULL,
  `Rate` int(11) DEFAULT NULL,
  `Speed` int(11) NOT NULL,
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`),
  KEY `UserId` (`UserId`),
  KEY `MatchId` (`MatchId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=73 ;

--
-- Dumping data for table `tgresult`
--

INSERT INTO `tgresult` (`UserId`, `MatchId`, `Rate`, `Speed`, `Id`) VALUES
(2, 25, NULL, 400, 1),
(1, 25, NULL, 150, 2),
(2, 26, 2, 234, 3),
(1, 26, 1, 334, 4),
(2, 27, NULL, 434, 5),
(1, 27, NULL, 168, 6),
(1, 28, 2, 440, 7),
(2, 28, 1, 600, 8),
(1, 29, NULL, 203, 9),
(4, 29, NULL, -1, 10),
(1, 30, NULL, 490, 11),
(4, 30, NULL, -1, 12),
(1, 31, 1, 263, 13),
(2, 31, 2, 0, 14),
(2, 32, 2, 360, 15),
(1, 32, 1, 232, 16),
(2, 33, 2, 270, 17),
(1, 33, 1, 175, 18),
(1, 34, 2, 540, 19),
(2, 34, 1, 720, 20),
(1, 37, 2, 514, 21),
(2, 37, 1, 675, 22),
(2, 38, 2, 86, 23),
(1, 38, 1, 432, 24),
(2, 39, 1, 99, 25),
(1, 39, 2, 0, 26),
(2, 40, 2, 186, 27),
(1, 40, 1, 337, 28),
(2, 41, NULL, 0, 29),
(1, 41, NULL, 0, 30),
(2, 42, NULL, 0, 31),
(1, 42, NULL, 399, 32),
(2, 43, NULL, 0, 33),
(1, 43, NULL, 0, 34),
(2, 44, NULL, 0, 35),
(5, 44, NULL, -1, 36),
(1, 45, NULL, 0, 37),
(5, 45, NULL, -1, 38),
(1, 46, NULL, 220, 39),
(4, 46, NULL, -1, 40),
(1, 47, NULL, 0, 41),
(4, 47, NULL, -1, 42),
(1, 48, NULL, 308, 43),
(5, 48, NULL, -1, 44),
(1, 49, 1, 415, 45),
(2, 49, 2, 118, 46),
(2, 50, 2, 0, 47),
(6, 50, 1, 0, 48),
(1, 51, NULL, 0, 49),
(4, 51, NULL, -1, 50),
(1, 52, NULL, 372, 51),
(4, 52, NULL, -1, 52),
(1, 53, 1, 211, 53),
(6, 53, 2, 104, 54),
(1, 54, 2, 263, 55),
(2, 54, 1, 327, 56),
(1, 55, NULL, 270, 57),
(4, 55, NULL, -1, 58),
(1, 56, 2, 291, 59),
(6, 56, 1, 327, 60),
(1, 57, 2, 229, 61),
(6, 57, 1, 291, 62),
(1, 58, NULL, 284, 63),
(8, 58, NULL, -1, 64),
(1, 59, NULL, 432, 65),
(5, 59, NULL, -1, 66),
(6, 60, NULL, 0, 67),
(4, 60, NULL, -1, 68),
(2, 61, NULL, 0, 69),
(8, 61, NULL, -1, 70),
(1, 62, NULL, -1, 71),
(4, 62, NULL, -1, 72);

-- --------------------------------------------------------

--
-- Table structure for table `tgrole`
--

CREATE TABLE IF NOT EXISTS `tgrole` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tgrole`
--

INSERT INTO `tgrole` (`Id`, `name`) VALUES
(1, 'player'),
(2, 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `tguser`
--

CREATE TABLE IF NOT EXISTS `tguser` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Fullname` varchar(255) NOT NULL,
  `AverageSpeed` int(11) DEFAULT NULL,
  `BestSpeed` int(11) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `RegisterDate` datetime NOT NULL,
  `Status` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Username` (`Username`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `tguser`
--

INSERT INTO `tguser` (`Id`, `Username`, `Password`, `Fullname`, `AverageSpeed`, `BestSpeed`, `Email`, `RegisterDate`, `Status`) VALUES
(1, 'hainnt', '123456', 'Nguyen Hai', 144, 432, 'hainnt@gmail.com', '2014-10-22 00:00:00', 1),
(2, 'trungdq', '123123', 'Trung', 105, 122, 'trung@gmail.com', '2014-10-22 00:00:00', 1),
(3, 'MinhHV', '123456', 'Ha Minh', NULL, NULL, 'minhhv@gmail.com', '2014-10-21 00:00:00', 1),
(4, 'thangnt', '123456', 'Thang', 122, 123, 'thang@gmail.com', '2014-10-21 00:00:00', 1),
(5, 'phuchq', '123456', 'Phuc', 322, 344, 'phuc@gmail.com', '2014-10-21 00:00:00', 1),
(6, 'hoappt', '123456', 'Hoa', 194, 244, 'hoa@gmail.com', '2014-10-16 00:00:00', 1),
(7, 'khang', '123456', 'Khang', NULL, NULL, 'khang@gmail.com', '2014-10-26 08:12:54', 0),
(8, 'quangtv', '123456', 'Quang', NULL, NULL, 'account@gmail.com', '2014-10-26 08:29:49', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tguserinrole`
--

CREATE TABLE IF NOT EXISTS `tguserinrole` (
  `UserId` int(11) NOT NULL,
  `RoleId` int(11) NOT NULL,
  KEY `UserId` (`UserId`),
  KEY `RoleId` (`RoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tguserinrole`
--

INSERT INTO `tguserinrole` (`UserId`, `RoleId`) VALUES
(1, 1),
(3, 2),
(2, 1),
(5, 1),
(6, 1),
(4, 1),
(8, 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tgarticle`
--
ALTER TABLE `tgarticle`
  ADD CONSTRAINT `tgarticle_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `tguser` (`Id`);

--
-- Constraints for table `tgmatch`
--
ALTER TABLE `tgmatch`
  ADD CONSTRAINT `tgmatch_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `tguser` (`Id`),
  ADD CONSTRAINT `tgmatch_ibfk_2` FOREIGN KEY (`ArticleId`) REFERENCES `tgarticle` (`Id`);

--
-- Constraints for table `tgresult`
--
ALTER TABLE `tgresult`
  ADD CONSTRAINT `tgresult_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `tguser` (`Id`),
  ADD CONSTRAINT `tgresult_ibfk_2` FOREIGN KEY (`MatchId`) REFERENCES `tgmatch` (`Id`);

--
-- Constraints for table `tguserinrole`
--
ALTER TABLE `tguserinrole`
  ADD CONSTRAINT `tguserinrole_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `tguser` (`Id`),
  ADD CONSTRAINT `tguserinrole_ibfk_2` FOREIGN KEY (`RoleId`) REFERENCES `tgrole` (`Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
