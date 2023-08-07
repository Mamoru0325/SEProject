-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 04, 2023 at 08:57 AM
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
CREATE DATABASE IF NOT EXISTS `se` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `se`;
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
  `commentDetail` text NOT NULL,
  `reportStatus` enum('Waiting','Done') DEFAULT 'Done',
  `createDate` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`commentId`, `postId`, `userId`, `commentDetail`, `reportStatus`, `createDate`) VALUES
(1, 1, 4, 'dfghjkl', 'Done', '2023-04-02 19:06:23'),
(2, 2, 5, 'sdfghjk', 'Done', '2023-04-02 19:06:23'),
(3, 1, 5, 'sdgfhgjhkjl', 'Done', '2023-04-02 19:06:23'),
(4, 1, 4, 'dfghjkl', 'Done', '2023-04-02 19:06:37'),
(5, 2, 5, 'sdfghjk', 'Done', '2023-04-02 19:06:37'),
(6, 1, 5, 'sdgfhgjhkjl', 'Done', '2023-04-02 19:06:37');

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
  `contentTypeId` int(11) NOT NULL,
  `courseTopic` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `userId` int(11) NOT NULL,
  `courseDetail` text NOT NULL,
  `minimum` int(11) NOT NULL,
  `maximum` int(11) NOT NULL,
  `price` double NOT NULL,
  `status` enum('Full','Available') NOT NULL DEFAULT 'Available',
  `reportStatus` enum('Waiting','Done') DEFAULT 'Done',
  `firstEnrollDate` date NOT NULL,
  `lastEnrollDate` date NOT NULL,
  `eventDate` date NOT NULL,
  `startDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `endDate` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`courseId`, `contentTypeId`, `courseTopic`, `userId`, `courseDetail`, `minimum`, `maximum`, `price`, `status`, `reportStatus`, `firstEnrollDate`, `lastEnrollDate`, `eventDate`, `startDate`, `endDate`) VALUES
(1, 1, 'service', 6, 'service', 5, 30, 100, 'Available', 'Done', '2023-03-24', '2023-03-24', '2023-03-24', '2023-03-23 17:00:00', '2023-03-23 17:00:00'),
(2, 1, 'service2', 6, 'service2', 5, 30, 100, 'Available', 'Done', '2023-03-24', '2023-03-24', '2023-03-24', '2023-03-23 17:00:00', '2023-03-23 17:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `follower`
--

CREATE TABLE `follower` (
  `followerId` int(11) NOT NULL,
  `followTo` int(11) NOT NULL,
  `followBy` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `follower`
--

INSERT INTO `follower` (`followerId`, `followTo`, `followBy`) VALUES
(1, 6, 4),
(2, 6, 5),
(3, 6, 7);

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

--
-- Dumping data for table `imgpost`
--

INSERT INTO `imgpost` (`imgPostId`, `postId`, `imgPath`) VALUES
(1, 1, './image\\Slip\\postId1\\1.JPG'),
(2, 1, 'file'),
(3, 1, 'D:/se/se-web-api-alllearn/public/image\\Slip\\postId1\\1.JPG'),
(4, 1, 'D:/se/se-web-api-alllearn/public/image\\Slip\\postId1\\1.JPG'),
(5, 1, 'D:/se/se-web-api-alllearn/public/image\\Post\\postId1\\1.JPG'),
(6, 1, 'D:/se/se-web-api-alllearn/public/image\\Post\\postId1\\1.JPG'),
(7, 1, '..\\Post\\postId1\\1.JPG'),
(8, 1, '..\\Post\\postId1\\1.JPG');

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
  `courseId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `joincourse`
--

INSERT INTO `joincourse` (`joinCourseId`, `courseId`) VALUES
(5, 1),
(6, 1),
(7, 1),
(8, 2);

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

--
-- Dumping data for table `likepost`
--

INSERT INTO `likepost` (`likePostId`, `postId`, `userId`) VALUES
(1, 1, 3),
(2, 1, 4),
(3, 1, 5),
(5, 1, 7),
(4, 2, 6),
(6, 2, 8);

-- --------------------------------------------------------

--
-- Table structure for table `paymentcheck`
--

CREATE TABLE `paymentcheck` (
  `paymentCheckId` int(11) NOT NULL,
  `payBy` int(11) NOT NULL,
  `joinCourseId` int(11) NOT NULL,
  `status` enum('Paid','Unpaid','Waiting') NOT NULL DEFAULT 'Waiting',
  `qrCodePath` varchar(150) NOT NULL,
  `slipPath` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `paymentcheck`
--

INSERT INTO `paymentcheck` (`paymentCheckId`, `payBy`, `joinCourseId`, `status`, `qrCodePath`, `slipPath`) VALUES
(1, 3, 5, 'Waiting', '../image\\Qrcode\\courseId1\\5.png', ''),
(2, 4, 6, 'Waiting', '../image\\Qrcode\\courseId1\\5.png', ''),
(3, 4, 8, 'Waiting', '../image\\Qrcode\\courseId1\\5.png', ''),
(4, 5, 7, 'Waiting', '../image\\Qrcode\\courseId1\\5.png', '');

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE `post` (
  `postId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `contentTypeId` int(11) NOT NULL,
  `postTopic` varchar(255) NOT NULL,
  `postDetail` text NOT NULL,
  `reportStatus` enum('Waiting','Done') DEFAULT 'Done',
  `createDate` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`postId`, `userId`, `contentTypeId`, `postTopic`, `postDetail`, `reportStatus`, `createDate`) VALUES
(1, 3, 1, 'service', 'do it pokpong', 'Waiting', '2023-03-21 00:00:00'),
(2, 3, 1, 'service1', 'do it pokpong', 'Done', '2023-03-22 11:00:00'),
(3, 3, 1, 'service2', 'do it pokpong', 'Done', '2023-03-23 11:00:00'),
(4, 3, 1, 'service3', 'do it pokpong', 'Done', '2023-03-24 11:00:00');

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
  `reportDetail` text NOT NULL,
  `status` enum('Approve','Waiting') NOT NULL DEFAULT 'Waiting'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `report`
--

INSERT INTO `report` (`reportId`, `reportTypeId`, `postId`, `commentId`, `courseId`, `userId`, `reportDetail`, `status`) VALUES
(1, 1, 1, NULL, NULL, 3, 'pokpong', 'Waiting'),
(2, 1, 1, NULL, NULL, 3, 'pokpong', 'Waiting');

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
-- Table structure for table `requestcourse`
--

CREATE TABLE `requestcourse` (
  `requestCourseId` int(11) NOT NULL,
  `topic` varchar(255) NOT NULL,
  `detail` text NOT NULL,
  `requestTo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `requestverify`
--

CREATE TABLE `requestverify` (
  `requestVerifyId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `staffId` int(11) DEFAULT NULL,
  `verifyType` enum('verify','attitude') NOT NULL,
  `verifyHeader` varchar(255) NOT NULL,
  `verifyDetail` text NOT NULL,
  `approveStatus` enum('Approve','Waiting','Reject') NOT NULL DEFAULT 'Waiting',
  `dateApprove` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `requestverify`
--

INSERT INTO `requestverify` (`requestVerifyId`, `userId`, `staffId`, `verifyType`, `verifyHeader`, `verifyDetail`, `approveStatus`, `dateApprove`) VALUES
(1, 3, NULL, 'verify', 'service', 'do it pokpong', 'Waiting', '2023-03-24');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `roleId` int(11) NOT NULL,
  `roleName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`roleId`, `roleName`) VALUES
(1, 'ROLE_User'),
(2, 'ROLE_Staff'),
(3, 'ROLE_SystemAdmin'),
(4, 'ROLE_CourseCreator');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `title` varchar(10) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `phoneNumber` varchar(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `imgPath` varchar(150) NOT NULL,
  `backgroundPath` varchar(150) NOT NULL,
  `verifyStatus` enum('Y','N') NOT NULL DEFAULT 'N',
  `detail` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `email`, `password`, `title`, `firstName`, `lastName`, `phoneNumber`, `username`, `imgPath`, `backgroundPath`, `verifyStatus`, `detail`) VALUES
(1, 'admin@hotmail.com', '$2a$10$a1l6WI0b02CU.BMy3k6NnujFnQRPTncydqmPY3S3DoFQf26.DQzrK', 'Mr', 'admin', 'admin', '0896345911', 'admin', 'dd', 'dd', 'Y', ''),
(2, 'staff@hotmail.com', '$2a$10$KsBCSQd56QysbLE2zwI29Obs3dJXterNDpjK5mpzx07oqH6lS4qqa', 'Mr', 'staff', 'staff', '0896345911', 'staff', 'dd', 'dd', 'Y', ''),
(3, 'user@hotmail.com', '$2a$10$gRAnr2TAg/psqZH2Huv6seXmGP/vVDeBDHDBQ97omeTLG8IH4Cn..', 'Mr', 'user', 'user', '0896345911', 'user', 'dd', 'dd', 'Y', ''),
(4, 'user1@hotmail.com', '$2a$10$gRAnr2TAg/psqZH2Huv6seXmGP/vVDeBDHDBQ97omeTLG8IH4Cn..', 'Mr', 'user1', 'user1', '0896345911', 'user1', 'dd', 'dd', 'Y', ''),
(5, 'user2@hotmail.com', '$2a$10$gRAnr2TAg/psqZH2Huv6seXmGP/vVDeBDHDBQ97omeTLG8IH4Cn..', 'Mr', 'user2', 'user2', '0896345911', 'user2', 'dd', 'dd', 'N', ''),
(6, 'user3@hotmail.com', '$2a$10$gRAnr2TAg/psqZH2Huv6seXmGP/vVDeBDHDBQ97omeTLG8IH4Cn..', 'Mr', 'user3', 'user3', '0896345911', 'user3', 'dd', 'dd', 'Y', ''),
(7, 'user4@hotmail.com', '$2a$10$gRAnr2TAg/psqZH2Huv6seXmGP/vVDeBDHDBQ97omeTLG8IH4Cn..', 'Mr', 'user4', 'user4', '0896345911', 'user4', 'dd', 'dd', 'Y', ''),
(8, 'user5@hotmail.com', '$2a$10$gRAnr2TAg/psqZH2Huv6seXmGP/vVDeBDHDBQ97omeTLG8IH4Cn..', 'Mr', 'user5', 'user5', '0896345911', 'user5', 'dd', 'dd', 'N', ''),
(9, 'user6@hotmail.com', '$2a$10$qeU5VmKnI8HsbfMjb46ZTe.jnv4HmYp0zx5eAqLFyStK943oacfYG', 'Mr', 'user6', 'user6', '0896345911', 'user6', 'hh', 'hh', 'N', ''),
(10, 'staff1@hotmail.com', '$2a$10$gj3kH.iUN146bbMMnupkZeuDboCS.6jpphZHHT64Ibh7SR9e/eI92', 'Mr', 'staff1', 'staff1', '0896345911', 'staff1', 'hh', 'hh', 'Y', ''),
(11, 'user7@hhotmail.com', '$2a$10$3MfJ8pQU7mlqXRISN5R7hOredd4JHfHDGEPdLPXiKhzDfwQGFJcd2', 'mr', 'user7', 'user7', '0896345911', 'user7', 'D:/image\\Userprofile\\Profile\\basic.png\n', 'D:/image\\Userprofile\\Background\\basic.jpg', 'N', ''),
(12, 'user8@hotmail.com', '$2a$10$bGmf3MBNd/1GRZcXt0ln4.bw6brB5t6Wp9xjU7meNPaJUU.Y6CQy.', 'mr', 'user8', 'user8', '0896345911', 'user8', 'D:/image\\Userprofile\\Profile\\basic.png', 'D:/image\\Userprofile\\Background\\basic.jpg', 'N', '');

-- --------------------------------------------------------

--
-- Table structure for table `userrole`
--

CREATE TABLE `userrole` (
  `userRoleId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `userrole`
--

INSERT INTO `userrole` (`userRoleId`, `userId`, `roleId`) VALUES
(3, 1, 3),
(5, 2, 2),
(6, 3, 1),
(7, 4, 1),
(8, 5, 1),
(9, 6, 1),
(10, 6, 4),
(11, 7, 1),
(12, 7, 4),
(13, 8, 1),
(14, 9, 1),
(16, 10, 2),
(17, 11, 1),
(18, 12, 1);

--
-- Indexes for dumped tables
--

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
  ADD KEY `TC_Course339` (`userId`),
  ADD KEY `contentTypeId` (`contentTypeId`);

--
-- Indexes for table `follower`
--
ALTER TABLE `follower`
  ADD PRIMARY KEY (`followerId`),
  ADD KEY `followTo` (`followTo`),
  ADD KEY `followBy` (`followBy`);

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
  ADD KEY `TC_JoinCourse345` (`courseId`);

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
  ADD UNIQUE KEY `postId` (`postId`,`userId`),
  ADD KEY `TC_LikePost328` (`postId`),
  ADD KEY `TC_LikePost327` (`userId`);

--
-- Indexes for table `paymentcheck`
--
ALTER TABLE `paymentcheck`
  ADD PRIMARY KEY (`paymentCheckId`),
  ADD KEY `userId` (`payBy`),
  ADD KEY `joinCourseId` (`joinCourseId`);

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
-- Indexes for table `requestcourse`
--
ALTER TABLE `requestcourse`
  ADD PRIMARY KEY (`requestCourseId`),
  ADD KEY `requestTo` (`requestTo`);

--
-- Indexes for table `requestverify`
--
ALTER TABLE `requestverify`
  ADD PRIMARY KEY (`requestVerifyId`),
  ADD KEY `TC_requestVerify341` (`userId`),
  ADD KEY `TC_requestVerify342` (`staffId`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`roleId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `email_2` (`email`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `userrole`
--
ALTER TABLE `userrole`
  ADD PRIMARY KEY (`userRoleId`),
  ADD UNIQUE KEY `userId_2` (`userId`,`roleId`),
  ADD KEY `userId` (`userId`),
  ADD KEY `roleId` (`roleId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookmark`
--
ALTER TABLE `bookmark`
  MODIFY `bookmarkId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `commentId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `contenttype`
--
ALTER TABLE `contenttype`
  MODIFY `contentTypeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `courseId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `follower`
--
ALTER TABLE `follower`
  MODIFY `followerId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

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
  MODIFY `imgPostId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `imgverify`
--
ALTER TABLE `imgverify`
  MODIFY `imgVerifyId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `joincourse`
--
ALTER TABLE `joincourse`
  MODIFY `joinCourseId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `likecomment`
--
ALTER TABLE `likecomment`
  MODIFY `likeCommentId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `likepost`
--
ALTER TABLE `likepost`
  MODIFY `likePostId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `paymentcheck`
--
ALTER TABLE `paymentcheck`
  MODIFY `paymentCheckId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `post`
--
ALTER TABLE `post`
  MODIFY `postId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `report`
--
ALTER TABLE `report`
  MODIFY `reportId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `reporttype`
--
ALTER TABLE `reporttype`
  MODIFY `reportTypeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `requestcourse`
--
ALTER TABLE `requestcourse`
  MODIFY `requestCourseId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `requestverify`
--
ALTER TABLE `requestverify`
  MODIFY `requestVerifyId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `roleId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `userrole`
--
ALTER TABLE `userrole`
  MODIFY `userRoleId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookmark`
--
ALTER TABLE `bookmark`
  ADD CONSTRAINT `FK_Bookmark176` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bookmark_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FK_Comment175` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`contentTypeId`) REFERENCES `contenttype` (`contentTypeId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `course_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `follower`
--
ALTER TABLE `follower`
  ADD CONSTRAINT `follower_ibfk_1` FOREIGN KEY (`followTo`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `follower_ibfk_2` FOREIGN KEY (`followBy`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

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
  ADD CONSTRAINT `FK_JoinCourse186` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `likecomment`
--
ALTER TABLE `likecomment`
  ADD CONSTRAINT `FK_LikeComment181` FOREIGN KEY (`commentId`) REFERENCES `comment` (`commentId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `likecomment_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `likepost`
--
ALTER TABLE `likepost`
  ADD CONSTRAINT `FK_LikePost174` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `likepost_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `paymentcheck`
--
ALTER TABLE `paymentcheck`
  ADD CONSTRAINT `paymentcheck_ibfk_2` FOREIGN KEY (`joinCourseId`) REFERENCES `joincourse` (`joinCourseId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `paymentcheck_ibfk_3` FOREIGN KEY (`payBy`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `FK_Post179` FOREIGN KEY (`contentTypeId`) REFERENCES `contenttype` (`contentTypeId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `post_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `report`
--
ALTER TABLE `report`
  ADD CONSTRAINT `FK_Report183` FOREIGN KEY (`reportTypeId`) REFERENCES `reporttype` (`reportTypeId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `report_ibfk_1` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `report_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `report_ibfk_3` FOREIGN KEY (`commentId`) REFERENCES `comment` (`commentId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `report_ibfk_4` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `requestcourse`
--
ALTER TABLE `requestcourse`
  ADD CONSTRAINT `requestcourse_ibfk_1` FOREIGN KEY (`requestTo`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `requestverify`
--
ALTER TABLE `requestverify`
  ADD CONSTRAINT `requestverify_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `requestverify_ibfk_2` FOREIGN KEY (`staffId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `userrole`
--
ALTER TABLE `userrole`
  ADD CONSTRAINT `userrole_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `userrole_ibfk_3` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
