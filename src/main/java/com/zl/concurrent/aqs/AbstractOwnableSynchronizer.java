package com.zl.concurrent.aqs;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-31
 */
public abstract class AbstractOwnableSynchronizer implements java.io.Serializable {
    private static final long serialVersionUID = 3737899427754241961L;

    protected AbstractOwnableSynchronizer() { }

    /**
     * 独占模式当前持有锁的线程
     */
    private transient Thread exclusiveOwnerThread;

    protected final void setExclusiveOwnerThread(Thread thread) {
        exclusiveOwnerThread = thread;
    }

    protected final Thread getExclusiveOwnerThread() {
        return exclusiveOwnerThread;
    }
}
