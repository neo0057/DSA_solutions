package interviews.arcesium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HitCounter {

    private List<Long> hits = new ArrayList<>();

    public void hit(Long timestamp) {
        // Long timestamp = System.currentTimeMillis();
        hits.add(timestamp);
        removeExpiredHits();
    }

    public int getHits(Long currentTimeStamp) {
        // Long currentMillis = System.currentTimeMillis();
        Long minutePass = 5*60*1000L;
        int count = 0;
        for(Long val : hits) {
            if((val + minutePass) >= currentTimeStamp) count++;
        }
        // long count = hits.stream().filter(val -> (val + minutePass) >= currentTimeStamp).collect(Collectors.toList()).size();
        removeExpiredHits();
        return count;
    }

    private void removeExpiredHits() {
        Long currentMillis = System.currentTimeMillis();
        Long minutePass = 5*60*1000L;
        hits = hits.stream().filter(val -> (val + minutePass) < currentMillis).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        HitCounter hc = new HitCounter();
        // for(int i = 0; i < 10; i++) {

        Long currentTime = System.currentTimeMillis();
        hc.hit(currentTime - 298*60*1000L);
        hc.hit(currentTime - 299*60*1000L);
        hc.hit(currentTime - 301*60*1000L);
        hc.hit(currentTime - 302*60*1000L);
        hc.hit(currentTime - 303*60*1000L);
        hc.hit(currentTime - 304*60*1000L);
        // }
        System.out.println(hc.getHits(currentTime));
    }

}
