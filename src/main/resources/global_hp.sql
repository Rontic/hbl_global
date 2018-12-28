/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50624
 Source Host           : localhost:3306
 Source Schema         : global_hp

 Target Server Type    : MySQL
 Target Server Version : 50624
 File Encoding         : 65001

 Date: 28/12/2018 10:07:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_base_module
-- ----------------------------
DROP TABLE IF EXISTS `tbl_base_module`;
CREATE TABLE `tbl_base_module`  (
  `module_id` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `parent_id` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `module_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `total_point` int(3) NULL DEFAULT NULL,
  `real_point` int(3) NULL DEFAULT 0,
  PRIMARY KEY (`module_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_base_module
-- ----------------------------
INSERT INTO `tbl_base_module` VALUES ('0001', '0', '规划统筹', 60, 0);
INSERT INTO `tbl_base_module` VALUES ('0002', '0', '要素体系', 260, 0);
INSERT INTO `tbl_base_module` VALUES ('0003', '0', '公共服务', 260, 0);
INSERT INTO `tbl_base_module` VALUES ('0004', '0', '资源环境', 100, 0);
INSERT INTO `tbl_base_module` VALUES ('0005', '0', '优质服务', 100, 0);
INSERT INTO `tbl_base_module` VALUES ('0006', '0', '品牌营销', 60, 0);
INSERT INTO `tbl_base_module` VALUES ('0007', '0', '体制机制', 80, 0);
INSERT INTO `tbl_base_module` VALUES ('0008', '0', '政策供给与创新', 80, 0);
INSERT INTO `tbl_base_module` VALUES ('1.1', '0001', '旅游规划创新', 20, 0);
INSERT INTO `tbl_base_module` VALUES ('1.2', '0001', '多规融合', 20, 0);
INSERT INTO `tbl_base_module` VALUES ('1.3', '0001', '旅游规划实施管理', 20, 0);
INSERT INTO `tbl_base_module` VALUES ('2.1', '0002', '旅游餐饮', 20, 0);
INSERT INTO `tbl_base_module` VALUES ('2.2', '0002', '旅游住宿', 20, 0);
INSERT INTO `tbl_base_module` VALUES ('2.3', '0002', '旅游交通', 20, 0);
INSERT INTO `tbl_base_module` VALUES ('2.4', '0002', '旅游吸引物', 150, 0);
INSERT INTO `tbl_base_module` VALUES ('2.5', '0002', '旅游购物', 30, 0);
INSERT INTO `tbl_base_module` VALUES ('2.6', '0002', '旅游娱乐', 20, 0);
INSERT INTO `tbl_base_module` VALUES ('3.1', '0003', '旅游交通网络', 34, 0);
INSERT INTO `tbl_base_module` VALUES ('3.2', '0003', '旅游交通配套', 56, 0);
INSERT INTO `tbl_base_module` VALUES ('3.3', '0003', '旅游交通组织', 10, 0);
INSERT INTO `tbl_base_module` VALUES ('3.4', '0003', '旅游标识系统', 70, 0);
INSERT INTO `tbl_base_module` VALUES ('3.5', '0003', '旅游厕所', 60, 0);
INSERT INTO `tbl_base_module` VALUES ('3.6', '0003', '旅游安全保障', 30, 0);
INSERT INTO `tbl_base_module` VALUES ('4.1', '0004', '资源环境质量', 24, 0);
INSERT INTO `tbl_base_module` VALUES ('4.2', '0004', '城乡建设水平', 16, 0);
INSERT INTO `tbl_base_module` VALUES ('4.3', '0004', '全域环境整治', 20, 0);
INSERT INTO `tbl_base_module` VALUES ('4.4', '0004', '社会环境', 40, 0);
INSERT INTO `tbl_base_module` VALUES ('5.1', '0005', '服务标准化', 10, 5);
INSERT INTO `tbl_base_module` VALUES ('5.2', '0005', '服务标杆化', 8, 0);
INSERT INTO `tbl_base_module` VALUES ('5.3', '0005', '服务智能化', 38, 10);
INSERT INTO `tbl_base_module` VALUES ('5.4', '0005', '投诉处理', 10, 0);
INSERT INTO `tbl_base_module` VALUES ('5.5', '0005', '市场管理', 16, 0);
INSERT INTO `tbl_base_module` VALUES ('5.6', '0005', '文明旅游', 8, 0);
INSERT INTO `tbl_base_module` VALUES ('5.7', '0005', '旅游志愿者服务', 10, 0);
INSERT INTO `tbl_base_module` VALUES ('6.1', '0006', '营销保障', 20, 0);
INSERT INTO `tbl_base_module` VALUES ('6.2', '0006', '品牌战略', 20, 0);
INSERT INTO `tbl_base_module` VALUES ('6.3', '0006', '营销机制', 10, 0);
INSERT INTO `tbl_base_module` VALUES ('6.4', '0006', '营销方式', 10, 0);
INSERT INTO `tbl_base_module` VALUES ('7.1', '0007', '健全领导机制', 20, 0);
INSERT INTO `tbl_base_module` VALUES ('7.2', '0007', '旅游协调机制', 25, 0);
INSERT INTO `tbl_base_module` VALUES ('7.3', '0007', '旅游综合管理', 20, 0);
INSERT INTO `tbl_base_module` VALUES ('7.4', '0007', '行业协会自律', 15, 0);
INSERT INTO `tbl_base_module` VALUES ('8.1', '0008', '全域旅游支持政策', 15, 0);
INSERT INTO `tbl_base_module` VALUES ('8.2', '0008', '财政投入政策', 25, 0);
INSERT INTO `tbl_base_module` VALUES ('8.3', '0008', '投融资政策', 10, 0);
INSERT INTO `tbl_base_module` VALUES ('8.4', '0008', '土地政策', 20, 0);
INSERT INTO `tbl_base_module` VALUES ('8.5', '0008', '旅游人才与教育', 10, 0);

-- ----------------------------
-- Table structure for tbl_file
-- ----------------------------
DROP TABLE IF EXISTS `tbl_file`;
CREATE TABLE `tbl_file`  (
  `module_id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模块ID',
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `file_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件路径'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_file
-- ----------------------------
INSERT INTO `tbl_file` VALUES ('1.1', '1.1.1关于成立旅游产业综合协调领导小组的通知 .pdf', '/pdfFile/1.1/1.1.1关于成立旅游产业综合协调领导小组的通知.pdf');
INSERT INTO `tbl_file` VALUES ('1.1', '1.1.3组织机构职责相关文件.pdf', '/pdfFile/1.1/1.1.3组织机构职责相关文件.pdf');
INSERT INTO `tbl_file` VALUES ('1.2', '1.2.3旅游警察相关工作记录.pdf', '/pdfFile/1.2/1.2.3旅游警察相关工作记录.pdf');
INSERT INTO `tbl_file` VALUES ('1.2', '1.2.4旅游警察挂牌照片.pdf', '/pdfFile/1.2/1.2.4旅游警察挂牌照片.pdf');
INSERT INTO `tbl_file` VALUES ('1.2', '1.2.5关于成立旅游巡回法庭的批复.pdf', '/pdfFile/1.2/1.2.5关于成立旅游巡回法庭的批复.pdf');
INSERT INTO `tbl_file` VALUES ('1.2', '1.2.6旅游巡回法庭相关管理制度、办法.pdf', '/pdfFile/1.2/1.2.6旅游巡回法庭相关管理制度、办法.pdf');
INSERT INTO `tbl_file` VALUES ('1.2', '1.2.7旅游巡回法庭相关工作记录.pdf', '/pdfFile/1.2/1.2.7旅游巡回法庭相关工作记录.pdf');
INSERT INTO `tbl_file` VALUES ('1.2', '1.2.8旅游专门法庭挂牌、旅游法庭挂牌、旅游巡回审判点挂牌等相关照片.pdf', '/pdfFile/1.2/1.2.8旅游专门法庭挂牌、旅游法庭挂牌、旅游巡回审判点挂牌等相关照片.pdf');
INSERT INTO `tbl_file` VALUES ('1.2', '1.2.9关于成立工商旅游分局的批复.pdf', '/pdfFile/1.2/1.2.9关于成立工商旅游分局的批复.pdf');
INSERT INTO `tbl_file` VALUES ('1.2', '1.2.10工商旅游分局相关管理制度、办法.pdf', '/pdfFile/1.2/1.2.10工商旅游分局相关管理制度、办法.pdf');
INSERT INTO `tbl_file` VALUES ('1.2', '1.2.11工商旅游分局相关工作记录.pdf', '/pdfFile/1.2/1.2.11工商旅游分局相关工作记录.pdf');
INSERT INTO `tbl_file` VALUES ('1.2', '1.2.12工商旅游分局挂牌照片.pdf', '/pdfFile/1.2/1.2.12工商旅游分局挂牌照片.pdf');
INSERT INTO `tbl_file` VALUES ('1.3', '1.3.1旅游数据中心建设方案.pdf', '/pdfFile/1.3/1.3.1旅游数据中心建设方案.pdf');
INSERT INTO `tbl_file` VALUES ('1.3', '1.3.2全域旅游统计指标体系报告.pdf', '/pdfFile/1.3/1.3.2全域旅游统计指标体系报告.pdf');
INSERT INTO `tbl_file` VALUES ('1.3', '1.3.3数据统计体系报告.pdf', '/pdfFile/1.3/1.3.3数据统计体系报告.pdf');
INSERT INTO `tbl_file` VALUES ('1.4', '1.4.1旅游产业用地改革试点总体方案.pdf', '/pdfFile/1.4/1.4.1旅游产业用地改革试点总体方案.pdf');
INSERT INTO `tbl_file` VALUES ('1.5', '1.5.1旅游规划体系.pdf', '/pdfFile/1.5/1.5.1旅游规划体系.pdf');
INSERT INTO `tbl_file` VALUES ('1.5', '1.5.2全域旅游发展规划结构目录.pdf', '/pdfFile/1.5/1.5.2全域旅游发展规划结构目录.pdf');
INSERT INTO `tbl_file` VALUES ('1.6', '1.6.1景区门票价格专项整治工作方案.pdf', '/pdfFile/1.6/1.6.1景区门票价格专项整治工作方案.pdf');
INSERT INTO `tbl_file` VALUES ('1.6', '1.6.2导游管理体制改革实施方案.pdf', '/pdfFile/1.6/1.6.2导游管理体制改革实施方案.pdf');
INSERT INTO `tbl_file` VALUES ('1.6', '1.6.3国家级旅游业改革创新先行区批复及实施方案.pdf', '/pdfFile/1.6/1.6.3国家级旅游业改革创新先行区批复及实施方案.pdf');
INSERT INTO `tbl_file` VALUES ('1.6', '1.6.4设立旅游综合改革、专项旅游改革试验区批复及总体方案.pdf', '/pdfFile/1.6/1.6.4设立旅游综合改革、专项旅游改革试验区批复及总体方案.pdf');
INSERT INTO `tbl_file` VALUES ('1.6', '1.6.5旅游专项改革试验实施方案.pdf', '/pdfFile/1.6/1.6.5旅游专项改革试验实施方案.pdf');
INSERT INTO `tbl_file` VALUES ('2.1', '2.1.2全域旅游创建领导小组工作制度.pdf', '/pdfFile/2.1/2.1.2全域旅游创建领导小组工作制度.pdf');
INSERT INTO `tbl_file` VALUES ('2.1', '2.1.3全域旅游创建领导小组办公室现场照片.pdf', '/pdfFile/2.1/2.1.3全域旅游创建领导小组办公室现场照片.pdf');
INSERT INTO `tbl_file` VALUES ('2.2', '2.2.1创建全域旅游意见、方案等指导性文件.pdf', '/pdfFile/2.2/2.2.1创建全域旅游意见、方案等指导性文件.pdf');
INSERT INTO `tbl_file` VALUES ('2.2', '2.2.2推进会会议通知、会议记录、会议报道等记录文件.pdf', '/pdfFile/2.2/2.2.2推进会会议通知、会议记录、会议报道等记录文件.pdf');
INSERT INTO `tbl_file` VALUES ('2.2', '2.2.3现场考察全域旅游创建进程的宣传报道及现场照片.pdf', '/pdfFile/2.2/2.2.3现场考察全域旅游创建进程的宣传报道及现场照片.pdf');
INSERT INTO `tbl_file` VALUES ('2.3', '2.3.1全域旅游规划.pdf', '/pdfFile/2.3/2.3.1全域旅游规划.pdf');
INSERT INTO `tbl_file` VALUES ('2.3', '2.3.2全域旅游实施方案及任务分解表.pdf', '/pdfFile/2.3/2.3.2全域旅游实施方案及任务分解表.pdf');
INSERT INTO `tbl_file` VALUES ('2.3', '2.3.3全域旅游创建工作考核办法.pdf', '/pdfFile/2.3/2.3.3全域旅游创建工作考核办法.pdf');
INSERT INTO `tbl_file` VALUES ('2.3', '2.3.4全域旅游创建工作监督检查制度.pdf', '/pdfFile/2.3/2.3.4全域旅游创建工作监督检查制度.pdf');
INSERT INTO `tbl_file` VALUES ('2.4', '2.4.1全域旅游创建工作会议记录、通知、签到表等记录性文件.pdf', '/pdfFile/2.4/2.4.1全域旅游创建工作会议记录、通知、签到表等记录性文件.pdf');
INSERT INTO `tbl_file` VALUES ('2.4', '2.4.2全域旅游培训计划.pdf', '/pdfFile/2.4/2.4.2全域旅游培训计划.pdf');
INSERT INTO `tbl_file` VALUES ('2.4', '2.4.3全域旅游培训通知、记录和签到等记录性文件.pdf', '/pdfFile/2.4/2.4.3全域旅游培训通知、记录和签到等记录性文件.pdf');
INSERT INTO `tbl_file` VALUES ('2.5', '2.5.1关于全域旅游创建经专项经费的批复.pdf', '/pdfFile/2.5/2.5.1关于全域旅游创建经专项经费的批复.pdf');
INSERT INTO `tbl_file` VALUES ('2.5', '2.5.2专项经费投入明细.pdf', '/pdfFile/2.5/2.5.2专项经费投入明细.pdf');
INSERT INTO `tbl_file` VALUES ('2.5', '2.5.3全域旅游发展专项资金使用管理办法.pdf', '/pdfFile/2.5/2.5.3全域旅游发展专项资金使用管理办法.pdf');
INSERT INTO `tbl_file` VALUES ('3.1', '3.1.1旅游业占GDP比重图.pdf', '/pdfFile/3.1/3.1.1旅游业占GDP比重图.pdf');
INSERT INTO `tbl_file` VALUES ('3.2', '3.2.1旅游业对就业贡献占比图.pdf', '/pdfFile/3.2/3.2.1旅游业对就业贡献占比图.pdf');
INSERT INTO `tbl_file` VALUES ('3.2', '3.2.2旅游业对新增就业贡献占比图.pdf', '/pdfFile/3.2/3.2.2旅游业对新增就业贡献占比图.pdf');
INSERT INTO `tbl_file` VALUES ('3.3', '3.3.1旅游对农民增收综合贡献占比图.pdf', '/pdfFile/3.3/3.3.1旅游对农民增收综合贡献占比图.pdf');
INSERT INTO `tbl_file` VALUES ('3.4', '3.4.1旅游对财政税收综合贡献占比图.pdf', '/pdfFile/3.4/3.4.1旅游对财政税收综合贡献占比图.pdf');
INSERT INTO `tbl_file` VALUES ('3.5', '3.5.1旅游对脱贫综合贡献占比图.pdf', '/pdfFile/3.5/3.5.1旅游对脱贫综合贡献占比图.pdf');
INSERT INTO `tbl_file` VALUES ('3.6', '3.6.1年游客接待人次占本地常住人口比率图.pdf', '/pdfFile/3.6/3.6.1年游客接待人次占本地常住人口比率图.pdf');
INSERT INTO `tbl_file` VALUES ('4.1', '4.1.1核心吸引物分布地图.pdf', '/pdfFile/4.1/4.1.1核心吸引物分布地图.pdf');
INSERT INTO `tbl_file` VALUES ('4.2', '4.2.1年接待游客数量统计表.pdf', '/pdfFile/4.2/4.2.1年接待游客数量统计表.pdf');
INSERT INTO `tbl_file` VALUES ('4.2', '4.2.2过夜游客数量统计表及占比图.pdf', '/pdfFile/4.2/4.2.2过夜游客数量统计表及占比图.pdf');
INSERT INTO `tbl_file` VALUES ('4.3', '4.3.1旅游产品一览表.pdf', '/pdfFile/4.3/4.3.1旅游产品一览表.pdf');
INSERT INTO `tbl_file` VALUES ('4.3', '4.3.2旅游产品分布图.pdf', '/pdfFile/4.3/4.3.2旅游产品分布图.pdf');
INSERT INTO `tbl_file` VALUES ('4.4', '4.4.1旅游产品空间分析报告.pdf', '/pdfFile/4.4/4.4.1旅游产品空间分析报告.pdf');
INSERT INTO `tbl_file` VALUES ('4.5', '4.5.1旅游产品时间分析报告.pdf', '/pdfFile/4.5/4.5.1旅游产品时间分析报告.pdf');
INSERT INTO `tbl_file` VALUES ('4.6', '4.6.1全域旅游品牌打造方案.pdf', '/pdfFile/4.6/4.6.1全域旅游品牌打造方案.pdf');
INSERT INTO `tbl_file` VALUES ('5.1', '5.1.1旅游交通分布图.pdf', '/pdfFile/5.1/5.1.1旅游交通分布图.pdf');
INSERT INTO `tbl_file` VALUES ('5.2', '5.2.1旅游厕所分布图.pdf', '/pdfFile/5.2/5.2.1旅游厕所分布图.pdf');
INSERT INTO `tbl_file` VALUES ('5.3', '5.3.1旅游集散设施分布图.pdf', '/pdfFile/5.3/5.3.1旅游集散设施分布图.pdf');
INSERT INTO `tbl_file` VALUES ('5.4', '5.4.1旅游信息咨询中心分布图.pdf', '/pdfFile/5.4/5.4.1旅游信息咨询中心分布图.pdf');
INSERT INTO `tbl_file` VALUES ('5.5', '5.5.1旅游标识牌分布图.pdf', '/pdfFile/5.5/5.5.1旅游标识牌分布图.pdf');
INSERT INTO `tbl_file` VALUES ('5.5', '5.5.2自驾车服务点分布图.pdf', '/pdfFile/5.5/5.5.2自驾车服务点分布图.pdf');
INSERT INTO `tbl_file` VALUES ('6.1', '6.1.1旅游住宿设施分布图.pdf', '/pdfFile/6.1/6.1.1旅游住宿设施分布图.pdf');
INSERT INTO `tbl_file` VALUES ('6.2', '6.2.1旅游餐饮设施分布图.pdf', '/pdfFile/6.2/6.2.1旅游餐饮设施分布图.pdf');
INSERT INTO `tbl_file` VALUES ('6.3', '6.3.1旅游购物设施分布图.pdf', '/pdfFile/6.3/6.3.1旅游购物设施分布图.pdf');
INSERT INTO `tbl_file` VALUES ('6.4', '6.4.1旅游文化娱乐休闲设施分布图.pdf', '/pdfFile/6.4/6.4.1旅游文化娱乐休闲设施分布图.pdf');
INSERT INTO `tbl_file` VALUES ('6.5', '6.5.1旅游交通设施分布图.pdf', '/pdfFile/6.5/6.5.1旅游交通设施分布图.pdf');
INSERT INTO `tbl_file` VALUES ('6.6', '6.6.1导游信息汇总表.pdf', '/pdfFile/6.6/6.6.1导游信息汇总表.pdf');
INSERT INTO `tbl_file` VALUES ('6.7', '6.7.1旅游新业态分布图.pdf', '/pdfFile/6.7/6.7.1旅游新业态分布图.pdf');
INSERT INTO `tbl_file` VALUES ('7.1', '7.1.1旅游安全状况分析报告.pdf', '/pdfFile/7.1/7.1.1旅游安全状况分析报告.pdf');
INSERT INTO `tbl_file` VALUES ('7.2', '7.2.1旅游质量报告.pdf', '/pdfFile/7.2/7.2.1旅游质量报告.pdf');
INSERT INTO `tbl_file` VALUES ('7.2', '7.2.2旅游投诉管理办法.pdf', '/pdfFile/7.2/7.2.2旅游投诉管理办法.pdf');
INSERT INTO `tbl_file` VALUES ('7.3', '7.3.1文明旅游统计分析报告.pdf', '/pdfFile/7.3/7.3.1文明旅游统计分析报告.pdf');
INSERT INTO `tbl_file` VALUES ('7.4', '7.4.1游客满意度报告.pdf', '/pdfFile/7.4/7.4.1游客满意度报告.pdf');
INSERT INTO `tbl_file` VALUES ('8.1', '8.1.1旅游资源遗产保护办法.pdf', '/pdfFile/8.1/8.1.1旅游资源遗产保护办法.pdf');
INSERT INTO `tbl_file` VALUES ('8.1', '8.1.2旅游资源遗产保护报告.pdf', '/pdfFile/8.1/8.1.2旅游资源遗产保护报告.pdf');
INSERT INTO `tbl_file` VALUES ('8.2', '8.2.1生态环境保护办法.pdf', '/pdfFile/8.2/8.2.1生态环境保护办法.pdf');
INSERT INTO `tbl_file` VALUES ('8.2', '8.2.2生态环境保护报告.pdf', '/pdfFile/8.2/8.2.2生态环境保护报告.pdf');
INSERT INTO `tbl_file` VALUES ('8.3', '8.3.1重点旅游景区最大承载量汇总表.pdf', '/pdfFile/8.3/8.3.1重点旅游景区最大承载量汇总表.pdf');
INSERT INTO `tbl_file` VALUES ('8.3', '8.3.2重点旅游景区人流量控制管理办法.pdf', '/pdfFile/8.3/8.3.2重点旅游景区人流量控制管理办法.pdf');
INSERT INTO `tbl_file` VALUES ('8.4', '8.4.1生态旅游示范区报告.pdf', '/pdfFile/8.4/8.4.1生态旅游示范区报告.pdf');
INSERT INTO `tbl_file` VALUES ('8.4', '8.4.2绿色旅游认证报告.pdf', '/pdfFile/8.4/8.4.2绿色旅游认证报告.pdf');
INSERT INTO `tbl_file` VALUES ('8.5', '8.5.1旅游企业节能减排报告.pdf', '/pdfFile/8.5/8.5.1旅游企业节能减排报告.pdf');
INSERT INTO `tbl_file` VALUES ('8.6', '8.6.1环卫体系报告.pdf', '/pdfFile/8.6/8.6.1环卫体系报告.pdf');
INSERT INTO `tbl_file` VALUES ('5.6', '5.6.1自驾车服务点分布图.pdf', '/pdfFile/5.5/5.5.2自驾车服务点分布图.pdf');
INSERT INTO `tbl_file` VALUES ('5.7', '5.7.1自驾车服务点分布图.pdf', '/pdfFile/5.5/5.5.2自驾车服务点分布图.pdf');
INSERT INTO `tbl_file` VALUES ('1.1', '1.1.2关于成立旅游委的通知.pdf', '/pdfFile/1.1/1.1.2关于成立旅游委的通知.pdf');
INSERT INTO `tbl_file` VALUES ('1.2', '1.2.1关于组建旅游警察大队的批复.pdf', '/pdfFile/1.2/1.2.1关于组建旅游警察大队的批复.pdf');
INSERT INTO `tbl_file` VALUES ('1.2', '1.2.2旅游警察相关管理制度、办法.pdf', '/pdfFile/1.2/1.2.2旅游警察相关管理制度、办法.pdf');
INSERT INTO `tbl_file` VALUES ('2.1', '2.1.1关于成立全域旅游创建领导小组的通知.pdf', '/pdfFile/2.1/2.1.1关于成立全域旅游创建领导小组的通知.pdf');

-- ----------------------------
-- Table structure for tbl_item_percent
-- ----------------------------
DROP TABLE IF EXISTS `tbl_item_percent`;
CREATE TABLE `tbl_item_percent`  (
  `statistic_id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `total_amount` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '总金额',
  `item_amount` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '旅游金额',
  `data_year` int(4) NULL DEFAULT NULL COMMENT '统计年份',
  `user_id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `statistic_type` int(2) NULL DEFAULT NULL COMMENT '统计类型',
  `module_id` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`statistic_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_item_percent
-- ----------------------------
INSERT INTO `tbl_item_percent` VALUES (1, '10000', '1000', 2016, 'liwenwu', 1, '3.1');
INSERT INTO `tbl_item_percent` VALUES (2, '25665', '2165', 2017, 'liwenwu', 1, '3.1');
INSERT INTO `tbl_item_percent` VALUES (3, '26566', '6213', 2018, 'liwenwu', 1, '3.1');
INSERT INTO `tbl_item_percent` VALUES (4, '26566', '2563', 2016, 'liwenwu', 1, '3.2');
INSERT INTO `tbl_item_percent` VALUES (5, '26568', '2369', 2017, 'liwenwu', 1, '3.2');
INSERT INTO `tbl_item_percent` VALUES (6, '22222', '3333', 2018, 'liwenwu', 1, '3.2');
INSERT INTO `tbl_item_percent` VALUES (7, '1111', '111', 2017, 'liwenwu', 2, '3.2');
INSERT INTO `tbl_item_percent` VALUES (8, '2222', '222', 2017, 'liwenwu', 2, '3.2');
INSERT INTO `tbl_item_percent` VALUES (9, '3333', '333', 2018, 'liwenwu', 2, '3.2');
INSERT INTO `tbl_item_percent` VALUES (10, '100000', '1000', 2016, 'liwenwu', 1, '3.3');
INSERT INTO `tbl_item_percent` VALUES (11, '5623', '256', 2017, 'liwenwu', 1, '3.3');
INSERT INTO `tbl_item_percent` VALUES (12, '59533', '2115', 2018, 'liwenwu', 1, '3.3');
INSERT INTO `tbl_item_percent` VALUES (13, '2655522', '3333', 2016, 'liwenwu', 1, '3.4');
INSERT INTO `tbl_item_percent` VALUES (14, '562356', '2212', 2017, 'liwenwu', 1, '3.4');
INSERT INTO `tbl_item_percent` VALUES (15, '5665656', '2156', 2018, 'liwenwu', 1, '3.4');
INSERT INTO `tbl_item_percent` VALUES (16, '154646', '4464', 2016, 'liwenwu', 1, '3.5');
INSERT INTO `tbl_item_percent` VALUES (17, '14545', '2222', 2017, 'liwenwu', 1, '3.5');
INSERT INTO `tbl_item_percent` VALUES (18, '135565', '2154', 2016, 'liwenwu', 1, '3.6');
INSERT INTO `tbl_item_percent` VALUES (19, '14454', '2699', 2017, 'liwenwu', 1, '3.6');
INSERT INTO `tbl_item_percent` VALUES (20, '14545', '2121', 2016, 'liwenwu', 1, '4.2');
INSERT INTO `tbl_item_percent` VALUES (21, '45454', '2154', 2017, 'liwenwu', 1, '4.2');

-- ----------------------------
-- Table structure for tbl_module_file
-- ----------------------------
DROP TABLE IF EXISTS `tbl_module_file`;
CREATE TABLE `tbl_module_file`  (
  `module_id` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `file_flg` int(1) NULL DEFAULT NULL COMMENT '是否需要文件证明',
  `road_flg` int(1) NULL DEFAULT NULL COMMENT '是否有路线展示',
  `image_flg` int(1) NULL DEFAULT NULL COMMENT '是否有图片证明',
  `map_flg` int(1) NULL DEFAULT NULL COMMENT '地图证明',
  `map_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地图类型',
  `statistics_flg` int(1) NULL DEFAULT NULL COMMENT '统计证明',
  `statistics_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '统计名称',
  `statistics_type` int(2) NULL DEFAULT NULL COMMENT '统计类型',
  PRIMARY KEY (`module_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_module_file
-- ----------------------------
INSERT INTO `tbl_module_file` VALUES ('1.1', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('1.2', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('1.3', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('2.1', 1, 0, 0, 1, '1', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('2.2', 0, 0, 0, 1, '4', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('2.3', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('2.4', 1, 0, 0, 1, '11', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('2.5', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('2.6', 0, 0, 0, 1, '10', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('3.1', 1, 1, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('3.2', 0, 1, 1, 1, '12', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('3.3', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('3.4', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('3.5', 0, 0, 0, 1, '2', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('3.6', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('4.1', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('4.2', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('4.3', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('4.4', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('5.1', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('5.2', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('5.3', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('5.4', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('5.5', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('5.6', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('5.7', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('6.1', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('6.2', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('6.3', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('6.4', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('7.1', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('7.2', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('7.3', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('7.4', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('8.1', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('8.2', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('8.3', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('8.4', 1, 0, 0, 0, '0', 0, NULL, NULL);
INSERT INTO `tbl_module_file` VALUES ('8.5', 1, 0, 0, 0, '0', 0, NULL, NULL);

-- ----------------------------
-- Table structure for tbl_module_image
-- ----------------------------
DROP TABLE IF EXISTS `tbl_module_image`;
CREATE TABLE `tbl_module_image`  (
  `module_id` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `image_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_module_image
-- ----------------------------
INSERT INTO `tbl_module_image` VALUES ('3.2', '3.2.1旅游业对就业贡献占比图.jpg', '/image/3.2/3.2.1旅游业对就业贡献占比图.jpg', ' 座谈会上，问津书院管理中心主任陈清平就“问津书院的建设情况和管理模式”作了详细汇报。新洲区文化局局长张晓菡向来宾介绍了问津书院二千多年来的历史变迁，并赞扬黄陂区旅游项目是我们学习的榜样。黄陂区副区长吴立群介绍了黄陂二程书院的建设规模和远景规划。最后，副区长张再强说，新洲与黄陂文脉、山水相连，今天大家通过这种座谈方式，共同探讨两地书院的现状和未来发展，增进了兄弟区之间的情感，对两地书院当下建设管理与运行机制存在的问题和不足有了更加深入的了解，此次交流，也必将进一步推动两地书院的建设。与会人员还就书院人事编制、资金来源、活动组织等问题进行了交流探讨。 ');
INSERT INTO `tbl_module_image` VALUES ('3.2', '3.2.2旅游业对新增就业贡献占比图.jpg', '/image/3.2/3.2.2旅游业对新增就业贡献占比图.jpg', ' 座谈会上，问津书院管理中心主任陈清平就“问津书院的建设情况和管理模式”作了详细汇报。新洲区文化局局长张晓菡向来宾介绍了问津书院二千多年来的历史变迁，并赞扬黄陂区旅游项目是我们学习的榜样。黄陂区副区长吴立群介绍了黄陂二程书院的建设规模和远景规划。最后，副区长张再强说，新洲与黄陂文脉、山水相连，今天大家通过这种座谈方式，共同探讨两地书院的现状和未来发展，增进了兄弟区之间的情感，对两地书院当下建设管理与运行机制存在的问题和不足有了更加深入的了解，此次交流，也必将进一步推动两地书院的建设。与会人员还就书院人事编制、资金来源、活动组织等问题进行了交流探讨。 ');
INSERT INTO `tbl_module_image` VALUES ('1.1', '/image/1.1/1.1.1关于成立旅游产业综合协调领导小组的通知.jpg', NULL, '');
INSERT INTO `tbl_module_image` VALUES ('1.1', '/image/1.1/1.1.2关于成立旅游委的通知.jpg', NULL, '');
INSERT INTO `tbl_module_image` VALUES ('1.2', '/image/1.2/1.2.1关于组建旅游警察大队的批复.jpg', NULL, '');
INSERT INTO `tbl_module_image` VALUES ('1.2', '/image/1.2/1.2.2旅游警察相关管理制度、办法.jpg', NULL, '');
INSERT INTO `tbl_module_image` VALUES ('2.1', '/image/2.1/2.1.1关于成立全域旅游创建领导小组的通知.jpg', NULL, '');
INSERT INTO `tbl_module_image` VALUES ('10.1', '/image/1.1/1.1.1关于成立旅游产业综合协调领导小组的通知.jpg', NULL, '大手大脚爱神的箭阿三领导就爱上了\n大家萨拉丁撒的就是拉到就爱上了的的撒决定了撒娇达拉斯的啊十大建设的卢卡斯\n大家撒打算了');
INSERT INTO `tbl_module_image` VALUES ('10.1', '/image/1.1/1.1.2关于成立旅游委的通知.jpg', NULL, '');
INSERT INTO `tbl_module_image` VALUES ('10.1', '/image/1.2/1.2.1关于组建旅游警察大队的批复.jpg', NULL, '');
INSERT INTO `tbl_module_image` VALUES ('10.1', '/image/1.2/1.2.2旅游警察相关管理制度、办法.jpg', NULL, '');
INSERT INTO `tbl_module_image` VALUES ('10.1', '/image/2.1/2.1.1关于成立全域旅游创建领导小组的通知.jpg', NULL, '');

-- ----------------------------
-- Table structure for tbl_module_road
-- ----------------------------
DROP TABLE IF EXISTS `tbl_module_road`;
CREATE TABLE `tbl_module_road`  (
  `module_id` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '模块ID',
  `road_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '路线名',
  `start_lon` decimal(10, 7) NULL DEFAULT NULL COMMENT '起点经度',
  `start_lat` decimal(10, 7) NULL DEFAULT NULL COMMENT '起点纬度',
  `end_lon` decimal(10, 7) NULL DEFAULT NULL COMMENT '终点经度',
  `end_lat` decimal(10, 7) NULL DEFAULT NULL COMMENT '终点纬度'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_module_road
-- ----------------------------
INSERT INTO `tbl_module_road` VALUES ('3.2', '测试线路', 110.9824430, 30.8228090, 110.9887340, 30.8307700);
INSERT INTO `tbl_module_road` VALUES ('3.1', '机场线路', 110.9849220, 30.8000700, 114.2114700, 30.7719500);
INSERT INTO `tbl_module_road` VALUES ('3.1', '武昌火车站线路', 110.9845710, 30.8004860, 114.3177900, 30.5289800);
INSERT INTO `tbl_module_road` VALUES ('3.2', '汽车站线路', 110.9896940, 30.8072090, 114.2554700, 30.6178500);

-- ----------------------------
-- Table structure for tbl_ordinarypoi
-- ----------------------------
DROP TABLE IF EXISTS `tbl_ordinarypoi`;
CREATE TABLE `tbl_ordinarypoi`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `No` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编号 索引列',
  `Name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称 索引列',
  `TypeID` int(11) NULL DEFAULT NULL COMMENT '类别ID',
  `Price` int(11) NULL DEFAULT NULL COMMENT '价格',
  `Star` int(11) NULL DEFAULT NULL COMMENT '评分星级',
  `Addr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `Tel` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `Contact` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `Lon` decimal(10, 7) NULL DEFAULT NULL COMMENT '经度',
  `Lat` decimal(10, 7) NULL DEFAULT NULL COMMENT '纬度',
  `Images` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `Summary` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简介',
  `Level` int(11) NULL DEFAULT NULL COMMENT '显示级别',
  `GridID` int(11) NULL DEFAULT NULL COMMENT '网格ID',
  `Tags` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标签',
  `Likes` int(11) NULL DEFAULT NULL COMMENT '点赞数',
  `Season` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '季节',
  `CityID` int(11) NULL DEFAULT NULL COMMENT '所属城市ID',
  `OfficialUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '官网链接',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 673 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '普通兴趣点表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_ordinarypoi
-- ----------------------------
INSERT INTO `tbl_ordinarypoi` VALUES (670, 'JQ000000000001', '木兰天池', 11, NULL, 0, '湖北省武汉市黄陂区长轩岭街道木兰天池', NULL, NULL, 114.2722590, 31.1760860, '/wholePictures/JQ000000000001.jpg', '木兰文化生态旅游区由武汉市黄陂区的木兰山、木兰天池、木兰草原、木兰云雾山四大景区组成。想看山，这里有国家地质公园、千年宗教名胜木兰山；想看森林，这里有幽谷美景、浪漫山水的国家森林公园木兰天池；想看草原，这里有华中唯一的草原风情景区木兰草原；想看花，木兰云雾山里有万亩杜鹃，木兰清凉寨景区有10万株野生樱花。2014年11月，湖北省武汉市黄陂木兰文化生态旅游区正式获批国家5A级旅游景区。', NULL, NULL, NULL, NULL, NULL, NULL, 'http://www.mltc.cn/');
INSERT INTO `tbl_ordinarypoi` VALUES (671, 'JQ000000000002', '木兰草原', 11, NULL, 0, '武汉市黄陂区王家河镇张家榨村', NULL, NULL, 114.4620520, 30.9600540, '/wholePictures/JQ000000000001_1.jpg', '武汉木兰草原景区，位于黄陂木兰生态旅游区境内的王家河镇，占地面积2万亩，属“木兰八景”之一。景区距武汉市中心城区38公里，该景区融草原观光、游乐、会务、度假为一体。主要景点：草原人家、草原古城、草原部落、茶马客栈、草原敖包、草原集市、草原马场等20余处。主营项目：草原马车游、草原歌舞观赏、草原骑马、草原射箭、草原篝火晚会、敖包朝圣、茶马客栈体验、草原度假等10多个参与性的活动。木兰草原，无限缭阔，碧水缠绕。相传这里是木兰将军习武骑马射箭的地方。走进木兰草原，你可骑马奔驰，亦可信马由僵；你可去欣赏那浪漫风情的草原民族歌舞，亦可去篝火旁边品味烤全羊；你可去豪华的星级宾馆度假，亦可在蒙古包度过美好的草原之夜……请到木兰草原来，欢乐又开怀！', NULL, NULL, NULL, NULL, NULL, NULL, 'http://www.whmlcy.net/');
INSERT INTO `tbl_ordinarypoi` VALUES (672, 'JD000000000003', '武汉天河机场东希尔顿欢朋酒店', 4, NULL, 0, '武汉黄陂区盘龙城经济开发区巨龙大道190号.。(地铁巨龙大道站C出口)', NULL, NULL, 114.8010960, 30.8414260, '/wholePictures/JD000000000001_1.jpg;/wholePictures/JD000000000001_2.jpg;/wholePictures/JD000000000001_3.jpg', '武汉天河机场东希尔顿欢朋酒店位于盘龙城主干道巨龙大道，地铁2号线巨龙大道站C出口旁，毗邻盘龙城开发区管委会。北邻武汉天河国际机场，南抵汉口火车站。酒店周边有奥特莱斯购物广场和新汉正街海宁皮革城等大型购物商场可满足您的购物需求，更有武汉海昌极地海洋世界主题公园、盘龙城遗址公园等风景名胜供您游览。 ', NULL, NULL, NULL, NULL, NULL, NULL, 'http://hampton.hilton.com.cn/zh-cn/hotel/wuhan/hampton-by-hilton-wuhan-panlongcheng-WUHHXHX/index.html');

-- ----------------------------
-- Table structure for tbl_poicomment
-- ----------------------------
DROP TABLE IF EXISTS `tbl_poicomment`;
CREATE TABLE `tbl_poicomment`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PoilID` int(11) NULL DEFAULT NULL COMMENT '关联的景区ID',
  `Content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `CreateTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UserID` int(11) NULL DEFAULT NULL COMMENT '评论用户',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '景区评论表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_poitag
-- ----------------------------
DROP TABLE IF EXISTS `tbl_poitag`;
CREATE TABLE `tbl_poitag`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PoilID` int(11) NULL DEFAULT NULL COMMENT '关联的poi点id',
  `TypeD` int(11) NULL DEFAULT NULL COMMENT '类别ID',
  `Name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签名',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '标签管理表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_poitype
-- ----------------------------
DROP TABLE IF EXISTS `tbl_poitype`;
CREATE TABLE `tbl_poitype`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称 索引列',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '兴趣点类别表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_poitype
-- ----------------------------
INSERT INTO `tbl_poitype` VALUES (1, '旅游餐厅');
INSERT INTO `tbl_poitype` VALUES (2, '旅游公厕');
INSERT INTO `tbl_poitype` VALUES (3, '加油站');
INSERT INTO `tbl_poitype` VALUES (4, '酒店/民宿');
INSERT INTO `tbl_poitype` VALUES (5, '旅行社');
INSERT INTO `tbl_poitype` VALUES (6, '旅游购物点');
INSERT INTO `tbl_poitype` VALUES (7, '停车场');
INSERT INTO `tbl_poitype` VALUES (8, '救援及医疗');
INSERT INTO `tbl_poitype` VALUES (9, '银行');
INSERT INTO `tbl_poitype` VALUES (10, '娱乐场所');
INSERT INTO `tbl_poitype` VALUES (11, '景区/乡村旅游点');
INSERT INTO `tbl_poitype` VALUES (12, '集散中心');
INSERT INTO `tbl_poitype` VALUES (13, '旅游驿站');
INSERT INTO `tbl_poitype` VALUES (14, '旅游标识牌');
INSERT INTO `tbl_poitype` VALUES (15, '自驾车营地');
INSERT INTO `tbl_poitype` VALUES (16, '导游');
INSERT INTO `tbl_poitype` VALUES (17, '交通');

-- ----------------------------
-- Table structure for tbl_scenicpoi
-- ----------------------------
DROP TABLE IF EXISTS `tbl_scenicpoi`;
CREATE TABLE `tbl_scenicpoi`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `No` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编号 索引列',
  `Name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称 索引列',
  `Price` int(11) NULL DEFAULT NULL COMMENT '价格',
  `Star` int(11) NULL DEFAULT NULL COMMENT '评分星级',
  `Addr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `Tel` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `Contact` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `Lon` decimal(10, 7) NULL DEFAULT NULL COMMENT '经度',
  `Lat` decimal(10, 7) NULL DEFAULT NULL COMMENT '纬度',
  `Images` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `Summary` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简介',
  `Level` int(11) NULL DEFAULT NULL COMMENT '显示级别',
  `GridID` int(11) NULL DEFAULT NULL COMMENT '网格ID',
  `Tags` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标签',
  `Likes` int(11) NULL DEFAULT NULL COMMENT '点赞数',
  `Season` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '季节',
  `CityID` int(11) NULL DEFAULT NULL COMMENT '所属城市ID',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '景区表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_sys_backup
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sys_backup`;
CREATE TABLE `tbl_sys_backup`  (
  `user_id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `operation_type` int(1) NULL DEFAULT NULL COMMENT '操作类型',
  `operation_detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作详细',
  `operation_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_sys_backup
-- ----------------------------
INSERT INTO `tbl_sys_backup` VALUES ('liwenwu', 1, '李文武获取数据库备份', '2018-01-30 18:45:31');
INSERT INTO `tbl_sys_backup` VALUES ('liwenwu', 1, '李文武获取数据库备份', '2018-02-24 10:25:40');
INSERT INTO `tbl_sys_backup` VALUES ('liwenwu', 1, '李文武获取数据库备份', '2018-03-13 15:19:30');

-- ----------------------------
-- Table structure for tbl_sys_code
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sys_code`;
CREATE TABLE `tbl_sys_code`  (
  `code_id` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典id',
  `code_type_id` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典类型id',
  `code_value` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典值',
  `code_order` int(11) NULL DEFAULT NULL COMMENT '字典顺序',
  `code_remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典备注',
  `del_flg` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_user` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`code_id`, `code_type_id`) USING BTREE,
  INDEX `fk_code_ref_code_type`(`code_type_id`) USING BTREE,
  CONSTRAINT `tbl_sys_code_ibfk_1` FOREIGN KEY (`code_type_id`) REFERENCES `tbl_sys_code_type` (`code_type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表; InnoDB free: 4096 kB; (`code_type_id`) REFER `3551/tbl_sys_code_type`(`code' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_sys_code_type
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sys_code_type`;
CREATE TABLE `tbl_sys_code_type`  (
  `code_type_id` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典类型id',
  `code_type_value` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典类型值',
  `code_type_remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典类型备注',
  `del_flg` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_user` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`code_type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典类型表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sys_user`;
CREATE TABLE `tbl_sys_user`  (
  `user_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `user_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `user_remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户备注',
  `user_sex` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户性别',
  `user_mobile` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `user_tel` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '固定电话',
  `user_email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `del_flg` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_user` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改者',
  `city_id` int(11) NULL DEFAULT NULL COMMENT '城市ID',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户 表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_sys_user
-- ----------------------------
INSERT INTO `tbl_sys_user` VALUES ('1', 'e10adc3949ba59abbe56e057f20f883e', '1', NULL, '1', '', '', '', '1', '2013-10-17 15:35:52', 'admin', '2017-12-03 18:22:46', 'liwenwu', NULL);
INSERT INTO `tbl_sys_user` VALUES ('admin', 'e10adc3949ba59abbe56e057f20f883e', '超级管理员', NULL, '1', '13007103455', '', 'longmafan@qq.com', '0', NULL, NULL, '2018-03-07 14:04:45', 'liwenwu', NULL);
INSERT INTO `tbl_sys_user` VALUES ('asdf', 'e10adc3949ba59abbe56e057f20f883e', 'SD', NULL, '', '', '', '', '1', '2013-11-13 16:30:34', 'admin', '2017-12-03 18:22:41', 'liwenwu', NULL);
INSERT INTO `tbl_sys_user` VALUES ('liwenwu', '86a377b5ac172658a83aecdbef218165', '李文武', NULL, '1', '13007103455', '', '', '0', '2017-04-25 15:10:42', 'admin', '2017-04-25 15:10:42', NULL, 1);
INSERT INTO `tbl_sys_user` VALUES ('superadmin', 'e10adc3949ba59abbe56e057f20f883e', '超级管理员', NULL, '1', '10000000', '87968788', 'yuanj@163.com', '0', '2013-11-05 14:22:49', 'admin', '2014-05-30 14:17:09', 'admin', NULL);
INSERT INTO `tbl_sys_user` VALUES ('test', 'e10adc3949ba59abbe56e057f20f883e', 'test', NULL, '', '', '', '', '1', '2013-12-02 18:02:32', 'admin', '2017-12-03 18:22:46', 'liwenwu', NULL);
INSERT INTO `tbl_sys_user` VALUES ('test1', '5a105e8b9d40e1329780d62ea2265d8a', 'test1', NULL, '', '', '', '', '1', '2017-07-06 14:41:38', 'liwenwu', '2017-12-03 18:22:41', 'liwenwu', NULL);
INSERT INTO `tbl_sys_user` VALUES ('xaoyi', 'e10adc3949ba59abbe56e057f20f883e', 'xiaoyi', '', '', '', '', '', '1', '2014-03-16 09:55:10', 'admin', '2017-12-03 18:22:41', 'liwenwu', NULL);
INSERT INTO `tbl_sys_user` VALUES ('xiaoyi', 'e10adc3949ba59abbe56e057f20f883e', 'xiaoyi', '', '', '', '', '', '1', '2014-03-16 09:55:10', 'admin', '2017-12-03 18:22:46', 'liwenwu', NULL);
INSERT INTO `tbl_sys_user` VALUES ('z444', 'e10adc3949ba59abbe56e057f20f883e', '曾军', NULL, '1', '', '', '', '1', '2013-11-26 16:07:18', 'admin', '2017-12-03 18:22:48', 'liwenwu', NULL);
INSERT INTO `tbl_sys_user` VALUES ('z444z', 'e10adc3949ba59abbe56e057f20f883e', 'zz', NULL, '', '', '', '', '1', '2014-03-16 09:55:10', 'admin', '2017-12-03 18:22:46', 'liwenwu', NULL);
INSERT INTO `tbl_sys_user` VALUES ('zj', 'e10adc3949ba59abbe56e057f20f883e', '曾军', NULL, '1', '', '', '', '1', '2013-11-26 16:07:18', 'admin', '2017-12-03 18:22:41', 'liwenwu', NULL);
INSERT INTO `tbl_sys_user` VALUES ('zz', 'e10adc3949ba59abbe56e057f20f883e', 'zz', NULL, '', '', '', '', '1', '2014-03-16 09:55:10', 'admin', '2017-12-03 18:22:41', 'liwenwu', NULL);

SET FOREIGN_KEY_CHECKS = 1;
