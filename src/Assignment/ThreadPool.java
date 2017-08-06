/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

/**
 *
 * @author caeden
 */
//code refer from http://tutorials.jenkov.com/java-concurrency/thread-pools.html
public class ThreadPool {
	
    BlockingQueue <Runnable> queue;
    public ThreadPool(int queueSize, int nThread) {
        queue = new BlockingQueue<>(queueSize);
        String threadName = null;
        TaskExecutor task = null;
        for (int count = 0; count < nThread; count++) {
        	threadName = "Thread-"+count;
        	task = new TaskExecutor(queue);
            Thread thread = new Thread(task, threadName);
            thread.start();
        }
    }

    public void submitTask(Runnable task) throws InterruptedException {
        queue.enqueue(task);
    }
}