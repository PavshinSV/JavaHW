package lesson04;

import java.util.ArrayList;
import java.util.List;

public class BarrierList {
    private List<Barrier> order = new ArrayList<>();

    public void addBarrier(Barrier barrier){
        this.order.add(barrier);
    }

    @Override
    public String toString() {
        String str="Order of Barriers:\n";
        for (Barrier el :
                order) {
            str+= el.toString()+"\n";
        }

        return str;
    }

    public int size(){
        return this.order.size();
    }

    public List<Barrier> getList(){
        return order;
    }
}
