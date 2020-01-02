package day18;

import java.util.Map.Entry;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test7 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        A a1 = new A();//�����������
        B b1 = new B();
        //��ȡ�̶��������̳߳�
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //�ύ����
        Future<String> submit1 = pool.submit(a1);
        Future<String> submit2 = pool.submit(b1);
        String a1he = submit1.get();
        String b1he = submit2.get();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < a1he.length(); i++) {
            map.put(a1he.charAt(i), b1he.charAt(i));
        }
        String ab = "";
        Set<Entry<Character, Character>> entrySet = map.entrySet();
        for (Entry<Character, Character> entry : entrySet) {
            ab += entry.getKey() + "" + entry.getValue();

        }
        System.out.println("����ǣ�" + a1he);
        System.out.println("����ǣ�" + b1he);
        System.out.println("����ǣ�" + ab);
        pool.shutdown();
    }
}

class A implements Callable<String> {

    @Override
    public String call() throws Exception {
        String string = "";
        for (char i = 'A'; i < 'Z'; i++) {
            string += i + "";
        }
        return string;
    }
}

class B implements Callable<String> {
    @Override
    public String call() throws Exception {
        String string = "";
        for (char i = 'a'; i < 'z'; i++) {
            string += i + "";
        }
        return string;
    }

}