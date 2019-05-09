-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 2019-05-10 00:04:13
-- 服务器版本： 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `monitor`
--

-- --------------------------------------------------------

--
-- 表的结构 `logon`
--

DROP TABLE IF EXISTS `logon`;
CREATE TABLE IF NOT EXISTS `logon` (
  `id` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `level` varchar(10) DEFAULT NULL,
  KEY `logon` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `logon`
--

INSERT INTO `logon` (`id`, `password`, `level`) VALUES
('admin', 'admin', 'admin');

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `email` varchar(20) DEFAULT NULL COMMENT '联系邮箱',
  `join_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `join_time`) VALUES
('admin', 'zeyu', 'zyzhang1997@163.com', '2019-04-28 07:31:25'),
('test1', 'aaa', NULL, '2019-04-28 07:32:18');

-- --------------------------------------------------------

--
-- 表的结构 `user_log`
--

DROP TABLE IF EXISTS `user_log`;
CREATE TABLE IF NOT EXISTS `user_log` (
  `id` varchar(20) NOT NULL,
  `log_in` timestamp NOT NULL,
  `ip_address` varchar(20) NOT NULL,
  KEY `log` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 限制导出的表
--

--
-- 限制表 `logon`
--
ALTER TABLE `logon`
  ADD CONSTRAINT `logon` FOREIGN KEY (`id`) REFERENCES `user` (`id`);

--
-- 限制表 `user_log`
--
ALTER TABLE `user_log`
  ADD CONSTRAINT `log` FOREIGN KEY (`id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
