
## 构建 ##

#### 脚本 ####

gradle + kotlin script

#### 结构 ####

- 根项目配置文件: build.gradle.kts，配置了如下内容
	- java.sourceCompatibility
	- root project plugins
	- common config:
		- group and version
		- jvmTarget
		- repositories
		- common plugins
		- dependencyManagement
		- dependencies
- 公共配置模块 buildSrc: 配置脚本中公用的常量、变量、任务、配置等。
	- Dependencies.kt
		- Versions: 所有依赖和插件的版本号
		- Plugins: 所有插件依赖
		- Libs: 所有依赖库
	- common-config.gradle.kts: 公共的自定义插件
- 子项目配置文件: build.gradle.kts，配置了如下内容
	- dependencies: 子项目的所有依赖


## 项目 ##

#### 模块结构 ####

- common: 公用模块，放常用的与业务无关的类
- discover: 注册和发现服务
- config: 配置服务中心
- gateway: 网关，用于登录态校验和跨域支持
- account: 账号服务，提供注册、登录、登录态校验功能
- account-api: 对其他服务公开的接口和实体类
- dashboard: 后台服务，提供配置和用户管理功能
- dashboard-api: 对其他服务公开的接口和实体类


#### 实体类分类 ####

- PO: 数据库层实体类。 Persistant Object
- BO: 业务层实体类。 Business Object
- DTO: 数据传输实体类。 Data Transfer Object

（注：这里把 VO 归到 DTO 中，减少类型转换带来的复杂度）

#### 命名规范 ####

- PO 与数据库表一一对应。
- BO 如果业务层不需要额外字段或方法，则可以直接使用 PO，否则应该定义一个 BO，推荐直接继承 PO。
- DTO 跨层或远程传输时使用。 可以作为服务输入或输出的实体类。如果 DTO 与 BO 或 PO 完全一致，则不再单独定义DTO。

对应类型的实体以对应的名字结尾。 比如 `user` 表可以对应 `UserPO`。


#### 目录结构和依赖 ####

遵循高内聚低耦合原则。

同一类功能放到一个包下，功能内尽量不依赖非公用外部类。
公用类尽量少且独立。


#### 配置管理 ####

独立配置模块: discover, config
配置中心管理模块: account, dashboard, gateway

业务模块的配置均放在 config 模块下的 resources/config
其中 common-dev 是公用配置。

-dev 表示开发配置，如果需要线上配置，可以自行复制并做修改。
这里配置中心使用的是 spring-cloud-config，相关配置和使用方法可以查阅网上资料。

## 测试 ##

#### 覆盖率 ####

- 高：类、方法覆盖率100%，分支覆盖率尽可能高，系统环境类异常分支可不覆盖。
- 中: 类、方法覆盖率50%。分支覆盖率尽可能高。

#### 单元测试要求 ####

- 公共类：高
- 工具类：高
- 数据层：高
- 业务层：中
- 服务层：中


## 服务 ##

#### 端口配置 ####

- gateway: 80
- discover: 8000
- config: 8100
- account: 8200
- dashboard: 8300

注意事项：机器对外只暴露 80 端口，有 https 需求的自行改成 443。

#### 网关 ####

- 统一前缀: /api
- 禁止外部访问的服务: discover,gateway,config
- 禁止外部访问的部分接口: /dashboard/config/xxx
