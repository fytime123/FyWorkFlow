package com.lfy.workflow;

public interface Worker {

    /**
     * 执行任务
     *
     * @param current 当前节点
     */
    void doWork(Node current);

}