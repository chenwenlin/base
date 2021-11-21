package com.chen.designpatterns.structure.composite;

import java.util.List;

/**
 * 使用安全组合模式实现无限级文件系统
 *
 * @Author chenwenlin
 * @Date 2021/11/21 20:27
 */
public class CompositeTest {
    public static void main(String[] args) {

    }
}

// 抽象构建
abstract class Directory {
    /**
     * 文件名
     */
    protected String name;

    public Directory(String name) {
        this.name = name;
    }

    /**
     * 显示文件名
     */
    abstract String show();
}

// 文件
class File extends Directory {

    public File(String name) {
        super(name);
    }

    @Override
    String show() {
        return null;
    }
}

// 文件夹
class Folder extends Directory {

    private List<Directory> folderList;

    public Folder(String name) {
        super(name);
    }

    // 添加文件
    public void addFile(Directory file) {
        folderList.add(file);
    }

    @Override
    String show() {
        return null;
    }
}