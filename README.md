# android-listview-demo

## 简介

本 demo 展示了如何在 Android 应用中使用 ListView 控件来显示垂直滚动的列表数据。ListView 是 Android 中最常用的列表显示组件之一，可以高效地展示大量数据。

## 基本原理

ListView 是 Android SDK 中的一个继承自 AbsListView 的视图组件，它采用 MVC 模式设计：
- **Model（模型）**：数据源，通常是数组或数据库查询结果
- **View（视图）**：列表项的布局视图
- **Controller（控制器）**：Adapter（适配器），负责将数据绑定到视图

ListView 采用了视图回收机制（View Recycling），当列表项滑出屏幕时，其视图会被回收并重用，极大地提高了内存使用效率。

## 启动和使用

### 环境要求
- Android Studio Arctic Fox 或更高版本
- JDK 11 或更高版本
- Android SDK 34

### 安装和运行
1. 使用 Android Studio 打开本项目
2. 连接 Android 设备或启动模拟器
3. 点击 Run 按钮运行应用

## 教程

### 什么是 ListView？

ListView 是 Android 中用于显示垂直列表的视图组件。它可以显示大量的可滚动项目，每个项目可以是文本、图像或其他视图的组合。

### 核心组件

1. **ListView**：列表视图容器
2. **Adapter**：数据适配器，负责提供列表项数据
3. **布局文件**：定义单个列表项的显示样式

### 使用步骤

1. 在布局文件中添加 ListView 控件：
```xml
<ListView
    android:id="@+id/listView"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```

2. 准备数据源：
```kotlin
private val dataList = arrayOf(
    "苹果", "香蕉", "橙子", "葡萄", "西瓜"
)
```

3. 创建适配器：
```kotlin
val adapter = ArrayAdapter(
    this,
    android.R.layout.simple_list_item_1,  // 系统提供的简单文本布局
    dataList
)
```

4. 将适配器绑定到 ListView：
```kotlin
listView.adapter = adapter
```

### 处理点击事件

使用 `onItemClickListener` 监听列表项的点击：

```kotlin
listView.onItemClickListener = object : AdapterView.OnItemClickListener {
    override fun onItemClick(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        val item = dataList[position]
        Toast.makeText(
            this@MainActivity,
            "点击了: $item",
            Toast.LENGTH_SHORT
        ).show()
    }
}
```

### 常用属性

- `android:divider`：列表项之间的分隔线颜色
- `android:dividerHeight`：分隔线高度
- `android:footerDividersEnabled`：是否在 footer 前显示分隔线
- `android:headerDividersEnabled`：是否在 header 后显示分隔线

### 注意事项

1. **数据量大时的优化**：对于大量数据，建议使用 RecyclerView 代替 ListView，它提供了更好的性能
2. **ViewHolder 模式**：虽然 ArrayAdapter 已经处理了视图复用，但自定义适配器时应使用 ViewHolder 模式进一步提高性能
3. **空数据处理**：应考虑数据为空时的 UI 显示
