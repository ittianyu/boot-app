
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

