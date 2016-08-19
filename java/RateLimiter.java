/**
 * Created by adamli on 8/18/16.
 */
public class RateLimiter {
    int capacity;
    int tokens = 0;
    long timeStamp = System.currentTimeMillis();

    public RateLimiter(int capacity) {
        this.capacity = capacity;
    }

    public boolean take() {
        long now = System.currentTimeMillis();
        int delta = (int) (now - timeStamp) * capacity / 1000;
        System.out.println(delta);
        tokens += delta;

        if (tokens > capacity)
            tokens = capacity;

        timeStamp = now;
        if (tokens == 0) {
            return false;
        }else{
            tokens--;
            return true;
        }
    }
}
