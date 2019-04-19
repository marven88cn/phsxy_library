# library 说明使用文档
## 一. 包结构
>> com.phsxy.utils

>>>com.phsxy.utils.contanst
## 二. 调用说明
  ### 1. 只需要在 Application 中调用 AppContextUtil.init() 进行初始化就行
  ### 2. 混淆
  #### #-keep com.phsxy.utils.*{}
## 三. Document

### String字符相关
#### StringUtils
   * returnStr 返回空字符
   * copyText 复制字符串
   * isEmpty 判断字符串
   * isSpace 判断字符串是否为null或全为空格
   * equals 判断两字符串是否相等
   * upperFirstLetter 首字母大写
   * lowerFirstLetter 首字母小写
   * reverse 反转字符串
   * toDBC 转化为半角字符
   * toSBC 转化为全角字符
   * cn2PY 中文转拼音
   * oneCn2PY 单个汉字转成拼音
   * oneCn2ASCII 单个汉字转成ASCII码
   * getParseDouble 转换double后四位
   * getParseDouble2 转换double后两位
   * getEditStr 获取EditText文本
   * toInt String转int  
#### SpanUtils
### 应用相关
#### ApkUtils
   * install 安装apk
   * uninstall 卸载apk
   * isAvailable 通过packageName检查手机上是否安装了指定的软件 
   * isAvailable 通过file检查手机上是否安装了指定的软件
   * getPackageName 根据文件路径获取包名
   * getChannelFromApk 从apk中获取版本信息
   * getVersionName 获取应用程序版本VersionName
   * getVersionCode 获取应用程序VersionCode
   * getVersionCode 获取某个指定应用的versionCode
   
### 银行相关
#### BankInfoUtil
   * getBankId  获取银行编码
   * getBankName  获取银行名称
   * getCardType  获取银行卡类型 return 储蓄卡、信用卡、准贷记卡、预付费卡、无法识别
    
### 图片相关
#### BitmapUtils   应用开发中三种常见的图片压缩方法
   * getBitmap  资源文件转bitmap
   * compressImage  质量压缩
   * getimage  图片按比例大小压缩方法（根据路径获取图片并压缩）
   * comp  图片按比例大小压缩方法（根据Bitmap图片压缩）
### 定位
#### LocationUtils 定位 
   * isGpsEnabled   判断Gps是否可用
   * isLocationEnabled   判断定位是否可用
   * openGpsSettings   打开Gps设置界面
   * register   注册定位权限
   * unregister   注销、关闭定位
#### CoordinateUtils 坐标相关工具类  
   * bd09ToGcj02 BD09 坐标转 GCJ02 坐标   
   * gcj02ToBd09 BD09 GCJ02 坐标转 BD09 坐标 
   * gcj02ToWGS84 GCJ02 坐标转 WGS84 坐标
   * wgs84ToGcj02 GCJ02 WGS84 坐标转 GCJ02 坐标
   * bd09ToWGS84 BD09 坐标转 WGS84 坐标
   * wgs84ToBd09 WGS84 坐标转 BD09 坐标
   * outOfChina 坐标是否在中国
### 时间
#### DateTimeUtil 时间 
   * formatFriendly   将日期格式化成友好的字符串：几分钟前、几小时前、几天前、几月前、几年前、刚刚
   * compareDate   验证日期是否比当前日期早
   * getGapCount   获取两个日期之间的间隔天数
   * isSameDay   判断两日期是否同一天
   * getTimeInterval  获取两个日期的时间差
   * getInterval  获取两个日期的时间差 yyyy.MM.dd HH.mm.ss
   * getTime  两个时间之差 求出一个long Time
   * formatDate  传入时间 算出星期几
   * getCurrentDateTime   获取当前日期时间
   * stringToLong   获取当前时间 @return yyyyMMddHHmm
   * getFormateDate    获取系统时间的方法:月/日 时:分:秒 
   * getHourAndMinute    获取系统时间的方法:时:分:秒 
   * getHour    获取系统时间的方法:时
   * getCurrentDate   获取系统当前日期
   * formatDateTime   将日期以yyyy-MM-dd HH:mm:ss格式化
   * formatDateTime   将long格式日期以传入格式格式化
   * formatDateTime   将Date日期以传入格式格式化   
   * parseDate   将字符串日期字符串转成日期   
   * strFormatStr   将2017-07-10 00:00:00 换2017-07-10  
   * strToDateHHMMSS  2015-01-07 15:05:34 
   * strToDate  2015-01-07 转date   --
   * strToDateDorp  2015-01-07 转date  ..
   * dateToStr  date转yyyy-MM-dd类型日期
   * stringParserLong  传入一个String转化为long
   * currentDateParserLong  当前时间转换为long
   * getCurrentDateHHMM  当前时间 如: 10:37
   * getCurrentDateHHMMSS  当前时间 如: 10:37:11
   * getCurrentTime  当前时间 如: 2013-04-22
   * getSWAHDate  获取完整时间
   * addDateTime   对日期进行增加操作   
   * subDateTime   对日期进行相减操作   
   * secToTime   将1000秒转化为时分秒格式   
   * unitFormat   时分秒的格式转换
### 文件
#### FileUtils 文件工具类
   * getCacheDir 获取缓存目录
   * getCacheFile 绝对路径获取缓存文件
   * getFileName 根据链接获取文件名（带类型的），具有唯一性
   * getFileType 获取文件类型
   * writeFile 写入文件
   * readFile 读取文件长度
   * createTmpFile 创建临时文件
### Intent
#### IntentUtils  
   * goNextActivity activity 跳转工具方法  
   * goNextActivityResult activity 意图跳转工具方法  
   * toOtherPlatform 跳转到其他平台
   
### 其他
#### ButtonClickUtils 
   * isFastDoubleClick   按钮防止多点
#### ColorUtils 颜色工具类
#### EditChangeUtils 监听edittext输入 支持多个edittext
