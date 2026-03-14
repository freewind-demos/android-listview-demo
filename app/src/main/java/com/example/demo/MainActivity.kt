package com.example.demo

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

/**
 * ListView 示例程序
 *
 * 展示如何在 Android 中使用 ListView 控件显示垂直滚动列表
 */
class MainActivity : AppCompatActivity() {

    // 定义要显示的数据列表
    private val dataList = arrayOf(
        "苹果", "香蕉", "橙子", "葡萄", "西瓜",
        "草莓", "芒果", "菠萝", "猕猴桃", "石榴",
        "樱桃", "桃子", "梨", "柚子", "火龙果"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 创建根布局 - 使用 ConstraintLayout
        val rootLayout = ConstraintLayout(this).apply {
            id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT
            )
        }

        // 创建 ListView 控件
        val listView = ListView(this).apply {
            id = View.generateViewId()
        }

        // 创建数组适配器，将数据绑定到 ListView
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            dataList
        )

        // 设置适配器
        listView.adapter = adapter

        // 设置列表项点击监听器
        listView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // 获取点击的项
                val item = dataList[position]
                // 显示提示信息
                Toast.makeText(
                    this@MainActivity,
                    "点击了: $item",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // 将 ListView 添加到根布局
        rootLayout.addView(listView)

        // 设置布局参数，让 ListView 填充父容器
        listView.layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT
        ).apply {
            // 设置 ListView 的约束：上下左右都填满，略有边距
            topToTop = ConstraintLayout.LayoutParams.PARENT_ID
            bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
            leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
            rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
            topMargin = 16
            bottomMargin = 16
            leftMargin = 16
            rightMargin = 16
        }

        // 设置内容视图
        setContentView(rootLayout)
    }
}
