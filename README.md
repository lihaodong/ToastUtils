# ToastUtils #

安卓版本自定义Toast提示!

----

## 截图
完善成功后上传
## 使用方法
### Gradle
```groovy
compile 'com.lihaodong.toast:toastlibrary:1.0'
```
### Maven
```groovy
<dependency>
  <groupId>com.lihaodong.toast</groupId>
  <artifactId>toastlibrary</artifactId>
  <version>1.0</version>
  <type>pom</type>
</dependency>
```
### Eclipse ADT

放弃治疗。

### 初始化
初始化 ToastUtils，并设置 ToastUtils 建议把初始化方法放到 Application 中 onCreate 生命周期
方法里面。还有别忘了在manifest.xml中注册Application。
```
HToast.newBuilder(this)
      .build();
```
## 调用

```
 HToast.success("我成功了");
 HToast.error("我错了");
 HToast.normal("我正常了");
 HToast.warning("我被警告了");
 HToast.info("我是一条信息");
 
```

## 友好的调试模式

```
java
```
## License
```text
Copyright 2017 Li Haodong

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```



