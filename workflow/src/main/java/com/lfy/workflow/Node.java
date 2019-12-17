package com.lfy.workflow;

public interface Node<R,T> {

    /**
     * 节点id
     *
     * @return 当前节点id
     */
    int getId();

    /**
     * 任务完成时触发
     */
    void onCompleted();

    R getRequest();

    T getResult();

    void setRequest(R r);

    void setResult(T result);

}
