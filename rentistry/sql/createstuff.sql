INSERT INTO `rentistry`.`rent_user` (`id`, `account_expired`, `account_locked`, `credentials_expired`, `enabled`, `first_name`, `last_name`, `password`, `user_email`, `version`) VALUES (1, 0, 0, 0, 1, 'admin', 'admin', '9ff522475843d3ac98545d00d3e6bf0c4c67723c8b6286aa62214b3180189a96', 'austin.riba@gmail.com', 0);
INSERT INTO `authority` VALUES (1, 'ROLE_ADMIN', 0);


INSERT INTO `rent_user_given_authorities` VALUES (1,1);