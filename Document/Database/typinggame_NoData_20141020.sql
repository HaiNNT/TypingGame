-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 20, 2014 at 11:26 AM
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tgresult`
--

CREATE TABLE IF NOT EXISTS `tgresult` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) NOT NULL,
  `MatchId` int(11) NOT NULL,
  `Rate` int(11) NOT NULL,
  `Speed` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `UserId` (`UserId`),
  KEY `MatchId` (`MatchId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tgrole`
--

CREATE TABLE IF NOT EXISTS `tgrole` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tguser`
--

CREATE TABLE IF NOT EXISTS `tguser` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Fullname` varchar(255) NOT NULL,
  `AverageSpeed` int(11) NOT NULL,
  `BestSpeed` int(11) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `RegisterDate` date NOT NULL,
  `Status` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Username` (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
  ADD CONSTRAINT `tgmatch_ibfk_2` FOREIGN KEY (`ArticleId`) REFERENCES `tgarticle` (`Id`),
  ADD CONSTRAINT `tgmatch_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `tguser` (`Id`);

--
-- Constraints for table `tgresult`
--
ALTER TABLE `tgresult`
  ADD CONSTRAINT `tgresult_ibfk_2` FOREIGN KEY (`MatchId`) REFERENCES `tgmatch` (`Id`),
  ADD CONSTRAINT `tgresult_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `tguser` (`Id`);

--
-- Constraints for table `tguserinrole`
--
ALTER TABLE `tguserinrole`
  ADD CONSTRAINT `tguserinrole_ibfk_2` FOREIGN KEY (`RoleId`) REFERENCES `tgrole` (`Id`),
  ADD CONSTRAINT `tguserinrole_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `tguser` (`Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
