# 程序员恋爱系列(1)---OiView

标签（空格分隔）： Android Java

---

##什么是程序员恋爱系列
打算是程序员圈子比较小、妹子也少，认识妹子更少，泡上妹子难上加难所以就有了这份教程，但是这个不一定是用在这个用途，可以有更多用途，等着你发现~~~

您可以使用OiView：

> *  简单灵活，直接调用，个性化定制
> * 酷炫，灵活，符合潮流
> * 学会了可以给Ta一个惊喜，遇到Ta的时候能搭讪

---

##什么是OiView
哟，这个项目是复写了TextView,Button，增加部分动画，使一些控件看起来更舒服，增加了一些闪动的效果，可以在适当的位置使用，使你的app更加酷炫。
不多说上gif图片

###通常第一步配置咯
jdk下载:http://www.oracle.com/technetwork/java/javase/downloads/index.html
jdk配置:http://www.cnblogs.com/xing901022/p/3955794.html
android&&android Studio 下载 的请用https://dl.google.com/dl/android/studio/install/1.1.0/android-studio-bundle-135.1740770-windows.exe
android配置:http://blog.csdn.net/webrobot/article/details/7304831

###好了配置好，可以去开发了
先定义自己的页面
```xml
<com.oi.library.view.OiTextView
        android:id="@+id/OiTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        oi:textColor="#000000"
        oi:textSize="12"
        oi:text="Dear" />
 <com.oi.library.view.OiButton
        android:id="@+id/OiButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/OiTextView"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="20dp"
        oi:text="Cancle"
        oi:textColor="#000000"
        oi:textSize="12sp" />
```
`com.oi.library.view.OiTextView`&&`com.oi.library.view.OiButton`这个是命名空间，写过自定义插件童鞋门应该知道的
`oi:xxxx`这个是相应自定义属性
> textColor 是重写了android:textColor属性
> textSize 是重写了android:textSize属性
> text 是重写了android:text的属性

Button的例子比较看出来

自定义样式已经写完，可以写代码了
TextView:
```Java
OiTextView	oiTextView = (OiTextView) findViewById(R.id.OiTextView);
oiTextView.setInTime(0.2f);
oiTextView.setOutTime(0.2f);
oiTextView.setTextColor(Color.RED);
oiTextView.setProgress(progress * 1f / 100);
```
重要参数说明:其他方法可以看OiView
> setInTime(float mTime) 设置划入动画时长
> setOutTime(float mTime) 设置划出动画时长
> setLight(boolean isLight) 划入后是否开始闪光
> setPaddingTop(int dp) 设置划入动画的高度
> setTextSize(float mTextSize) 设置字体大小
> show() 展示
> hide() 隐藏

OiButton是继承OiTextView，所大同小异
