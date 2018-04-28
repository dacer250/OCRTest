# OCRTest
from  baidu`s ocr technology
#### 好好写文档
#### 集成多个项目的例子。
- 百度的图像识别，，OCR
- 阿里云的短信服务。
#### OCR

- 根据百度的官方教程来就好。说实话还是百度的doc方便
#### Sms

- 在阿里的官网上教程已经是很详细了，但是因为太多反而有点杂乱无章
- 最后也是直接去github上面去搜了一下，遇到一个比较完备的解决方案。

```maven
		<dependency>
			<groupId>com.aliyun</groupId>
			<artifactId>aliyun-java-sdk-core</artifactId>
			<version>3.2.8</version>
		</dependency>
		<dependency>
			<groupId>com.aliyun</groupId>
			<artifactId>aliyun-java-sdk-dysmsapi</artifactId>
			<version>1.1.0</version>
		</dependency>
```
- 这个是主要的俩个依赖包
- 主要的代码实现放在service的SendSms这个类里面

          public static SendSmsResponse sendSms( String  phoneNumber ,String SignName,String TemplateCode,String Template)
- 这个方法主要是发送短信的作用。。具体的情况在代码里面有注释