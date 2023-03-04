-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 04, 2023 at 06:19 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `se`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `accountId` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `title` varchar(10) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `phoneNumber` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`accountId`, `email`, `password`, `title`, `firstName`, `lastName`, `phoneNumber`) VALUES
(1, 'pokpongthunder789@gmail.com', '123456', 'mr', 'paweenwich', 'thadee', '0896345911');

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
  `commentDetail` varchar(255) NOT NULL,
  `createDate` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `contenttype`
--

CREATE TABLE `contenttype` (
  `contentTypeId` int(11) NOT NULL,
  `typeName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contenttype`
--

INSERT INTO `contenttype` (`contentTypeId`, `typeName`) VALUES
(1, 'เทคโนโลยี'),
(2, 'อาหาร'),
(3, 'กีฬา'),
(4, 'การแพทย์'),
(5, 'สุขภาพ'),
(6, 'ทั่วไป');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `courseId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `courseDetail` varchar(255) NOT NULL,
  `minimum` int(11) NOT NULL,
  `maximum` int(11) NOT NULL,
  `price` double NOT NULL,
  `status` enum('Full','Available') NOT NULL DEFAULT 'Available',
  `firstEnrollDate` date NOT NULL,
  `lastEnrollDate` date NOT NULL,
  `eventDate` date NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `imgcomment`
--

CREATE TABLE `imgcomment` (
  `imgCommentId` int(11) NOT NULL,
  `commentId` int(11) NOT NULL,
  `imgPath` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `imgcourse`
--

CREATE TABLE `imgcourse` (
  `imgCourseId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  `imgPath` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `imgpost`
--

CREATE TABLE `imgpost` (
  `imgPostId` int(11) NOT NULL,
  `postId` int(11) NOT NULL,
  `imgPath` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `imgverify`
--

CREATE TABLE `imgverify` (
  `imgVerifyId` int(11) NOT NULL,
  `requestVerifyId` int(11) NOT NULL,
  `imgPath` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `joincourse`
--

CREATE TABLE `joincourse` (
  `joinCourseId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `likecomment`
--

CREATE TABLE `likecomment` (
  `likeCommentId` int(11) NOT NULL,
  `commentId` int(11) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `likepost`
--

CREATE TABLE `likepost` (
  `likePostId` int(11) NOT NULL,
  `postId` int(11) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE `post` (
  `postId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `contentTypeId` int(11) NOT NULL,
  `postHeader` varchar(255) NOT NULL,
  `postDetail` varchar(255) NOT NULL,
  `createDate` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE `report` (
  `reportId` int(11) NOT NULL,
  `reportTypeId` int(11) NOT NULL,
  `postId` int(11) DEFAULT NULL,
  `commentId` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  `reportDetail` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `reporttype`
--

CREATE TABLE `reporttype` (
  `reportTypeId` int(11) NOT NULL,
  `typeName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reporttype`
--

INSERT INTO `reporttype` (`reportTypeId`, `typeName`) VALUES
(1, 'อนาจาร,คุกคามทางเพศ'),
(2, 'คำหยาบคาย'),
(3, 'เนื้อหาไม่เหมาะสม');

-- --------------------------------------------------------

--
-- Table structure for table `requestverify`
--

CREATE TABLE `requestverify` (
  `requestVerifyId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `staffId` int(11) NOT NULL,
  `verifyHeader` varchar(255) NOT NULL,
  `verifyDetail` varchar(255) NOT NULL,
  `approveStatus` enum('Approve','Waiting','Reject') NOT NULL DEFAULT 'Waiting',
  `dateApprove` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staffId` int(11) NOT NULL,
  `position` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `imgPath` varchar(150) NOT NULL,
  `backgroundPath` varchar(150) NOT NULL,
  `verifyStatus` enum('Y','N') NOT NULL DEFAULT 'N',
  `type` enum('Nomal','CourseCreator') NOT NULL DEFAULT 'Nomal'
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
-- Indexes for table `bookmark`
--
ALTER TABLE `bookmark`
  ADD PRIMARY KEY (`bookmarkId`),
  ADD KEY `TC_Bookmark333` (`userId`),
  ADD KEY `TC_Bookmark332` (`postId`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`commentId`),
  ADD KEY `TC_Comment325` (`postId`),
  ADD KEY `TC_Comment326` (`userId`);

--
-- Indexes for table `contenttype`
--
ALTER TABLE `contenttype`
  ADD PRIMARY KEY (`contentTypeId`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`courseId`),
  ADD KEY `TC_Course339` (`userId`);

--
-- Indexes for table `imgcomment`
--
ALTER TABLE `imgcomment`
  ADD PRIMARY KEY (`imgCommentId`),
  ADD KEY `TC_ImgComment329` (`commentId`);

--
-- Indexes for table `imgcourse`
--
ALTER TABLE `imgcourse`
  ADD PRIMARY KEY (`imgCourseId`),
  ADD KEY `TC_ImgCourse340` (`courseId`);

--
-- Indexes for table `imgpost`
--
ALTER TABLE `imgpost`
  ADD PRIMARY KEY (`imgPostId`),
  ADD KEY `TC_ImgPost324` (`postId`);

--
-- Indexes for table `imgverify`
--
ALTER TABLE `imgverify`
  ADD PRIMARY KEY (`imgVerifyId`),
  ADD KEY `TC_ImgVerify343` (`requestVerifyId`);

--
-- Indexes for table `joincourse`
--
ALTER TABLE `joincourse`
  ADD PRIMARY KEY (`joinCourseId`),
  ADD KEY `TC_JoinCourse345` (`courseId`),
  ADD KEY `TC_JoinCourse344` (`userId`);

--
-- Indexes for table `likecomment`
--
ALTER TABLE `likecomment`
  ADD PRIMARY KEY (`likeCommentId`),
  ADD KEY `TC_LikeComment330` (`commentId`),
  ADD KEY `TC_LikeComment331` (`userId`);

--
-- Indexes for table `likepost`
--
ALTER TABLE `likepost`
  ADD PRIMARY KEY (`likePostId`),
  ADD KEY `TC_LikePost328` (`postId`),
  ADD KEY `TC_LikePost327` (`userId`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`postId`),
  ADD KEY `TC_Post322` (`userId`),
  ADD KEY `TC_Post323` (`contentTypeId`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`reportId`),
  ADD KEY `TC_Report336` (`reportTypeId`),
  ADD KEY `TC_Report334` (`userId`),
  ADD KEY `postId` (`postId`),
  ADD KEY `commentId` (`commentId`),
  ADD KEY `courseId` (`courseId`);

--
-- Indexes for table `reporttype`
--
ALTER TABLE `reporttype`
  ADD PRIMARY KEY (`reportTypeId`);

--
-- Indexes for table `requestverify`
--
ALTER TABLE `requestverify`
  ADD PRIMARY KEY (`requestVerifyId`),
  ADD KEY `TC_requestVerify341` (`userId`),
  ADD KEY `TC_requestVerify342` (`staffId`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staffId`),
  ADD KEY `TC_Staff321` (`staffId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`),
  ADD KEY `TC_User320` (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `accountId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
-- AUTO_INCREMENT for table `contenttype`
--
ALTER TABLE `contenttype`
  MODIFY `contentTypeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `courseId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `imgcomment`
--
ALTER TABLE `imgcomment`
  MODIFY `imgCommentId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `imgcourse`
--
ALTER TABLE `imgcourse`
  MODIFY `imgCourseId` int(11) NOT NULL AUTO_INCREMENT;

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
-- AUTO_INCREMENT for table `likecomment`
--
ALTER TABLE `likecomment`
  MODIFY `likeCommentId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `likepost`
--
ALTER TABLE `likepost`
  MODIFY `likePostId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `post`
--
ALTER TABLE `post`
  MODIFY `postId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `report`
--
ALTER TABLE `report`
  MODIFY `reportId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reporttype`
--
ALTER TABLE `reporttype`
  MODIFY `reportTypeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `requestverify`
--
ALTER TABLE `requestverify`
  MODIFY `requestVerifyId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookmark`
--
ALTER TABLE `bookmark`
  ADD CONSTRAINT `FK_Bookmark176` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Bookmark195` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FK_Comment175` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Comment193` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `FK_Course188` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `imgcomment`
--
ALTER TABLE `imgcomment`
  ADD CONSTRAINT `FK_ImgComment180` FOREIGN KEY (`commentId`) REFERENCES `comment` (`commentId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `imgcourse`
--
ALTER TABLE `imgcourse`
  ADD CONSTRAINT `FK_ImgCourse185` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `imgpost`
--
ALTER TABLE `imgpost`
  ADD CONSTRAINT `FK_ImgPost178` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `imgverify`
--
ALTER TABLE `imgverify`
  ADD CONSTRAINT `FK_ImgVerify187` FOREIGN KEY (`requestVerifyId`) REFERENCES `requestverify` (`requestVerifyId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `joincourse`
--
ALTER TABLE `joincourse`
  ADD CONSTRAINT `FK_JoinCourse186` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_JoinCourse191` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `likecomment`
--
ALTER TABLE `likecomment`
  ADD CONSTRAINT `FK_LikeComment181` FOREIGN KEY (`commentId`) REFERENCES `comment` (`commentId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_LikeComment189` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `likepost`
--
ALTER TABLE `likepost`
  ADD CONSTRAINT `FK_LikePost174` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_LikePost190` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `FK_Post179` FOREIGN KEY (`contentTypeId`) REFERENCES `contenttype` (`contentTypeId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Post196` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `report`
--
ALTER TABLE `report`
  ADD CONSTRAINT `FK_Report183` FOREIGN KEY (`reportTypeId`) REFERENCES `reporttype` (`reportTypeId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Report192` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `report_ibfk_1` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `report_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `report_ibfk_3` FOREIGN KEY (`commentId`) REFERENCES `comment` (`commentId`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `requestverify`
--
ALTER TABLE `requestverify`
  ADD CONSTRAINT `FK_requestVerify194` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_requestVerify198` FOREIGN KEY (`staffId`) REFERENCES `staff` (`staffId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `FK_Staff199` FOREIGN KEY (`staffId`) REFERENCES `account` (`accountId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_User197` FOREIGN KEY (`userId`) REFERENCES `account` (`accountId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
