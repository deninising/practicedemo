package com.dennis.originalio.dennis_01;

import java.io.File;
import java.io.IOException;
// 文件的基本操作：增、删、改、递归操作
public class FileDemo {
    public static void main(String[] args) throws IOException {
//        File file1 = new File("e:\\demo");
//        file1.mkdir();
//
//        File file = new File("e:\\demo\\a.txt");
//        System.out.println(file.createNewFile());

//        File file2 = new File("e:\\aaa\\bbb\\ccc");
//        file2.mkdirs();
//        File file = new File(file2, "e.txt");
//        file.createNewFile();

//        File file = new File("e:\\aaa\\bbb\\ccc");
//        file.mkdirs();
//        File file1 = new File(file, "e.txt");
//        file1.createNewFile();

//        file1.renameTo(new File("e:\\aaa\\bbb\\ccc\\林青霞.txt"));
//        File file3 = new File(file, "林青霞.txt");
//        File file2 = new File("e:\\aaa\\bbb\\成龙.txt");
//        file3.renameTo(file2);
//        long l = file2.lastModified();
//        System.out.println(l);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        Date date = new Date(l);
//        String format = simpleDateFormat.format(date);
//        System.out.println(format);
//        System.out.println(date);

//        File file = new File("e:");
//        String[] list = file.list();
//        File[] files = file.listFiles();
//
//        for (File f:files){
//            System.out.println(f.getPath());
//        }
        FileDemo fileDemo = new FileDemo();
        File file = new File("e:\\a");
        fileDemo.delet(file);

    }

    public void delet(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    if (f.listFiles() != null) {
                        delet(f);
                    } else {
                        f.delete();
                    }
                } else {
                    f.delete();
                }
            }
        }
        file.delete();
    }

    public void deleteFolder(File file) {
        File[] files = file.listFiles();
        if (files.length > 0) {
            for (File f : files) {
                if (f.isDirectory()) {
                    if (f.listFiles() == null) {
                        f.delete();
                    } else {
                        deleteFolder(f);
                    }
                } else {
                    f.delete();
                }
            }
        }
    }
}
