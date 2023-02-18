CREATE DATABASE IF NOT EXISTS `se` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `se`;

CREATE TABLE `Account`
(
 `accountId`   int NOT NULL ,
 `accountName` varchar(45) NOT NULL ,
 `pwd`         varchar(45) NOT NULL ,
 `title`       varchar(45) NOT NULL ,
 `firstName`   varchar(45) NOT NULL ,
 `lastName`    varchar(45) NOT NULL ,
 `phoneNumber` varchar(10) NOT NULL ,

PRIMARY KEY (`accountId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `User`
(
 `userId`       int NOT NULL ,
 `userName`     varchar(45) NOT NULL ,
 `verifyStatus` enum('yes','no') NOT NULL ,

PRIMARY KEY (`userId`),
KEY `FK_1` (`userId`),
CONSTRAINT `FK_9_1` FOREIGN KEY `FK_1` (`userId`) REFERENCES `Account` (`accountId`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Staff`
(
 `staffId`  int NOT NULL ,
 `position` varchar(45) NOT NULL ,

PRIMARY KEY (`staffId`),
KEY `FK_1` (`staffId`),
CONSTRAINT `FK_16` FOREIGN KEY `FK_1` (`staffId`) REFERENCES `Account` (`accountId`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `PostType`
(
 `postTypeId` int NOT NULL ,
 `type`       varchar(45) NOT NULL ,

PRIMARY KEY (`postTypeId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Post`
(
 `postId`     int NOT NULL ,
 `userId`     int NOT NULL ,
 `postTypeId` int NULL ,
 `postDetail` text NOT NULL ,

PRIMARY KEY (`postId`),
KEY `FK_3` (`postTypeId`),
CONSTRAINT `FK_13` FOREIGN KEY `FK_3` (`postTypeId`) REFERENCES `PostType` (`postTypeId`) ON DELETE SET NULL ON UPDATE CASCADE,
KEY `FK_3_1` (`userId`),
CONSTRAINT `FK_11` FOREIGN KEY `FK_3_1` (`userId`) REFERENCES `User` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Comment`
(
 `commentId`     int NOT NULL ,
 `postId`        int NOT NULL ,
 `userId`        int NOT NULL ,
 `commentDetail` text NOT NULL ,

PRIMARY KEY (`commentId`),
KEY `FK_2` (`postId`),
CONSTRAINT `FK_5` FOREIGN KEY `FK_2` (`postId`) REFERENCES `Post` (`postId`) ON DELETE CASCADE ON UPDATE CASCADE,
KEY `FK_3` (`userId`),
CONSTRAINT `FK_13_2` FOREIGN KEY `FK_3` (`userId`) REFERENCES `User` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `BookMark`
(
 `bookMarkId` int NOT NULL ,
 `postId`     int NOT NULL ,
 `userId`     int NOT NULL ,

PRIMARY KEY (`bookMarkId`),
KEY `FK_2` (`postId`),
CONSTRAINT `FK_9` FOREIGN KEY `FK_2` (`postId`) REFERENCES `Post` (`postId`) ON DELETE CASCADE ON UPDATE CASCADE,
KEY `FK_3` (`userId`),
CONSTRAINT `FK_14` FOREIGN KEY `FK_3` (`userId`) REFERENCES `User` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `CommentLike`
(
 `commentLike` int NOT NULL ,
 `commentId`   int NOT NULL ,
 `userId`      int NOT NULL ,

PRIMARY KEY (`commentLike`),
KEY `FK_2` (`commentId`),
CONSTRAINT `FK_7` FOREIGN KEY `FK_2` (`commentId`) REFERENCES `Comment` (`commentId`) ON DELETE CASCADE ON UPDATE CASCADE,
KEY `FK_3` (`userId`),
CONSTRAINT `FK_12` FOREIGN KEY `FK_3` (`userId`) REFERENCES `User` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Course`
(
 `courseId`     int NOT NULL ,
 `postId`       int NULL ,
 `courseDetail` varchar(45) NOT NULL ,
 `minimum`      int NOT NULL ,
 `maximum`      int NULL ,
 `price`        float NOT NULL ,
 `status`       enum('full','available') NOT NULL ,

PRIMARY KEY (`courseId`),
KEY `FK_3` (`postId`),
CONSTRAINT `FK_13_1` FOREIGN KEY `FK_3` (`postId`) REFERENCES `Post` (`postId`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `JoinCourse`
(
 `joinCourseId` int NOT NULL ,
 `userId`       int NOT NULL ,
 `courseId`     int NOT NULL ,

PRIMARY KEY (`joinCourseId`),
KEY `FK_3` (`courseId`),
CONSTRAINT `FK_15` FOREIGN KEY `FK_3` (`courseId`) REFERENCES `Course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE,
KEY `FK_3_1` (`userId`),
CONSTRAINT `FK_15_1` FOREIGN KEY `FK_3_1` (`userId`) REFERENCES `User` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `PostLike`
(
 `postLike` int NOT NULL ,
 `postId`   int NOT NULL ,
 `userId`   int NOT NULL ,

PRIMARY KEY (`postLike`),
KEY `FK_2` (`postId`),
CONSTRAINT `FK_3` FOREIGN KEY `FK_2` (`postId`) REFERENCES `Post` (`postId`) ON DELETE CASCADE ON UPDATE CASCADE,
KEY `FK_3` (`userId`),
CONSTRAINT `FK_10` FOREIGN KEY `FK_3` (`userId`) REFERENCES `User` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Request`
(
 `requestId`   int NOT NULL ,
 `requestBy`   int NOT NULL ,
 `postId`      int NOT NULL ,
 `approveBy`   int NOT NULL ,
 `status`      enum('waiting', 'approve', 'reject') NOT NULL ,
 `dateApprove` date NOT NULL ,

PRIMARY KEY (`requestId`),
KEY `FK_3` (`approveBy`),
CONSTRAINT `FK_19` FOREIGN KEY `FK_3` (`approveBy`) REFERENCES `Staff` (`staffId`) ON DELETE CASCADE ON UPDATE CASCADE,
KEY `FK_4` (`postId`),
CONSTRAINT `FK_20` FOREIGN KEY `FK_4` (`postId`) REFERENCES `Post` (`postId`) ON DELETE CASCADE ON UPDATE CASCADE,
KEY `FK_4_1` (`requestBy`),
CONSTRAINT `FK_20_1` FOREIGN KEY `FK_4_1` (`requestBy`) REFERENCES `User` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `RequestDetail`
(
 `requestDetailId` int NOT NULL ,
 `requestId`       int NOT NULL ,
 `courseId`        int NOT NULL ,

PRIMARY KEY (`requestDetailId`),
KEY `FK_2` (`requestId`),
CONSTRAINT `FK_17` FOREIGN KEY `FK_2` (`requestId`) REFERENCES `Request` (`requestId`) ON DELETE CASCADE ON UPDATE CASCADE,
KEY `FK_3` (`courseId`),
CONSTRAINT `FK_18` FOREIGN KEY `FK_3` (`courseId`) REFERENCES `Course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `PaymentCheck`
(
 `paymentId`    int NOT NULL ,
 `userId`       int NOT NULL ,
 `approveBy`    int NOT NULL ,
 `joinCourseId` int NOT NULL ,
 `status`       enum('yes','no') NOT NULL ,
 `moneySlip`    varchar(45) NOT NULL ,

PRIMARY KEY (`paymentId`),
KEY `FK_2` (`userId`),
CONSTRAINT `FK_20_2` FOREIGN KEY `FK_2` (`userId`) REFERENCES `User` (`userId`) ON DELETE NO ACTION ON UPDATE CASCADE,
KEY `FK_3` (`joinCourseId`),
CONSTRAINT `FK_21` FOREIGN KEY `FK_3` (`joinCourseId`) REFERENCES `JoinCourse` (`joinCourseId`) ON DELETE CASCADE ON UPDATE CASCADE,
KEY `FK_4` (`approveBy`),
CONSTRAINT `FK_22` FOREIGN KEY `FK_4` (`approveBy`) REFERENCES `Staff` (`staffId`) ON DELETE NO ACTION ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

