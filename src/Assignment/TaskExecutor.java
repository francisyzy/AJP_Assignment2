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
public class TaskExecutor implements Runnable {
    BlockingQueue<Runnable> queue;
    private static boolean cancel = false;
    
    public TaskExecutor(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String name = Thread.currentThread().getName();
                Runnable task = queue.dequeue();
                System.out.println("Task Started by Thread :" + name);
                task.run();
                System.out.println("Task Finished by Thread :" + name);
                
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    
    public static void canceltask(){
        cancel = true;
    }
}
