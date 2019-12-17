package com.lfy.workflow;


/**
 * 工作节点
 */
public class WorkNode<R, T> implements Node<R, T> {


    public static WorkNode build(int nodeId, Worker worker) {
        return new WorkNode(nodeId, worker);
    }

    public static <R> WorkNode<R, ?> build(int nodeId, Worker worker, R request) {
        WorkNode<R, ?> node = new WorkNode<>(nodeId, worker);
        node.setRequest(request);

        return node;
    }


    //节点id
    private int nodeId;

    //节点工作者
    private Worker worker;

    private WorkCallBack callBack;

    private R request;

    private T result;


    public WorkNode(int nodeId, Worker worker) {
        this.nodeId = nodeId;
        this.worker = worker;
    }

    public void doWork(WorkCallBack callBack) {
        this.callBack = callBack;
        worker.doWork(this);
    }

    public void removeCallBack() {
        this.callBack = null;
    }

    @Override
    public int getId() {
        return nodeId;
    }

    @Override
    public void onCompleted() {
        if (null != callBack) {
            callBack.onWorkCompleted();
        }
    }

    @Override
    public String toString() {
        return "nodeId : " + getId();
    }


    @Override
    public R getRequest() {
        return request;
    }

    @Override
    public T getResult() {
        return result;
    }

    @Override
    public void setRequest(R request) {
        this.request = request;
    }

    @Override
    public void setResult(T result) {
        this.result = result;
    }


    interface WorkCallBack {

        /**
         * 当前任务完成
         */
        void onWorkCompleted();

    }
}
