package com.phsxy.utils.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Description: 文件工具类
 * Copyright  : Copyright (c) 2018
 * Company    : 普华
 * Author     : marven
 * Date       : 2019/3/11 19:29
 */
public class FileUtils {

    private static String TAG = "FileUtils";


    /***
     * 获取缓存目录
     * @return 目录路径
     */
    public static File getCacheDir() {
        return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/001/");
    }

    /***
     * 绝对路径获取缓存文件
     *
     * @param url url
     */
    public static File getCacheFile(String url) {
        File cacheFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/001/"
                + getFileName(url));

        return cacheFile;
    }

    /***
     * 根据链接获取文件名（带类型的），具有唯一性
     * @param fileUrl 链接地址
     * @return fileName
     */
    public static String getFileName(String fileUrl) {
        String fileName = Md5Tool.hashKey(fileUrl) + "." + getFileType(fileUrl);
        return fileName;
    }

    /***
     * 获取文件类型
     * @param paramString 文件
     * @return 类型
     */
    public static String getFileType(String paramString) {
        String str = "";

        if (TextUtils.isEmpty(paramString)) {
            return str;
        }
        int i = paramString.lastIndexOf('.');
        if (i <= -1) {
            Log.d(TAG, "i <= -1");
            return str;
        }
        str = paramString.substring(i + 1);
        return str;
    }

    /**
     * 写入文件
     * 断点续传
     */
    public static void writeFile(InputStream in, File file) throws IOException {
        RandomAccessFile savedFile = null;
        long ltest = 0;
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file != null && file.exists()) {
            ltest = file.length();
        }
        if (in != null) {
            savedFile = new RandomAccessFile(file, "rw");
            savedFile.seek(ltest);
            byte[] buffer = new byte[1024 * 128];
            int len = -1;
            while ((len = in.read(buffer)) != -1) {
                savedFile.write(buffer, 0, len);
            }
            in.close();
        } else {
            Log.i(TAG, "写入失败");
        }
    }

    /**
     * 读取文件长度
     */
    public static long readFile(File file) {
        if (file != null && file.exists()) {
            return file.length();
        } else {
            return 0;
        }
    }

//    public static File saveFile(String filePath, ResponseBody body) {
//        InputStream inputStream = null;
//        OutputStream outputStream = null;
//        File file = null;
//        try {
//            if (filePath == null) {
//                return null;
//            }
//            file = new File(filePath);
//            if (file == null || !file.exists()) {
//                file.createNewFile();
//            }
//
//            long fileSize = body.contentLength();
//            long fileSizeDownloaded = 0;
//            byte[] fileReader = new byte[4096];
//
//            inputStream = body.byteStream();
//            outputStream = new FileOutputStream(file);
//
//            while (true) {
//                int read = inputStream.read(fileReader);
//                if (read == -1) {
//                    break;
//                }
//                outputStream.write(fileReader, 0, read);
//                fileSizeDownloaded += read;
//            }
//
//            outputStream.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (inputStream != null) {
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if (outputStream != null) {
//                try {
//                    outputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        return file;
//    }

    /**
     * 创建临时文件
     * @param context 上下文
     * @return 临时文件路径
     */
    public static File createTmpFile(Context context) {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            // 已挂载
            //Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
            File pic = Environment.getExternalStorageDirectory();
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA).format(new Date());
            String fileName = "multi_image_" + timeStamp + "";
            File tmpFile = new File(pic, fileName + ".jpg");
            return tmpFile;
        } else {
            File cacheDir = context.getCacheDir();
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA).format(new Date());
            String fileName = "multi_image_" + timeStamp + "";
            File tmpFile = new File(cacheDir, fileName + ".jpg");
            return tmpFile;
        }
    }
}
