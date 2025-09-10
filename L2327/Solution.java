package L2327;

import java.util.ArrayList;

public class Solution {
    static final long MOD = 1_000_000_007L;
    int peopleAwareOfSecret(int n, int delay, int forget) {
        circBuf buf = new circBuf(forget + 1);
        buf.insert(0, 1);
        for (int i = 1; i < n; i++) {
            long newSec = 0;
            for (int j = delay; j < forget; j++) {
                newSec += buf.get(j);
                newSec %= MOD;
            }
            buf.insert(0, newSec);
        }
        //System.out.println(buf);
        return buf.getSum();
    }

    class circBuf {
        public long[] buf;
        public int head;
        public int tail;
        public int len;

        public circBuf(int length) {
            buf = new long[length];
            len = length;
            head = 0;
            tail = length - 1;
        }

        public void insert(int index, long value) {
            buf[(index + head) % len] = value;
            head = (head - 1 + len) % len;
            tail = (tail - 1 + len) % len;
        }

        public long get(int index) {
            return buf[(head + index) % len];
        }

        public int getSum() {
            long sum = 0;
            head = (head + 1 + len) % len;
            for (int i = 0; i < len - 1; i++) {
                sum += this.get(i);
                sum %= MOD;
            }
            return (int) sum;
        }

    }

}
