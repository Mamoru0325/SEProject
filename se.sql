-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 28, 2023 at 06:51 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
CREATE DATABASE IF NOT EXISTS `se` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `se`;
--
-- Database: `se`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `accountId` int(11) NOT NULL,
  `accountName` varchar(45) NOT NULL,
  `pwd` varchar(45) NOT NULL,
  `title` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `phoneNumber` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`accountId`, `accountName`, `pwd`, `title`, `firstName`, `lastName`, `phoneNumber`) VALUES
(1, 'pokpongthunder789@gmail.com', '123456', 'mr', 'paweenwich', 'thadee', '0896345911');

-- --------------------------------------------------------

--
-- Table structure for table `approvewithdraw`
--

CREATE TABLE `approvewithdraw` (
  `approveWithdrawId` int(11) NOT NULL,
  `staffId` int(11) NOT NULL,
  `dateApprove` date NOT NULL,
  `status` enum('y','n') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `approvewithdrawdetail`
--

CREATE TABLE `approvewithdrawdetail` (
  `approveWithdrawDetailId` int(11) NOT NULL,
  `withdrawReportId` int(11) NOT NULL,
  `approveWithdrawId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `bankaccount`
--

CREATE TABLE `bankaccount` (
  `bankAccountId` int(11) NOT NULL,
  `accountNumber` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `bookmark`
--

CREATE TABLE `bookmark` (
  `bookmarkId` int(11) NOT NULL,
  `postId` int(11) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `commentId` int(11) NOT NULL,
  `postId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `commentDetail` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `commentlike`
--

CREATE TABLE `commentlike` (
  `commentLikeId` int(11) NOT NULL,
  `commentId` int(11) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `courseId` int(11) NOT NULL,
  `createBy` int(11) NOT NULL,
  `typeId` int(11) NOT NULL,
  `postId` int(11) DEFAULT NULL,
  `courseDetail` varchar(45) NOT NULL,
  `minimum` int(11) NOT NULL,
  `maximum` int(11) DEFAULT NULL,
  `price` float NOT NULL,
  `status` enum('full','available') NOT NULL,
  `firstEnrollDate` date NOT NULL,
  `lastEnrollDate` date NOT NULL,
  `eventDay` date NOT NULL,
  `startTime` varchar(45) NOT NULL,
  `endTime` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `coursecreator`
--

CREATE TABLE `coursecreator` (
  `courseCreatorId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `balance` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `imgcomment`
--

CREATE TABLE `imgcomment` (
  `imgComment` int(11) NOT NULL,
  `imgPath` varchar(150) NOT NULL,
  `commentId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `imgcourse`
--

CREATE TABLE `imgcourse` (
  `imgCourse` int(11) NOT NULL,
  `imgPath` varchar(150) NOT NULL,
  `courseId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `imgpost`
--

CREATE TABLE `imgpost` (
  `imgPostId` int(11) NOT NULL,
  `imgPath` varchar(150) NOT NULL,
  `postId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `imgverify`
--

CREATE TABLE `imgverify` (
  `imgVerifyId` int(11) NOT NULL,
  `requestVerifyId` int(11) NOT NULL,
  `imgPath` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `joincourse`
--

CREATE TABLE `joincourse` (
  `joinCourseId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `paymentcheck`
--

CREATE TABLE `paymentcheck` (
  `paymentId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `approveBy` int(11) NOT NULL,
  `joinCourseId` int(11) NOT NULL,
  `status` enum('yes','no') NOT NULL,
  `imgPath` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE `post` (
  `postId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `typeId` int(11) DEFAULT NULL,
  `postDetail` text NOT NULL,
  `imgPath` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `postlike`
--

CREATE TABLE `postlike` (
  `postLikeId` int(11) NOT NULL,
  `postId` int(11) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE `report` (
  `reportId` int(11) NOT NULL,
  `requestBy` int(11) NOT NULL,
  `courseId` int(11) DEFAULT NULL,
  `postId` int(11) DEFAULT NULL,
  `commentId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `requestcourse`
--

CREATE TABLE `requestcourse` (
  `requestCourseId` int(11) NOT NULL,
  `requestBy` int(11) NOT NULL,
  `postId` int(11) NOT NULL,
  `approveBy` int(11) NOT NULL,
  `status` enum('waiting','approve','reject') NOT NULL,
  `dateApprove` date NOT NULL,
  `dateExprie` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `requestcoursedetail`
--

CREATE TABLE `requestcoursedetail` (
  `requestCourseDetailId` int(11) NOT NULL,
  `requestCourseId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `requestverify`
--

CREATE TABLE `requestverify` (
  `requestVerifyId` int(11) NOT NULL,
  `approveBy` int(11) NOT NULL,
  `status` enum('waiting','approve','reject') NOT NULL,
  `note` text NOT NULL,
  `imgPath` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `requestverifydetail`
--

CREATE TABLE `requestverifydetail` (
  `requestVerifyDetail` int(11) NOT NULL,
  `requestVerifyId` int(11) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staffId` int(11) NOT NULL,
  `position` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE `type` (
  `typeId` int(11) NOT NULL,
  `type` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`typeId`, `type`) VALUES
(1, 'เทคโนโลยี'),
(2, 'อาหาร'),
(3, 'กีฬา'),
(4, 'การแพทย์'),
(5, 'สุขภาพ'),
(6, 'ทั่วไป');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` int(11) NOT NULL,
  `userName` varchar(45) NOT NULL,
  `verifyStatus` enum('yes','no') NOT NULL,
  `imgPath` varchar(150) NOT NULL,
  `followBy` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `withdrawreport`
--

CREATE TABLE `withdrawreport` (
  `withdrawReportId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `withdrawBalance` float NOT NULL,
  `dateWithdraw` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`accountId`);

--
-- Indexes for table `approvewithdraw`
--
ALTER TABLE `approvewithdraw`
  ADD PRIMARY KEY (`approveWithdrawId`),
  ADD KEY `FK_2` (`staffId`);

--
-- Indexes for table `approvewithdrawdetail`
--
ALTER TABLE `approvewithdrawdetail`
  ADD PRIMARY KEY (`approveWithdrawDetailId`),
  ADD KEY `FK_2` (`withdrawReportId`),
  ADD KEY `FK_3` (`approveWithdrawId`);

--
-- Indexes for table `bankaccount`
--
ALTER TABLE `bankaccount`
  ADD PRIMARY KEY (`bankAccountId`);

--
-- Indexes for table `bookmark`
--
ALTER TABLE `bookmark`
  ADD PRIMARY KEY (`bookmarkId`),
  ADD KEY `FK_2` (`postId`),
  ADD KEY `FK_3` (`userId`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`commentId`),
  ADD KEY `FK_2` (`postId`),
  ADD KEY `FK_3` (`userId`);

--
-- Indexes for table `commentlike`
--
ALTER TABLE `commentlike`
  ADD PRIMARY KEY (`commentLikeId`),
  ADD KEY `FK_2` (`commentId`),
  ADD KEY `FK_3` (`userId`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`courseId`),
  ADD KEY `FK_3` (`postId`),
  ADD KEY `FK_4` (`typeId`),
  ADD KEY `FK_4_1` (`createBy`);

--
-- Indexes for table `coursecreator`
--
ALTER TABLE `coursecreator`
  ADD PRIMARY KEY (`courseCreatorId`),
  ADD KEY `FK_2` (`userId`);

--
-- Indexes for table `imgcomment`
--
ALTER TABLE `imgcomment`
  ADD PRIMARY KEY (`imgComment`),
  ADD KEY `FK_2` (`commentId`);

--
-- Indexes for table `imgcourse`
--
ALTER TABLE `imgcourse`
  ADD PRIMARY KEY (`imgCourse`),
  ADD KEY `FK_2` (`courseId`);

--
-- Indexes for table `imgpost`
--
ALTER TABLE `imgpost`
  ADD PRIMARY KEY (`imgPostId`),
  ADD KEY `FK_2` (`postId`);

--
-- Indexes for table `imgverify`
--
ALTER TABLE `imgverify`
  ADD PRIMARY KEY (`imgVerifyId`),
  ADD KEY `FK_2` (`requestVerifyId`);

--
-- Indexes for table `joincourse`
--
ALTER TABLE `joincourse`
  ADD PRIMARY KEY (`joinCourseId`),
  ADD KEY `FK_3` (`courseId`);

--
-- Indexes for table `paymentcheck`
--
ALTER TABLE `paymentcheck`
  ADD PRIMARY KEY (`paymentId`),
  ADD KEY `FK_2` (`userId`),
  ADD KEY `FK_3` (`joinCourseId`),
  ADD KEY `FK_4` (`approveBy`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`postId`),
  ADD KEY `FK_3` (`typeId`),
  ADD KEY `FK_3_1` (`userId`);

--
-- Indexes for table `postlike`
--
ALTER TABLE `postlike`
  ADD PRIMARY KEY (`postLikeId`),
  ADD KEY `FK_2` (`postId`),
  ADD KEY `FK_3` (`userId`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`reportId`),
  ADD KEY `FK_2` (`requestBy`),
  ADD KEY `FK_3` (`commentId`),
  ADD KEY `FK_4` (`postId`),
  ADD KEY `FK_5` (`courseId`);

--
-- Indexes for table `requestcourse`
--
ALTER TABLE `requestcourse`
  ADD PRIMARY KEY (`requestCourseId`),
  ADD KEY `FK_3` (`approveBy`),
  ADD KEY `FK_4` (`postId`),
  ADD KEY `FK_4_1` (`requestBy`);

--
-- Indexes for table `requestcoursedetail`
--
ALTER TABLE `requestcoursedetail`
  ADD PRIMARY KEY (`requestCourseDetailId`),
  ADD KEY `FK_2` (`requestCourseId`),
  ADD KEY `FK_3` (`courseId`);

--
-- Indexes for table `requestverify`
--
ALTER TABLE `requestverify`
  ADD PRIMARY KEY (`requestVerifyId`),
  ADD KEY `FK_2` (`approveBy`);

--
-- Indexes for table `requestverifydetail`
--
ALTER TABLE `requestverifydetail`
  ADD PRIMARY KEY (`requestVerifyDetail`),
  ADD KEY `FK_2` (`requestVerifyId`),
  ADD KEY `FK_3` (`userId`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staffId`),
  ADD KEY `FK_1` (`staffId`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`typeId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`),
  ADD KEY `FK_1` (`userId`),
  ADD KEY `followBy` (`followBy`);

--
-- Indexes for table `withdrawreport`
--
ALTER TABLE `withdrawreport`
  ADD PRIMARY KEY (`withdrawReportId`),
  ADD KEY `FK_2` (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `accountId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `approvewithdraw`
--
ALTER TABLE `approvewithdraw`
  MODIFY `approveWithdrawId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `approvewithdrawdetail`
--
ALTER TABLE `approvewithdrawdetail`
  MODIFY `approveWithdrawDetailId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `bankaccount`
--
ALTER TABLE `bankaccount`
  MODIFY `bankAccountId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `bookmark`
--
ALTER TABLE `bookmark`
  MODIFY `bookmarkId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `commentId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `commentlike`
--
ALTER TABLE `commentlike`
  MODIFY `commentLikeId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `courseId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `coursecreator`
--
ALTER TABLE `coursecreator`
  MODIFY `courseCreatorId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `imgcomment`
--
ALTER TABLE `imgcomment`
  MODIFY `imgComment` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `imgcourse`
--
ALTER TABLE `imgcourse`
  MODIFY `imgCourse` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `imgpost`
--
ALTER TABLE `imgpost`
  MODIFY `imgPostId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `imgverify`
--
ALTER TABLE `imgverify`
  MODIFY `imgVerifyId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `joincourse`
--
ALTER TABLE `joincourse`
  MODIFY `joinCourseId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `paymentcheck`
--
ALTER TABLE `paymentcheck`
  MODIFY `paymentId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `post`
--
ALTER TABLE `post`
  MODIFY `postId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `postlike`
--
ALTER TABLE `postlike`
  MODIFY `postLikeId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `report`
--
ALTER TABLE `report`
  MODIFY `reportId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `requestcourse`
--
ALTER TABLE `requestcourse`
  MODIFY `requestCourseId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `requestcoursedetail`
--
ALTER TABLE `requestcoursedetail`
  MODIFY `requestCourseDetailId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `requestverify`
--
ALTER TABLE `requestverify`
  MODIFY `requestVerifyId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `requestverifydetail`
--
ALTER TABLE `requestverifydetail`
  MODIFY `requestVerifyDetail` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
  MODIFY `typeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `withdrawreport`
--
ALTER TABLE `withdrawreport`
  MODIFY `withdrawReportId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `approvewithdraw`
--
ALTER TABLE `approvewithdraw`
  ADD CONSTRAINT `FK_38` FOREIGN KEY (`staffId`) REFERENCES `staff` (`staffId`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `approvewithdrawdetail`
--
ALTER TABLE `approvewithdrawdetail`
  ADD CONSTRAINT `FK_39` FOREIGN KEY (`withdrawReportId`) REFERENCES `withdrawreport` (`withdrawReportId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_40` FOREIGN KEY (`approveWithdrawId`) REFERENCES `approvewithdraw` (`approveWithdrawId`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `bookmark`
--
ALTER TABLE `bookmark`
  ADD CONSTRAINT `FK_14` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_9` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FK_13_2` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_5` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `commentlike`
--
ALTER TABLE `commentlike`
  ADD CONSTRAINT `FK_12` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_7` FOREIGN KEY (`commentId`) REFERENCES `comment` (`commentId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `FK_13_1` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_25` FOREIGN KEY (`typeId`) REFERENCES `type` (`typeId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_28_1` FOREIGN KEY (`createBy`) REFERENCES `coursecreator` (`courseCreatorId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `coursecreator`
--
ALTER TABLE `coursecreator`
  ADD CONSTRAINT `FK_28` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `imgcomment`
--
ALTER TABLE `imgcomment`
  ADD CONSTRAINT `FK_35` FOREIGN KEY (`commentId`) REFERENCES `comment` (`commentId`);

--
-- Constraints for table `imgcourse`
--
ALTER TABLE `imgcourse`
  ADD CONSTRAINT `FK_36` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`);

--
-- Constraints for table `imgpost`
--
ALTER TABLE `imgpost`
  ADD CONSTRAINT `FK_34` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`);

--
-- Constraints for table `imgverify`
--
ALTER TABLE `imgverify`
  ADD CONSTRAINT `FK_41` FOREIGN KEY (`requestVerifyId`) REFERENCES `requestverify` (`requestVerifyId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `joincourse`
--
ALTER TABLE `joincourse`
  ADD CONSTRAINT `FK_15` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `paymentcheck`
--
ALTER TABLE `paymentcheck`
  ADD CONSTRAINT `FK_20_2` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_21` FOREIGN KEY (`joinCourseId`) REFERENCES `joincourse` (`joinCourseId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_22` FOREIGN KEY (`approveBy`) REFERENCES `staff` (`staffId`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `FK_11` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_13` FOREIGN KEY (`typeId`) REFERENCES `type` (`typeId`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `postlike`
--
ALTER TABLE `postlike`
  ADD CONSTRAINT `FK_10` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_3` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `report`
--
ALTER TABLE `report`
  ADD CONSTRAINT `FK_29` FOREIGN KEY (`requestBy`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_30` FOREIGN KEY (`commentId`) REFERENCES `comment` (`commentId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_31` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_32` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `requestcourse`
--
ALTER TABLE `requestcourse`
  ADD CONSTRAINT `FK_19` FOREIGN KEY (`approveBy`) REFERENCES `staff` (`staffId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_20` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_20_1` FOREIGN KEY (`requestBy`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `requestcoursedetail`
--
ALTER TABLE `requestcoursedetail`
  ADD CONSTRAINT `FK_17` FOREIGN KEY (`requestCourseId`) REFERENCES `requestcourse` (`requestCourseId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_18` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `requestverify`
--
ALTER TABLE `requestverify`
  ADD CONSTRAINT `FK_25_1` FOREIGN KEY (`approveBy`) REFERENCES `staff` (`staffId`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `requestverifydetail`
--
ALTER TABLE `requestverifydetail`
  ADD CONSTRAINT `FK_27` FOREIGN KEY (`requestVerifyId`) REFERENCES `requestverify` (`requestVerifyId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_27_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `FK_16` FOREIGN KEY (`staffId`) REFERENCES `account` (`accountId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_9_1` FOREIGN KEY (`userId`) REFERENCES `account` (`accountId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`followBy`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `withdrawreport`
--
ALTER TABLE `withdrawreport`
  ADD CONSTRAINT `FK_37` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
