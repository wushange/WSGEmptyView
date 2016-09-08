在Git上发现一个好玩的控件 可以用来当作emptyview 和 errorview 效果不错
[Parallax-Layer-Layout](https://github.com/SchibstedSpain/Parallax-Layer-Layout)

于是在项目使用中，我为了方便就把它折腾了一下，方便以后使用嘿嘿

[GitHub传送门](https://github.com/wushge11/WSGEmptyView)
[源码下载](http://download.csdn.net/detail/wushge11/9624032)
看效果图
![](http://img.blog.csdn.net/20160907124952203)

这样以后可以直接在任意位置 添加
也可以开发者封装在自己的基类里面 方便开发

使用方法简单


gradlew引用

```
compile 'com.wushange:emptyView:0.01'
```

两个类
EmptyViewConfig ：设置提示文字，添加点击监听事件设置等...
EmptyView :主要的fragment 负责显示 和重力感应监听的 
注：默认是添加到android.R.id.content,会在整个界面最上层

```
EmptyViewConfig emptyViewConfig = new EmptyViewConfig();
EmptyView emptyView = new EmptyView();
emptyView.setEmptyViewConfig(emptyViewConfig);
emptyView.injectEmptyView(getSupportFragmentManager());
```
在Activity中直接传入FragmentManager 可以默认添加到android.R.id.content

```
emptyView.injectEmptyView(getFragmentManager(),R.id.customer_layout);
```

也可以指定添加位置，自己传入ID即可

在Fragment中添加的时候 ，我现在是指定添加位置id ，不用android.R.id.content避免不必要的麻烦，


Next Version

 - 可定制ParallaxLayout，添加自定义图片

