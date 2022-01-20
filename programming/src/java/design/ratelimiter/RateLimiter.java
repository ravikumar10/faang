package src.java.design.ratelimiter;

public interface RateLimiter {
    boolean check(String eid);
}