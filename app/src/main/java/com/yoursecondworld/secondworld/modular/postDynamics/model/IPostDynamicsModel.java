package com.yoursecondworld.secondworld.modular.postDynamics.model;

import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;

import java.io.File;
import java.util.List;

/**
 * Created by cxj on 2016/8/24.
 */
public interface IPostDynamicsModel {

    /**
     * 发布动态
     *
     * @param session_id
     * @param object_id
     * @param game_tag
     * @param type_tag
     * @param content
     * @param video_list
     * @param picture_list
     * @param money
     * @param infor_type
     * @param listener
     */
    void postDynamics(String session_id, String object_id, String game_tag, String type_tag,
                      String content, String[] video_list, String[] picture_list, Integer money, String infor_type,
                      NetWorkSoveListener<BaseEntity> listener);

    /**
     * 对路径的图片信息转化成文件的集合
     *
     * @param images
     * @return
     */
    List<File> converse(List<String> images);

}
