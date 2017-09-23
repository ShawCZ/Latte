package com.shaw.latte.ui.camera;

/**
 * Created by shaw on 2017/9/17.
 */

import android.net.Uri;

import com.shaw.latte.delegates.PermissionCheckerDelegate;
import com.shaw.latte.util.file.FileUtil;

/**
 * 照相机调用类
*/
public class LatteCamera {

    public static Uri createCropFile(){
        return Uri.parse(FileUtil.createFile("crop_image",FileUtil.getFileNameByTime("IMG","jpg")).getPath());
    }

    public static void start(PermissionCheckerDelegate delegate){
        new CameraHandler(delegate).beginCameraDialog();
    }

}
