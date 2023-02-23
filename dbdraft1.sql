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
 `imgPath`      varchar(150) NOT NULL ,

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

CREATE TABLE `Type`
(
 `typeId` int NOT NULL ,
 `type`   varchar(45) NOT NULL ,

PRIMARY KEY (`typeId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Post`
(
 `postId`     int NOT NULL ,
 `userId`     int NOT NULL ,
 `typeId`     int NULL ,
 `postDetail` text NOT NULL ,
 `imgPath`    varchar(150) NOT NULL ,

PRIMARY KEY (`postId`),
KEY `FK_3` (`typeId`),
CONSTRAINT `FK_13` FOREIGN KEY `FK_3` (`typeId`) REFERENCES `Type` (`typeId`) ON DELETE SET NULL ON UPDATE CASCADE,
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

CREATE TABLE `CourseCreator`
(
 `courseCreatorId` int NOT NULL ,
 `userId`          int NOT NULL ,
 `balance`         float NOT NULL ,

PRIMARY KEY (`courseCreatorId`),
KEY `FK_2` (`userId`),
CONSTRAINT `FK_28` FOREIGN KEY `FK_2` (`userId`) REFERENCES `User` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Course`
(
 `courseId`        int NOT NULL ,
 `createBy`        int NOT NULL ,
 `typeId`          int NOT NULL ,
 `postId`          int NULL ,
 `courseDetail`    varchar(45) NOT NULL ,
 `minimum`         int NOT NULL ,
 `maximum`         int NULL ,
 `price`           float NOT NULL ,
 `status`          enum('full','available') NOT NULL ,
 `firstEnrollDate` date NOT NULL ,
 `lastEnrollDate`  date NOT NULL ,
 `eventDay`        date NOT NULL ,
 `startTime`       varchar(45) NOT NULL ,
 `endTime`         varchar(45) NOT NULL ,

PRIMARY KEY (`courseId`),
KEY `FK_3` (`postId`),
CONSTRAINT `FK_13_1` FOREIGN KEY `FK_3` (`postId`) REFERENCES `Post` (`postId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
KEY `FK_4` (`typeId`),
CONSTRAINT `FK_25` FOREIGN KEY `FK_4` (`typeId`) REFERENCES `Type` (`typeId`) ON DELETE NO ACTION ON UPDATE CASCADE,
KEY `FK_4_1` (`createBy`),
CONSTRAINT `FK_28_1` FOREIGN KEY `FK_4_1` (`createBy`) REFERENCES `CourseCreator` (`courseCreatorId`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `JoinCourse`
(
 `joinCourseId` int NOT NULL ,
 `courseId`     int NOT NULL ,

PRIMARY KEY (`joinCourseId`),
KEY `FK_3` (`courseId`),
CONSTRAINT `FK_15` FOREIGN KEY `FK_3` (`courseId`) REFERENCES `Course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE
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

CREATE TABLE `RequestCourse`
(
 `requestCourseId` int NOT NULL ,
 `requestBy`       int NOT NULL ,
 `postId`          int NOT NULL ,
 `approveBy`       int NOT NULL ,
 `status`          enum('waiting', 'approve', 'reject') NOT NULL ,
 `dateApprove`     date NOT NULL ,
 `dateExprie`      date NOT NULL ,

PRIMARY KEY (`requestCourseId`),
KEY `FK_3` (`approveBy`),
CONSTRAINT `FK_19` FOREIGN KEY `FK_3` (`approveBy`) REFERENCES `Staff` (`staffId`) ON DELETE NO ACTION ON UPDATE CASCADE,
KEY `FK_4` (`postId`),
CONSTRAINT `FK_20` FOREIGN KEY `FK_4` (`postId`) REFERENCES `Post` (`postId`) ON DELETE CASCADE ON UPDATE CASCADE,
KEY `FK_4_1` (`requestBy`),
CONSTRAINT `FK_20_1` FOREIGN KEY `FK_4_1` (`requestBy`) REFERENCES `User` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `RequestCourseDetail`
(
 `requestCourseDetailId` int NOT NULL ,
 `requestCourseId`       int NOT NULL ,
 `courseId`              int NOT NULL ,

PRIMARY KEY (`requestCourseDetailId`),
KEY `FK_2` (`requestCourseId`),
CONSTRAINT `FK_17` FOREIGN KEY `FK_2` (`requestCourseId`) REFERENCES `RequestCourse` (`requestCourseId`) ON DELETE CASCADE ON UPDATE CASCADE,
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
 `imgPath`      varchar(150) NOT NULL ,

PRIMARY KEY (`paymentId`),
KEY `FK_2` (`userId`),
CONSTRAINT `FK_20_2` FOREIGN KEY `FK_2` (`userId`) REFERENCES `User` (`userId`) ON DELETE NO ACTION ON UPDATE CASCADE,
KEY `FK_3` (`joinCourseId`),
CONSTRAINT `FK_21` FOREIGN KEY `FK_3` (`joinCourseId`) REFERENCES `JoinCourse` (`joinCourseId`) ON DELETE CASCADE ON UPDATE CASCADE,
KEY `FK_4` (`approveBy`),
CONSTRAINT `FK_22` FOREIGN KEY `FK_4` (`approveBy`) REFERENCES `Staff` (`staffId`) ON DELETE NO ACTION ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Report`
(
 `reportId`  int NOT NULL ,
 `requestBy` int NOT NULL ,
 `courseId`  int NULL ,
 `postId`    int NULL ,
 `commentId` int NULL ,

PRIMARY KEY (`reportId`),
KEY `FK_2` (`requestBy`),
CONSTRAINT `FK_29` FOREIGN KEY `FK_2` (`requestBy`) REFERENCES `User` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
KEY `FK_3` (`commentId`),
CONSTRAINT `FK_30` FOREIGN KEY `FK_3` (`commentId`) REFERENCES `Comment` (`commentId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
KEY `FK_4` (`postId`),
CONSTRAINT `FK_31` FOREIGN KEY `FK_4` (`postId`) REFERENCES `Post` (`postId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
KEY `FK_5` (`courseId`),
CONSTRAINT `FK_32` FOREIGN KEY `FK_5` (`courseId`) REFERENCES `Course` (`courseId`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `RequestVerify`
(
 `requestVerifyId` int NOT NULL ,
 `approveBy`       int NOT NULL ,
 `status`          enum('waiting', 'approve', 'reject') NOT NULL ,
 `note`            text NOT NULL ,
 `imgPath`         varchar(150) NOT NULL ,

PRIMARY KEY (`requestVerifyId`),
KEY `FK_2` (`approveBy`),
CONSTRAINT `FK_25_1` FOREIGN KEY `FK_2` (`approveBy`) REFERENCES `Staff` (`staffId`) ON DELETE NO ACTION ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `RequestVerifyDetail`
(
 `requestVerifyDetail` int NOT NULL ,
 `requestVerifyId`     int NOT NULL ,
 `userId`              int NOT NULL ,

PRIMARY KEY (`requestVerifyDetail`),
KEY `FK_2` (`requestVerifyId`),
CONSTRAINT `FK_27` FOREIGN KEY `FK_2` (`requestVerifyId`) REFERENCES `RequestVerify` (`requestVerifyId`) ON DELETE CASCADE ON UPDATE CASCADE,
KEY `FK_3` (`userId`),
CONSTRAINT `FK_27_1` FOREIGN KEY `FK_3` (`userId`) REFERENCES `User` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;