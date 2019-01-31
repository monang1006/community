/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/1/31 11:09:23                           */
/*==============================================================*/


DROP TABLE IF EXISTS T_COMMUNITY_ATTENTION;

DROP TABLE IF EXISTS T_COMMUNITY_COMPLAINT;

DROP TABLE IF EXISTS T_COMMUNITY_MEMBER;

DROP TABLE IF EXISTS T_COMMUNITY_TRAFFIC;

DROP TABLE IF EXISTS T_COMMUNITY_TRAFFIC_AUTO_RULE;

/*==============================================================*/
/* Table: T_COMMUNITY_ATTENTION                                 */
/*==============================================================*/
CREATE TABLE T_COMMUNITY_ATTENTION
(
   ID                   VARCHAR(32) NOT NULL,
   MEMBER_ID            VARCHAR(32),
   ATTENTION_MEMBER_ID  VARCHAR(32),
   PRIMARY KEY (ID)
);

ALTER TABLE T_COMMUNITY_ATTENTION COMMENT '关注会员';

/*==============================================================*/
/* Table: T_COMMUNITY_COMPLAINT                                 */
/*==============================================================*/
CREATE TABLE T_COMMUNITY_COMPLAINT
(
   ID                   VARCHAR(32) NOT NULL,
   MEMBER_ID            VARCHAR(32),
   CONTENT              VARCHAR(2000),
   PRIMARY KEY (ID)
);

ALTER TABLE T_COMMUNITY_COMPLAINT COMMENT '投诉';

/*==============================================================*/
/* Table: T_COMMUNITY_MEMBER                                    */
/*==============================================================*/
CREATE TABLE T_COMMUNITY_MEMBER
(
   ID                   VARCHAR(32) NOT NULL,
   MEMBER_MOBILE        VARCHAR(20),
   MEMBER_NAME          VARCHAR(50),
   MEMBER_PIC           VARCHAR(500),
   MEMBER_COMMUNITY     VARCHAR(200),
   MEMBER_WX            VARCHAR(100),
   MEMBER_OPENID        VARCHAR(100),
   MEMEBER_JOIN_DATE    TIMESTAMP,
   PRIMARY KEY (ID)
);

ALTER TABLE T_COMMUNITY_MEMBER COMMENT '会员表';

/*==============================================================*/
/* Table: T_COMMUNITY_TRAFFIC                                   */
/*==============================================================*/
CREATE TABLE T_COMMUNITY_TRAFFIC
(
   ID                   VARCHAR(32) NOT NULL,
   START_TIME           DATETIME,
   START_PLACE          VARCHAR(500),
   END_PLACE            VARCHAR(500),
   PUB_TYPE             VARCHAR(1),
   PRICE                VARCHAR(10),
   PUB_MEMBER           VARCHAR(32),
   PUB_TIME             TIMESTAMP,
   STATUS               VARCHAR(2),
   PRIMARY KEY (ID)
);

ALTER TABLE T_COMMUNITY_TRAFFIC COMMENT '搭车出行';

/*==============================================================*/
/* Table: T_COMMUNITY_TRAFFIC_AUTO_RULE                         */
/*==============================================================*/
CREATE TABLE T_COMMUNITY_TRAFFIC_AUTO_RULE
(
   ID                   VARCHAR(32) NOT NULL,
   START_TIME           TIME,
   START_PLACE          VARCHAR(500),
   END_PLACE            VARCHAR(500),
   PUB_TYPE             VARCHAR(1),
   PRICE                VARCHAR(10),
   PUB_MEMBER           VARCHAR(32),
   PUB_FREQUENCY        VARCHAR(100),
   PRIMARY KEY (ID)
);

ALTER TABLE T_COMMUNITY_TRAFFIC_AUTO_RULE COMMENT '搭车出行自动发布规则';

